package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

/* Controller + ResponseBody */
@RestController
public class RestUserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<UserVO> getUserList() {
		return userService.getUserList();
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public UserVO getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	
	/*RequestBody : Http Request Body를 Java 객체로 받을 수 있음 */
	@RequestMapping(value="/users", method=RequestMethod.POST, headers= {"content-type=application/json"})
	public Boolean insertUser(@RequestBody UserVO user) {
		if(user != null) {
			userService.insertUser(user);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
}
