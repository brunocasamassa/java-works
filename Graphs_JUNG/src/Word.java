public class Word {

	private String nome = "";
	private String nome2 = "";
	private String nome3 = "";
	private String nome4 = "";
	private int id = 0;

	public Word(int id, String nome, String nome2, String nome3, String nome4) {
		this.nome = nome;
		this.nome2 = nome2;
		this.nome3 = nome3;
		this.nome4 = nome4;
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (nome != null) {
			return nome;
		} else if (nome2 != null) {
			return nome2;
		} else if (nome3 != null) {
			return nome3;
		} else {
			return nome4;
		}

	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
