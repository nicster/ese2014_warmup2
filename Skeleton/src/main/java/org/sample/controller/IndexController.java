package org.sample.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.sample.model.Team;
import org.sample.model.User;
import org.sample.model.dao.TeamDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

    @Autowired   SampleService sampleService;  
    @Autowired   TeamDao teamDao;
    @Autowired 	 UserDao userDao;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("index");
    	Iterable<Team> teams = teamDao.findAll();
    	model.addObject("teams", teams);
    	model.addObject("signupForm", new SignupForm());
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	ModelAndView model;    	
    	if (!result.hasErrors()) {
            try {
            	sampleService.saveFrom(signupForm);
            	model = new ModelAndView("show");
            } catch (InvalidUserException e) {
            	model = new ModelAndView("index");
            	model.addObject("page_error", e.getMessage());
            }
        } else {
        	model = new ModelAndView("index");
        }   	
    	return model;
    }
    
    @RequestMapping(value = "/profile", params = "userId")
    public @ResponseBody ModelAndView profile(@RequestParam("userId") long id) {
    	ModelAndView model = new ModelAndView("profile");
    	User aUser = new User();
    	try {
    		aUser = userDao.findOne(id);
    	} catch (IllegalArgumentException e) {
    		model = new ModelAndView("index");
        	model.addObject("page_error", e.getMessage());
    	}
    	model.addObject("aUser", aUser);
    	return model;
    }
    @ResponseBody
    public User getUserById(@RequestParam("userId") long id) {
    	return userDao.findOne(id);
    }
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have have permission to do that!");
        return "redirect:/";
    }

}


