package groupbase.thn.web.videoapp.data.entry;

import groupbase.thn.web.libs.JsonAnnotation;


/**
 * Created by TruongHieuNghia on 8/17/15.
 */
public class Thumbnails {
    @JsonAnnotation(FieldName = "default",FieldType = Thumbnail.class,isObject = true)
    public Thumbnail Default;
    @JsonAnnotation(FieldName = "medium",FieldType = Thumbnail.class,isObject = true)
    public Thumbnail medium;
    @JsonAnnotation(FieldName = "high",FieldType = Thumbnail.class,isObject = true)
    public Thumbnail high;
    @JsonAnnotation(FieldName = "standard",FieldType = Thumbnail.class,isObject = true)
    public Thumbnail standard;
    @JsonAnnotation(FieldName = "maxres",FieldType = Thumbnail.class,isObject = true)
    public Thumbnail maxres;

}
