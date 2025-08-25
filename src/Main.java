import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Contato> Contatos = new ArrayList<>();
        int escolha;
        do {
            System.out.println("""
                    === Agenda de Contatos ===
                    1 - Adicionar Contato
                    2 - Listar Contatos
                    3 - Buscar Contato
                    4 - Editar Contato
                    5 - Excluir Contato
                    6 - Sair
                    """);
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1: {
                    System.out.println("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o número do contato: ");
                    String numero = scanner.nextLine();

                    Contatos.add(new Contato(nome, numero));
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                }
                case 2: {
                    System.out.println("===Lista de Contatos===");
                    if (Contatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado!");
                    } else {
                        for (Contato c : Contatos) {
                            System.out.println(c);
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Digite o nome do contato que deseja buscar: ");
                    String nome = scanner.nextLine();
                    boolean encontrado = false;

                    for (Contato c : Contatos) {
                        if (c.getNome().equalsIgnoreCase(nome)) {
                            System.out.println("Contato encontrado: " + c);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("Contato não encontrado!");
                    break;
                }
                case 4: {
                    System.out.println("Digite o nome do contato que deseja alterar: ");
                    String nome = scanner.nextLine();
                    boolean encontrado = false;

                    for (Contato c : Contatos) {
                        if (c.getNome().equalsIgnoreCase(nome)) {
                            System.out.println("Digite o novo nome do contato: ");
                            String nomeNovo = scanner.nextLine();
                            c.setNome(nomeNovo);
                            System.out.println("Digite o novo número do contato: ");
                            String numeroNovo = scanner.nextLine();
                            c.setTelefone(numeroNovo);
                            System.out.println("Contato atualizado!");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("Contato não encontrado!");
                    break;
                }
                case 5: {
                    System.out.println("Digite o nome do contato que deseja excluir: ");
                    String nome = scanner.nextLine();
                    boolean removido = Contatos.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
                    if (removido) System.out.println("Contato excluido!");
                    else System.out.println("Contato não encontrado!");
                    break;
                }
                case 6: {
                    System.out.println("saindo...");
                    break;
                }

            }
        } while (escolha != 6) ;
            scanner.close();
    }
}