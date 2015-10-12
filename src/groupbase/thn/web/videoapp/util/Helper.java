package groupbase.thn.web.videoapp.util;

import groupbase.thn.web.libs.Parse;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.libs.ViewAction;
import groupbase.thn.web.videoapp.data.entry.VideoEntry;
import groupbase.thn.web.videoapp.from.YoutubeForm;
import groupbase.thn.web.videoapp.json_object.JsonVideoList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.apache.geronimo.mail.util.Base64;

import com.google.gson.Gson;

public class Helper {
	public static String URL_HOST = "https://www.googleapis.com/youtube/v3/";
	public static String KEY_SERVER = "?part=snippet&key=AIzaSyALZZqDtgXVc2Hb5GFPYevPxjj0xDXhNoQ";
	public static String base64Encode(String token) {
        byte[] encodedBytes = Base64.encode(token.getBytes());
        return new String(encodedBytes, Charset.forName("UTF-8"));
    }


    public static String base64Decode(String token) {
        byte[] decodedBytes = Base64.decode(token.getBytes());
        return new String(decodedBytes, Charset.forName("UTF-8"));
    }
    
    public static String Result(String strurl) {
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
			return null;
		}

	}
    public static JsonVideoList ResultObject(String strurl) {
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
			return Parse.FromJsonToObject(Result(data), JsonVideoList.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
    
    public static JsonVideoList getPlaylistItems(YoutubeForm youtubeForm) {
		String url = URL_HOST + "playlistItems" + KEY_SERVER;
		url = url + "&playlistId=" + youtubeForm.playlistId + "&maxResults="
				+ youtubeForm.maxResults;
		String url_tmp = url;
		if (youtubeForm.pageToken != null) {
			if (youtubeForm.pageToken.trim().length() > 0) {
				url = url + "&pageToken=" + youtubeForm.pageToken;
			}
		}
		JsonVideoList JsonVideoList =Parse.FromJsonToObject(Helper.Result(url), JsonVideoList.class);
		JsonVideoList resultList = new JsonVideoList();
		resultList.nextPageToken = JsonVideoList.nextPageToken;
		resultList.prevPageToken = JsonVideoList.prevPageToken;
		for(VideoEntry obj :JsonVideoList.listVideo){
			if(!obj.title.contains("Deleted video")|| !obj.title.contains("Private video")){
				if (obj.image_Default != null && obj.image_high != null && obj.image_medium != null){
    				resultList.listVideo.add(obj);				
    				}		
			}
		}
		while (resultList.nextPageToken!=null){
			if(resultList.listVideo.size()< Integer.parseInt(youtubeForm.maxResults)){
				String url_next = url_tmp+"&pageToken=" + resultList.nextPageToken;
	            JsonVideoList VideoList =Parse.FromJsonToObject(Helper.Result(url_next), JsonVideoList.class);
	            resultList.nextPageToken = VideoList.nextPageToken;
	    		resultList.prevPageToken = VideoList.prevPageToken;
	    		for(VideoEntry obj :VideoList.listVideo){
	    			if(!obj.title.contains("Deleted video")|| !obj.title.contains("Private video")){
	    				if (obj.image_Default != null && obj.image_high != null && obj.image_medium != null){
	        				resultList.listVideo.add(obj);				
	        				}
	    			}
	    		}
			}else{
				break;
			}
            
        }
		return resultList;

	}
}
