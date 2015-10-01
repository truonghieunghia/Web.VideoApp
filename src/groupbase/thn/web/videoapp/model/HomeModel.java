package groupbase.thn.web.videoapp.model;

import groupbase.thn.web.libs.ModelBase;
import groupbase.thn.web.libs.View;

public class HomeModel extends ModelBase{

	@Override
	public View init() {
		// TODO Auto-generated method stub
		return new View("home");
	}
	
	public View init(String videocode,String packageId,String title,String image_url,String parameter) {
		// TODO Auto-generated method stub
		View view = new View("home");
		view.setData("code", videocode);
		view.setData("packageId", packageId);
		view.setData("title", title);
		view.setData("image_url", image_url);
		view.setData("query", parameter);
		return view;
	}
}
