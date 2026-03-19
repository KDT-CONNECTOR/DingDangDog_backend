package com.ddd.app.dogarchive.controller;

// ===== 멍 카이브 작성 ===== 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;

public class ArchiveWriteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		// ===== archiveWrite.jsp로 이동 =====
		result.setPath("/app/dogarchive/archiveWrite.jsp");
		result.setRedirect(false);

		return result;
	}
}