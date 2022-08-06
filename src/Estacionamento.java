public class Estacionamento {
	private int index = 25;
	private Vaga[] vagasCarro = new Vaga[index];
	private Vaga[] vagasMoto = new Vaga[index];
	private int carroParaVaga;
	private int motoParaVaga;
	private int vagasLivresCarro;
	private int vagasLivresMoto;
	
	
	public Estacionamento() {
		for (int i = 0; i < index; i++) {
			this.vagasCarro[i] = new Vaga(i + 1, "Carro");
			this.vagasMoto[i] = new Vaga(i + 26, "Moto");
			if (i < 5) {
				vagasCarro[i].setLivre(true);
				vagasMoto[i].setLivre(true);
			}
		}
	}

	public Vaga getVagasCarro(int i) {
		return vagasCarro[i];
	}

	public Vaga getVagasMoto(int i) {
		return vagasMoto[i];
	}

	public int getCarroParaVaga() {
		return carroParaVaga;
	}

	public void setCarroParaVaga(int carroParaVaga) {
		this.carroParaVaga = this.carroParaVaga + carroParaVaga;
	}

	public int getMotoParaVaga() {
		return motoParaVaga;
	}

	public void setMotoParaVaga(int motoParaVaga) {
		this.motoParaVaga = this.motoParaVaga + motoParaVaga;
	}

	public int getVagasLivresCarro() {
		this.vagasLivresCarro = 0;
		for (int i = 0; i < index; i++) {
			if (vagasCarro[i].getLivre() == true)
				this.vagasLivresCarro++;
		}
		return vagasLivresCarro;
	}

	public int getVagasLivresMoto() {
		this.vagasLivresMoto = 0;
		for (int i = 0; i < index; i++) {
			if (vagasMoto[i].getLivre() == true)
				this.vagasLivresMoto++;
		}
		return vagasLivresMoto;
	}
	
	public void estacionarCarro(Carro carro) {
		if (this.getVagasLivresCarro() > 0) {
			for (int i = 0; i < index; i++) {
				if (vagasCarro[i].getLivre() == true) {
					this.setCarroParaVaga(1);
					vagasCarro[i].ocupar();
					vagasCarro[i].placa = carro.getPlaca();
					carro.estacionar();
					break;
				}
			}
		} 
	}
	
	public void estacionarMoto(Moto moto) {
		if (this.getVagasLivresMoto() > 0) {
			for (int i = 0; i < index; i++) {
				if (vagasMoto[i].getLivre() == true) {
					this.setMotoParaVaga(1);
					vagasMoto[i].ocupar();
					vagasMoto[i].placa = moto.getPlaca();
					moto.estacionar();
					break;
				}
			}
		}
		else if (this.getVagasLivresCarro() > 0) {
			for (int i = 0; i < index; i++) {
				if (vagasCarro[i].getLivre() == true) {
					this.setCarroParaVaga(1);
					vagasCarro[i].ocupar();
					vagasCarro[i].placa = moto.getPlaca();
					moto.estacionar();
					break;
				}
			}
		}
	}
	
	public void removerCarro(Carro carro) {
		for (int i = 0; i < index; i++) {
			if (carro.getPlaca() == vagasCarro[i].placa) {
				vagasCarro[i].desocupar();
				vagasCarro[i].placa = null;
				setCarroParaVaga(-1);
				carro.sairDaVaga();
				break;
			}
		}
	}
	
	public void removerMoto(Moto moto) {
		for (int i = 0; i < index; i++) {
			if (moto.getPlaca() == vagasMoto[i].placa) {
				vagasMoto[i].desocupar();
				vagasMoto[i].placa = null;
				setMotoParaVaga(-1);
				moto.sairDaVaga();
				break;
			}
			else if (moto.getPlaca() == vagasCarro[i].placa) {
				vagasCarro[i].desocupar();
				vagasCarro[i].placa = null;
				setCarroParaVaga(-1);
				moto.sairDaVaga();
				break;
			}
		}
	}
	
	public void estadoEstacionamento() {
		System.out.println();
		for (int i = 0; i < index; i++) {
			if (vagasCarro[i].livre == false && vagasMoto[i].livre == false) {
				System.out.println("A vaga de " + vagasCarro[i].tipo + ", id = " + vagasCarro[i].id + " está ocupada pelo veículo de placa " + vagasCarro[i].placa);
				System.out.println("A vaga de " + vagasMoto[i].tipo + ", id = " + vagasMoto[i].id + " está ocupada pela moto de placa " + vagasMoto[i].placa);
			}
			else if (vagasCarro[i].livre == false) {
				System.out.println("A vaga de " + vagasCarro[i].tipo + ", id = " + vagasCarro[i].id + " está ocupada pelo veículo de placa " + vagasCarro[i].placa);
				System.out.println("A vaga de " + vagasMoto[i].tipo + ", id = " + vagasMoto[i].id + " está livre.");
			}
			else if (vagasMoto[i].livre == false) {
				System.out.println("A vaga de " + vagasCarro[i].tipo + ", id = " + vagasCarro[i].id + " está livre.");
				System.out.println("A vaga de " + vagasMoto[i].tipo + ", id = " + vagasMoto[i].id + " está ocupada pela moto de placa " + vagasMoto[i].placa);
			}
			else {
				System.out.println("A vaga de " + vagasCarro[i].tipo + ", id = " + vagasCarro[i].id + " está livre.");
				System.out.println("A vaga de " + vagasMoto[i].tipo + ", id = " + vagasMoto[i].id + " está livre.");
			}
		}
		System.out.println("Estacionamento [vagas Carro = " + this.index + ", vagas Moto = " + this.index + 
				"], Vagas de Carro ocupadas = " + carroParaVaga + ", Vagas de Moto ocupadas = " + motoParaVaga + ", vagas livres de carro = "
				+ this.getVagasLivresCarro() + ", vagas livres de Moto = " + this.getVagasLivresMoto() );
	}
}
