public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(10, 5);

        Livro livro1 = new Livro(1, "Dom Casmurro", "Machado de Assis");
        Livro livro2 = new Livro(2, "O Hobbit", "J. R. R. Tolkien");
        Livro livro3 = new Livro(3, "1984", "George Orwell");
        Livro livro4 = new Livro(4, "Capitães da Areia", "Jorge Amado");

        Revista revista = new Revista(5, "Ciência Hoje", 320);
        DVD dvd = new DVD(6, "Documentário sobre natureza");

        Aluno aluno = new Aluno("Ana");
        Professor professor = new Professor("Carlos");

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(livro3);
        biblioteca.cadastrarItem(livro4);
        biblioteca.cadastrarItem(revista);
        biblioteca.cadastrarItem(dvd);

        biblioteca.cadastrarUsuario(aluno);
        biblioteca.cadastrarUsuario(professor);

        System.out.println("=== TESTE DE EMPRESTIMOS ===");

        System.out.println("Livro 1: " + biblioteca.emprestar(livro1, aluno));
        System.out.println("Livro 2: " + biblioteca.emprestar(livro2, aluno));
        System.out.println("Livro 3: " + biblioteca.emprestar(livro3, aluno));

        System.out.println("Quarto item: " + biblioteca.emprestar(livro4, aluno));

        System.out.println("\n=== PRAZOS E MULTAS ===");
        System.out.println("Livro: " + livro1.prazoDevolucao()
                + " dias | Multa: R$ " + livro1.multaPorDia());

        System.out.println("Revista: " + revista.prazoDevolucao()
                + " dias | Multa: R$ " + revista.multaPorDia());

        System.out.println("DVD: " + dvd.prazoDevolucao()
                + " dias | Multa: R$ " + dvd.multaPorDia());

        biblioteca.devolver(livro1, aluno);

        System.out.println("\nNovo empréstimo após devolução: "
                + biblioteca.emprestar(livro4, aluno));

        System.out.println("\n=== ACERVO ===");
        biblioteca.listarAcervo();
    }
}
