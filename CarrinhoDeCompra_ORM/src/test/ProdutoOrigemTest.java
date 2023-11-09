package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Livro;
import model.LojaOrigem;
import model.Produto;
import model.Editora;

public class ProdutoOrigemTest {
	
	public static void main(String[] args) {
		
		LojaOrigem loja = new LojaOrigem(12367, "Minha Loja");
		Produto produto = new Produto(1234, "12/09/2023", loja);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(loja);
		em.persist(produto);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
