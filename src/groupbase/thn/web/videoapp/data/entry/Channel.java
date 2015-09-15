package groupbase.thn.web.videoapp.data.entry;

import groupbase.thn.web.libs.JsonAnnotation;

/**
 * Created by TruongHieuNghia on 8/17/15.
 */
public class Channel {
    @JsonAnnotation(FieldName = "id",FieldType = String.class)
    public String id;
    @JsonAnnotation(FieldName = "snippet",FieldType = Snippet.class,isObject = true)
    public Snippet snippet;
}
