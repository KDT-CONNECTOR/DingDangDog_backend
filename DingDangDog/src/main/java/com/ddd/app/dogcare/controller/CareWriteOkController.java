package com.ddd.app.dogcare.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.dogcare.dao.CareDAO;
import com.ddd.app.dogcare.dto.CareDTO;

public class CareWriteOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("===== CareWriteOkController 실행 =====");

		CareDTO careDTO = new CareDTO();
		CareDAO careDAO = new CareDAO();
		HttpSession session = request.getSession();

		Integer userNumber = (Integer)session.getAttribute("userNumber");
		if(userNumber == null) {
		    throw new RuntimeException("로그인 필요");
		}
		careDTO.setUserNumber(userNumber);
//		careDTO.setUserNumber(Integer.parseInt(request.getParameter("userNumber")));
		careDTO.setCareTitle(request.getParameter("careTitle"));
		careDTO.setCarePost(request.getParameter("carePost"));
		careDTO.setCareRecruit(Integer.parseInt(request.getParameter("careRecruit")));

		String careDateStr = request.getParameter("careDate");

		if (careDateStr != null && !careDateStr.isEmpty()) {
		    LocalDateTime careDate = LocalDateTime.parse(careDateStr + "T00:00:00");
		    careDTO.setCareDate(careDate);
		}
		
		careDAO.insertCare(careDTO);

		Result result = new Result();
		result.setPath(request.getContextPath() + "/care/list.ca");
		result.setRedirect(true);

		return result;
	}

}
