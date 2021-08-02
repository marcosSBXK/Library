package aplication;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import controller.AlunoController;
import controller.FuncionarioController;
import controller.LivroController;
import model.DAO.AlunoDAO;
import model.DAO.FuncionarioDAO;
import model.DAO.LivroDAO;
import model.entity.Aluno;
import model.entity.Funcionario;
import model.entity.Livro;

public class Main {
	static Scanner entrada = new Scanner(System.in);
	
	public static void cadastroLivro() throws SQLException {
		int option;
		do{
			System.out.println("\n---------- Cadastro de livros ----------");
			System.out.println("  0 - Sair");
			System.out.println("  1 - Cadastrar livro");
			System.out.println("  2 - Atualizar livro");
			System.out.println("  3 - Buscar livro");
			System.out.println("  4 - Listar todos os livros");
			System.out.println("  5 - Listar livros livres");
			System.out.println("  6 - Listar livros emprestados");
			System.out.println("  7 - Remover livro");
			System.out.print(" Opcao desejada: ");
			option = entrada.nextInt();
			entrada.nextLine();
	        switch (option) {
	            case 0:
	            	break;
	            case 1:
	                LivroController.salvarLivro();
	                break;
	            case 2:
	                LivroController.atualizarLivro();
	                break;
	            case 3:
	                LivroController.buscarLivro();
	                break;
	            case 4:
	                LivroController.listarTodosLivros();
	                break;
	            case 5:
	                LivroController.listarLivrosLivres();
	                break;
	            case 6:
	                LivroController.listarLivrosEmprestados();
	                break;
	            case 7:
	                LivroController.apagarLivro();
	                break;
	            default:
	                System.out.println("\n Opcao invalida!\nDigite novamente");
	                break;
	           }
		} while (option != 0);
	}
	
	public static void cadastroFunc() throws SQLException {
		int option;
		do{
			System.out.println("\n---------- Cadastro de funcionarios ----------");
			System.out.println("  0 - Sair");
			System.out.println("  1 - Cadastrar funcionario");
			System.out.println("  2 - Atualizar funcionario");
			System.out.println("  3 - Buscar funcionario");
			System.out.println("  4 - Listar todos funcionarios");
			System.out.println("  5 - Remover livro");
			System.out.print(" Opcao desejada: ");
			option = entrada.nextInt();
			entrada.nextLine();
	        switch (option) {
	            case 0:
	            	break;
	            case 1:
	                FuncionarioController.salvarFuncionario();
	                break;
	            case 2:
	            	FuncionarioController.atualizarFuncionario();
	                break;
	            case 3:
	            	FuncionarioController.buscarFuncionario();
	                break;
	            case 4:
	            	FuncionarioController.listarTodosFuncionarios();
	                break;
	            case 5:
	            	FuncionarioController.apagarFuncionario();
	                break;
	            default:
	                System.out.println("\n Opcao invalida!\nDigite novamente");
	                break;
	           }
		} while (option != 0);
	}
	
	public static void cadastroAluno() throws SQLException {
		int option;
		do{
			System.out.println("\n---------- Cadastro de alunos ----------");
			System.out.println("  0 - Sair");
			System.out.println("  1 - Cadastrar aluno");
			System.out.println("  2 - Atualizar aluno");
			System.out.println("  3 - Buscar aluno");
			System.out.println("  4 - Listar todos alunos");
			System.out.println("  5 - Remover aluno");
			System.out.print(" Opcao desejada: ");
			option = entrada.nextInt();
			entrada.nextLine();
	        switch (option) {
	            case 0:
	            	break;
	            case 1:
	            	AlunoController.salvarAluno();
	                break;
	            case 2:
	            	AlunoController.atualizarAluno();
	                break;
	            case 3:
	            	AlunoController.buscarAluno();
	                break;
	            case 4:
	            	AlunoController.listarTodosAlunos();
	                break;
	            case 5:
	            	AlunoController.apagarAluno();
	                break;
	            default:
	                System.out.println("\n Opcao invalida!\nDigite novamente");
	                break;
	           }
		} while (option != 0);
	}
	
	public static void emprestaLivro(Livro livro, int codAluno, String data) {
    	livro.setDataEmprestimo(data);
    	livro.setCodAluno(codAluno);
    }
	
