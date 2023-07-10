package br.com.rasmoo.restaurante.dao;


import br.com.rasmoo.restaurante.entity.Ordem;
import br.com.rasmoo.restaurante.vo.ItensPrincipaisVo;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class OrdemDAO {

    private  EntityManager entityManager;

    public OrdemDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void  cadastrar( final Ordem ordem){
        this.entityManager.persist(ordem);

    }

    public Ordem  consultarPorId(final Integer id){
        return this.entityManager.find(Ordem.class, id);
    }

    public List<Ordem> consultarTodos(){
        String jpql = "SELECT c FROM  Ordem c";
        return this.entityManager.createQuery(jpql, Ordem.class).getResultList();
    }


    public List<ItensPrincipaisVo> consultarMasVendidos(){
        String jpql = "SELECT new br.com.rasmoo.restaurante.vo.ItensPrincipaisVo(" +
                "c.nome, SUM(oc.quantidade)) FROM  Ordem o " +
                "JOIN OrdemCardapio oc on o.id = oc.cardapio.id " +
                "JOIN oc.cardapio c " +
                "GROUP BY c.nome " +
                "ORDER BY SUM(oc.quantidade) DESC";
        return this.entityManager.createQuery(jpql,ItensPrincipaisVo.class).getResultList();
    }

    public Ordem joinFectchCliente(final Integer id){
        String jpql = "SELECT c FROM  Ordem c JOIN FETCH c.cliente WHERE c.id = :id";
        return this.entityManager.createQuery(jpql, Ordem.class).setParameter("id", id).getSingleResult();
    }

    public void atualizar(final Ordem ordem){
        this.entityManager.merge(ordem);
    }

    public void excluir(final Ordem  ordem){
        this.entityManager.remove(ordem);
    }

}
