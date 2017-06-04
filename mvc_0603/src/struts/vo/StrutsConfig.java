package struts.vo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class StrutsConfig {

	public StrutsConfig(){
	}
	
	public static Map<String,XmlBean> xmlBuild(String xmlPath) throws Exception{
		SAXBuilder builder = new SAXBuilder();
		Document document =  builder.build(new File(xmlPath));
		Element root = document.getRootElement();
		
		Map<String,XmlBean> map = new HashMap<String,XmlBean>();
		Element actionRoot = root.getChild("action-mapping");
		List<Element> actionBean = actionRoot.getChildren();
		for(Element ea : actionBean){
			XmlBean action = new XmlBean();
			String name = ea.getAttributeValue("name");
			action.setBeanName(name);
			Element formBeans = root.getChild("beans");
			List<Element> formBeanList = formBeans.getChildren();
			
			//解析beans
			for(Element eb : formBeanList){
				if(name.equals(eb.getAttributeValue("name"))){
					String beanClazz = eb.getAttributeValue("class");
					action.setBeanClazz(beanClazz);
				}
				
			}
			action.setActionClazz(ea.getAttributeValue("class"));
			
			String path = ea.getAttributeValue("path");
			action.setActionPath(path);
			
			//解析返回结果
			List<Element> forwards = ea.getChildren();
			Map<String,String> forwardMap = new HashMap<String,String>();
			for(Element ef : forwards){
				forwardMap.put(ef.getAttributeValue("name"), ef.getAttributeValue("value"));
			}
			action.setActtionForward(forwardMap);
			
			map.put(path, action);
		}
		return map;
	}
	
	public static void main(String[] arg)throws Exception{
		Map<String,XmlBean> map = StrutsConfig.xmlBuild("D:/YL/mvc_0530/WebContent/WEB-INF/struts-config.xml");
		for(Map.Entry<String,XmlBean> entry : map.entrySet()){
			 System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	
	}
}
