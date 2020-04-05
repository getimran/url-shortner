package com.shrt.url.model;

import java.io.Serializable;

public class ShortnerId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7557348811351990609L;
	private int id;
	private String urlKey;
	
	public ShortnerId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShortnerId(int id, String urlKey) {
		super();
		this.id = id;
		this.urlKey = urlKey;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((urlKey == null) ? 0 : urlKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShortnerId other = (ShortnerId) obj;
		if (id != other.id)
			return false;
		if (urlKey == null) {
			if (other.urlKey != null)
				return false;
		} else if (!urlKey.equals(other.urlKey))
			return false;
		return true;
	}
	
	

}
