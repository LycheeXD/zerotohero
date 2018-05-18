package com.michaelchen.zerotohero;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpaController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getSpa() {
        return "spa";
    }
}
