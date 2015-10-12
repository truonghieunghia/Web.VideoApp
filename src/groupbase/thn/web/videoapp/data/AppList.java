package groupbase.thn.web.videoapp.data;

import java.util.ArrayList;
import java.util.List;

public class AppList {
	public Apps mPhimBo = new Apps();
	public Apps mPhimLe = new Apps();
	public Apps mPhimViet = new Apps();
	public Apps mClipHay = new Apps();
	public Apps mClipVl = new Apps();
	public Apps mClipHai = new Apps();

	public List<Apps> Apps_list = new ArrayList<Apps>();
	public AppList (){
		//phim bo
		mPhimBo.Account = "taikhoan.appvideo@gmail.com";
		mPhimBo.Api_Key = "UCJaMj_QB3u0Ikqwr6UF9JGw";
		mPhimBo.AppID = "1";
		mPhimBo.Image_Url="1.png";
		mPhimBo.ContentMessage="";
		mPhimBo.AppName="Phim Bộ";
		mPhimBo.InstallCount = 0;
		mPhimBo.StoreAndroid = "https://play.google.com/store/apps/details?id=groupbase.vn.thn.phimbo";
		mPhimBo.StoreIOS = "";
		mPhimBo.StoreWinPhone = "";
		mPhimBo.Version = 11;
		mPhimBo.Published =true;
		Apps_list.add(mPhimBo);
		//phimle
		mPhimLe.Account = "taikhoan.appvideo@gmail.com";
		mPhimLe.Api_Key = "UC8qJSiTVWvRoy-GWv698_cA";
		mPhimLe.AppID = "3";
		mPhimLe.Image_Url="3.png";
		mPhimLe.ContentMessage="";
		mPhimLe.AppName="Phim Lẻ";
		mPhimLe.InstallCount = 0;
		mPhimLe.StoreAndroid = "https://play.google.com/store/apps/details?id=groupbase.vn.thn.phimle";
		mPhimLe.StoreIOS = "";
		mPhimLe.StoreWinPhone = "";
		mPhimLe.Version = 12;
		mPhimLe.Published =true;
		Apps_list.add(mPhimLe);
		//phimViet
		mPhimViet.Account = "taikhoan.appvideo@gmail.com";
		mPhimViet.Api_Key = "UCQqKZoWeD2EfmxeK7jyiBMA";
		mPhimViet.AppID = "7";
		mPhimViet.Image_Url="7.png";
		mPhimViet.ContentMessage="";
		mPhimViet.AppName="Phim Việt";
		mPhimViet.InstallCount = 0;
		mPhimViet.StoreAndroid = "https://play.google.com/store/apps/details?id=groupbase.vn.thn.phimviet";
		mPhimViet.StoreIOS = "";
		mPhimViet.StoreWinPhone = "";
		mPhimViet.Version = 11;
		mPhimViet.Published =true;
		Apps_list.add(mPhimViet);
		//hai
		mClipHai.Account = "taikhoan.appvideo@gmail.com";
		mClipHai.Api_Key = "UCmpJZB_ciCeKAK0BkIApouQ";
		mClipHai.AppID = "6";
		mClipHai.Image_Url="6.png";
		mClipHai.ContentMessage="";
		mClipHai.AppName="Clip Hài";
		mClipHai.InstallCount = 0;
		mClipHai.StoreAndroid = "https://play.google.com/store/apps/details?id=groupbase.vn.thn.cliphai";
		mClipHai.StoreIOS = "";
		mClipHai.StoreWinPhone = "";
		mClipHai.Version = 11;
		mClipHai.Published =true;
		Apps_list.add(mClipHai);
		//hay
		mClipHay.Account = "taikhoan.appvideo@gmail.com";
		mClipHay.Api_Key = "PLgUBxoLuBn_GCK_615zRiX6w_xx8563FA";
		mClipHay.AppID = "2";
		mClipHay.Image_Url="2.png";
		mClipHay.ContentMessage="";
		mClipHay.AppName="Clip Hay";
		mClipHay.InstallCount = 0;
		mClipHay.StoreAndroid = "https://play.google.com/store/apps/details?id=vn.co.thn.android.cliphay";
		mClipHay.StoreIOS = "";
		mClipHay.StoreWinPhone = "";
		mClipHay.Version = 7;
		mClipHay.Published =true;
		Apps_list.add(mClipHay);
		//vl
		mClipVl.Account = "taikhoan.appvideo@gmail.com";
		mClipVl.Api_Key = "PLlQ9iNG1xwiGkYCI5Ks-i-HpPOtD8dS4l";
		mClipVl.AppID = "5";
		mClipVl.Image_Url="5.png";
		mClipVl.ContentMessage="";
		mClipVl.AppName="ClipVL";
		mClipVl.InstallCount = 0;
		mClipVl.StoreAndroid = "https://play.google.com/store/apps/details?id=groupbase.vn.thn.clipvl";
		mClipVl.StoreIOS = "";
		mClipVl.StoreWinPhone = "";
		mClipVl.Version = 11;
		mClipVl.Published =true;
		Apps_list.add(mClipVl);
	}
}
