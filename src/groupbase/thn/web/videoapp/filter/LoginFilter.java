package groupbase.thn.web.videoapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);
        
        if(session==null){
        	if(req.getQueryString()!=null){
        		res.sendRedirect("/login?url="+uri+"?"+req.getQueryString());
        	}else{
        		res.sendRedirect("/login?url="+uri);
        	}
        	
        }else{
        	String name = (String) session.getAttribute("username");
        	if (name != null) {
				request.setAttribute("username", name);
				 chain.doFilter(request, response);
			} else{
				
				res.sendRedirect("/login?url="+uri);
			}
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
