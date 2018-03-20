package cn.com.fourwind.propertyManager.entity;

public class LogBean {
	
	private String userId;
	private String orgId;
	private String menuId;
	private String operFlag;
	private String logTypeId;
	private String beforeValue;
	private String afterValue;
	private String content;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getOperFlag() {
		return operFlag;
	}
	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}
	public String getLogTypeId() {
		return logTypeId;
	}
	public void setLogTypeId(String logTypeId) {
		this.logTypeId = logTypeId;
	}
	public String getBeforeValue() {
		return beforeValue;
	}
	public void setBeforeValue(String beforeValue) {
		this.beforeValue = beforeValue;
	}
	public String getAfterValue() {
		return afterValue;
	}
	public void setAfterValue(String afterValue) {
		this.afterValue = afterValue;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "{\"userId\":\"" + userId + "\",\"orgId\":\"" + orgId + "\",\"menuId\":\"" + menuId
				+ "\",\"operFlag\":\"" + operFlag + "\",\"logTypeId\":\"" + logTypeId + "\",\"beforeValue\":\""
				+ beforeValue + "\",\"afterValue\":\"" + afterValue + "\",\"content\":\"" + content + "\"}";
	}
	
	

}
