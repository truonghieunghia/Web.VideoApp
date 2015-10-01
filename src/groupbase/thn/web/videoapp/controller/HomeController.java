package groupbase.thn.web.videoapp.controller;

import groupbase.thn.web.libs.CtlBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.videoapp.model.HomeModel;
import groupbase.thn.web.videoapp.util.Helper;

public class HomeController extends CtlBase<HomeModel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public View doGet() {
		// TODO Auto-generated method stub
		String param = this.getParam("v");
		if (param!=null){
			String parameter = param;
			param=Helper.base64Decode(param);
			String[] array_param = param.split(",");
			String packageId = array_param[0];
			String videocode = Helper.base64Decode(array_param[1]);
			String title = array_param[2];
			String image = array_param[3];
			return Model.init(videocode,packageId,title,image,parameter);
			
		}
				
		return Model.init();
	}

	@Override
	public View doPost() {
		// TODO Auto-generated method stub
		return null;
	}

}
