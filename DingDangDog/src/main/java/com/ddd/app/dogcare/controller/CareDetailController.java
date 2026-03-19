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
		System.out.println("상세정보 출력");
		
		CareDetailDTO care = careDAO.selectCare(careNumber);

		// 신청현황 따로 조회
		String applyStatus = careDAO.getApplyStatus(careNumber);
		// care 객체에 넣기
		care.setApplyStatus(applyStatus);
		// request에 담기
		request.setAttribute("care", care);
		System.out.println("care."+detail.getApplyStatus());

		result.setPath("/app/dogcare/dogcare_detail_shelter.jsp");
		result.setRedirect(false);

		return result;
	}
	
}
