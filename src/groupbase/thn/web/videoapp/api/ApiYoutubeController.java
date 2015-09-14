package groupbase.thn.web.videoapp.api;

import javax.servlet.ServletException;

import groupbase.thn.web.libs.CtlBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.videoapp.from.YoutubeForm;
import groupbase.thn.web.videoapp.model.ApiYoutubeModel;

public class ApiYoutubeController extends CtlBase<ApiYoutubeModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		mContentType = "application/json; text/plain; charset=UTF-8";
	}

	@Override
	public View doGet() {
		// TODO Auto-generated method stub
		return Model.init();
	}

	@Override
	public View doPost() {
		// TODO Auto-generated method stub
		String apiName = getParam("list").trim();
		if (apiName != null) {
			if (apiName.equalsIgnoreCase("playlists")) {
				return Model.getPlayList(getDataPost(YoutubeForm.class));
			}
			if (apiName.equalsIgnoreCase("playlistItems")) {
				return Model.getPlaylistItems(getDataPost(YoutubeForm.class));
			}
			if (apiName.equalsIgnoreCase("subscriptions")) {
				return Model.getSubscriptionsList(getDataPost(YoutubeForm.class));
			}
		}
		return Model.init();
	}

}
