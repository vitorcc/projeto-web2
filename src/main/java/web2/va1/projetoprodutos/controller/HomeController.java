package web2.va1.projetoprodutos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("Home");
//        mv.addObject("convidados", convidados.findAll());

        return mv;
    }
}
