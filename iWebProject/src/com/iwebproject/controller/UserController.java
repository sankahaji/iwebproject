package com.iwebproject.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iwebproject.bean.Account;
import com.iwebproject.common.Constants;
import com.iwebproject.service.AccountService;

@Controller
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private AccountService accountService;

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView login(Account loginUser,ModelMap modelMap,HttpServletRequest request){
        logger.info("login() method begin...");

        Account user = this.accountService.read(loginUser);

        logger.info("login() method end...");

        ModelAndView mav;
        
        if(null != user){
            request.getSession().setAttribute(Constants.USER_ID_SESSION, user.getId());
            
            mav = new ModelAndView("redirect:/"+user.getId()+"/home");  
        }else{
            modelMap.put("errorTips", "用户名或密码错误！");
            mav = new ModelAndView("/home", modelMap);
        }
        
        return mav;
    }
    
    @RequestMapping(value="/{userId}/logout",method=RequestMethod.GET)
	public String logout(@PathVariable("userId")String userId,HttpServletRequest request){
        logger.info("logout() method begin...");

        request.getSession().invalidate();

        logger.info("logout() method end...");
        
        return "redirect:/";
	}
    
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(Account user,HttpServletRequest request) {
		logger.info("register() method begin...");
		
		this.accountService.create(user);

        request.getSession().setAttribute(Constants.USER_ID_SESSION, user.getId());
        
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/"+user.getId()+"/home");
		
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
