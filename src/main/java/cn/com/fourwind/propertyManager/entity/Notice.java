package cn.com.fourwind.propertyManager.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//@Document
public class Notice {
	@Id
	@GeneratedValue
	private String id;
	
	private String noticeMainType;
	
	private String noticeSubType;
	
	private String noticeStatus;
	
	private String lastUser;
	
	private Date endDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNoticeMainType() {
		return noticeMainType;
	}

	public void setNoticeMainType(String noticeMainType) {
		this.noticeMainType = noticeMainType;
	}

	public String getNoticeSubType() {
		return noticeSubType;
	}

	public void setNoticeSubType(String noticeSubType) {
		this.noticeSubType = noticeSubType;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	public String getLastUser() {
		return lastUser;
	}

	public void setLastUser(String lastUser) {
		this.lastUser = lastUser;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"noticeMainType\":\"" + noticeMainType + "\",\"noticeSubType\":\""
				+ noticeSubType + "\",\"noticeStatus\":\"" + noticeStatus + "\",\"lastUser\":\"" + lastUser
				+ "\",\"endDate\":\"" + endDate + "\"}";
	}
	
	
	
}
