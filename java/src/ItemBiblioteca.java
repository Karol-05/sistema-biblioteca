public abstract class ItemBiblioteca {
    private final int codigo;
    private final String titulo;
    private boolean disponivel;

    public ItemBiblioteca(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public int getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public boolean isDisponivel() { return disponivel; }

    void marcarEmprestado() { disponivel = false; }
    void marcarDisponivel() { disponivel = true; }

    public abstract int prazoDevolucao();
    public abstract double multaPorDia();

    @Override
    public String toString() {
        return "Código: " + codigo + " | Título: " + titulo
                + " | Disponível: " + (disponivel ? "Sim" : "Não");
    }
}
