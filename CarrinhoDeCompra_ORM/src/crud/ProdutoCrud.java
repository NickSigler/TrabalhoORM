package CarrinhoDeCompra_ORM.src.crud;

import java.util.Scanner;

public class ProdutoCrud {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("O que você deseja fazer?");
        System.out.printf("1 - Cadastrar um produto%n2 - Ver a lista de produtos%n" +
                "3 - Deletar um produto%n4 - Editar um produto");

        int opcao = input.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Informe o id do produto: ");
                int idProduto = input.nextInt();
                System.out.println("Informe a data de compra do produto: ");
                String dataCompra = input.next();

                // Informe os dados da loja
                System.out.println("Informe o id da loja de origem do produto: ");
                int idLoja = input.nextInt();
                System.out.println("Informe a descrição da loja de origem do produto: ");
                String descricaoLoja = input.next();
                LojaOrigem lojaProduto = new LojaOrigem(idLoja, descricaoLoja);

                Produto produto = new Produto(idProduto, dataCompra, lojaProduto);

                /*
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtoPU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();
                em.persist(produto);
                em.getTransaction().commit();

                em.close();
                emf.close();
                */
                break;

            case 2:
                /*
                Query query = em.createQuery("select p from Produto p");
                List<Produto> produtos = query.getResultList();
                for (Produto p : produtos) {
                    System.out.println("ID: " + p.getId() + " / Data de compra: " + p.getDataCompra() +
                            " / Loja: " + p.getLoja().getDescricao());
                }
                */
                break;

            case 3:
                System.out.println("Informe o ID do produto:");
                int procurarIdProduto = input.nextInt();

                /*
                Produto produto = buscarPorId(procurarIdProduto, em);
                em.remove(produto);
                em.getTransaction().commit();
                em.close();
                emf.close();
                */
                break;

            case 4:
                System.out.println("Informe o ID do produto: ");
                int procurarIdProduto2 = input.nextInt();
                System.out.println("O que você deseja alterar? ");
                System.out.printf("1 - Data de compra%n");
                int opcao2 = input.nextInt();
                switch (opcao2) {
                    case 1:
                        System.out.println("Informe a nova data de compra: ");
                        String novaDataCompra = input.next();
                        Produto produtoProcurado = buscarPorId(procurarIdProduto2, em);
                        produtoProcurado.setDataCompra(novaDataCompra);
                        break;
                }
        }
    }

    // Método para buscar um produto por ID
    public static Produto buscarPorId(int id, EntityManager em) {
        return em.find(Produto.class, id);
    }
}
