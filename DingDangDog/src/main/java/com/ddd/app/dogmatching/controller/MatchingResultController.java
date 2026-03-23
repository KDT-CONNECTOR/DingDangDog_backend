package com.ddd.app.dogmatching.controller;

// ===== 멍! 매칭 결과 조회 =====
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.dogarchive.dto.ArchiveListDTO;
import com.ddd.app.dogmatching.dao.MatchingResultDAO;
import com.ddd.app.dogmatching.dto.MatchingResultDTO;

public class MatchingResultController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MatchingResultDAO dao = new MatchingResultDAO();
		Result result = new Result();

		Integer sessionUserNumber = (Integer) request.getSession().getAttribute("userNumber");
		String resultNumberParam = request.getParameter("resultNumber");

		// ===== 로그인 정보 없으면 메인/설문 시작 페이지로 =====
		if (sessionUserNumber == null) {
			result.setPath(request.getContextPath() + "/matching/test.ma");
			result.setRedirect(true);
			return result;
		}

		// ===== resultNumber 없거나 숫자가 아니면 메인/설문 시작 페이지로 =====
		if (resultNumberParam == null || resultNumberParam.trim().isEmpty()) {
			result.setPath(request.getContextPath() + "/matching/test.ma");
			result.setRedirect(true);
			return result;
		}

		int resultNumber = 0;

		try {
			resultNumber = Integer.parseInt(resultNumberParam);
		} catch (NumberFormatException e) {
			result.setPath(request.getContextPath() + "/matching/test.ma");
			result.setRedirect(true);
			return result;
		}

		// ===== 저장된 매칭 결과 1건 조회 =====
		MatchingResultDTO matchingResultDTO = dao.selectResultByResultNumber(resultNumber);

		// ===== 없는 결과면 메인/설문 시작 페이지로 =====
		if (matchingResultDTO == null) {
			result.setPath(request.getContextPath() + "/matching/test.ma");
			result.setRedirect(true);
			return result;
		}

		// ===== 본인 결과가 아니면 메인/설문 시작 페이지로 =====
		if (matchingResultDTO.getUserNumber() != sessionUserNumber) {
			result.setPath(request.getContextPath() + "/matching/test.ma");
			result.setRedirect(true);
			return result;
		}

		// ===== 저장된 추천 강아지 번호 조회 =====
		List<Integer> topDogNumbers = dao.selectResultDogNumbers(resultNumber);

		List<ArchiveListDTO> recommendedDogs = new ArrayList<>();

		for (Integer dogNumber : topDogNumbers) {
			ArchiveListDTO dog = dao.selectDogCardByDogNumber(dogNumber);
			if (dog != null) {
				recommendedDogs.add(dog);
			}
		}

		String resultComment = makeResultComment(matchingResultDTO);

		request.setAttribute("recommendedDogs", recommendedDogs);
		request.setAttribute("resultComment", resultComment);

		result.setPath("/app/dogmatching/dogmatching_result.jsp");
		result.setRedirect(false);

		return result;
	}

	private String makeResultComment(MatchingResultDTO dto) {
		double activityAvg = (double) dto.getDogActivity() / 4;
		double socialityAvg = (double) dto.getDogSociality() / 4;
		double independenceAvg = (double) dto.getDogIndependence() / 4;
		double barkingAvg = (double) dto.getDogBarking() / 4;
		double groomingAvg = (double) dto.getDogGrooming() / 4;

		String activityComment = getActivityComment(activityAvg);
		String socialityComment = getSocialityComment(socialityAvg);
		String independenceComment = getIndependenceComment(independenceAvg);
		String barkingComment = getBarkingComment(barkingAvg);
		String groomingComment = getGroomingComment(groomingAvg);

		return "입력한 응답을 보면 "
				+ activityComment + ", "
				+ socialityComment + "<br>"
				+ ". 또한 "
				+ independenceComment + ", "
				+ barkingComment + ", " + "<br>"
				+ groomingComment + ".";
	}

	private String getActivityComment(double avg) {
		if (avg >= 4.0) return "활동량이 있는 반려견과 잘 맞는 편이고";
		if (avg >= 2.5) return "적당한 활동성을 가진 반려견을 선호하는 편이고";
		return "차분하고 무리한 활동이 적은 반려견이 더 잘 맞는 편이고";
	}

	private String getSocialityComment(double avg) {
		if (avg >= 4.0) return "사회성이 좋은 성향을 중요하게 보는 편이에요";
		if (avg >= 2.5) return "무난한 사회성을 가진 반려견과 잘 맞는 편이에요";
		return "조용하고 낯선 환경에 크게 예민하지 않은 성향이 더 잘 맞는 편이에요";
	}

	private String getIndependenceComment(double avg) {
		if (avg >= 4.0) return "혼자 있는 시간에도 안정적인 성향과 잘 맞아요";
		if (avg >= 2.5) return "독립성과 교감의 균형이 있는 성향을 선호하는 편이에요";
		return "보호자와의 교감이 많은 성향을 더 선호하는 편이에요";
	}

	private String getBarkingComment(double avg) {
		if (avg >= 4.0) return "생활 소음 부담이 적은 조용한 친구들을 중요하게 보셨어요";
		if (avg >= 2.5) return "짖음 정도가 과하지 않은 무난한 성향을 선호하는 편이에요";
		return "짖음에 대해서는 비교적 유연한 편이에요";
	}

	private String getGroomingComment(double avg) {
		if (avg >= 4.0) return "털 관리 부담이 적은 친구들이 더 잘 맞아요";
		if (avg >= 2.5) return "그루밍 부담이 과하지 않은 친구들을 선호하는 편이에요";
		return "털관리나 미용에 어느 정도 시간을 들일 수 있는 편이에요";
	}
}