package web2.va1.projetoprodutos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import web2.va1.projetoprodutos.repository.ProdutoRepository;

@Controller
public class HomeController {

    @Autowired
    private ProdutoRepository produtos;

    @GetMapping("/home")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("Home");
        mv.addObject("produtos", produtos.findAll());
        return mv;
    }
}
