package com.oulim.app.volunteer.activity.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerActivityDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunActListController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    VolunteerActivityDAO dao = new VolunteerActivityDAO();
	    VolunActivityDTO dto = new VolunActivityDTO();

	    // ===================== 파라미터 =====================
	    String actType = request.getParameter("actType");
	    String ageGroup = request.getParameter("ageGroup");
	    String recruitStatus = request.getParameter("recruitStatus");
	    String keyword = request.getParameter("keyword");
	    String searchType = request.getParameter("searchType");
	    String organization = request.getParameter("organization");

	    dto.setVolunActActType(actType == null || actType.equals("0") ? 0 : Integer.parseInt(actType));
	    dto.setVolunActAgeGroup(ageGroup == null || ageGroup.equals("0") ? 0 : Integer.parseInt(ageGroup));
	    dto.setRecruitStatus(recruitStatus == null ? "0" : recruitStatus);
	    dto.setKeyword(keyword);
	    dto.setSearchType(searchType);
	    dto.setOrganization(organization);

	    // ===================== 페이징 =====================
	    int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
	    int size = 10;

	    int totalCount = dao.selectCount(dto);
	    int totalPage = (int) Math.ceil((double) totalCount / size);

	    int pageBlock = 5;
	    int startPage = ((page - 1) / pageBlock) * pageBlock + 1;
	    int endPage = Math.min(startPage + pageBlock - 1, totalPage);

	    int startRow = (page - 1) * size;
	    int endRow = page * size;

	    dto.setStartRow(startRow);
	    dto.setEndRow(endRow);

	    // ===================== 조회 =====================
	    List<VolunActivityDTO> list = dao.selectVolActList(dto);

	    // ===================== 전달 =====================
	    request.setAttribute("volunteerList", list);
	    request.setAttribute("search", dto);
	    request.setAttribute("page", page);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("totalPage", totalPage);

	    Result result = new Result();
	    result.setPath("/app/volunteer-activity/volunAct-list.jsp");
	    result.setRedirect(false);

	    return result;
	}
}