package cn.com.fourwind.propertyManager.entity;

import java.util.ArrayList;
import java.util.List;

public class BaseMenu {

	private Long id;
	private String label;
	private Long pid;
	
	private String labelEn;
	
	public String getLabelEn() {
		return labelEn;
	}
	public void setLabelEn(String labelEn) {
		this.labelEn = labelEn;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	private List<BaseMenu> children = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<BaseMenu> getChildren() {
		return children;
	}
	public void setChildren(List<BaseMenu> children) {
		this.children = children;
	}
	
}
