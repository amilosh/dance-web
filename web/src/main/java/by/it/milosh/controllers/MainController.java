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
        /* разбиваю строку на слова */
        String[] words = numbers.split("\\s");

        /* слова типа String перекодирую в int и заношу в массив */
        int[] intNumbers = new int[words.length];
        for (int i = 0; i < intNumbers.length; i++) {
            intNumbers[i] = Integer.parseInt(words[i]);
        }

         /* перекодирую длину платформы из String в int */
        int intPlatformSize = Integer.parseInt(platformSize);

        return "main";
    }

}
