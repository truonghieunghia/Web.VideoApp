package groupbase.thn.web.videoapp.model;
import java.util.List;

import groupbase.thn.web.libs.ModelBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.libs.ViewAction;
import groupbase.thn.web.videoapp.data.AppList;
import groupbase.thn.web.videoapp.data.Apps;
import groupbase.thn.web.videoapp.data.Devices;
import groupbase.thn.web.videoapp.from.DevicesForm;
import groupbase.thn.web.videoapp.json_object.JsonApp;
import groupbase.thn.web.videoapp.json_object.JsonResult;

import com.google.gson.Gson;

public class ApiModel extends ModelBase {

	@Override
	public View init() {
		// TODO Auto-generated method stub
		return null;
	}

	public View getAppsList(){
		JsonApp jsonApp = new JsonApp();
//		jsonApp.Apps_list =jdoModel.getList(Apps.class);
		jsonApp.Apps_list = new AppList().Apps_list;
		return new  View(new Gson().toJson(jsonApp), ViewAction.OUTTEXT);
	}
	public View RegisterDevice(DevicesForm devicesForm){
		Devices devices = new Devices();
		devices.AppID = devicesForm.AppID;
		devices.AppName = devicesForm.AppName;
		devices.DevicesID = devicesForm.DevicesID;
		devices.DevicesName = devicesForm.DevicesName;
		devices.OS = devicesForm.OS;
		devices.RegID = devicesForm.RegID;
		devices.Version = devicesForm.Version;
		devices.KeyDevices = devicesForm.DevicesID+devicesForm.AppID;
		jdoModel.Add(devices);
		JsonResult jsonResult = new JsonResult();
		jsonResult.result="OK";
//		jsonResult.Apps_list = jdoModel.getList(Apps.class);
//		updateApp(devices.AppID);		
		jsonResult.Apps_list = new AppList().Apps_list;
		return new  View(new Gson().toJson(jsonResult), ViewAction.OUTTEXT);
	}
	public void updateApp(String appID){
		jdoModel.setFilter("AppID =='" + appID + "'");
		List<Devices> list = jdoModel.getList(Devices.class);
		
		Apps app =jdoModel.getObject(appID, Apps.class);
		app.InstallCount = list.size();
		jdoModel.Update(app);
	}
}
