public class DVD extends ItemBiblioteca {
    public DVD(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int prazoDevolucao() { return 3; }

    @Override
    public double multaPorDia() { return 2.00; }

    @Override
    public String toString() {
        return "DVD | " + super.toString();
    }
}
