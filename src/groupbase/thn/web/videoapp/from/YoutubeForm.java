package groupbase.thn.web.videoapp.from;

import groupbase.thn.web.libs.FormAnnotation;

public class YoutubeForm {
	@FormAnnotation(Name = "channelId", FieldType = String.class)
	public String channelId;
	@FormAnnotation(Name = "playlistId", FieldType = String.class)
	public String playlistId;
	@FormAnnotation(Name = "maxResults", FieldType = String.class)
	public String maxResults;
	@FormAnnotation(Name = "pageToken", FieldType = String.class)
	public String pageToken;
}
