package com.google.api.services.samples.youtube.cmdline.youtube_cmdline_playlistupdates_sample;


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
