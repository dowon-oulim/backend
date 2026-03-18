package com.oulim.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.admin.dao.AdminDAO;
import com.oulim.app.admin.dto.AdminDTO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class AdminLoginOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stuob
		
	    AdminDTO adminDTO = new AdminDTO();
	    AdminDAO adminDAO = new AdminDAO();
	    Result result = new Result();

	    String adminId = request.getParameter("adminId");
	    String adminPw = request.getParameter("adminPw");
	    HttpSession session = request.getSession();

	    adminDTO.setAdminId(adminId);
	    adminDTO.setAdminPw(adminPw);

	    AdminDTO loginAdmin = adminDAO.login(adminDTO);

	    String path;

	    if (loginAdmin != null) {
	        // 로그인 성공
	        session.setAttribute("adminNo", loginAdmin.getAdminNum());
	        path = "/app/admin/jsp/dashboard/dashboard/"; // 로그인 성공 시 대시보드
	    } else {
	        // 로그인 실패
	        path = "/app/admin/jsp/login.usr?login=fail";
	    }

	    result.setPath(path);
	    result.setRedirect(true);

	    return result;
	}

}
