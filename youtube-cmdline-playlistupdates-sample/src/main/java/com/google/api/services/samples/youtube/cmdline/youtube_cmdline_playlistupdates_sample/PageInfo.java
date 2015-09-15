package com.google.api.services.samples.youtube.cmdline.youtube_cmdline_playlistupdates_sample;


/**
 * Created by TruongHieuNghia on 8/17/15.
 */
public class PageInfo {
    @JsonAnnotation(FieldName = "totalResults",FieldType = Integer.class)
    public int totalResults;
    @JsonAnnotation(FieldName = "resultsPerPage",FieldType = Integer.class)
    public int resultsPerPage;
}
