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
    public String count(@RequestParam("numbers") String numbers, @RequestParam("platformSize") String platformSize, Model model) {
        /* разбиваю строку на слова */
        String[] words = numbers.split("\\s");

        /* слова типа String перекодирую в int и заношу в массив */
        int[] intNumbers = new int[words.length];
        for (int i = 0; i < intNumbers.length; i++) {
            intNumbers[i] = Integer.parseInt(words[i]);
        }

         /* перекодирую длину платформы из String в int */
        int intPlatformSize = Integer.parseInt(platformSize);

        int point = 0; // текущее положение танцора

        int leftBorder = 0; // левая граница площадки
        int rightBorder = intPlatformSize; // правая граница площадки

        int step = 0; // количество шагов танцора

        for (int i = 0; i < intNumbers.length; i++) {
            if (intNumbers[i] % 2 == 0) {    // усли число чётное, то движение вправо (вперёд)
                if (point == rightBorder){    // если танцор находится на правой границе площадки, то стоит на месте
                    step += 0;
                } else if ((rightBorder - intNumbers[i]) >= point) {    // если танцор находится очень далеко от правого края, то он совершит все предназначенные ему шаги
                    point = point + intNumbers[i];
                    step = step + intNumbers[i];
                } else if ((rightBorder - intNumbers[i]) < point) {    // танцор находится возле самого края и он не сможет сделать все предназначенные шаги и упрётся в край
                    int newStep = rightBorder - point;
                    step = step + newStep;
                    point = rightBorder;
                }

            } else {
                if (point == leftBorder) {    // если танцор находится на левой границе площадки, то стоит на месте
                    step += 0;
                } else if ((point - intNumbers[i]) >= leftBorder) {    // если танцор находится очень далеко от левого края, то он совершит все предназначенные ему шаги
                    point = point - intNumbers[i];
                    step = step + intNumbers[i];
                } else if ((point - intNumbers[i]) < leftBorder) {
                    int newStep = point - leftBorder;
                    step = step + newStep;
                    point = leftBorder;
                }
            }
        }

        int finishStep = step;    // количество пройденных шагов
        int finishPoint = point;    // точка на которой танцор закончил

        model.addAttribute("numberOfSteps", finishStep);

        return "main";
    }

}
