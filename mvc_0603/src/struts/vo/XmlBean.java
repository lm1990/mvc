package struts.vo;

import java.util.Map;

public class XmlBean {

	public XmlBean(){
	}
	
	
	private String beanName;	//name����ֵ
	private String actionPath;	//action����·��
	private String actionClazz;	//action��Ӧ���ַ
	private String beanClazz;	//bean���ַ
	private Map<String,String> acttionForward;	//���ؽ��
	
	
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
