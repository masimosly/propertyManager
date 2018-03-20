package cn.com.fourwind.propertyManager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FuncInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String funcId;
	
	private String urlHtml;
	
	private String urlJs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getUrlHtml() {
		return urlHtml;
	}

	public void setUrlHtml(String urlHtml) {
		this.urlHtml = urlHtml;
	}

	public String getUrlJs() {
		return urlJs;
	}

	public void setUrlJs(String urlJs) {
		this.urlJs = urlJs;
	}
	
	
}
