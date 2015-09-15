package groupbase.thn.web.videoapp.data.entry;

import groupbase.thn.web.libs.JsonAnnotation;

/**
 * Created by TruongHieuNghia on 8/17/15.
 */
public class Thumbnail {
    @JsonAnnotation(FieldName = "url",FieldType = String.class)
    public String url;
    @JsonAnnotation(FieldName = "width",FieldType = Integer.class)
    public int width;
    @JsonAnnotation(FieldName = "height",FieldType = Integer.class)
    public int height;
}
