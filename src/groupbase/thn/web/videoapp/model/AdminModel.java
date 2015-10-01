package groupbase.thn.web.videoapp.model;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;

import groupbase.thn.web.libs.ModelBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.libs.ViewAction;
import groupbase.thn.web.videoapp.data.Apps;
import groupbase.thn.web.videoapp.data.Devices;
import groupbase.thn.web.videoapp.from.AppsForm;
import groupbase.thn.web.videoapp.from.QueryStringObject;

public class AdminModel extends ModelBase {
	private static final String SENDER_ID = "AIzaSyALZZqDtgXVc2Hb5GFPYevPxjj0xDXhNoQ";
	private List<String> androidTargets = new ArrayList<String>();

	@Override
	public View init() {
		View view = new View("admin/admin");
		view.setData("page", 0);
		view.setData("listapp", jdoModel.getList(Apps.class));
		view.setData("action", 0);
		return view;
	}

	public View init(QueryStringObject page) {
		// TODO Auto-generated method stub
		View view = new View("admin/admin");
		view.setData("page", 0);
		view.setData("listapp", jdoModel.getList(Apps.class));
		view.setData("action", 0);
		return view;
	}

	public View initApp(QueryStringObject page) {
		View view = new View("admin/admin");
		view.setData("page", 0);
		if (page.action == null) {
			view.setData("listapp", jdoModel.getList(Apps.class));
			view.setData("action", 0);
		} else {
			if (page.action.equalsIgnoreCase("new")
					|| page.action.equalsIgnoreCase("edit")) {
				view.setData("action", 1);
				if (page.action.equalsIgnoreCase("edit")) {
					view.setData("action", 2);
					view.setData("app",
							jdoModel.getObject(page.key, Apps.class));
				}
			}
			if (page.action.equalsIgnoreCase("delete")) {
				jdoModel.Delete(page.key, Apps.class);
				return new View("/admin", ViewAction.REDIRECT);
			}
		}
		return view;
	}

	public View addApp(AppsForm appsForm) {
		Apps apps = new Apps();
		apps.AppID = appsForm.AppID;
		apps.AppName = appsForm.AppName;
		apps.Image_Url = appsForm.Image_Url;
		apps.InstallCount = 0;
		apps.Api_Key = appsForm.Api_Key;
		apps.StoreAndroid = appsForm.StoreAndroid;
		apps.StoreIOS = appsForm.StoreIOS;
		apps.StoreWinPhone = appsForm.StoreWinPhone;
		apps.ContentMessage = appsForm.ContentMessage;
		apps.Account = appsForm.Account;
		apps.Published = appsForm.Published;
		apps.Version = appsForm.Version;
		jdoModel.Add(apps);
		return new View("/admin", ViewAction.REDIRECT);
	}

	public View updateApp(AppsForm appsForm, String key) {
		jdoModel.setFilter("AppID =='" + key + "'");
		List<Devices> list = jdoModel.getList(Devices.class);
		Apps apps = new Apps();		
		apps.AppID = key;
		apps.AppName = appsForm.AppName;
		apps.Image_Url = appsForm.Image_Url;
		if(list!=null){
			apps.InstallCount = list.size();	
		}		
		apps.Api_Key = appsForm.Api_Key;
		apps.StoreAndroid = appsForm.StoreAndroid;
		apps.StoreIOS = appsForm.StoreIOS;
		apps.StoreWinPhone = appsForm.StoreWinPhone;
		apps.ContentMessage = appsForm.ContentMessage;
		apps.Account = appsForm.Account;
		apps.Published = appsForm.Published;
		apps.Version = appsForm.Version;
		jdoModel.Update(apps);
		return new View("/admin", ViewAction.REDIRECT);
	}

	//
	public View initDevices(QueryStringObject page) {
		View view = new View("admin/admin");
		view.setData("page", 1);
		if (page.action == null) {
			view.setData("action", 0);
			view.setData("listapps", jdoModel.getList(Apps.class));
			if(page.fillter!=null && !page.fillter.equals("0")){
				Apps apps = jdoModel.getObject(page.fillter, Apps.class);
				String appid = page.fillter;
				if (apps == null) {
					appid = "0";
				}
				view.setData("app", apps);
				view.setData("AppID", appid);
				jdoModel.setFilter("AppID =='" + page.fillter + "'");
			}
			List<Devices> lst = jdoModel.getList(Devices.class);
			view.setData("total", lst.size());
			view.setData("listdevice", lst);
			
		}else{
			if (page.action.equalsIgnoreCase("delete")) {
				jdoModel.Delete(page.key, Devices.class);
				return new View("/admin?page=Devices", ViewAction.REDIRECT);
			}
		}
		return view;
	}

	public View initApi(QueryStringObject page) {
		View view = new View("admin/admin");
		return view;
	}

	public View initPushs(QueryStringObject page) {
		View view = new View("admin/admin");
		view.setData("page", 3);
		String appid = page.key;
		Apps apps = jdoModel.getObject(page.key, Apps.class);
		if (apps == null) {
			appid = "0";
		}
		view.setData("app", apps);
		view.setData("AppID", appid);
		view.setData("listapps", jdoModel.getList(Apps.class));
		return view;
	}

	public View PushApp(QueryStringObject page) {
		
		View view = new View("admin/admin");
		if(page.Message==null){
			view.setData("page", 2);
			view.setData("message","Please input Message and Push Again");
			return view;
		}else{
			if(page.Message.trim().isEmpty() ){
				view.setData("page", 2);
				view.setData("message","Please input Message and Push Again");
				return view;
			}
		}
		
		if (!page.key.equals("0")) {
			jdoModel.setFilter("AppID =='" + page.key + "'");
		}
		List<Devices> list = jdoModel.getList(Devices.class);
		if (list.size() > 0) {
			for (Devices device : list) {
				androidTargets.add(device.RegID);
			}
			Sender sender = new Sender(SENDER_ID);
			String collapseKey ="noti";
			if (page.push_type == 1){
				collapseKey = "update";
			}
			
			try {
				Message message = new Message.Builder().collapseKey(collapseKey)
						.timeToLive(30).delayWhileIdle(true)					
						.addData("message", URLEncoder.encode(page.Message, "UTF-8")).build();
				// use this for multicast messages. The second parameter
				// of sender.send() will need to be an array of register ids.
				MulticastResult result = sender
						.send(message, androidTargets, 1);

				if (result.getResults() != null) {
					int canonicalRegId = result.getCanonicalIds();
					if (canonicalRegId != 0) {
						view.setData("page", 2);
						view.setData("message","OK" +canonicalRegId+"Device");
						view.setData("content",page.Message);
						return view;
					}
				} else {
					int error = result.getFailure();
					System.out.println("Broadcast failure: " + error);
					view.setData("page", 2);
					view.setData("message","Error");
					view.setData("content",page.Message);
					return view;
				}

			} catch (Exception e) {
				e.printStackTrace();
				view.setData("page", 2);
				view.setData("message","Error");
				view.setData("content",page.Message);
				return view;
			}
			
		}
		view.setData("page", 2);
		view.setData("message","Nodevice");
		view.setData("content",page.Message);
		return view;
	}
}
