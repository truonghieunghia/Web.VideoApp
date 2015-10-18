package groupbase.thn.web.videoapp.model;

import java.net.URLEncoder;

import groupbase.thn.web.libs.ModelBase;
import groupbase.thn.web.libs.View;

public class PlayModel extends ModelBase{

	@Override
	public View init() {
		// TODO Auto-generated method stub
		return null;
	}
	public View init(String videocode,String packageId,String title,String image_url,String parameter) {
		// TODO Auto-generated method stub
		View view = new View("home");
		view.setData("code", videocode);
		view.setData("packageId", packageId);
		view.setData("title", title);
		view.setData("image_url", image_url);
		view.setData("query", parameter);
		if (packageId.contains("phimle")){
			view.setData("selected", 3);
		}
		if (packageId.contains("phimbo")){
			view.setData("selected", 1);
		}
		if (packageId.contains("phimviet")){
			view.setData("selected", 7);
		}
		if (packageId.contains("cliphai")){
			view.setData("selected", 6);
		}
		if (packageId.contains("clipvl")){
			view.setData("selected", 5);
		}
		return view;
	}
}
