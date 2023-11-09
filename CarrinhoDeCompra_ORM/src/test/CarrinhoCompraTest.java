package test;


import java.util.Calendar;
import java.util.Date;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.CarrinhoCompra;
import model.Cliente;
import model.Editora;
import model.Livro;
import model.Locacao;
import model.LojaOrigem;
import model.Produto;

public class CarrinhoCompraTest {
	
	public static void main(String[] args) {

		LojaOrigem loja = new LojaOrigem(879234,"Minha Loja");
		Produto produto = new Produto(4324234,"Editora Moderna", loja);
		
		Cliente cliente = new Cliente(6235243, "Nicoalas", "nicolar@gmail.com", "43234234", "8883-4434");
		CarrinhoCompra carrinho = new CarrinhoCompra(124234235, "17/02/2023", produto, cliente);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(loja);
		em.persist(produto);
		em.persist(cliente);
		em.persist(carrinho);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
