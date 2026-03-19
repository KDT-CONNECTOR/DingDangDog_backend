package com.ddd.app.dogcare.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.dogcare.dao.CareDAO;

public class CareCancelController implements Execute{
// 마이페이지로 이동 예정
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=== CareCancelController 실행 ===");
		
		CareDAO careDAO = new CareDAO();
		Map<String, Integer> map = new HashMap<>();
		Result result = new Result();
		
		// 게시글 번호 받기
		int careNumber = Integer.parseInt(request.getParameter("careNumber"));
		// 회원 번호 받기
		int userNumber = Integer.parseInt(request.getParameter("userNumber"));

		
		map.put("careNumber", careNumber);
		map.put("userNumber", userNumber);

		// 봉사 신청 취소
		careDAO.cancelApply(map);
		
		result.setRedirect(true);
		result.setPath("/care/detail.ca?careNumber=" + careNumber);

		return result;
	}

}
