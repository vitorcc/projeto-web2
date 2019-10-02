package web2.va1.projetoprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web2.va1.projetoprodutos.model.Produto;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
