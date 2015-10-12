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
		if (param!=null){
			String appid = this.getParam("appid");
			return Model.init(param,appid);
		}
		return Model.init();
	}

	@Override
	public View doPost() {
		// TODO Auto-generated method stub
		return null;
	}

}
