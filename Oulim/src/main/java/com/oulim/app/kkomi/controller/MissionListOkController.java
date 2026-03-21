package com.oulim.app.kkomi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.kkomi.dao.KkomiDAO;
import com.oulim.app.kkomi.dto.UserMissionDTO;

public class MissionListOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KkomiDAO kkomiDAO = new KkomiDAO();
		List<UserMissionDTO> missionList = new ArrayList<UserMissionDTO>();
		
		return null;
	}

}
