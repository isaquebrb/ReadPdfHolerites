
public class PrintHoleritePensionista implements Print {

	@Override
	public void enviarMensagem(String mensagem) {
		System.out.println(mensagem);
	}

	@Override
	public void enviarMensagemHolerite(Holerite holerite) {
		System.out.println("Cargo: " + holerite.getCargoInstituidor());
		System.out.println("Tipo: " + holerite.getTipoHolerite().name());
		System.out.println("Nome Funcion�rio: " + holerite.getNome());
		System.out.println("CNPJ Empresa: " + holerite.getCnpj());
		System.out.println("Sal�rio Base: " + holerite.getSalarioBase());
		System.out.println("Sal�rio Liqu�do: " + holerite.getSalarioLiq());
		System.out.println("Total Descontos: " + holerite.getTotalDescontos());

	}

}
