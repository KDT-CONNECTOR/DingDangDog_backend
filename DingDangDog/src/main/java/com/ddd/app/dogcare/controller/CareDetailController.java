package com.ddd.app.dogcare.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.dogcare.dao.CareDAO;
import com.ddd.app.dogcare.dto.CareDetailDTO;

public class CareDetailController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=== CareDetailController 실행 ===");
		
		CareDAO careDAO = new CareDAO();
		Result result = new Result();
		
		int careNumber = Integer.parseInt(request.getParameter("careNumber"));
		
		CareDetailDTO detail = careDAO.selectCare(careNumber);

		request.setAttribute("care", detail);

		result.setPath("/app/care/care_detail_common.jsp");
		result.setRedirect(false);

		return result;
	}
	
}
