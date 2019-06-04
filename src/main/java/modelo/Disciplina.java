package modelo;

public class Disciplina {


	private int id;
	private final String nome;
	private final String ementa;
	private final String cargahr;


	public Disciplina(String nome, String ementa, String cargahr) {
		this.nome = nome;
		this.ementa = ementa;
		this.cargahr = cargahr;
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

	public String getEmenta() {
		return ementa;
	}

	public String getCargahr() {
		return cargahr;
	}


	@Override
	public String toString() {
		return "Disciplina{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", ementa='" + ementa + '\'' +
				", cargahr='" + cargahr + '\'' +
				'}';
	}
}
