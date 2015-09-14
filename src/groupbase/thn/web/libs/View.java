package groupbase.thn.web.libs;

import java.util.HashMap;

public class View {

	private String mViewName;
	private ViewAction mViewAction;
	private boolean mIsFile = false;
	private HashMap<String, Object> data = new HashMap<String, Object>();
	public View(String viewName,ViewAction viewAction) {
		mViewName = viewName;
		mViewAction = viewAction;
	}

	public View(String viewName) {
		mViewName = viewName;
		mViewAction = ViewAction.FORWARD;
	}
	public String getViewName() {
		return mViewName;
	}

	public View setIsFile(boolean isfile){
		mIsFile = isfile;
		return this;
	}
	
	public boolean isFile(){
		return mIsFile;
	}
	public ViewAction getViewAction (){
		return mViewAction;
	}
	public void setData(String key,Object value){
		data.put(key, value);
	}
	public HashMap<String, Object> getData(){
		return data;
	}
}
