package org.website.core.web.mvc.action.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.website.core.server.article.model.impl.Article;
import org.website.core.server.service.ArticleService;
@Controller
@RequestMapping("/control")
public class ArticleActionController {
	
	String BASE_URL = "/back/article";
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/articleManager")
    public String articleManager(Model model) {
		
		return BASE_URL + "/articleManager";
	}
	
	@RequestMapping("/articleSend")
    public String articles(Model model) {
		List<Article> articles = new ArrayList<>();
		model.addAttribute("articles",articles);
        return BASE_URL + "/articleSend";
	}
	
	@RequestMapping("/articleWrite")
    public String articleWrite(Model model) {
		
        return BASE_URL + "/articleWrite";
	}
	
	@RequestMapping("/uploadArticle")
	@ResponseBody
    public String uploadArticle(@RequestBody Article article,Model model) {
		String jsonResult = "sucess";
		article.setDate(new Date());
		articleService.save(article);
        return jsonResult;
	}
	
}
