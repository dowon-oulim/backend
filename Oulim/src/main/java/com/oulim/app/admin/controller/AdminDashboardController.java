package com.oulim.app.admin.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminDAO;
import com.oulim.app.admin.dto.AdminStatisticDTO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.user.dto.UserDTO;

public class AdminDashboardController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Result result = new Result();
		System.out.println("대쉬보드 진입요청");
		AdminDAO adminDAO = new AdminDAO();
		
		AdminStatisticDTO statisticDTO = adminDAO.getStatistic();
		statisticDTO.setCurrDate(LocalDateTime.now());
		List<UserDTO> userList = adminDAO.getUnApprovedOrganUser();
		userList = userList.stream().sorted(Comparator.comparingInt(UserDTO::getUserNo).reversed()).limit(3).toList();
		System.out.println(userList);
		System.out.println(statisticDTO);
		request.setAttribute("statistic", statisticDTO);
		request.setAttribute("userList", userList);
			
		result.setPath("/app/admin/jsp/dashboard/dashboard.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
	

}
