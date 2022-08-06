public class Main {

	public static void main(String[] args) {
		Estacionamento estacionamento = new Estacionamento();
		Carro carro1 = new Carro("IBM6322");
		Moto moto1 = new Moto("AVG5412");
		
		
		estacionamento.estacionarCarro(carro1);
		estacionamento.estacionarMoto(moto1);
		estacionamento.estadoEstacionamento();
	}

}
