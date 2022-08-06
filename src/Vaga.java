public class Vaga {
	protected int id;
	protected String tipo;
	protected boolean livre;
	protected String placa;
	
	public Vaga(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
		this.livre = false;
	}
	
	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}

	protected boolean getLivre() {
		return livre;
	}

	protected void setLivre(boolean livre) {
		this.livre = livre;
	}

	protected String getPlaca() {
		return placa;
	}

	protected void setPlaca(String placa) {
		this.placa = placa;
	}

	public void ocupar() {
		this.setLivre(false);
	}
	
	public void desocupar() {
		this.setLivre(true);
	}
	
}
