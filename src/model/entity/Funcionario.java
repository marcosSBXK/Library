package model.entity;

public class Funcionario {
	private int codFunc;
	private String nomeFunc;
	private String telFunc;
	private String senha;
	
	public Funcionario() {
		this.nomeFunc = "";
		this.telFunc = "";
		this.senha = "";
	}
	
	public Funcionario(String nomeFunc, String telFunc, String senha) {
		this.nomeFunc = nomeFunc;
		this.telFunc = telFunc;
		this.senha = senha;
	}
	
	public Funcionario(int codFunc, String nomeFunc, String telFunc, String senha) {
		this.codFunc = codFunc;
		this.nomeFunc = nomeFunc;
		this.telFunc = telFunc;
		this.senha = senha;
	}

	public Funcionario(Funcionario f) {
		this.codFunc = f.codFunc;
		this.nomeFunc = f.nomeFunc;
		this.telFunc = f.telFunc;
		this.senha = f.senha;
	}

	public int getCodFunc() {
		return codFunc;
	}

	public void setCodFunc(int codFunc) {
		this.codFunc = codFunc;
	}

	public String getNomeFunc() {
		return nomeFunc;
	}

	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}

	public String getTelFunc() {
		return telFunc;
	}

	public void setTelFunc(String telFunc) {
		this.telFunc = telFunc;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}