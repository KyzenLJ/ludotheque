package co.simplon.ludotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//classe qui appelle la page index.html
@Controller
public class Home {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
