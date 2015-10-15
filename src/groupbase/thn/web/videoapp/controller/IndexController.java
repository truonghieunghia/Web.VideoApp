package groupbase.thn.web.videoapp.controller;

import groupbase.thn.web.libs.CtlBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.videoapp.model.IndexModel;

public class IndexController extends CtlBase<IndexModel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public View doGet() {
		// TODO Auto-generated method stub
		String param = this.getParam("v");	
		String page = this.getParam("page");
		if (param!=null){
			String appid = this.getParam("appid");
			return Model.init(param,appid);
		}
		if (page!=null){
			return Model.nextPage(page);
		}
		return Model.init();
	}

	@Override
	public View doPost() {
		// TODO Auto-generated method stub
		return null;
	}

}
