package web2.va1.projetoprodutos.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    @Valid
    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false, referencedColumnName = "id")
    //@NotNull(message = "Informe a marca")
    private Marca marca;

    @Valid
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false, referencedColumnName = "id")
    //@NotNull(message = "Informe a categoria")
    private Categoria categoria;

    //@NotEmpty(message = "Informe o nome do produto")
    private String nome;

    //@NotEmpty(message = "Informe o modelo do produto")
    private String modelo;

    //@NotNull(message = "Informe o valor do produto")
    private Float valor_unitario;

    //@NotNull(message = "Informe a quantidade")
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Float getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(Float valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
