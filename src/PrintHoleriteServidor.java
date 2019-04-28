
public class PrintHoleriteServidor implements Print {

	@Override
	public void enviarMensagem(String mensagem) {
		System.out.println(mensagem);
	}

	@Override
	public void enviarMensagemHolerite(HoleriteServidor holerite) {
		System.out.println("Cargo: " + holerite.getCargo());
		System.out.println("Tipo: " + holerite.getHolerite().getTipoHolerite().name());
		System.out.println("Nome Funcionário: " + holerite.getNome());
		System.out.println("CNPJ Empresa: " + holerite.getCnpj());
		System.out.println("Salário Base: " + holerite.getSalarioBase());
		System.out.println("Salário Liquído: " + holerite.getSalarioLiq());
		System.out.println("Total Descontos: " + holerite.getTotalDescontos());

	}

	@Override
	public void enviarMensagemHolerite(HoleritePensionista holerite) {
		// TODO Auto-generated method stub
	}

}
