package top.lcmatrix.fw.sso.client_test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.lcmatrix.fw.sso.client_test.entity.User;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(){
		return "redirect:index.html";
	}
	
	@RequestMapping("/myInfo")
	@ResponseBody
	public User myInfo(HttpServletRequest request){
		return (User) request.getSession().getAttribute("user");
	}
}
