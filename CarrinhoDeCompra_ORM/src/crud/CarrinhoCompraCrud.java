package CarrinhoDeCompra_ORM.src.crud;

import java.util.Scanner;

public class CarrinhoCompraCrud {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("O que você deseja fazer?");
        System.out.printf("1 - Adicionar um item ao carrinho de compra%n" +
                "2 - Ver o carrinho de compras%n" +
                "3 - Remover um item do carrinho de compras");

        int opcao = input.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Informe o id do carrinho de compra: ");
                int idCarrinho = input.nextInt();
                System.out.println("Informe a data da compra: ");
                String dataCompra = input.next();

                // Informe os dados do produto
                System.out.println("Informe o id do produto: ");
                int idProduto = input.nextInt();
                System.out.println("Informe a data de compra do produto: ");
                String dataCompraProduto = input.next();
                System.out.println("Informe o id da loja de origem do produto: ");
                int idLojaProduto = input.nextInt();
                System.out.println("Informe a descrição da loja de origem do produto: ");
                String descricaoLojaProduto = input.next();
                LojaOrigem lojaProduto = new LojaOrigem(idLojaProduto, descricaoLojaProduto);
                Produto produto = new Produto(idProduto, dataCompraProduto, lojaProduto);

                // Informe os dados do cliente
                System.out.println("Informe o id do cliente: ");
                int idCliente = input.nextInt();
                System.out.println("Informe o nome do cliente: ");
                String nomeCliente = input.next();
                System.out.println("Informe o email do cliente: ");
                String emailCliente = input.next();
                System.out.println("Informe o CPF do cliente: ");
                String cpfCliente = input.next();
                System.out.println("Informe o telefone do cliente: ");
                String foneCliente = input.next();
                Cliente cliente = new Cliente(idCliente, nomeCliente, emailCliente, cpfCliente, foneCliente);

                CarrinhoCompra carrinho = new CarrinhoCompra(idCarrinho, dataCompra, produto, cliente);

                /*
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("carrinhoPU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();
                em.persist(carrinho);
                em.getTransaction().commit();

                em.close();
                emf.close();
                */
                break;

            case 2:
                /*
                Query query = em.createQuery("select c from CarrinhoCompra c");
                List<CarrinhoCompra> carrinhos = query.getResultList();
                for (CarrinhoCompra c : carrinhos) {
                    System.out.println("ID: " + c.getId() + " / Data da compra: " + c.getDataCompra() +
                            " / Produto: " + c.getProduto().getId() +
                            " / Cliente: " + c.getCliente().getNome());
                }
                */
                break;

            case 3:
                System.out.println("Informe o ID do carrinho de compra:");
                int procurarIdCarrinho = input.nextInt();

                /*
                CarrinhoCompra carrinho = buscarPorId(procurarIdCarrinho, em);
                em.remove(carrinho);
                em.getTransaction().commit();
                em.close();
                emf.close();
                */
                break;
            case 4:
                System.out.println("Informe o ID do carrinho de compra:");
                int procurarIdCarrinho2 = input.nextInt();

                /*
                CarrinhoCompra carrinho = buscarPorId(procurarIdCarrinho2, em);
                if (carrinho != null) {
                    System.out.println("O que você deseja alterar? ");
                    System.out.printf("1 - Data da compra%n");
                    int opcao2 = input.nextInt();
                    switch (opcao2) {
                        case 1:
                            System.out.println("Informe a nova data da compra: ");
                            String novaDataCompra = input.next();
                            carrinho.setDataCompra(novaDataCompra);
                            break;
                    }
                }
                em.getTransaction().commit();
                em.close();
                emf.close();
                */
                break;
        }
    }

    // Método para buscar um carrinho de compra por ID
    public static CarrinhoCompra buscarPorId(int id, EntityManager em) {
        return em.find(CarrinhoCompra.class, id);
    }
}
