public abstract class Veiculo {
	private String placa;
	private String tipo;
	private boolean estacionado;
	
	public Veiculo(String placa, String tipo) {
		this.placa = placa;
		this.tipo = tipo;
		this.estacionado = false;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean getEstacionado() {
		return estacionado;
	}

	public void setEstacionado(boolean estacionado) {
		this.estacionado = estacionado;
	}

	public void estacionar() {
		if (this.getEstacionado() == false) {
			this.setEstacionado(true);
		}
	}
	
	public void sairDaVaga() {
		if (this.getEstacionado() == true) {
			this.setEstacionado(false);
		}
	}
}
