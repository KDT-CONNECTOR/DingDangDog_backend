package com.ddd.app.mypage.controller;

// ===== 마이페이지 매칭 =====
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Result;

public class MyPageDogMatchingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ===== Encoding - UTF-8 =====
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = null;

		// ===== 요청별 분기 처리 =====
		switch (target) {

		// ===== 설문 페이지 이동 =====
		case "/matching/test.matching":
			result = new Result();

			// ===== dogmatching.jsp로 이동 =====
			result.setPath("/app/dogmatching/dogmatching.jsp");
			result.setRedirect(false);
			break;

		// ===== MyPageDogMatchingOkController =====
		case "/matching/matchingOk.matching":
			// ===== 5건 제한 저장 =====
			result = new MyPageDogMatchingOkController().execute(request, response);
			break;

		// ===== 매칭 결과 상세 보기 =====
		case "/matching/result.matching":
			break;

		// ===== 매칭 리스트 보기 =====
		case "/matching/list.matching":
			break;
		}

		// ===== 최종 페이지 이동 =====
		if (result != null && result.getPath() != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	}
}