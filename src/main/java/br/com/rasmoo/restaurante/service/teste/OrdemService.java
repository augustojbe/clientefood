package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.ClienteDAO;
import br.com.rasmoo.restaurante.dao.EnderecoDao;
import br.com.rasmoo.restaurante.dao.OrdemDAO;
import br.com.rasmoo.restaurante.entity.*;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutoCardapio(entityManager);
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        System.out.println(enderecoDao.consultarClientes("Sao Paulo", null, null));
        System.out.println(enderecoDao.consultarClientesUsandoCriteria(null, null, null));


        ClienteDAO clienteDAO = new ClienteDAO(entityManager);
        System.out.println(clienteDAO.consultarPorId(new ClienteId("claudia@email.com", "111111111345")));
        entityManager.getTransaction().commit();
        entityManager.close();






    }
}
