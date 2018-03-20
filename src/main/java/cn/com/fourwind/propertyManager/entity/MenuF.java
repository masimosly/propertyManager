package cn.com.fourwind.propertyManager.entity;

import java.util.ArrayList;
import java.util.List;

public class MenuF {

	private String id;
	
	private String icon;
	
	private String text;
	
	private Long pid;
	
	private Long menuId;
	
	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	private List<MenuF> children = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public List<MenuF> getChildren() {
		return children;
	}

	public void setChildren(List<MenuF> children) {
		this.children = children;
	}
	
	
	
}
