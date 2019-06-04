package modelo;

public class Professor {


	private int id;
	private final String nome;



	public Professor(String nome) {

		this.nome = nome;

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


}
