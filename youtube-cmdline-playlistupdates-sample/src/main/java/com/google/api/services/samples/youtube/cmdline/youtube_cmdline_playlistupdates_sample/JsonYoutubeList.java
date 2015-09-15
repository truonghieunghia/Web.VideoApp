package com.google.api.services.samples.youtube.cmdline.youtube_cmdline_playlistupdates_sample;



import java.util.ArrayList;



/**
 * Created by TruongHieuNghia on 8/17/15.
 */
public class JsonYoutubeList {
    @JsonAnnotation(FieldName = "prevPageToken",FieldType = String.class,isObject = false)
    public String prevPageToken;
    @JsonAnnotation(FieldName = "nextPageToken",FieldType = String.class,isObject = false)
    public String nextPageToken;
    @JsonAnnotation(FieldName = "pageInfo",FieldType = PageInfo.class,isObject = true)
    public PageInfo pageInfo;
    @JsonAnnotation(FieldName = "items",FieldType = Channel.class,isObject = true,isList = true)
    public ArrayList<Channel> items = new ArrayList<Channel>();
}
