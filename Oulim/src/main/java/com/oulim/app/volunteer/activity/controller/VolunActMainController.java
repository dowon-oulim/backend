package com.oulim.app.volunteer.activity.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerActivityDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunActMainController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VolunteerActivityDAO volunActDAO = new VolunteerActivityDAO();
		List<VolunActivityDTO> volunActList = volunActDAO.selectMainVolActList();
		
		
		try (PrintWriter out = response.getWriter()) {
			StringBuilder json = new StringBuilder();
			json.append("{");
			json.append("\"volunActList\":[");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			if (volunActList != null && !volunActList.isEmpty()) {

				for (int i = 0; i < volunActList.size(); i++) {
					VolunActivityDTO volunAct = volunActList.get(i);
					json.append("{");
					json.append("\"volunActNo\":\"").append(volunAct.getVolunActNo()).append("\",");
					json.append("\"volunActTitle\":\"").append(volunAct.getVolunActTitle()).append("\",");
					json.append("\"volunActStatus\":\"").append(volunAct.getRecruStatus()).append("\",");
					json.append("\"volunActPoint\":\"").append(volunAct.getVolunActPoint()).append("\",");
					json.append("\"volunActAddress\":\"").append(volunAct.getVolunActAddress()).append("\"");					
					json.append("}");
					if (i < volunActList.size() - 1) {
						json.append(",");
					}
				}
			}			
			json.append("]");
			json.append("}");

			out.write(json.toString());
			out.flush();
		}
		return null;
	}

}
