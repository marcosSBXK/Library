package model.entity;

public class Livro {
	private int codLivro;
	private int codAluno;
	private String titulo;
	private String autor;
	private String dataEmprestimo;
	private String dataDevolucao;
	
	public Livro() {
		this.codLivro = 0;
		this.codAluno = 0;
		this.titulo = "";
		this.autor = "";
		this.dataEmprestimo = null;
		this.dataDevolucao = null;
	}

	public Livro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
		this.dataEmprestimo = null;
		this.dataDevolucao = null;
	}
	
	public Livro(int codLivro, String titulo, String autor) {
		this.codLivro = codLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.dataEmprestimo = null;
		this.dataDevolucao = null;
	}
	
	public Livro(int codLivro, String titulo, String autor, String dataEmprestimo, String dataDevolucao, int codAluno) {
		this.codLivro = codLivro;
		this.codAluno = codAluno;
		this.titulo = titulo;
		this.autor = autor;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}
	
	public Livro(Livro l) {
		this.codLivro = l.codLivro;
		this.codAluno = l.codAluno;
		this.titulo = l.titulo;
		this.autor = l.autor;
		this.dataEmprestimo = l.dataEmprestimo;
		this.dataDevolucao = l.dataDevolucao;
	}

	public int getCodLivro() {
		return codLivro;
	}

	public void setCodLivro(int codLivro) {
		this.codLivro = codLivro;
	}

	public int getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
}