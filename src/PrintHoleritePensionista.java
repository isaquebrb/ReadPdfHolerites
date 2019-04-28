
public class PrintHoleritePensionista implements Print {

	@Override
	public void enviarMensagem(String mensagem) {
		System.out.println(mensagem);
	}

	public void enviarMensagemHolerite(HoleritePensionista holerite) {
		System.out.println("Cargo: " + holerite.getCargoInstituidor());
		System.out.println("Tipo: " + holerite.getHolerite().getTipoHolerite().name());
		System.out.println("Nome Funcion�rio: " + holerite.getNome());
		System.out.println("CNPJ Empresa: " + holerite.getCnpj());
		System.out.println("Sal�rio Base: " + holerite.getSalarioBase());
		System.out.println("Sal�rio Liqu�do: " + holerite.getSalarioLiq());
		System.out.println("Total Descontos: " + holerite.getTotalDescontos());

	}

	@Override
	public void enviarMensagemHolerite(HoleriteServidor holerite) {
		// TODO Auto-generated method stub
		
	}

}
