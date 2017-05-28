package org.website.core.web.mvc.action.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebBackActionController {
	
	@RequestMapping("/control")
    public String index(Model model) {
		String BASE_URL = "/back/website";
        return BASE_URL + "/index";
	}
	
}
