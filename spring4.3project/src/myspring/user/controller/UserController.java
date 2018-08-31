package myspring.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="getUserList.do")
	public ModelAndView getUserList() {
		return new ModelAndView("userList.jsp", "userList", userService.getUserList());
	}
	
	@RequestMapping(value="getUser.do")
	public String getUser(@RequestParam String id, Model model) {
		model.addAttribute("user", userService.getUser(id));
		return "userInfo.jsp";
	}
	
	@ExceptionHandler
	public String handleException(Exception e) {
		return "viewError.jsp";
	}
}
