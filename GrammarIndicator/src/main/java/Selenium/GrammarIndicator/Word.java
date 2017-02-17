public class Word {

	private String nome = "";
	private int id = 0;

	public Word( String nome) {
		this.nome = nome;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;

	}

	public int getId() {
		// TODO Auto-generated method stub

		return id;
	}
	
	public int setId(int i){
		this.id=i;
		return id;
	}

}
