package modelo;

public class Curso {


	private int id;
	private final String nome;



	public Curso(String nome) {

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


	@Override
	public String toString() {
		return "Curso{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				'}';
	}
}
