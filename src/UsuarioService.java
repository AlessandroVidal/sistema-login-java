import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private final String ARQUIVO = "usuarios.txt";

    public void cadastrarUsuario(Usuario usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            writer.write(usuario.toString());
            writer.newLine();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                usuarios.add(new Usuario(partes[0], partes[1]));
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler usuários.");
        }

        return usuarios;
    }

    public boolean fazerLogin(String nome, String senha) {
        List<Usuario> usuarios = listarUsuarios();

        for (Usuario u : usuarios) {
            if (u.getNome().equals(nome) && u.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
