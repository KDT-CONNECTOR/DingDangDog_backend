package com.ddd.app.dogcare.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.dogcare.dao.CareDAO;
import com.ddd.app.dogcare.dto.CareListDTO;

public class CareListController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=== CareListController 실행 ===");
		CareDAO careDAO = new CareDAO();
		Result result = new Result();

		// 페이징 처리
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp);

		int rowCount = 15;
		int pageCount = 5;

		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow + rowCount - 1;

		// 검색어 받기
		String keyword = request.getParameter("keyword");

		// Map 하나로 통합
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		if (keyword != null && !keyword.trim().isEmpty()) {
			pageMap.put("keyword", keyword);
		}

		System.out.println("페이지 + 검색 조건 : " + pageMap);

		// DAO 호출
		List<CareListDTO> careList = careDAO.selectCareList(pageMap);
		request.setAttribute("careList", careList);

		// 검색어 유지
		request.setAttribute("keyword", keyword);

		// 페이징
		int total = careDAO.getTotal();
		int realEndPage = (int) Math.ceil(total / (double) rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);

		endPage = Math.min(endPage, realEndPage);

		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		request.setAttribute("page", page);
		request.setAttribute("startpage", startPage);
		request.setAttribute("endpage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);

		result.setPath("/app/dogcare/dogcare_list_shelter.jsp");
		result.setRedirect(false);
		return result;
	}
}