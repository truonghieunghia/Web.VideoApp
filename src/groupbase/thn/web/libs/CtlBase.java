package groupbase.thn.web.libs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class CtlBase<M extends ModelBase> extends HttpServlet {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest mRequest;
	protected HttpServletResponse mResponse;
	private String mPathView = "/";
	private PrintWriter mPrintWriter;
	protected String mContentType = "text/plain; charset=UTF-8";
	public M Model;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		mRequest = arg0;
		mResponse = arg1;
		mResponse.setContentType(mContentType);
		mPrintWriter = mResponse.getWriter();
		createModel();
		super.service(arg0, arg1);
	}
	public HttpSession getSession(){
		return mRequest.getSession();
	}
	protected String getParam(String name){
		return mRequest.getParameter(name);
	}
	private <T> T paserStringToType(String str, Class<T> clazz) {
		Object value = null;
		if (clazz.equals(String.class)) {
			value = str;
		}
		if (clazz.equals(Integer.class)) {
			value = Integer.parseInt(str);
		}
		if (clazz.equals(Float.class)) {
			value = Float.parseFloat(str);
		}
		if (clazz.equals(Boolean.class)) {
			value = Boolean.parseBoolean(str);
		}
		return clazz.cast(value);
	}

	protected <T> T getDataPost(Class<T> formData) {
		try {
			List<Field> fields = new ArrayList<Field>();
			fields.addAll(Arrays.asList(formData.getDeclaredFields()));
			Object result = formData.newInstance();

			for (Field field : fields) {
				field.setAccessible(true);
				FormAnnotation formAnnotation = field
						.getAnnotation(FormAnnotation.class);
				if (formAnnotation != null) {
					String[] value = mRequest.getParameterValues(formAnnotation
							.Name());

					if (value != null) {
						if (value.length == 1) {
							if (value[0].trim().length() == 0) {
								field.set(result, null);
							} else {
								field.set(
										result,
										paserStringToType(value[0],
												formAnnotation.FieldType()));
							}
						} else {
							field.set(result, value);
						}
					}
				}
			}
			return formData.cast(result);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		showView(doGet());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		showView(doPost());
	}

	public abstract View doGet();

	public abstract View doPost();

	private void createModel() {
		@SuppressWarnings("unchecked")
		Class<M> obj = (Class<M>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		try {
			Model = obj.getConstructor().newInstance();
			// Model= obj.getDeclaredConstructor(HttpServletRequest.class,
			// HttpServletResponse.class).newInstance(request, response);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getPathRoot() {
		return getServletContext().getRealPath("");
	}

	private void outString(String text) {
		mPrintWriter.println(text);
	}

	protected String outTextFromFile(String pathFile) {
		try {
			FileInputStream fis = new FileInputStream(getPathRoot() + pathFile);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader reader = new BufferedReader(isr);
			String line = null;
			String result = "";
			while ((line = reader.readLine()) != null) {
				result = result + line;
			}
			reader.close();
			fis.close();
			isr.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	private String getPath() {
		ServletContext context = getServletContext();
		if (context.getInitParameter("View") == null) {
			return mPathView;
		}
		if (mPathView.length() == 1) {
			return context.getInitParameter("View");
		} else {
			return mPathView;
		}
	}

	private void showView(View view) {
		RequestDispatcher mDispatcher = getServletContext()
				.getRequestDispatcher(getPath() + view.getViewName() + ".jsp");
		switch (view.getViewAction()) {
		case FORWARD:
			try {
				if(view.getData().size()>0){
					Map<String, Object> temp=view.getData();
					for (Map.Entry<String, Object> entry : temp.entrySet()) {
					    String key = entry.getKey();
					    Object value = entry.getValue();
					    mRequest.setAttribute(key, value);
					}
				}
				mDispatcher.forward(mRequest, mResponse);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case REDIRECT:
			try {
				if(view.getData().size()>0){
					Map<String, Object> temp=view.getData();
					for (Map.Entry<String, Object> entry : temp.entrySet()) {
					    String key = entry.getKey();
					    Object value = entry.getValue();
					    mRequest.setAttribute(key, value);
					}
				}
				this.mResponse.sendRedirect(view.getViewName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case OUTTEXT:
			if (view.isFile()) {
				outString(outTextFromFile(view.getViewName()));
			} else {
				outString(view.getViewName());
			}

			break;
		default:

			try {
				mDispatcher.forward(mRequest, mResponse);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

	}
}
