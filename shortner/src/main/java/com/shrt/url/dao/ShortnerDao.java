/**
 * 
 */
package com.shrt.url.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shrt.url.model.ShortnerModel;

/**
 * @author imran
 *
 */
public interface ShortnerDao extends CrudRepository<ShortnerModel, Integer> {

	List<ShortnerModel> findByUrlKey(String urlKey);
	
	List<ShortnerModel> findByUrl(String url);
}
