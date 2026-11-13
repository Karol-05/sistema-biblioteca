public class Revista extends ItemBiblioteca {
    private final int edicao;

    public Revista(int codigo, String titulo, int edicao) {
        super(codigo, titulo);
        this.edicao = edicao;
    }

    public int getEdicao() { return edicao; }

    @Override
    public int prazoDevolucao() { return 7; }

    @Override
    public double multaPorDia() { return 1.00; }

    @Override
    public String toString() {
        return "Revista | " + super.toString() + " | Edição: " + edicao;
    }
}
