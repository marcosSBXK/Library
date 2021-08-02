package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.entity.Funcionario;

public class FuncionarioView {
	static Scanner entra = new Scanner(System.in);
	
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
	
	public static int getCodFunc() {
		System.out.print(" Digite o codigo do funcionario: ");
		int codFunc = entra.nextInt();
		return codFunc;
	}
	
	public static Funcionario salvarFuncionario() {
		String nome, telefone, senha;
		System.out.println("\n Cadastrar funcionario:");
		System.out.print(" Nome: ");
		nome = entra.nextLine();
		System.out.print(" Telefone: ");
		telefone = entra.nextLine();
		System.out.print(" Senha: ");
		senha = entra.nextLine();
		Funcionario funcionario = new Funcionario(nome, telefone, senha);
		return funcionario;
	}
	
	public static void exibirFuncionario(Funcionario funcionario) {
		System.out.println("\nCod. Funcionario\t Nome\t\t\t Telefone");
        System.out.println("-------------------------------------------------------------");
        System.out.printf(" %s\t\t\t %-20.20s\t %-12.12s\n",
        		funcionario.getCodFunc(), funcionario.getNomeFunc(), funcionario.getTelFunc());
	}
	
	public static void listarTodosFuncionarios(ArrayList<Funcionario> lista) {
		System.out.println("\n\t\t Listagem de funcionario");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cod. Funcionario\t Nome\t\t\t Telefone");
        System.out.println("-------------------------------------------------------------");
        for(int i=0; i<lista.size(); i++){
            Funcionario funcionario = lista.get(i);
            System.out.printf(" %s\t\t\t %-20.20s\t %-12.12s\n",
            		funcionario.getCodFunc(), funcionario.getNomeFunc(), funcionario.getTelFunc());
        }
	}
	
	public static Funcionario atualizarFuncionario() {
		int codFunc;
		String nome;
		String telefone;
		String senha;
		System.out.println("\n Atualizar funcionario:");
		System.out.print(" Codigo: ");
		codFunc = entra.nextInt();
		clearBuffer(entra);
		System.out.print(" Nome: ");
		nome = entra.nextLine();
		System.out.print(" Telefone: ");
		telefone = entra.nextLine();
		System.out.print(" Senha: ");
		senha = entra.nextLine();
		Funcionario funcionario = new Funcionario(codFunc, nome, telefone, senha);
		return funcionario;
	}
}