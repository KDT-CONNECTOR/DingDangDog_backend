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

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int careNumber = Integer.parseInt(request.getParameter("careNumber"));
		int userNumber = Integer.parseInt(request.getParameter("userNumber"));

		Map<String, Integer> map = new HashMap<>();
		map.put("careNumber", careNumber);
		map.put("userNumber", userNumber);

		CareDAO careDAO = new CareDAO();
		careDAO.cancelApply(map);

		Result result = new Result();
		result.setRedirect(true);
		result.setPath("/care/detail.care?careNumber=" + careNumber);

		return result;
	}

}
