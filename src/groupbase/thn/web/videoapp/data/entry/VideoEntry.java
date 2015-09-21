package groupbase.thn.web.videoapp.data.entry;

import groupbase.thn.web.libs.JsonAnnotation;

public class VideoEntry {
	@JsonAnnotation(PathRoot={"snippet"} ,FieldName = "title",FieldType = String.class)
    public String title;
	@JsonAnnotation(PathRoot={"snippet","resourceId"},FieldName = "videoId",FieldType = String.class, isEncode = true)
    public String videoId;
	@JsonAnnotation(PathRoot={"snippet","thumbnails","default"},FieldName = "url",FieldType = String.class)
    public String image_Default;
	@JsonAnnotation(PathRoot={"snippet","thumbnails","medium"},FieldName = "url",FieldType = String.class)
	public String image_medium;
	@JsonAnnotation(PathRoot={"snippet","thumbnails","high"},FieldName = "url",FieldType = String.class)
	public String image_high;
}
