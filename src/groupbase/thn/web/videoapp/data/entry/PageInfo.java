package groupbase.thn.web.videoapp.data.entry;

import groupbase.thn.web.libs.JsonAnnotation;

/**
 * Created by TruongHieuNghia on 8/17/15.
 */
public class PageInfo {
    @JsonAnnotation(FieldName = "totalResults",FieldType = Integer.class)
    public int totalResults;
    @JsonAnnotation(FieldName = "resultsPerPage",FieldType = Integer.class)
    public int resultsPerPage;
}
