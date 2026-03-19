package com.ddd.app.mypage.controller;
// ===== 마이페이지 리스트 저장 (5건) ===== 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ddd.app.Result;
import com.ddd.app.mypage.dao.MypageDAO;
import com.ddd.app.mypage.dto.MyPageDogMatchingDTO;

public class MyPageDogMatchingOkController {
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 객체
		Result result = new Result();
		MypageDAO dao = new MypageDAO();
		MyPageDogMatchingDTO dto = new MyPageDogMatchingDTO();

		// ===== 로그인한 userNumber =====
		HttpSession session = request.getSession();
		Integer userNumber = (Integer) session.getAttribute("userNumber");

		// ===== 로그인 안 되었을 시 -> 로그인 페이지로 이동 =====
		if (userNumber == null) {
			result.setPath(request.getContextPath() + "/user/login.me");
			result.setRedirect(true);
			return result;
		}

		// ===== userNumber =====
		dto.setUserNumber(userNumber);

		// ===== DB에 저장된 개수 확인 (5개이상 인지 아닌지) =====
		int currentCount = dao.countSavedResults(userNumber);
		System.out.println("현재 저장된 매칭 건수: " + currentCount);

		// ===== 저장 개수 5건 이상이면 삭제 =====
		if (currentCount >= 5) {
			dao.deleteOldestResult(userNumber);
			System.out.println("5건 초과로 인한 가장 오래된 기록 삭제 완료");
		}

		// ===== 새로운 매칭 결과 DB 저장 =====
		dao.insertMatchingResult(dto);
		System.out.println("새로운 매칭 결과 저장 성공");

		// ===== 결과 페이지로 이동 =====
		result.setPath(request.getContextPath() + "/matching/result.matching");
		result.setRedirect(true);

		return result;

	}
}
