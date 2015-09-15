package groupbase.thn.web.videoapp.model;

import groupbase.thn.web.libs.ModelBase;
import groupbase.thn.web.libs.View;

public class HomeModel extends ModelBase{

	@Override
	public View init() {
		// TODO Auto-generated method stub
		return new View("home");
	}
	
	public View init(String videocode,String packageId) {
		// TODO Auto-generated method stub
		View view = new View("home");
		view.setData("code", videocode);
		view.setData("packageId", packageId);
		return view;
	}
}
