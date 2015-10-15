package groupbase.thn.web.videoapp.controller;

import groupbase.thn.web.libs.CtlBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.libs.ViewAction;
import groupbase.thn.web.videoapp.model.PlayListModel;

public class PlayListController extends CtlBase<PlayListModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public View doGet() {
		// TODO Auto-generated method stub
		String appid = this.getParam("appid");
		String list = this.getParam("list");
		String page = this.getParam("page");
		if (appid.equalsIgnoreCase("phimle")) {
			if (list == null) {
				return Model.phimle(page);
			} else {
				return Model.getList(list, 3, "phimle",page);
			}
			
		}
		if (appid.equalsIgnoreCase("phimbo")) {
			if (list == null) {
				return Model.phimbo(page);
			} else {
				return Model.getList(list, 1, "phimbo",page);
			}
			
		}
		if (appid.equalsIgnoreCase("phimviet")) {
			if (list == null) {
				return Model.phimviet(page);
			} else {
				return Model.getList(list, 7, "phimviet",page);
			}
			
		}
		if (appid.equalsIgnoreCase("cliphai")) {
			if (list == null) {
				return Model.phimhai(page);
			} else {
				return Model.getList(list, 6, "cliphai",page);
			}
			
		}

		return new View("", ViewAction.OUTTEXT);
	}

	@Override
	public View doPost() {
		// TODO Auto-generated method stub
		return null;
	}

}
