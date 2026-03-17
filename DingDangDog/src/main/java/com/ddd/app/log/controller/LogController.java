package com.ddd.app.log.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.log.dao.LogDAO;
import com.ddd.app.log.dto.LogDTO;


public class LogController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("LogController 요청 : " + target);

		switch (target) {

		case "/log/list.lo":
		    LogDAO logDAO = new LogDAO();
		    List<LogDTO> logList = logDAO.selectAll();

		    request.setAttribute("logList", logList);
		    request.getRequestDispatcher("/app/doglog/doglog_list.jsp").forward(request, response);
		    break;

		case "/log/detail.lo":
			System.out.println("멍! 로그 상세");
			request.getRequestDispatcher("/app/doglog/doglog_detail.jsp").forward(request, response);
			break;

		case "/log/write.lo":
			System.out.println("멍! 로그 작성 페이지");
			request.getRequestDispatcher("/app/doglog/doglog_write.jsp").forward(request, response);
			break;

		case "/log/writeOk.lo":
			System.out.println("멍! 로그 작성 완료");
			response.sendRedirect(request.getContextPath() + "/log/list.lo");
			break;

		case "/log/edit.lo":
			System.out.println("멍! 로그 수정 페이지");
			request.getRequestDispatcher("/app/doglog/doglog_edit.jsp").forward(request, response);
			break;

		case "/log/editOk.lo":
			System.out.println("멍! 로그 수정 완료");
			response.sendRedirect(request.getContextPath() + "/log/detail.lo");
			break;

		case "/log/deleteOk.lo":
			System.out.println("멍! 로그 삭제 완료");
			response.sendRedirect(request.getContextPath() + "/log/list.lo");
			break;

		default:
			System.out.println("잘못된 요청");
			break;
		}
	}
}