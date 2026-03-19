package com.ddd.app.report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;
import com.ddd.app.report.dao.ReportDAO;
import com.ddd.app.report.dto.ReportDTO;

public class ReportOkController implements Execute{
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("=== ReportOkController 실행 ===");
		
		Result result = new Result();
		ReportDAO reportDAO = new ReportDAO();
		ReportDTO reportDTO = new ReportDTO();
		
		int applyNumber = Integer.parseInt(request.getParameter("applyNumber"));
		int reportedNumber = Integer.parseInt(request.getParameter("reportedUserNumber"));
		String reportReason = request.getParameter("reportReason");
		
		reportDTO.setApplyNumber(applyNumber);
		reportDTO.setReportedUserNumber(reportedNumber);
		reportDTO.setReportReason(reportReason);
		
		reportDAO.insertReport(reportDTO);
		
		result.setPath(null);
		result.setRedirect(false);
		
		return result;
	}

}
