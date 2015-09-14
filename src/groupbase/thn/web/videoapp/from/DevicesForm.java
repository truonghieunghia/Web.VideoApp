package groupbase.thn.web.videoapp.from;

import groupbase.thn.web.libs.FormAnnotation;

public class DevicesForm {
	@FormAnnotation(Name = "KeyDevices",FieldType = String.class)
	public String KeyDevices;
	@FormAnnotation(Name = "DevicesID",FieldType = String.class)
	public String DevicesID;
	@FormAnnotation(Name = "DevicesName",FieldType = String.class)
	public String DevicesName;
	@FormAnnotation(Name = "AppID",FieldType = String.class)
	public String AppID;
	@FormAnnotation(Name = "AppName",FieldType = String.class)
	public String AppName;
	@FormAnnotation(Name = "OS",FieldType = String.class)
	public String OS;
	@FormAnnotation(Name = "RegID",FieldType = String.class)
	public String RegID;
	@FormAnnotation(Name = "Version",FieldType = Integer.class)
	public int Version;
}
