package groupbase.thn.web.videoapp.data.entry;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import groupbase.thn.web.libs.JsonAnnotation;
import groupbase.thn.web.videoapp.util.Helper;

public class VideoEntry {
	@JsonAnnotation(PathRoot={"snippet"} ,FieldName = "title",FieldType = String.class)
    public String title;
	@JsonAnnotation( FieldName = "id",FieldType = String.class)
    public String id;
	@JsonAnnotation(PathRoot={"snippet","resourceId"},FieldName = "videoId",FieldType = String.class, isEncode = true)
    public String videoId;
	@JsonAnnotation(PathRoot={"snippet","thumbnails","default"},FieldName = "url",FieldType = String.class)
    public String image_Default;
	@JsonAnnotation(PathRoot={"snippet","thumbnails","medium"},FieldName = "url",FieldType = String.class)
	public String image_medium;
	@JsonAnnotation(PathRoot={"snippet","thumbnails","high"},FieldName = "url",FieldType = String.class)
	public String image_high;
	public String url_view;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getImage_Default() {
		return image_Default;
	}
	public void setImage_Default(String image_Default) {
		this.image_Default = image_Default;
	}
	public String getImage_medium() {
		return image_medium;
	}
	public void setImage_medium(String image_medium) {
		this.image_medium = image_medium;
	}
	public String getImage_high() {
		return image_high;
	}
	public void setImage_high(String image_high) {
		this.image_high = image_high;
	}
	public String getUrl_view() {
		String img="";
		if (image_high !=null){
			img = image_high;
		}else{
			if (image_medium !=null){
				img = image_medium;
			}else{
				if (image_Default !=null){
					img = image_Default;
				}
			}
		}					
		url_view = Helper.base64Encode(videoId+","+title+","+img);
		try {
			return URLEncoder.encode( url_view,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	public void setUrl_view(String url_view) {
		this.url_view = url_view;
	}
}
