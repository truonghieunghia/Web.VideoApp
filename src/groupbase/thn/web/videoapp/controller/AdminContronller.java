package groupbase.thn.web.videoapp.controller;

import groupbase.thn.web.libs.CtlBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.videoapp.from.AppsForm;
import groupbase.thn.web.videoapp.from.QueryStringObject;
import groupbase.thn.web.videoapp.model.AdminModel;

public class AdminContronller extends CtlBase<AdminModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public View doGet() {
		// TODO Auto-generated method stub
		QueryStringObject page = getDataPost(QueryStringObject.class);
		if (page.page != null) {
			if (page.page.equalsIgnoreCase("Apps")) {
				return Model.initApp(page);
			}
			if (page.page.equalsIgnoreCase("Devices")) {
				return Model.initDevices(page);
			}
			if (page.page.equalsIgnoreCase("Api")) {
				return Model.initApi(page);
			}
			if (page.page.equalsIgnoreCase("Pushs")) {
				return Model.initPushs(page);
			}
		}
		return Model.init();
	}

	@Override
	public View doPost() {
		QueryStringObject page = getDataPost(QueryStringObject.class);
		if (page.page != null) {
			if (page.page.equalsIgnoreCase("Apps")) {
				if (page.action.equalsIgnoreCase("new")) {
					return Model.addApp(getDataPost(AppsForm.class));
				}
				if (page.action.equalsIgnoreCase("edit")) {
					return Model.updateApp(getDataPost(AppsForm.class),page.key);
				}
				if (page.action.equalsIgnoreCase("delete")) {
					
				}
			}
			//
			if (page.page.equalsIgnoreCase("Pushs")) {			
				return Model.PushApp(page);
			}
		}
		
		return Model.init();
	}

}
