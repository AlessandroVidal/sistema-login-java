import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UsuarioService service = new UsuarioService();
        int opcao = -1;

        while (opcao != 0) {

            try {
                System.out.println("\n=== SISTEMA ===");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Login");
                System.out.println("3 - Listar usuários");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();

                        service.cadastrarUsuario(new Usuario(nome, senha));
                        break;

                    case 2:
                        System.out.print("Nome: ");
                        String loginNome = scanner.nextLine();

                        System.out.print("Senha: ");
                        String loginSenha = scanner.nextLine();

                        if (service.fazerLogin(loginNome, loginSenha)) {
                            System.out.println("Login realizado com sucesso!");
                        } else {
                            System.out.println("Credenciais inválidas.");
                        }
                        break;

                    case 3:
                        service.listarUsuarios().forEach(u ->
                                System.out.println("Usuário: " + u.getNome()));
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números válidos!");
            }
        }

        scanner.close();
    }
}
