package groupbase.thn.web.videoapp.from;


import groupbase.thn.web.libs.FormAnnotation;

public class AppsForm {
	@FormAnnotation(Name = "AppID",FieldType = String.class)
	public String AppID;
	@FormAnnotation(Name = "AppName",FieldType = String.class)
	public String AppName;
	@FormAnnotation(Name = "Api_Key",FieldType = String.class)
	public String Api_Key;
	@FormAnnotation(Name = "StoreAndroid",FieldType = String.class)
	public String StoreAndroid;
	@FormAnnotation(Name = "StoreIOS",FieldType = String.class)
	public String StoreIOS;
	@FormAnnotation(Name = "StoreWinPhone",FieldType = String.class)
	public String StoreWinPhone;
	@FormAnnotation(Name = "Image_Url",FieldType = String.class)
	public String Image_Url;
	@FormAnnotation(Name = "Message",FieldType = String.class)
	public String ContentMessage;
	@FormAnnotation(Name = "Account",FieldType = String.class)
	public String Account;
	@FormAnnotation(Name = "Published",FieldType = Boolean.class)
	public boolean Published;
	@FormAnnotation(Name = "Version",FieldType = Integer.class)
	public int Version;
}
