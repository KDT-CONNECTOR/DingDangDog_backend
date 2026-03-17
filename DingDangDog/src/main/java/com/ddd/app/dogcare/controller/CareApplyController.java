package com.ddd.app.dogcare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.dogcare.dao.CareDAO;
import com.ddd.app.dogcare.dto.CareApplyDTO;

public class CareApplyController implements Execute{

	public Result execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CareApplyController 실행");

		int careNumber = Integer.parseInt(request.getParameter("careNumber"));
		int userNumber = Integer.parseInt(request.getParameter("userNumber"));

		CareApplyDTO dto = new CareApplyDTO();
		dto.setCareNumber(careNumber);
		dto.setUserNumber(userNumber);

		CareDAO careDAO = new CareDAO();

		careDAO.applyCare(dto);

		Result result = new Result();
		result.setRedirect(true);
		result.setPath("/app/care/detail.care?careNumber=" + careNumber);

		return result;
	}

}
