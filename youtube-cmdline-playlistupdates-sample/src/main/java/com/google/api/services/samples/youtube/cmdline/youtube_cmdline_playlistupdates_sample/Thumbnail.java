package com.google.api.services.samples.youtube.cmdline.youtube_cmdline_playlistupdates_sample;


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
