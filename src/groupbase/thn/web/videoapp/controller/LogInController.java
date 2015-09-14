package groupbase.thn.web.videoapp.controller;

import groupbase.thn.web.libs.CtlBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.videoapp.model.LogInModel;

public class LogInController extends CtlBase<LogInModel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public View doGet() {
		// TODO Auto-generated method stub
		return new View("login");
	}

	@Override
	public View doPost() {
		// TODO Auto-generated method stub
		return Model.login(getParam("username"), getParam("password"), getSession(), getParam("url"));
	}

}