	public static void emprestarLivro() {
	    boolean flag = false;
	    boolean flagAluno = false;
	    int codLivro;
	    int codAluno;
	    String data;
	    AlunoController.listarTodosAlunos();
	    System.out.print("\n Digite o codigo do aluno que emprestara o livro ou 0 para voltar: ");
	    codAluno = entrada.nextInt();
	    entrada.nextLine();
	    if (codAluno!=0) {
	        Aluno aluno = new Aluno(AlunoDAO.readAluno(codAluno));
	        if (aluno.getCodAluno() == codAluno){
	            flagAluno = true;
	            if (aluno.isRestricao() == true) {
	                System.out.println(" O aluno nao pode emprestar livros no momento!");
	            }
	            else {
	                LivroController.listarLivrosLivres();
	                System.out.print("\n Digite o codigo do livro a ser emprestado ou 0 para voltar: ");
	                codLivro = entrada.nextInt();
	                entrada.nextLine();
	                if (codLivro!=0) {
	                    Livro l = new Livro(LivroDAO.readLivro(codLivro));
	                    if (l.getCodLivro() == codLivro && l.getDataEmprestimo() == null) {
	                        System.out.print(" Digite a data do emprestimo (ano-mes-dia): ");
	                        data = entrada.nextLine();
	                        emprestaLivro(l, codAluno, data);
	                        LivroDAO.updateLivro(l);
	                        System.out.println("\n "+l.getTitulo()+" emprestado para "+aluno.getNomeAluno());
	                        System.out.println(" Data do emprestimo: "+l.getDataEmprestimo());
	                        flag = true;
	                    }
	                    if (!flag) {
	                        System.out.println(" Livro nao encontrado ou nao disponivel!");
	                    }
	                }
	            }
	        }
	        if (!flagAluno) {
	            System.out.println(" Aluno nao encontrado!");
	        }
	    }
	}

	public static void devolverLivro() {
	    String dataDev;
	    boolean flag = false;
	    int codLivro;
	    LivroController.listarLivrosEmprestados();
	    System.out.print("\n Digite o codigo do livro a ser devolvido ou 0 para voltar: ");
	    codLivro = entrada.nextInt();
	    entrada.nextLine();
	    if (codLivro!=0) {
	        Livro l = new Livro(LivroDAO.readLivro(codLivro));
	        if (l.getCodLivro() == codLivro && l.getDataEmprestimo() != null) {
	            System.out.print(" Digite a data da devolucao: (ano-mes-dia): ");
	            dataDev = entrada.nextLine();
	            l.setDataDevolucao(dataDev);
	            Period periodo = Period.between(LocalDate.parse(l.getDataEmprestimo()), LocalDate.parse(l.getDataDevolucao()));
	            if (periodo.getYears() >= 1 || periodo.getMonths() >= 1 || periodo.getDays() > 14) {
	                int atraso, ano, mes, dia;
	                ano = periodo.getYears();
	                mes = periodo.getMonths();
	                dia = periodo.getDays();
	                atraso = (ano * 365) + (mes *30) + dia - 14;
	                System.out.println(" Dias de atraso: "+atraso);
	                atraso *= 3;
	                System.out.println(" Periodo restrito: "+atraso);
	                Aluno a = new Aluno(AlunoDAO.readAluno(l.getCodAluno()));
	                if (a.getCodAluno() == l.getCodAluno()) {
	                    a.setRestricao(true);
	                    a.setDataRestricao(dataDev);
	                    a.setPeriodoRestrito(atraso);
	                    AlunoDAO.updateAluno(a);
	                }
	            }
	            l.setDataEmprestimo(null);
	            l.setCodAluno(0);
	            LivroDAO.updateLivro(l);
	            flag = true;
	            System.out.println("\n Livro Cod. "+l.getCodLivro()+" devolvido com sucesso!");

	        }
	    }
	    if (!flag) {
	        System.out.println("\n Livro nao encontrado!");
	    }
	}
    
	public static void main(String[] args) throws SQLException {
			boolean flag = false;
			boolean flagSenha = false;
			boolean password = false;
			int cod;
			String senha;
			
			do{
				System.out.println("\n--------------------- Login de usuario ----------------------");
				System.out.print(" Digite o codigo do funcionario ou 0 para sair: ");
				cod = entrada.nextInt();
				entrada.nextLine();
				if (cod == 0) {
					System.exit(0);
				}
				Funcionario f = new Funcionario(FuncionarioDAO.readFuncionario(cod));
				if (f.getCodFunc() == cod) {
					flag = true;
					System.out.print(" Senha: ");
					senha = entrada.nextLine();
					if (f.getSenha().equals(senha)) {
						flagSenha=true;
						int op;
				        do{
				            System.out.println("\n---------- Menu Principal ----------");
				            System.out.println("  0 - Sair");
				            System.out.println("  1 - Cadastro de livros");
				            System.out.println("  2 - Cadastro de funcionarios");
				            System.out.println("  3 - Cadastro de alunos");
				            System.out.println("  4 - Emprestar livro");
				            System.out.println("  5 - Devolver livro");
							System.out.print(" Opcao desejada: ");
							op = entrada.nextInt();
							entrada.nextLine();
				            switch (op) {
				                case 0:
				                    System.out.println("\n Fim da sessao do usuario "+f.getNomeFunc());
				                    password = true;
				                    break;
				                case 1:
				                    cadastroLivro();
				                    break;
				                case 2:
				                    cadastroFunc();
				                    break;
				                case 3:
				                	cadastroAluno();
				                    break;
				                case 4:
				                	emprestarLivro();
				                	break;
				                case 5:
				                	devolverLivro();
				                	break;
				                default:
				                    System.out.println("\n Opcao invalida!\nDigite novamente");
				                    break;
					        }
					    } while (op!=0);
					}
				if (!flagSenha) {
					System.out.println(" Senha incorreta!");
				}
			}
			if (!flag) {
			    System.out.println(" Codigo invalido!");
			    }
			if (password) {
				flagSenha = false;
			}
		} while (true);
	}
}