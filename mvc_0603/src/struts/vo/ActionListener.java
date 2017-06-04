package struts.vo;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ActionListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("��Ϣ:ϵͳ��ע��Q!");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		ServletContext context = arg0.getServletContext();
		String xmlPath = context.getInitParameter("struts-config");
		String tomcatPath = context.getRealPath("\\");
		try {
			Map<String,XmlBean> map = StrutsConfig.xmlBuild(tomcatPath+xmlPath);
			context.setAttribute("struts-config", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("��Ϣ��struts-config.xml�������!");
	}

}
