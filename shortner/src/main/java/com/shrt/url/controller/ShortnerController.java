package com.shrt.url.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shrt.url.model.ShortnerModel;
import com.shrt.url.service.ShortnerService;

@Controller
public class ShortnerController {
	
	private static final String INDEX_PAGE = "index";
	private static final String ERROR_MESSAGE = "errorMessage";
	private static final String REDIRECT = "redirect:";
	

	@Autowired
	private ShortnerService shortnerService;
	
	@GetMapping
	public String indexPage() {
		return INDEX_PAGE;
	}
	
	@PostMapping("/short")
	public ModelAndView shortUrl(@RequestParam String url, HttpServletRequest request) {
		ModelAndView modelAndView= new ModelAndView(INDEX_PAGE);
		if(url.isEmpty()) {
			modelAndView.addObject(ERROR_MESSAGE, "Aha! URL is empty...");
			return modelAndView;
		}
		ShortnerModel shortnerModel= shortnerService.addShortner(url.trim());
		StringBuilder shortUrl= new StringBuilder();
		shortUrl.append(request.getScheme()).append("://").append(request.getHeader("host")).append("/").append(shortnerModel.getUrlKey());
		
		modelAndView.addObject("shortenData", shortnerModel);
		modelAndView.addObject("shortenUrl", shortUrl);
		return modelAndView;
	}
	
	@GetMapping("/goto/{urlKey}")
	public String gotoUrl(@PathVariable String urlKey, HttpServletRequest request, ModelMap map) {
		
		ShortnerModel shortnerModel= shortnerService.retrieveShortnerForUrlKey(urlKey);
		if(shortnerModel==null) {
			map.addAttribute(ERROR_MESSAGE, "Some issue with the URL...");
			return INDEX_PAGE;
		}
		
		return REDIRECT + shortnerModel.getUrl();
	}
}
