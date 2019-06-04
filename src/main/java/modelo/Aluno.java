package modelo;

public class Aluno {
	
	
	private int id;
	private final String nome;
	private final String endereco;
	private final String rg;
	private final String cpf;
	private final String telefone;


	public Aluno(String nome, String endereco, String rg, String cpf, String telefone) {

		this.nome = nome;
		this.endereco = endereco;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getRg() {
		return rg;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}




}
