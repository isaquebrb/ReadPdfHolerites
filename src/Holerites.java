
public class Holerites {
	private String cnpj;
	private double salarioBase;
	private double salarioLiq;
	private double totalDescontos;
	private TipoHolerite tipoHolerite;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(String salarioBase) {
		this.salarioBase = FormatStringToDouble(salarioBase);
	}

	public double getSalarioLiq() {
		return salarioLiq;
	}

	public void setSalarioLiq(String salarioLiq) {
		this.salarioLiq = FormatStringToDouble(salarioLiq);
	}

	public double getTotalDescontos() {
		return totalDescontos;
	}

	public void setTotalDescontos(String totalDescontos) {
		this.totalDescontos = FormatStringToDouble(totalDescontos);

		if (this.totalDescontos != (this.getSalarioBase() - this.getSalarioLiq())) {
			IPrint print = new PrintServidor();
			print.enviarMensagem(
					"O desconto capturado não bate com o valor do desconto calculado (salário base - salário liquido)");
			this.totalDescontos = 0;
		}
	}

	public TipoHolerite getTipoHolerite() {
		return tipoHolerite;
	}

	public void setTipoHolerite(TipoHolerite tipo) {
		this.tipoHolerite = tipo;
	}

	public double FormatStringToDouble(String strValor) {
		strValor = strValor.substring(0, strValor.length() - 2).replaceAll("[R$\\,\\.]", "");
		double valor = Double.valueOf(strValor);
		return valor;
	}
}
