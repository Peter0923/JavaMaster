package com.autodesk.zen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.autodesk.zen.model.Hero;

@RequestMapping("star")
@Controller
public class Star {

    private Hero hero;

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doRequest(final HttpServletRequest request,
                                  final HttpServletResponse response) {
        final ModelAndView mv = new ModelAndView("star");
        mv.addObject("name", hero.getName());
        mv.addObject("description", hero.getDesc());
        return mv;
    }

}
