package org.sample.controller;

import org.sample.controller.pojos.TeamForm;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class TeamController {
	
	@Autowired
	SampleService sampleService;


	@RequestMapping(value = "/team", method = RequestMethod.GET)
    public ModelAndView team() {
    	ModelAndView model = new ModelAndView("new-team");
    	model.addObject("TeamForm", new TeamForm());
    	return model;
    }
	
	@RequestMapping(value = "/createteam", method = RequestMethod.POST)
	public ModelAndView createTeam(TeamForm teamForm, BindingResult result, RedirectAttributes redirectAttributes) {
		ModelAndView model;
		if (!result.hasErrors()) {
			sampleService.saveTeam(teamForm);
			model = new ModelAndView("showteam");
		}
		else {
			model = new ModelAndView("new-team");
		}
		return model;
	}

}