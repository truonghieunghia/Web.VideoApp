package groupbase.thn.web.videoapp.model;

import javax.servlet.http.HttpSession;

import groupbase.thn.web.libs.ModelBase;
import groupbase.thn.web.libs.View;
import groupbase.thn.web.libs.ViewAction;

public class LogInModel extends ModelBase{

	@Override
	public View init() {
		// TODO Auto-generated method stub
		return null;
	}
	public View login(String name,String password,HttpSession session,String uri){
		
		if (name.equals("hieunghia") && password.equals("abc251184")) {
			session.setAttribute("username", name);
		} else {
			session.invalidate();
		}
		if (uri != null) {
			return new View(uri, ViewAction.REDIRECT);
		} else {
			return new View("/admin", ViewAction.REDIRECT);
		}
	}
}
