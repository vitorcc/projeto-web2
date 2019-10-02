package web2.va1.projetoprodutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import web2.va1.projetoprodutos.controller.ProdutoController;

import java.io.File;

@SpringBootApplication
public class ProjetoProdutosApplication {

	public static void main(String[] args) {
		new File(ProdutoController.UPLOADED_FOLDER).mkdir();
		SpringApplication.run(ProjetoProdutosApplication.class, args);
	}

}
