package com.ddd.app.dogcare.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.dogcare.dao.CareDAO;

public class CareDeleteController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("=== CareDeleteController 실행 ===");

		CareDAO careDAO = new CareDAO();
		Result result = new Result();
		
		// 게시글 번호 받기
		int careNumber = Integer.parseInt(request.getParameter("careNumber"));
		System.out.println("삭제할 글 번호 : " + careNumber);

		// 게시글 삭제
		careDAO.deleteCare(careNumber);
		System.out.println("삭제 완료");

		// 목록으로 이동 (redirect)
		result.setPath(request.getContextPath() + "/care/list.ca");
		result.setRedirect(true);

		return result;
	}

}
