package web2.va1.projetoprodutos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web2.va1.projetoprodutos.model.Marca;
import web2.va1.projetoprodutos.repository.MarcaRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaRepository marcas;

    @GetMapping("/listar")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("Marcas/Listar");
        mv.addObject("marcas", marcas.findAll());

        return mv;
    }

    @GetMapping("/adicionar")
    public ModelAndView adicionar(){
        ModelAndView mv = new ModelAndView("Marcas/Cadastrar");
        mv.addObject(new Marca());
        return mv;
    }

    @PostMapping("/adicionar")
    public ModelAndView adicionar(@Valid Marca marca,
                                  BindingResult result,
                                  RedirectAttributes attributes){
        if(result.hasErrors()){
            return new ModelAndView("Marcas/Cadastrar");
        }

        ModelAndView mv = new ModelAndView("redirect:/marcas/listar");

        if(marca.getId() != null){
            attributes.addFlashAttribute("mensagem", "Marca editada com sucesso.");
        } else {
            attributes.addFlashAttribute("mensagem", "Marca adicionada com sucesso.");
        }

        this.marcas.save(marca);

        return mv;
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Long id,
                                RedirectAttributes attributes){
        this.marcas.deleteById(id);
        ModelAndView mv = new ModelAndView("redirect:/marcas/listar");
        attributes.addFlashAttribute("mensagem", "Marca removida com sucesso.");

        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("Marcas/Cadastrar");
        mv.addObject("marca", this.marcas.findById(id));
        mv.addObject("id", id);
        return mv;
    }
}
