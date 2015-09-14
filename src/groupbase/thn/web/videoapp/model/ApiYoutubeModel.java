package groupbase.thn.web.videoapp.model;

import groupbase.thn.web.libs.ModelBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.libs.ViewAction;
import groupbase.thn.web.videoapp.from.YoutubeForm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ApiYoutubeModel extends ModelBase {

	public static String URL_HOST = "https://www.googleapis.com/youtube/v3/";
	public static String KEY_SERVER = "?part=snippet&key=AIzaSyBc68GuwQhA9qxj6vBwKU1XqJ0K75ZI2IU";

	@Override
	public View init() {
		// TODO Auto-generated method stub
		String data = "";
		URL url;
		try {
			url = new URL(
					"https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UC9SG73RjBqiycBaYBziBmGQ&key=AIzaSyBc68GuwQhA9qxj6vBwKU1XqJ0K75ZI2IU");
			URLConnection urlConnection = url.openConnection();
			InputStream result = urlConnection.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					result));
			String line = null;

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				data = data + line;
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new View("", ViewAction.OUTTEXT);
	}

	public String Result(String strurl) {
		String data = "";
		URL url;
		try {
			url = new URL(strurl);
			URLConnection urlConnection = url.openConnection();
			InputStream result = urlConnection.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					result,"UTF-8"));
			String line = null;

			while ((line = reader.readLine()) != null) {
				data = data + line;
			}
			reader.close();
			return data;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

	public View getPlayList(YoutubeForm youtubeForm) {
		String url = URL_HOST + "playlists" + KEY_SERVER;
		url = url + "&channelId=" + youtubeForm.channelId + "&maxResults="
				+ youtubeForm.maxResults;
		if (youtubeForm.pageToken != null) {
			if (youtubeForm.pageToken.trim().length() > 0) {
				url = url + "&pageToken=" + youtubeForm.pageToken;
			}
		}
		return new View(Result(url), ViewAction.OUTTEXT);

	}

	public View getPlaylistItems(YoutubeForm youtubeForm) {
		String url = URL_HOST + "playlistItems" + KEY_SERVER;
		url = url + "&playlistId=" + youtubeForm.playlistId + "&maxResults="
				+ youtubeForm.maxResults;
		if (youtubeForm.pageToken != null) {
			if (youtubeForm.pageToken.trim().length() > 0) {
				url = url + "&pageToken=" + youtubeForm.pageToken;
			}
		}
		return new View(Result(url), ViewAction.OUTTEXT);

	}

	public View getSubscriptionsList(YoutubeForm youtubeForm) {
		String url = URL_HOST + "subscriptions" + KEY_SERVER;
		url = url + "&channelId=" + youtubeForm.channelId + "&maxResults="
				+ youtubeForm.maxResults;
		if (youtubeForm.pageToken != null) {
			if (youtubeForm.pageToken.trim().length() > 0) {
				url = url + "&pageToken=" + youtubeForm.pageToken;
			}
		}
		return new View(Result(url), ViewAction.OUTTEXT);

	}
}
