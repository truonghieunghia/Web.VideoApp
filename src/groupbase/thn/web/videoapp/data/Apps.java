package groupbase.thn.web.videoapp.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Apps {
	@PrimaryKey
	public String AppID;
	@Persistent
	public String AppName;
	@Persistent
	public String ContentMessage;
	@Persistent
	public String Api_Key;
	@Persistent
	public String StoreAndroid;
	@Persistent
	public String StoreIOS;
	@Persistent
	public String StoreWinPhone;
	@Persistent
	public String Image_Url;
	@Persistent
	public int InstallCount;
	@Persistent
	public boolean Published;
	@Persistent
	public String Account;
	@Persistent
	public int Version;
	public String getAppID() {
		return AppID;
	}

	public void setAppID(String appID) {
		AppID = appID;
	}

	public String getAppName() {
		return AppName;
	}

	public void setAppName(String appName) {
		AppName = appName;
	}

	public String getContentMessage() {
		return ContentMessage;
	}

	public void setContentMessage(String contentMessage) {
		ContentMessage = contentMessage;
	}

	public String getApi_Key() {
		return Api_Key;
	}

	public void setApi_Key(String api_Key) {
		Api_Key = api_Key;
	}

	public String getStoreAndroid() {
		return StoreAndroid;
	}

	public void setStoreAndroid(String storeAndroid) {
		StoreAndroid = storeAndroid;
	}

	public String getStoreIOS() {
		return StoreIOS;
	}

	public void setStoreIOS(String storeIOS) {
		StoreIOS = storeIOS;
	}

	public String getStoreWinPhone() {
		return StoreWinPhone;
	}

	public void setStoreWinPhone(String storeWinPhone) {
		StoreWinPhone = storeWinPhone;
	}

	public String getImage_Url() {
		return Image_Url;
	}

	public void setImage_Url(String image_Url) {
		Image_Url = image_Url;
	}

	public int getInstallCount() {
		return InstallCount;
	}

	public void setInstallCount(int installCount) {
		InstallCount = installCount;
	}

	public boolean isPublished() {
		return Published;
	}

	public void setPublished(boolean published) {
		Published = published;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}

	public int getVersion() {
		return Version;
	}

	public void setVersion(int version) {
		Version = version;
	}
}
