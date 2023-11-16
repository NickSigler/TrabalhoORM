package CarrinhoDeCompra_ORM.src.crud;

import java.util.Scanner;

public class ClienteCrud
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("O que você deseja fazer?");
        System.out.printf("1 - Cadastrar um cliente%n2 - Ver a lista de clientes%n" +
                "3 - Deletar um cliente%n4 - Editar um cliente");

        int opcao = input.nextInt();
        switch (opcao)
        {
            case 1:
                System.out.println("Informe o id do cliente: ");
                int idCliente = input.nextInt();
                System.out.println("Informe o nome do cliente: ");
                String nomeCliente = input.nextLine();
                input.next();
                System.out.println("Informe o nome do email: ");
                String emailCliente = input.nextLine();
                input.next();
                System.out.println("Informe o nome do cpf: ");
                String cpfCliente = input.nextLine();
                input.next();
                System.out.println("Informe o nome do fone: ");
                String foneCliente = input.nextLine();
                input.next();
                Cliente cliente = new Cliente(idCliente,nomeCliente,emailCliente,cpfCliente,foneCliente);


                EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();
                em.persist(cliente);
                em.getTransaction().commit();

                em.close();
                emf.close();


                break;

            case 2:

                Query query = em.createQuery("select c from Cliente c");
                List<Cliente> clientes = query.getResultList();
                for (Cliente c: clientes) {
                    System.out.println("Nome: " + c.getNome() + " / CPF: " +
                            c.getCpf());

                break;
            case 3:
                System.out.println("Informe o cpf do cliente:");
                String procurarCpf = input.nextLine();

                /*
                Cliente cliente = buscarPorCpf(procurarCpf, em);
                em.remove(cliente);
                em.getTransaction().commit();
                em.close();
                emf.close();
                */
                break;
            case 4:
                System.out.println("Informe o CPF do cliente: ");
                String procurarCpf2 = input.nextLine();
                System.out.println("O que você deseja alterar? ");
                System.out.printf("1 - Nome%n2 - email 3 - telefone");
                int opcao2 = input.nextInt();
                switch (opcao2)
                {
                    case 1:
                        System.out.println("Informe o novo nome: ");
                        String novoNomeCliente = input.nextLine();
                        Cliente clienteProcurado = buscarPorCpf(procurarCpf2, em);
                        clienteProcurado.setNome(novoNomeCliente);
                        break;
                    case 2:
                        System.out.println("Informe o novo email: ");
                        String novoEmailCliente = input.nextLine();
                        Cliente clienteProcurado2 = buscarPorCpf(procurarCpf2, em);
                        clienteProcurado.setEmail(novoEmailCliente);
                        break;
                    case 3:
                        System.out.println("Informe o novo email: ");
                        String novoFoneCliente = input.nextLine();
                        Cliente clienteProcurado3 = buscarPorCpf(procurarCpf2, em);
                        clienteProcurado.setFone(novoFoneCliente);
                        break;
                }

        }

    }
    public static Cliente buscarPorCpf(String cpf, EntityManager em) {
        Query query = em.createQuery("select c from Cliente c where c.cpf
                = :cpf");
        query.setParameter("cpf", cpf);
        List<Cliente> clientes = query.getResultList();
        return (Cliente) query.getSingleResult();
    }
}