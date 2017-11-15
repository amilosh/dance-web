package by.it.milosh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    @RequestMapping(value = {"/count"}, method = RequestMethod.POST)
    public String count(@RequestParam("numbers") String numbers, @RequestParam("platformSize") String platformSize) {
        return "main";
    }

}
