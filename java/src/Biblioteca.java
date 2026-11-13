public class Biblioteca {
    private final ItemBiblioteca[] acervo;
    private final Usuario[] usuarios;
    private final ItemBiblioteca[] itensEmprestados;
    private final Usuario[] responsaveis;

    private int totalItens;
    private int totalUsuarios;
    private int totalEmprestimos;

    public Biblioteca(int capacidadeItens, int capacidadeUsuarios) {
        acervo = new ItemBiblioteca[capacidadeItens];
        usuarios = new Usuario[capacidadeUsuarios];
        itensEmprestados = new ItemBiblioteca[capacidadeItens];
        responsaveis = new Usuario[capacidadeItens];
    }

    public boolean cadastrarItem(ItemBiblioteca item) {
        if (item == null || totalItens >= acervo.length) return false;
        acervo[totalItens++] = item;
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (usuario == null || totalUsuarios >= usuarios.length) return false;
        usuarios[totalUsuarios++] = usuario;
        return true;
    }

    private boolean usuarioCadastrado(Usuario usuario) {
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i] == usuario) return true;
        }
        return false;
    }

    private boolean itemCadastrado(ItemBiblioteca item) {
        for (int i = 0; i < totalItens; i++) {
            if (acervo[i] == item) return true;
        }
        return false;
    }

    public boolean emprestar(ItemBiblioteca item, Usuario usuario) {
        if (item == null || usuario == null) return false;
        if (!itemCadastrado(item) || !usuarioCadastrado(usuario)) return false;
        if (!item.isDisponivel()) return false;
        if (usuario.getQuantidadeEmprestada() >= usuario.limiteItens()) return false;
        if (totalEmprestimos >= itensEmprestados.length) return false;

        item.marcarEmprestado();
        usuario.registrarEmprestimo();

        itensEmprestados[totalEmprestimos] = item;
        responsaveis[totalEmprestimos] = usuario;
        totalEmprestimos++;

        return true;
    }

    public boolean devolver(ItemBiblioteca item, Usuario usuario) {
        for (int i = 0; i < totalEmprestimos; i++) {
            if (itensEmprestados[i] == item && responsaveis[i] == usuario) {
                item.marcarDisponivel();
                usuario.registrarDevolucao();

                for (int j = i; j < totalEmprestimos - 1; j++) {
                    itensEmprestados[j] = itensEmprestados[j + 1];
                    responsaveis[j] = responsaveis[j + 1];
                }

                totalEmprestimos--;
                itensEmprestados[totalEmprestimos] = null;
                responsaveis[totalEmprestimos] = null;

                return true;
            }
        }
        return false;
    }

    public void listarAcervo() {
        for (ItemBiblioteca item : acervo) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }
}
