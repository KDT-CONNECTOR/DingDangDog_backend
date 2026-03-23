package com.ddd.app.dogmatching.controller;

// ===== 멍! 매칭 결과 저장 =====
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.dogmatching.dao.MatchingResultDAO;
import com.ddd.app.dogmatching.dto.MatchingResultDTO;

public class MatchingResultSaveController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MatchingResultDAO dao = new MatchingResultDAO();
		Result result = new Result();
		HttpSession session = request.getSession();

		// ===== 로그인 사용자 확인 =====
		Integer userNumber = (Integer) session.getAttribute("userNumber");

		if (userNumber == null) {
			System.out.println("세션에 userNumber가 없습니다.");
			result.setPath(request.getContextPath() + "/matching/test.ma");
			result.setRedirect(true);
			return result;
		}

		// ===== 세션에 저장된 최근 설문 결과/추천 번호 꺼내기 =====
		MatchingResultDTO matchingResultDTO = (MatchingResultDTO) session.getAttribute("matchingResultDTO");

		@SuppressWarnings("unchecked")
		List<Integer> topDogNumbers = (List<Integer>) session.getAttribute("topDogNumbers");

		if (matchingResultDTO == null || topDogNumbers == null || topDogNumbers.isEmpty()) {
			System.out.println("저장할 매칭 결과 정보가 세션에 없습니다.");
			result.setPath(request.getContextPath() + "/matching/test.ma");
			result.setRedirect(true);
			return result;
		}

		// ===== 혹시 세션 dto의 userNumber가 비어있을 수 있으니 다시 세팅 =====
		matchingResultDTO.setUserNumber(userNumber);

		// ===== 저장 개수 확인 =====
		int savedCount = dao.countSavedResults(userNumber);

		// ===== 5개 이상이면 가장 오래된 결과 삭제 =====
		if (savedCount >= 5) {
			dao.deleteOldestResult(userNumber);
		}

		// ===== 새 resultNumber 발급 =====
		int resultNumber = dao.getNextResultNumber();
		matchingResultDTO.setResultNumber(resultNumber);

		// ===== 헤더 저장 =====
		dao.insertResult(matchingResultDTO);

		// ===== 추천 강아지 8마리 저장 =====
		for (int i = 0; i < topDogNumbers.size(); i++) {
			MatchingResultDTO dogResultDTO = new MatchingResultDTO();
			dogResultDTO.setResultNumber(resultNumber);
			dogResultDTO.setDogNumber(topDogNumbers.get(i));
			dogResultDTO.setResultRank(i + 1);

			dao.insertResultDog(dogResultDTO);
		}

		System.out.println("매칭 결과 저장 완료, resultNumber = " + resultNumber);

		// ===== 저장 후 다시 결과 페이지로 이동 =====
		result.setPath(request.getContextPath() + "/matching/result.ma?resultNumber=" + resultNumber);
		result.setRedirect(true);

		return result;
	}
}