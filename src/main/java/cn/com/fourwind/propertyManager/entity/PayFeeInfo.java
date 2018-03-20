package cn.com.fourwind.propertyManager.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PayFeeInfo {
	@Id
	@GeneratedValue
	private String id;
	
	private String payType;
	private String UserId;
	private String lastDegree;
	private String CurrentDegree;
	private String unit;
	private Double amount;
	private Double lateFee;
	private String bak;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getLastDegree() {
		return lastDegree;
	}
	public void setLastDegree(String lastDegree) {
		this.lastDegree = lastDegree;
	}
	public String getCurrentDegree() {
		return CurrentDegree;
	}
	public void setCurrentDegree(String currentDegree) {
		CurrentDegree = currentDegree;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getLateFee() {
		return lateFee;
	}
	public void setLateFee(Double lateFee) {
		this.lateFee = lateFee;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
	public PayFeeInfo(String payType, String userId, String lastDegree, String currentDegree, String unit,
			Double amount, Double lateFee, String bak) {
		super();
		this.payType = payType;
		UserId = userId;
		this.lastDegree = lastDegree;
		CurrentDegree = currentDegree;
		this.unit = unit;
		this.amount = amount;
		this.lateFee = lateFee;
		this.bak = bak;
	}
	public PayFeeInfo() {
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"payType\":\"" + payType + "\",\"UserId\":\"" + UserId + "\",\"lastDegree\":\""
				+ lastDegree + "\",\"CurrentDegree\":\"" + CurrentDegree + "\",\"unit\":\"" + unit + "\",\"amount\":\""
				+ amount + "\",\"lateFee\":\"" + lateFee + "\",\"bak\":\"" + bak + "\"} ";
	}
	
}
