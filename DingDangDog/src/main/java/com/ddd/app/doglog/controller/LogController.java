package com.ddd.app.doglog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.doglog.dao.LogCommentDAO;
import com.ddd.app.doglog.dao.LogDAO;
import com.ddd.app.doglog.dao.LogImgDAO;
import com.ddd.app.doglog.dto.LogCommentDTO;
import com.ddd.app.doglog.dto.LogDTO;
import com.ddd.app.doglog.dto.LogImgDTO;

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
			System.out.println("멍! 로그 목록");
			LogDAO logDAO = new LogDAO();
			List<LogDTO> logList = logDAO.selectAll();
			System.out.println("조회된 logList 개수 : " + logList.size());

			request.setAttribute("logList", logList);
			request.getRequestDispatcher("/apps/doglog/doglog_list.jsp").forward(request, response);
			break;

		case "/log/detail.lo": {
			System.out.println("멍! 로그 상세");

			int logNumber = Integer.parseInt(request.getParameter("logNumber"));

			LogDAO detailDAO = new LogDAO();
			LogImgDAO detailImgDAO = new LogImgDAO();
			LogCommentDAO logCommentDAO = new LogCommentDAO();

			LogDTO log = detailDAO.selectDetail(logNumber);
			List<LogImgDTO> imageList = detailImgDAO.selectImageList(logNumber);
			List<LogCommentDTO> commentList = logCommentDAO.selectCommentList(logNumber);

			request.setAttribute("log", log);
			request.setAttribute("imageList", imageList);
			request.setAttribute("commentList", commentList);

			request.getRequestDispatcher("/apps/doglog/doglog_detail.jsp").forward(request, response);
			break;
		}
			


		case "/log/write.lo":
			System.out.println("멍! 로그 작성 페이지");
			request.getRequestDispatcher("/apps/doglog/doglog_write.jsp").forward(request, response);
			break;

		case "/log/writeOk.lo":
			System.out.println("멍! 로그 작성 완료");
			response.sendRedirect(request.getContextPath() + "/log/list.lo");
			break;

		case "/log/edit.lo": {
			System.out.println("멍! 로그 수정 페이지");

			int editLogNumber = Integer.parseInt(request.getParameter("logNumber"));
			LogDAO editDAO = new LogDAO();
			LogDTO editLog = editDAO.selectDetail(editLogNumber);

			LogImgDAO editImgDAO = new LogImgDAO();
			List<LogImgDTO> imageList = editImgDAO.selectImageList(editLogNumber);

			request.setAttribute("log", editLog);
			request.setAttribute("imageList", imageList);
			request.getRequestDispatcher("/apps/doglog/doglog_edit.jsp").forward(request, response);
			break;
		}

		case "/log/editOk.lo": {
			System.out.println("멍! 로그 수정 완료");

			int logNumber = Integer.parseInt(request.getParameter("logNumber"));
			String logTitle = request.getParameter("logTitle");
			String logPost = request.getParameter("logPost");
			String deleteImageIds = request.getParameter("deleteImageIds");

			// 1. 게시글 수정
			LogDTO updateLog = new LogDTO();
			updateLog.setLogNumber(logNumber);
			updateLog.setLogTitle(logTitle);
			updateLog.setLogPost(logPost);

			LogDAO updateDAO = new LogDAO();
			updateDAO.update(updateLog);

			// 2. 삭제할 기존 이미지가 있으면 삭제
			LogImgDAO logImgDAO = new LogImgDAO();

			if (deleteImageIds != null && !deleteImageIds.trim().isEmpty()) {
				String[] deleteIds = deleteImageIds.split(",");

				for (String id : deleteIds) {
					if (id != null && !id.trim().isEmpty()) {
						int logImgNumber = Integer.parseInt(id.trim());
						logImgDAO.deleteImageByImageNumber(logImgNumber);
					}
				}
			}

			// 3. 새 이미지 추가
			// 이 부분은 파일 업로드 처리 방식 정한 뒤 붙여야 함

			response.sendRedirect(request.getContextPath() + "/log/detail.lo?logNumber=" + logNumber);
			break;
		}

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