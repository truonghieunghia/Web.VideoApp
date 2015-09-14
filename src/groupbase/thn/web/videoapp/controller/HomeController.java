package groupbase.thn.web.videoapp.controller;

import groupbase.thn.web.libs.CtlBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.videoapp.model.HomeModel;

public class HomeController extends CtlBase<HomeModel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public View doGet() {
		// TODO Auto-generated method stub
		return Model.init();
	}

	@Override
	public View doPost() {
		// TODO Auto-generated method stub
		return null;
	}

}
