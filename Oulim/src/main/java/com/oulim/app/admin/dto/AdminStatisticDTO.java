package com.oulim.app.admin.dto;

import java.time.LocalDateTime;

public class AdminStatisticDTO {
//	u.total_user,
//	u.NOT_APPROVED_ORGAN_USER,
//	u.total_organ_user,
//	o.organ_count,
//	ap.uncomplete_volun_act,
//	va.TOTAL_VOLUN_ACT 
	private int totalUser;
	private int notApprovedOrganUser;
	private int totalOrganUser;
	private int organCount;
	private int uncompleteVolunAct;
	private int totalVolunAct;
	private LocalDateTime currDate;
	public int getTotalUser() {
		return totalUser;
	}
	public void setTotalUser(int totalUser) {
		this.totalUser = totalUser;
	}
	public int getNotApprovedOrganUser() {
		return notApprovedOrganUser;
	}
	public void setNotApprovedOrganUser(int notApprovedOrganUser) {
		this.notApprovedOrganUser = notApprovedOrganUser;
	}
	public int getTotalOrganUser() {
		return totalOrganUser;
	}
	public void setTotalOrganUser(int totalOrganUser) {
		this.totalOrganUser = totalOrganUser;
	}
	public int getOrganCount() {
		return organCount;
	}
	public void setOrganCount(int organCount) {
		this.organCount = organCount;
	}
	public int getUncompleteVolunAct() {
		return uncompleteVolunAct;
	}
	public void setUncompleteVolunAct(int uncompleteVolunAct) {
		this.uncompleteVolunAct = uncompleteVolunAct;
	}
	public int getTotalVolunAct() {
		return totalVolunAct;
	}
	public void setTotalVolunAct(int totalVolunAct) {
		this.totalVolunAct = totalVolunAct;
	}
	
	public LocalDateTime getCurrDate() {
		return currDate;
	}
	public void setCurrDate(LocalDateTime currDate) {
		this.currDate = currDate;
	}
	@Override
	public String toString() {
		return "AdminStatisticDTO [totalUser=" + totalUser + ", notApprovedOrganUser=" + notApprovedOrganUser
				+ ", totalOrganUser=" + totalOrganUser + ", organCount=" + organCount + ", uncompleteVolunAct="
				+ uncompleteVolunAct + ", totalVolunAct=" + totalVolunAct + "]";
	}
}
