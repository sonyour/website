package org.website.core.web.mvc.action.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control")
public class ArticleActionController {

	@RequestMapping("/articleWrite")
    public String articleWrite(Model model) {
		String BASE_URL = "/back/article";
		
        return BASE_URL + "/articleWrite";
	}
}
