package com.google.api.services.samples.youtube.cmdline.youtube_cmdline_playlistupdates_sample;


/**
 * Created by TruongHieuNghia on 8/17/15.
 */
public class Snippet {
    @JsonAnnotation(FieldName = "publishedAt",FieldType = String.class)
    public String publishedAt;
    @JsonAnnotation(FieldName = "title",FieldType = String.class)
    public String title;
    @JsonAnnotation(FieldName = "description",FieldType = String.class)
    public String description;
    @JsonAnnotation(FieldName = "resourceId",FieldType = ResourceId.class,isObject = true)
    public ResourceId resourceId;
    @JsonAnnotation(FieldName = "channelId",FieldType = String.class)
    public String channelId;
    @JsonAnnotation(FieldName = "thumbnails",FieldType = Thumbnails.class,isObject = true)
    public Thumbnails thumbnails;
}
