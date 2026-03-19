package com.ddd.app.dogcare.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddd.app.Execute;
import com.ddd.app.Result;

public class CareWriteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("=== CareWriteController 실행 ===");

        Result result = new Result();
        result.setPath("/app/dogcare/dogcare_write.jsp");
        result.setRedirect(false);

        return result;
    }
}