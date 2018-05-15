package com.michaelchen.zerotohero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityExistsException;

@Controller
public class ViewController {
    @Autowired
    private CandyRepository candyRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView getHomePage(@RequestParam(required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homepage");

        if (id != null) {
            Candy candy = candyRepository.findById(id).get();
            modelAndView.addObject("candy", candy);
        }

        return modelAndView;
    }

    @RequestMapping(path = "/mvcNewCandy", method = RequestMethod.POST)
    public String addCandy(@RequestParam Long id, @RequestParam String name) {
        Candy candy = new Candy();

        candy.setId(id);
        candy.setName(name);

        if (candyRepository.existsById(candy.getId())) {
            throw new EntityExistsException("candy with ID " + candy.getId() + " already exists");
        }

        candyRepository.save(candy);

        return "redirect:/?id=" + candy.getId();
    }
}
