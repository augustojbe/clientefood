package br.com.rasmoo.restaurante.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "ordens")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor_total")
    private BigDecimal valorTotal = BigDecimal.ZERO;

    @Column (name = "data_de_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    /*
    * ALL = Realiza todas as operações em cascata
    * DETCHA = Operação detach execulta no pai e no filho
    * MERGE = Salva pai e filho, podendo já haver a entidade gerenciada
    * PERSIST = Cria pai e filho
    * REFRESH =  Atualiza entidade com operações do banco
    * REMOVE = Propaga remoção pai e filho
    * */

    @OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL)
    private List<OrdemCardapio> ordemCardapioList = new ArrayList<>();

    public Ordem(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ordem() {
    }

    public void addOrdemCardapio(OrdemCardapio ordemCardapio){
        ordemCardapio.setOrdem(this);
        this.ordemCardapioList.add(ordemCardapio);
        this.valorTotal = valorTotal.add(ordemCardapio.getValorDeRegistro()
                .multiply(BigDecimal.valueOf(ordemCardapio.getQuantidade())));

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<OrdemCardapio> getOrdemCardapioList() {
        return ordemCardapioList;
    }



    public void setOrdemCardapioList(List<OrdemCardapio> ordemCardapioList) {
        this.ordemCardapioList = ordemCardapioList;
    }


    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataCriacao=" + dataCriacao +
                ", cliente=" + cliente +
                ", ordemCardapioList=" + ordemCardapioList +
                '}';
    }
}
