package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.AlunoController;
import model.entity.Aluno;

public class AlunoView {
	static Scanner entra = new Scanner(System.in);
	
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
	
	public static int getCodAluno() {
		System.out.print(" Digite o codigo do aluno: ");
		int codAluno = entra.nextInt();
		return codAluno;
	}
	
	public static Aluno salvarAluno() {
		String nome;
		String telefone;
		String matricula;
		System.out.println("\n Cadastrar aluno:");
		System.out.print(" Nome: ");
		nome = entra.nextLine();
		System.out.print(" Telefone: ");
		telefone = entra.nextLine();
		System.out.print(" Matricula: ");
		matricula = entra.nextLine();
		Aluno aluno = new Aluno(nome, telefone, matricula);
		return aluno;
	}
	
	public static void exibirAluno(Aluno aluno) {
		System.out.println("\nCod. Aluno\t Nome\t\t\t Telefone\tMatricula\tRestricao");
        System.out.println("---------------------------------------------------------------------------------");
        AlunoController.verificaRestricao(aluno);
        System.out.printf(" %s\t\t %-20.20s\t %-12.12s\t%-13.13s",
        		aluno.getCodAluno(), aluno.getNomeAluno(), aluno.getTelAluno(), aluno.getMatricula());
        if(aluno.isRestricao() == false){
            System.out.println("\tNao");
        }
        else if(aluno.isRestricao() == true){
            System.out.println("\tSim");
        }
	}
	
	public static void listarTodosAlunos(ArrayList<Aluno> lista) {
		System.out.println("\n\t\t Listagem de aluno");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Cod. Aluno\t Nome\t\t\t Telefone\tMatricula\tRestricao");
        System.out.println("---------------------------------------------------------------------------------");
        for(int i=0; i<lista.size(); i++){
            Aluno a = lista.get(i);
            AlunoController.verificaRestricao(a);
            System.out.printf(" %s\t\t %-20.20s\t %-12.12s\t%-13.13s",
                a.getCodAluno(), a.getNomeAluno(), a.getTelAluno(), a.getMatricula());
            if(a.isRestricao() == false){
                System.out.println("\tNao");
            }
            else if(a.isRestricao() == true){
                System.out.println("\tSim");
            }
        }
	}

	public static Aluno atualizarAluno() {
		int codAluno;
		int periodoRestrito;
		String nome;
		String telefone;
		String matricula;
		String dataRestricao;
		String aux;
		boolean restricao;
		System.out.println("\n Atualizar aluno:");
		System.out.print(" Codigo: ");
		codAluno = entra.nextInt();
		clearBuffer(entra);
		System.out.print(" Nome: ");
		nome = entra.nextLine();
		System.out.print(" Telefone: ");
		telefone = entra.nextLine();
		System.out.print(" Matricula: ");
		matricula = entra.nextLine();
		System.out.print(" Restricao(s/n): ");
		aux = entra.nextLine();
		if (aux.equals("s")) {
			restricao = true;
		}
		else {
			restricao = false;
		}
		System.out.print(" Periodo restrito: ");
		periodoRestrito = entra.nextInt();
		clearBuffer(entra);
		System.out.print(" Data da restricao: ");
		dataRestricao = entra.nextLine();
		Aluno aluno = new Aluno(codAluno ,nome, telefone, matricula, restricao, periodoRestrito, dataRestricao);
		return aluno;
	}
}