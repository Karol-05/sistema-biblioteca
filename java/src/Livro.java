public class Livro extends ItemBiblioteca {
    private final String autor;

    public Livro(int codigo, String titulo, String autor) {
        super(codigo, titulo);
        this.autor = autor;
    }

    public String getAutor() { return autor; }

    @Override
    public int prazoDevolucao() { return 14; }

    @Override
    public double multaPorDia() { return 0.50; }

    @Override
    public String toString() {
        return "Livro | " + super.toString() + " | Autor: " + autor;
    }
}
