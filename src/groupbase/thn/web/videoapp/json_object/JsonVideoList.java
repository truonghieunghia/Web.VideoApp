package groupbase.thn.web.videoapp.json_object;

import java.util.ArrayList;

import groupbase.thn.web.libs.JsonAnnotation;
import groupbase.thn.web.videoapp.data.entry.VideoEntry;

public class JsonVideoList {
	@JsonAnnotation(FieldName = "prevPageToken", FieldType = String.class, isObject = false)
	public String prevPageToken;
	@JsonAnnotation(FieldName = "nextPageToken", FieldType = String.class, isObject = false)
	public String nextPageToken;
	@JsonAnnotation(FieldName = "items", FieldType = VideoEntry.class, isObject = true, isList = true)
	public ArrayList<VideoEntry> listVideo = new ArrayList<VideoEntry>();
	public String getPrevPageToken() {
		return prevPageToken;
	}
	public void setPrevPageToken(String prevPageToken) {
		this.prevPageToken = prevPageToken;
	}
	public String getNextPageToken() {
		return nextPageToken;
	}
	public void setNextPageToken(String nextPageToken) {
		this.nextPageToken = nextPageToken;
	}
	public ArrayList<VideoEntry> getListVideo() {
		return listVideo;
	}
	public void setListVideo(ArrayList<VideoEntry> listVideo) {
		this.listVideo = listVideo;
	}
}
