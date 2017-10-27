package com.xxyjsjgcxy.scarousel.action;

import com.opensymphony.xwork2.ActionContext;

public class SkipAction {

	public SkipAction() {
	}

	public String skipToAddJsp() {
		return "successToAddJsp";

	}

	public String skipToDeleteJsp() {
		return "successToDeleteJsp";
	}

	public String skipToQueryJsp() {
		return "successToQueryJsp";
	}

	public String skipToAdd() {
		ActionContext.getContext().getValueStack().set("page", "skipToAdd");
		return "successAdd";
	}

	public String skipToDelete() {
		ActionContext.getContext().getValueStack().set("page", "skipToDelete");
		return "successDelete";
	}

	public String skipToQuery() {
		return "successQuery";
	}
}