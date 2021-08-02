package model.entity;

public final class Aluno {
    private int codAluno;
    private int periodoRestrito;
    private String nomeAluno;
    private String telAluno;
    private String matricula;
    private String dataRestricao;
    private boolean restricao;
    
    public Aluno(){
    	this.codAluno = 0;
    	this.periodoRestrito = 0;
        this.nomeAluno = "";
        this.telAluno = "";
        this.matricula = "";
        this.dataRestricao = "";
        this.restricao = false;
       
    }

    public Aluno(String nomeAluno, String telAluno, String matricula){
        this.periodoRestrito = 0;
        this.nomeAluno = nomeAluno;
        this.telAluno = telAluno;
        this.matricula = matricula;
        this.dataRestricao = "";
        this.restricao = false;
    }
    
    public Aluno(int codAluno, String nomeAluno, String telAluno, String matricula, boolean restricao, int periodoRestrito, String dataRestricao){
    	this.codAluno = codAluno;
        this.periodoRestrito = periodoRestrito;
        this.nomeAluno = nomeAluno;
        this.telAluno = telAluno;
        this.matricula = matricula;
        this.dataRestricao = dataRestricao;
        this.restricao = restricao;
    }

    public Aluno(Aluno a){
    	this.codAluno = a.codAluno;
    	this.periodoRestrito = a.periodoRestrito;
        this.nomeAluno = a.nomeAluno;
        this.telAluno = a.telAluno;
        this.matricula = a.matricula;
        this.dataRestricao = a.dataRestricao;
        this.restricao = a.restricao;
    }

	public int getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}

	public int getPeriodoRestrito() {
		return periodoRestrito;
	}

	public void setPeriodoRestrito(int periodoRestrito) {
		this.periodoRestrito = periodoRestrito;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getTelAluno() {
		return telAluno;
	}

	public void setTelAluno(String telAluno) {
		this.telAluno = telAluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDataRestricao() {
		return dataRestricao;
	}

	public void setDataRestricao(String dataRestricao) {
		this.dataRestricao = dataRestricao;
	}

	public boolean isRestricao() {
		return restricao;
	}

	public void setRestricao(boolean restricao) {
		this.restricao = restricao;
	}
}