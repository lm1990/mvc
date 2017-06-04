package struts.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import struts.vo.Form;

public class ActionForm implements Action{

	@Override
	public String excute(HttpServletRequest request, Form form,
			Map<String, String> forworadMap) {
		//TODO ÅÐ¶ÏÌø×ª
		return forworadMap.get("success");
	}


}
