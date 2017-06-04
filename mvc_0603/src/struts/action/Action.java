package struts.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import struts.vo.Form;

public interface Action {

	String excute(HttpServletRequest request,Form form,Map<String,String> forworadMap);
}
