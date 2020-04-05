package com.shrt.url.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrt.url.CommonUtility;
import com.shrt.url.dao.ShortnerDao;
import com.shrt.url.model.ShortnerModel;

@Service
public class ShortnerServiceImpl implements ShortnerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShortnerServiceImpl.class);

	@Autowired
	private ShortnerDao shortnerDao;

	@Override
	public ShortnerModel retrieveShortnerForUrlKey(String key) {
		LOGGER.info("Retrieving shorter detail for the key {}", key);
		List<ShortnerModel> shortnerModel= shortnerDao.findByUrlKey(key);
		if(shortnerModel.isEmpty()) {
			return null;
		}
		return shortnerModel.get(0);
	}

	@Override
	public ShortnerModel addShortner(String url) {
		LOGGER.info("Shortning in progress for url {}", url);
		List<ShortnerModel> exist = shortnerDao.findByUrl(url);
		if (exist.isEmpty()) {
			ShortnerModel shortnerModel = new ShortnerModel(CommonUtility.generateRandomStringOfSize(5), url);
			return shortnerDao.save(shortnerModel);
		}
		return exist.get(0);
	}

}
