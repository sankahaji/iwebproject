package com.iwebproject.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iwebproject.bean.User;
import com.iwebproject.common.Constants;
import com.iwebproject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService userService;

    @RequestMapping(value="/login",method=RequestMethod.GET)
    @ResponseBody
	public Map<String,String> login(User loginUser,HttpServletRequest request){
        logger.info("login() method begin...");

        User user = this.userService.read(loginUser);

        logger.info("login() method end...");

        Map<String,String> result = new HashMap<String,String>();
        
        if(null != user){
            request.getSession().setAttribute(Constants.USER_ID_SESSION, user.getId());

            result.put("result", Constants.SUCCESS_RESULT_FLAG);
            result.put("userId", user.getId());
        }else{
            result.put("result", Constants.FAILURE_RESULT_FLAG);
            result.put("errorTips", "用户名或密码错误！");
        }
        
        return result;
	}
    
    @RequestMapping(value="/{userId}/logout",method=RequestMethod.GET)
	public String logout(@PathVariable("userId")String userId,HttpServletRequest request){
        logger.info("logout() method begin...");

        request.getSession().invalidate();

        logger.info("logout() method end...");
        
        return "redirect:/";
	}
    
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(User user,HttpServletRequest request) {
		logger.info("register() method begin...");
		
		this.userService.create(user);

        request.getSession().setAttribute(Constants.USER_ID_SESSION, user.getId());
        
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/user/"+user.getId()+"/home");
		
		logger.info("register() method end...");
		
		return mav;
	}

    @RequestMapping(value="/{userId}/home")
	public ModelAndView home(@PathVariable("userId")String userId){
        logger.info("home() method begin...");
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/home");
        mav.addObject("userId", userId);
        
        logger.info("home() method end...");
        
        return mav;
	}
}
