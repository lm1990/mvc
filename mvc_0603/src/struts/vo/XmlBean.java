package struts.vo;

import java.util.Map;

public class XmlBean {

	public XmlBean(){
	}
	
	
	private String beanName;	//name属性值
	private String actionPath;	//action请求路径
	private String actionClazz;	//action对应类地址
	private String beanClazz;	//bean类地址
	private Map<String,String> acttionForward;	//返回结果
	
	
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public String getActionPath() {
		return actionPath;
	}
	public void setActionPath(String actionPath) {
		this.actionPath = actionPath;
	}
	public String getActionClazz() {
		return actionClazz;
	}
	public void setActionClazz(String actionClazz) {
		this.actionClazz = actionClazz;
	}
	public String getBeanClazz() {
		return beanClazz;
	}
	public void setBeanClazz(String beanClazz) {
		this.beanClazz = beanClazz;
	}
	public Map<String, String> getActtionForward() {
		return acttionForward;
	}
	public void setActtionForward(Map<String, String> acttionForward) {
		this.acttionForward = acttionForward;
	}
	
	
}
