package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Editora;
import model.LojaOrigem;


public class LojaOrigemTest {

		public static void main(String[] args) {
			
			LojaOrigem loja = new LojaOrigem(1235,"Minha Loja");
			
			//Vai validar a conexao com o banco no arquivo persistence.xml
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(loja);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			 
			 
		}
		
}
