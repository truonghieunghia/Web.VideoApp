package groupbase.thn.web.videoapp.model;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import groupbase.thn.web.libs.ModelBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.libs.ViewAction;
import groupbase.thn.web.videoapp.data.AppList;
import groupbase.thn.web.videoapp.from.YoutubeForm;
import groupbase.thn.web.videoapp.json_object.JsonVideoList;
import groupbase.thn.web.videoapp.util.Helper;

public class IndexModel extends ModelBase{

	@Override
	public View init() {
		// TODO Auto-generated method stub
		View view = new View("index");
		YoutubeForm youtubeForm = new YoutubeForm();
		AppList app = new AppList();
		youtubeForm.playlistId =app.mClipVl.Api_Key;
		youtubeForm.maxResults = "5";
		JsonVideoList list = Helper.getPlaylistItems(youtubeForm);
		view.setData("list", list);
		view.setData("selected", app.mClipVl.AppID);
		view.setData("appid", "clipvl");
		return view;
	}
	public View init(String param,String appid) {
		try {
			if(appid!=null){
				return new View("/view?v="+URLEncoder.encode( param,"UTF-8")+"&appid="+appid,ViewAction.REDIRECT);
			}else{
				return new View("/view?v="+URLEncoder.encode( param,"UTF-8"),ViewAction.REDIRECT);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new View("",ViewAction.OUTTEXT);
		}
	}
	public View nextPage(String page){
		View view = new View("index");
		YoutubeForm youtubeForm = new YoutubeForm();
		AppList app = new AppList();
		youtubeForm.playlistId =app.mClipVl.Api_Key;
		youtubeForm.maxResults = "5";
		youtubeForm.pageToken = page;
		JsonVideoList list = Helper.getPlaylistItems(youtubeForm);
		view.setData("list", list);
		view.setData("selected", app.mClipVl.AppID);
		view.setData("appid", "clipvl");
		return view;
	}
}
