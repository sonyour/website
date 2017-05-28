package org.website.core.web.mvc.action.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.website.core.server.article.model.impl.Article;


@Controller
public class WebIndexActionController {
	
	@RequestMapping("/")
    public String index(Model model) {
		String BASE_URL = "/front";
        return BASE_URL + "/index";
	}

}
