package groupbase.thn.web.videoapp.model;

import groupbase.thn.web.libs.ModelBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.videoapp.data.AppList;
import groupbase.thn.web.videoapp.from.YoutubeForm;
import groupbase.thn.web.videoapp.json_object.JsonVideoList;
import groupbase.thn.web.videoapp.util.Helper;

public class PlayListModel extends ModelBase {

	@Override
	public View init() {
		// TODO Auto-generated method stub

		return null;
	}

	public View phimle(String page) {
		View view = new View("playlist");
		YoutubeForm youtubeForm = new YoutubeForm();
		AppList app = new AppList(true);
		youtubeForm.channelId = app.mPhimLe.Api_Key;
		youtubeForm.maxResults = "5";
		if (page != null) {
			youtubeForm.pageToken = page;
		}
		JsonVideoList list = Helper.getPlaylist(youtubeForm);
		view.setData("list", list);
		view.setData("selected", app.mPhimLe.AppID);
		view.setData("appid", "phimle");
		return view;
	}

	public View phimbo(String page) {
		// TODO Auto-generated method stub

		View view = new View("playlist");
		YoutubeForm youtubeForm = new YoutubeForm();
		AppList app = new AppList(true);
		youtubeForm.channelId = app.mPhimBo.Api_Key;
		youtubeForm.maxResults = "5";
		if (page != null) {
			youtubeForm.pageToken = page;
		}
		JsonVideoList list = Helper.getPlaylist(youtubeForm);
		view.setData("list", list);
		view.setData("page", "phimbo&");
		view.setData("selected", app.mPhimBo.AppID);
		view.setData("appid", "phimbo");
		return view;
	}

	public View phimhai(String page) {
		// TODO Auto-generated method stub

		View view = new View("playlist");
		YoutubeForm youtubeForm = new YoutubeForm();
		AppList app = new AppList(true);
		youtubeForm.channelId = app.mClipHai.Api_Key;
		youtubeForm.maxResults = "5";
		if (page != null) {
			youtubeForm.pageToken = page;
		}
		JsonVideoList list = Helper.getPlaylist(youtubeForm);
		view.setData("list", list);
		view.setData("selected", app.mClipHai.AppID);
		view.setData("appid", "cliphai");
		return view;
	}

	public View phimviet(String page) {
		// TODO Auto-generated method stub

		View view = new View("playlist");
		YoutubeForm youtubeForm = new YoutubeForm();
		AppList app = new AppList(true);
		youtubeForm.channelId = app.mPhimViet.Api_Key;
		youtubeForm.maxResults = "5";
		if (page != null) {
			youtubeForm.pageToken = page;
		}
		JsonVideoList list = Helper.getPlaylist(youtubeForm);
		view.setData("list", list);
		view.setData("selected", app.mPhimViet.AppID);
		view.setData("appid", "phimviet");
		return view;
	}

	public View getList(String playListItem, int selected, String appid,
			String page) {
		View view = new View("index");
		YoutubeForm youtubeForm = new YoutubeForm();
		youtubeForm.playlistId = playListItem;
		if (page != null) {
			youtubeForm.pageToken = page;
		}
		youtubeForm.maxResults = "5";
		JsonVideoList list = Helper.getPlaylistItems(youtubeForm);
		view.setData("list", list);
		view.setData("selected", selected);
		view.setData("appid", appid);
		view.setData("id", playListItem);
		return view;
	}

}
