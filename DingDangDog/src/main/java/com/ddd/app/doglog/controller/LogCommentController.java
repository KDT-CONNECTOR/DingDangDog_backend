package com.ddd.app.doglog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.doglog.dao.LogCommentDAO;
import com.ddd.app.doglog.dto.LogCommentDTO;

public class LogCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogCommentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

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
		System.out.println("LogCommentController 요청 : " + target);

		switch (target) {

		// 댓글 작성 완료
		case "/comment/writeOk.lc":
			System.out.println("댓글 작성 완료");

			int writeLogNumber = Integer.parseInt(request.getParameter("logNumber"));
			String commentPost = request.getParameter("commentPost");

			Integer writeUserNumber = (Integer) request.getSession().getAttribute("userNumber");

			LogCommentDTO writeCommentDTO = new LogCommentDTO();
			writeCommentDTO.setLogNumber(writeLogNumber);
			writeCommentDTO.setUserNumber(writeUserNumber);
			writeCommentDTO.setCommentPost(commentPost);

			LogCommentDAO writeCommentDAO = new LogCommentDAO();
			writeCommentDAO.insertComment(writeCommentDTO);

			response.sendRedirect(request.getContextPath() + "/log/detail.lo?logNumber=" + writeLogNumber);
			break;

		// 댓글 수정 페이지
		case "/comment/edit.lc":
			System.out.println("댓글 수정 페이지");

			int editCommentNumber = Integer.parseInt(request.getParameter("commentNumber"));
			int editLogNumber = Integer.parseInt(request.getParameter("logNumber"));

			LogCommentDAO editCommentDAO = new LogCommentDAO();
			LogCommentDTO editComment = editCommentDAO.selectComment(editCommentNumber);

			request.setAttribute("comment", editComment);
			request.setAttribute("logNumber", editLogNumber);
			request.getRequestDispatcher("/apps/doglog/doglog_comment_edit.jsp").forward(request, response);
			break;

		// 댓글 수정 완료
		case "/comment/editOk.lc":
			System.out.println("댓글 수정 완료");

			int updateCommentNumber = Integer.parseInt(request.getParameter("commentNumber"));
			int updateLogNumber = Integer.parseInt(request.getParameter("logNumber"));
			String updateCommentPost = request.getParameter("commentPost");

			Integer updateUserNumber = (Integer) request.getSession().getAttribute("userNumber");

			LogCommentDTO updateCommentDTO = new LogCommentDTO();
			updateCommentDTO.setCommentNumber(updateCommentNumber);
			updateCommentDTO.setLogNumber(updateLogNumber);
			updateCommentDTO.setUserNumber(updateUserNumber);
			updateCommentDTO.setCommentPost(updateCommentPost);

			LogCommentDAO updateCommentDAO = new LogCommentDAO();
			updateCommentDAO.updateComment(updateCommentDTO);

			response.sendRedirect(request.getContextPath() + "/log/detail.lo?logNumber=" + updateLogNumber);
			break;

		// 댓글 삭제 완료
		case "/comment/deleteOk.lc":
			System.out.println("댓글 삭제 완료");

			int deleteCommentNumber = Integer.parseInt(request.getParameter("commentNumber"));
			int deleteLogNumber = Integer.parseInt(request.getParameter("logNumber"));

			Integer deleteUserNumber = (Integer) request.getSession().getAttribute("userNumber");

			LogCommentDTO deleteCommentDTO = new LogCommentDTO();
			deleteCommentDTO.setCommentNumber(deleteCommentNumber);
			deleteCommentDTO.setUserNumber(deleteUserNumber);

			LogCommentDAO deleteCommentDAO = new LogCommentDAO();
			deleteCommentDAO.deleteComment(deleteCommentDTO);

			response.sendRedirect(request.getContextPath() + "/log/detail.lo?logNumber=" + deleteLogNumber);
			break;

		default:
			System.out.println("잘못된 댓글 요청");
			break;
		}
	}
}