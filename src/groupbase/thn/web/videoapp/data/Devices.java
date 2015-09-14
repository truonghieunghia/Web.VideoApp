package groupbase.thn.web.videoapp.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Devices {
	@PrimaryKey
	public String KeyDevices;
	@Persistent
	public String DevicesID;
	@Persistent
	public String DevicesName;
	@Persistent
	public String AppID;
	@Persistent
	public String AppName;
	@Persistent
	public String OS;
	@Persistent
	public String RegID;
	@Persistent
	public int Version;
	public String getKeyDevices() {
		return KeyDevices;
	}
	public void setKeyDevices(String keyDevices) {
		KeyDevices = keyDevices;
	}
	public String getDevicesID() {
		return DevicesID;
	}
	public void setDevicesID(String devicesID) {
		DevicesID = devicesID;
	}
	public String getDevicesName() {
		return DevicesName;
	}
	public void setDevicesName(String devicesName) {
		DevicesName = devicesName;
	}
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
	public String getOS() {
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
	}
	public int getVersion() {
		return Version;
	}
	public void setVersion(int version) {
		Version = version;
	}
}
