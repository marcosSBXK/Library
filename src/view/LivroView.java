package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.entity.Livro;

public class LivroView {
	static Scanner entra = new Scanner(System.in);
	
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
	
	public static int getCodLivro() {
		System.out.print(" Digite o codigo: ");
		int codLivro = entra.nextInt();
		return codLivro;
	}
	
	public static Livro salvarLivro() {
		String titulo, autor;
		System.out.println("\n Cadastrar livro:");
		System.out.print(" Titulo: ");
		titulo = entra.nextLine();
		System.out.print(" Autor: ");
		autor = entra.nextLine();
		Livro livro = new Livro(titulo, autor);
		return livro;
	}
	
	public static void exibirLivro(Livro livro) {
		 System.out.println("\nCod. Livro\t Titulo\t\t\t\t\t  Autor\t\t\t Situacao\t\t Cod. Aluno\t");
	     System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
	     if (livro.getDataEmprestimo() == null) {
             System.out.printf(" %s\t\t %-32.32s\t  %-20.20s\t Disponivel\n",
            		 livro.getCodLivro(), livro.getTitulo(), livro.getAutor());
         }
         else {
             System.out.printf(" %s\t\t %-32.32s\t  %-20.20s\t Emprestado\t\t %-20.20s\n",
            		 livro.getCodLivro(), livro.getTitulo(), livro.getAutor(), livro.getCodAluno());
         }
	}
	
	public static void listarTodosLivros(ArrayList<Livro> lista) {
		System.out.println("\n\t\t\t\t\t\tListagem de todos os livros");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Cod. Livro\t Titulo\t\t\t\t\t  Autor\t\t\t Situacao\t\t Cod. Aluno\t");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        for (int i=0; i<lista.size(); i++) {
            Livro livro = lista.get(i);
            if (livro.getDataEmprestimo() == null) {
                System.out.printf(" %s\t\t %-32.32s\t  %-20.20s\t Livro Disponivel\n",
                		livro.getCodLivro(), livro.getTitulo(), livro.getAutor());
            }
            else {
                System.out.printf(" %s\t\t %-32.32s\t  %-20.20s\t Emprestado\t\t %-20.20s\n",
                		livro.getCodLivro(), livro.getTitulo(), livro.getAutor(), livro.getCodAluno());
            }
        }
	}
	
	public static void listarLivrosLivres(ArrayList<Livro> lista){
        System.out.println("\n\t\t Listagem de livros disponiveis");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Cod. Livro\t Titulo\t\t\t\t\t Autor");
        System.out.println("-----------------------------------------------------------------------------");
        for (int i=0; i<lista.size(); i++) {
            Livro livro = lista.get(i);
            if (livro.getDataEmprestimo() == null) {
                System.out.printf(" %s\t\t %-32.32s\t %-20s\n",
                		livro.getCodLivro(), livro.getTitulo(), livro.getAutor());
            }
        }
    }

    public  static void listarLivrosEmprestados(ArrayList<Livro> lista){
        System.out.println("\n\t\t Listagem de livros emprestados");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Cod. Livro\t Titulo\t\t\t\t\t Autor\t\t\t Cod. Aluno");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (int i=0; i<lista.size(); i++) {
            Livro livro = lista.get(i);
            if (livro.getDataEmprestimo() != null) {
                System.out.printf(" %s\t\t %-32.32s\t %-20s\t %-20s\n",
                		livro.getCodLivro(), livro.getTitulo(), livro.getAutor(), livro.getCodAluno());
            }
        }
    }
    
    public static Livro atualizarLivro() {
		int codLivro;
    	String titulo;
    	String autor;
		System.out.println("\n Atualizar livro:");
		System.out.print(" Codigo: ");
		codLivro = entra.nextInt();
		clearBuffer(entra);
		System.out.print(" Titulo: ");
		titulo = entra.nextLine();
		System.out.print(" Autor: ");
		autor = entra.nextLine();
		Livro livro = new Livro(codLivro, titulo, autor);
		return livro;
    }
}