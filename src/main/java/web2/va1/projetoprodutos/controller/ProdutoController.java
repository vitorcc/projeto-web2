package web2.va1.projetoprodutos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web2.va1.projetoprodutos.model.Produto;
import web2.va1.projetoprodutos.repository.CategoriaRepository;
import web2.va1.projetoprodutos.repository.MarcaRepository;
import web2.va1.projetoprodutos.repository.ProdutoRepository;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    public static String UPLOADED_FOLDER = System.getProperty("user.dir")+"/src/main/resources/static/images/";

    @Autowired
    private ProdutoRepository produtos;

    @Autowired
    private MarcaRepository marcas;

    @Autowired
    private CategoriaRepository categorias;

    @GetMapping("/listar")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("Produtos/Listar");
        mv.addObject("produtos", produtos.findAll());
        mv.addObject("marcas", marcas.findAll());
        mv.addObject("categorias", this.categorias.findAll());

        return mv;
    }

    @GetMapping("/adicionar")
    public ModelAndView adicionar(){
        ModelAndView mv = new ModelAndView("Produtos/Cadastrar");
        mv.addObject(new Produto());
        mv.addObject("listarMarcas", this.marcas.findAll());
        mv.addObject("listarCategorias", this.categorias.findAll());
        return mv;
    }

    @PostMapping("/adicionar")
    public ModelAndView adicionar(@Valid Produto produto, @RequestParam("file") MultipartFile file,
                                  BindingResult result,
                                  RedirectAttributes attributes){
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload");
            ModelAndView mv4 = new ModelAndView("Produtos/Cadastrar");
            return mv4;
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            String caminho = "/images/" + file.getOriginalFilename();
            produto.setPath(caminho);
            System.out.println(path.toString());
            Files.write(path, bytes);

            attributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result.hasErrors()){
            ModelAndView mv2 = new ModelAndView("Produtos/Cadastrar");
            mv2.addObject("marcas", marcas.findAll());
            mv2.addObject("categorias", categorias.findAll());
            return mv2;
        }
        ModelAndView mv = new ModelAndView("redirect:/produtos/listar");
        if(produto.getId() != null){
            attributes.addFlashAttribute("mensagem", "Produto editado com sucesso.");
        } else {
            attributes.addFlashAttribute("mensagem", "Produto adicionado com sucesso.");
        }
        produtos.save(produto);
        return mv;
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Long id,
                                RedirectAttributes attributes){
        this.produtos.deleteById(id);
        ModelAndView mv = new ModelAndView("redirect:/produtos/listar");
        attributes.addFlashAttribute("mensagem", "Produto removido com sucesso.");

        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("Produtos/Cadastrar");
        mv.addObject("produto", this.produtos.findById(id));
        mv.addObject("id", id);
        mv.addObject("listarMarcas", this.marcas.findAll());
        mv.addObject("listarCategorias", this.categorias.findAll());
        return mv;
    }
}
