package groupbase.thn.web.videoapp.api;

import groupbase.thn.web.libs.CtlBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.libs.ViewAction;
import groupbase.thn.web.videoapp.from.DevicesForm;
import groupbase.thn.web.videoapp.model.ApiModel;

import javax.servlet.ServletException;

public class ApiController extends CtlBase<ApiModel> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		mContentType = "application/json; text/plain; charset=utf-8";
	}

	@Override
	public View doGet() {
		// TODO Auto-generated method stub
		return Model.getAppsList();
	}

	@Override
	public View doPost() {
		String apiName = getParam("api");
		if (apiName.equalsIgnoreCase("registerdevice")&& apiName!=null) {
			DevicesForm devicesForm = getDataPost(DevicesForm.class);
			return Model.RegisterDevice(devicesForm);
		}else{
			return new View("",ViewAction.OUTTEXT);
		}
	}

}
