package groupbase.thn.web.videoapp.controller;

import groupbase.thn.web.libs.CtlBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.videoapp.model.PlayModel;
import groupbase.thn.web.videoapp.util.Helper;

public class PlayController extends CtlBase<PlayModel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public View doGet() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String param = this.getParam("v");
				String appid = this.getParam("appid");
				if(appid!=null){
					if (param!=null){
						//groupbase.vn.thn
						String parameter = param;
						param=Helper.base64Decode(param);
						String[] array_param = param.split(",");
						String packageId ="groupbase.vn.thn."+appid;
						String videocode = Helper.base64Decode(array_param[0]);
						String title = array_param[1];
						String image = array_param[2];
						return Model.init(videocode,packageId,title,image,parameter);
						
					}
				}else{
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
				}
				
						
				return Model.init();
	}

	@Override
	public View doPost() {
		// TODO Auto-generated method stub
		return null;
	}

}
