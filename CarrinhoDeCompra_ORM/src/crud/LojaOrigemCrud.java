package CarrinhoDeCompra_ORM.src.crud;

import java.util.Scanner;

public class LojaOrigemCrud {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("O que você deseja fazer?");
        System.out.printf("1 - Cadastrar uma loja%n2 - Ver a lista de lojas%n" +
                "3 - Deletar uma loja%n4 - Editar uma loja");

        int opcao = input.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Informe o id da loja: ");
                int idLoja = input.nextInt();
                System.out.println("Informe a descrição da loja: ");
                String descricaoLoja = input.next();
                LojaOrigem loja = new LojaOrigem(idLoja, descricaoLoja);

                /*
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojaPU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();
                em.persist(loja);
                em.getTransaction().commit();

                em.close();
                emf.close();

                */
                break;

            case 2:
                /*
                Query query = em.createQuery("select l from LojaOrigem l");
                List<LojaOrigem> lojas = query.getResultList();
                for (LojaOrigem l : lojas) {
                    System.out.println("Descrição: " + l.getDescricao());
                }
                */
                break;

            case 3:
                System.out.println("Informe a descrição da loja:");
                String procurarDescricao = input.next();

                /*
                LojaOrigem loja = buscarPorDescricao(procurarDescricao, em);
                em.remove(loja);
                em.getTransaction().commit();
                em.close();
                emf.close();
                */
                break;

            case 4:
                System.out.println("Informe a descrição da loja: ");
                String procurarDescricao2 = input.next();
                System.out.println("O que você deseja alterar? ");
                System.out.printf("1 - Descrição%n");
                int opcao2 = input.nextInt();
                switch (opcao2) {
                    case 1:
                        System.out.println("Informe a nova descrição: ");
                        String novaDescricaoLoja = input.next();
                        LojaOrigem lojaProcurada = buscarPorDescricao(procurarDescricao2, em);
                        lojaProcurada.setDescricao(novaDescricaoLoja);
                        break;
                }
        }
    }

    // Método para buscar uma loja por descrição
    public static LojaOrigem buscarPorDescricao(int id, EntityManager em) {
        Query query = em.createQuery("select l from LojaOrigem l where l.id = :id");
        query.setParameter("descricao", descricao);
        List<LojaOrigem> lojas = query.getResultList();
        return (LojaOrigem) query.getSingleResult();
    }
}
