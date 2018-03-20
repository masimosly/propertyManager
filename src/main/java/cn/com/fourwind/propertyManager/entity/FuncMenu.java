package cn.com.fourwind.propertyManager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class FuncMenu {
	
	@Id
	@GeneratedValue(generator = "myGenerator") 
	@GenericGenerator(name = "myGenerator", strategy = "uuid")
	private String menuId;
	
	private String menuName;
	
	private String upMenuId;
	
	private String menuIcon;
	
	private String funcId;
	
	private String funcUrl;
	
	private String leafFlag;
	
	private String upMenuName;

	public String getUpMenuName() {
		return upMenuName;
	}

	public void setUpMenuName(String upMenuName) {
		this.upMenuName = upMenuName;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUpMenuId() {
		return upMenuId;
	}

	public void setUpMenuId(String upMenuId) {
		this.upMenuId = upMenuId;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getFuncUrl() {
		return funcUrl;
	}

	public void setFuncUrl(String funcUrl) {
		this.funcUrl = funcUrl;
	}

	public String getLeafFlag() {
		return leafFlag;
	}

	public void setLeafFlag(String leafFlag) {
		this.leafFlag = leafFlag;
	}

	@Override
	public String toString() {
		return "{\"menuId\":\"" + menuId + "\",\"menuName\":\"" + menuName + "\",\"upMenuId\":\"" + upMenuId
				+ "\",\"menuIcon\":\"" + menuIcon + "\",\"funcId\":\"" + funcId + "\",\"funcUrl\":\"" + funcUrl
				+ "\",\"leafFlag\":\"" + leafFlag + "\",\"upMenuName\":\"" + upMenuName + "\"}";
	}

	
	
	

}
