package pl.turo.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.JstlView;

/**
 * Simple spring mvc controller
 * User: turo
 * Date: 07.08.12
 * Time: 22:38
 */
@Controller
public class HomeController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/")
    public String index() {
        String[] beanNamesForType = applicationContext.getBeanNamesForType(JstlView.class);
        return "index";
    }

    @RequestMapping("/hello")
    public void sayHello() {
    }

    @RequestMapping("/anotherHello")
    public String anotherHello() {
        return "anotherHello";
    }

    @RequestMapping("/modelAndViewHello")
    public ModelAndView modelAndViewHello() {
        return new ModelAndView("hello");
    }

    @RequestMapping("/parameterModelAndViewHello")
    public ModelAndView parameterModelAndViewHello(ModelAndView view) {
        view.setViewName("hello");
        return view;
    }

    @RequestMapping("/notExistView")
    public void parameterModelAndViewHello() {}

}
