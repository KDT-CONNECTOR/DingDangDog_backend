package com.ddd.app.dogcare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.dogcare.dao.CareDAO;
import com.ddd.app.dogcare.dto.CareApplyDTO;

public class CareApplyController implements Execute{

	public Result execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("=== CareApplyController 실행 ===");

		CareDAO careDAO = new CareDAO();
		CareApplyDTO dto = new CareApplyDTO();
		Result result = new Result();
		
		// 게시글 번호 받기
		int careNumber = Integer.parseInt(request.getParameter("careNumber"));
		// 회원 번호 받기
		int userNumber = Integer.parseInt(request.getParameter("userNumber"));
		
		dto.setCareNumber(careNumber);
		dto.setUserNumber(userNumber);
		
		// 봉사 신청
		careDAO.applyCare(dto);
		
		result.setPath("/app/care/detail.ca?careNumber=" + careNumber);
		result.setRedirect(true);

		return result;
	}

}
