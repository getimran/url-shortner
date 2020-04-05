package com.shrt.url.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "shortner")
public class ShortnerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String urlKey;
	private String url;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDateTime;
	
	
	public ShortnerModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ShortnerModel(String urlKey, String url) {
		super();
		this.urlKey = urlKey;
		this.url = url;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUrlKey() {
		return urlKey;
	}


	public void setUrlKey(String urlKey) {
		this.urlKey = urlKey;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Date getCreatedDateTime() {
		return createdDateTime;
	}


	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}


	public Date getUpdateDateTime() {
		return updateDateTime;
	}


	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
		
	
}
