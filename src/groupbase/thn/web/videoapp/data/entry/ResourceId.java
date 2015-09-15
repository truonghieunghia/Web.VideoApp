package groupbase.thn.web.videoapp.data.entry;

import groupbase.thn.web.libs.JsonAnnotation;

/**
 * Created by TruongHieuNghia on 8/17/15.
 */
public class ResourceId {
    @JsonAnnotation(FieldName = "kind",FieldType = String.class)
    public String kind;
    @JsonAnnotation(FieldName = "channelId",FieldType = String.class)
    public String channelId;
    @JsonAnnotation(FieldName = "videoId",FieldType = String.class)
    public String videoId;
}
