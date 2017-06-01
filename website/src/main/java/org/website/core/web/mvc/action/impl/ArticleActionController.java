package org.website.core.web.mvc.action.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.website.core.server.article.model.impl.Article;

import net.sf.json.JSON;

@Controller
@RequestMapping("/control")
public class ArticleActionController {

	@RequestMapping("/articleWrite")
    public String articleWrite(Model model) {
		String BASE_URL = "/back/article";
		
        return BASE_URL + "/articleWrite";
	}
	
	@RequestMapping("/uploadArticle")
	@ResponseBody
    public String uploadArticle(Model model,JSON article) {
		String jsonResult = "sucess";
		System.err.println(article);
        return jsonResult;
	}
}
