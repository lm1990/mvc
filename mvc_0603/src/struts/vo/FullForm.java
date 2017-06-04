package struts.vo;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;


public class FullForm extends Form{

public static Form reflectTo(String classPath,HttpServletRequest request){
		
	Form entity =  null;
		try {
			Class<?> clazz = Class.forName(classPath);
			entity = (Form) clazz.newInstance();
			Field[] fieldArr = clazz.getDeclaredFields();
			for(Field f:fieldArr){
				f.setAccessible(true);
				f.set(entity, request.getParameter(f.getName()));
				f.setAccessible(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DemoEnity×´Ì¬Ê§°Ü!");
		}
		
		return entity;
	}
}
