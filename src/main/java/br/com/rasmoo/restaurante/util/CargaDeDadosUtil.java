package br.com.rasmoo.restaurante.util;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDAO;
import br.com.rasmoo.restaurante.dao.ClienteDAO;
import br.com.rasmoo.restaurante.dao.EnderecoDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.entity.Cliente;
import br.com.rasmoo.restaurante.entity.Endereco;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {

    private static ClienteDAO clienteDao;

    public CargaDeDadosUtil() {
    }

    public static void cadastrarCategorias(EntityManager entityManager){
        Categoria entrada = new Categoria("Entrada");
        Categoria saldas = new Categoria("Saladas");
        Categoria pratoPrincipal = new Categoria("Pratos Principal");

        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

        categoriaDAO.cadastrar(entrada);
        entityManager.flush();
        categoriaDAO.cadastrar(saldas);
        entityManager.flush();
        categoriaDAO.cadastrar(pratoPrincipal);
        entityManager.flush();
        entityManager.clear();
    }

    public static void cadastrarProdutoCardapio(EntityManager entityManager){

        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDAO.consultarTodos();
        Cardapio moqueca = new Cardapio("Moqueca", "Peixe branco, banana da terra, arroz e farofa",
                true, BigDecimal.valueOf(95.00), categorias.get(2));
        Cardapio spaguetti = new Cardapio("Spaguetti", "Spagatti ao molho de parmesão e cogumelos",
                true, BigDecimal.valueOf(68.00), categorias.get(2));
        Cardapio bife = new Cardapio("Bife", "Bife acebolado com arroz branco, farofa e batata frita",
                true, BigDecimal.valueOf(59.00), categorias.get(2));
        Cardapio cordeiro = new Cardapio("Cordeiro", "Cordeiro com risoto de funghi",
                true, BigDecimal.valueOf(88.00), categorias.get(2));
        Cardapio burrata = new Cardapio("Burrata", "Tomates queimados, rúcula e torrada",
                true, BigDecimal.valueOf(15.00), categorias.get(0));
        Cardapio bruschetta = new Cardapio("Bruschetta", "Tomate, mucarela e manjericao",
                true, BigDecimal.valueOf(20.00), categorias.get(0));
        Cardapio scappeta = new Cardapio("Scappeta", "Ragu de linguica e torradinhas",
                true, BigDecimal.valueOf(25.00), categorias.get(0));
        Cardapio caprese = new Cardapio("Caprese", "Mini rucula e mucarela",
                true, BigDecimal.valueOf(47.00), categorias.get(1));
        Cardapio caesar = new Cardapio("Caesar", "Salada de franco com molho ceasar",
                true, BigDecimal.valueOf(40.00), categorias.get(1));
        Cardapio chevre = new Cardapio("Chevre", "Mix de folhas, mostarda e mel",
                true, BigDecimal.valueOf(59.00), categorias.get(1));

        cardapioDao.cadastrar(moqueca);
        cardapioDao.cadastrar(spaguetti);
        cardapioDao.cadastrar(bife);
        cardapioDao.cadastrar(cordeiro);
        cardapioDao.cadastrar(burrata);
        cardapioDao.cadastrar(bruschetta);
        cardapioDao.cadastrar(scappeta);
        cardapioDao.cadastrar(caprese);
        cardapioDao.cadastrar(caesar);
        cardapioDao.cadastrar(chevre);
        entityManager.flush();
        entityManager.clear();


    }

    public static void cadastrarClientes(EntityManager entityManager){

        ClienteDAO clienteDAO = new ClienteDAO(entityManager);
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);

        Endereco augusta = new Endereco("000000000","augusta","casa 43","Sao Paulo","SP");
        Cliente felipe = new Cliente("12345678901","feilpe@email.com","Felipe Ribeiro");
        felipe.addEndereco(augusta);

        Endereco rioVermelho = new Endereco("000000001","Lapa","apto 1001","Salvador","BA");
        Cliente cleber = new Cliente("111111111111","cleber@email.com","Cleber Machado");
        cleber.addEndereco(rioVermelho);

        Endereco leblon = new Endereco("000000002","Lapa","apto 203","Rio de Janeiro","RJ");
        Cliente calvin = new Cliente("09876543210","calvin@email.com","Calvin Coelho");
        calvin.addEndereco(leblon);

        Endereco heitorPenteado = new Endereco("000000000","Heitor Penteado","apto 101","Santos","SP");
        Cliente tayane = new Cliente("111111111123","tayane@email.com","Tayane Lopes Costa");
        tayane.addEndereco(heitorPenteado);

        Endereco consolacao = new Endereco("000000000","Lapa","apto 1001","Sao Paulo","SP");
        Cliente denise = new Cliente("111111111145","denise@email.com","Denise Costa");
        denise.addEndereco(consolacao);

        Endereco nacoesUnidas = new Endereco("000000000","NacoesUnidas","casa 27","Sao Paulo","SP");
        Cliente claudia = new Cliente("111111111345","claudia@email.com","Claudia Rosa");
        claudia.addEndereco(nacoesUnidas);

        enderecoDao.cadastrar(augusta);
        clienteDao.cadastrar(felipe);
        enderecoDao.cadastrar(rioVermelho);
        clienteDao.cadastrar(cleber);
        enderecoDao.cadastrar(leblon);
        clienteDao.cadastrar(calvin);
        enderecoDao.cadastrar(heitorPenteado);
        clienteDao.cadastrar(tayane);
        enderecoDao.cadastrar(consolacao);
        clienteDao.cadastrar(denise);
        enderecoDao.cadastrar(nacoesUnidas);
        clienteDao.cadastrar(claudia);

        entityManager.flush();
        entityManager.clear();
        
    }
}
