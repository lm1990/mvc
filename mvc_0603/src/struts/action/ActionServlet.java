package struts.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts.vo.Form;
import struts.vo.FullForm;
import struts.vo.XmlBean;

public class ActionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String path =  this.getPath(request.getServletPath());
		Map<String,XmlBean> map = (Map<String, XmlBean>) this.getServletContext().getAttribute("struts-config");
		XmlBean xml = map.get(path);
		String formBeanClass = xml.getBeanClazz();
		Form entity = FullForm.reflectTo(formBeanClass, request);
		String actionClazz = xml.getActionClazz();
		
		Action action = null;
		String url = "";
		try {
			Class<?> clazz = Class.forName(actionClazz);
			action = (ActionForm) clazz.newInstance();
			url = action.excute(request, entity, xml.getActtionForward());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("严重：控制器异常!");
		}
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
	
	private String getPath(String servletPath){
		return servletPath.split("\\.")[0];
	}
}
