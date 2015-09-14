package groupbase.thn.web.videoapp.from;

import groupbase.thn.web.libs.FormAnnotation;

public class QueryStringObject {
	@FormAnnotation(Name = "page",FieldType = String.class)
	public String page;
	@FormAnnotation(Name = "action",FieldType = String.class)
	public String action;
	@FormAnnotation(Name = "key",FieldType = String.class)
	public String key;
	@FormAnnotation(Name = "Message",FieldType = String.class)
	public String Message;
	@FormAnnotation(Name = "push_type",FieldType = Integer.class)
	public int push_type;
	@FormAnnotation(Name = "fillter",FieldType = String.class)
	public String fillter;
}
