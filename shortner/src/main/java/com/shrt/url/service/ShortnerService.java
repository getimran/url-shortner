package com.shrt.url.service;


import com.shrt.url.model.ShortnerModel;

public interface ShortnerService {
	
	public ShortnerModel retrieveShortnerForUrlKey(String key);

	public ShortnerModel addShortner(String url);
}
