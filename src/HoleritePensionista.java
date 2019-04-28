
public class HoleritePensionista {
	private String nome;
	private String cargoInstituidor;
	private Holerites holerites;
	
	public HoleritePensionista(Holerites holerites) {
		this.holerites = holerites;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargoInstituidor() {
		return cargoInstituidor;
	}

	public void setCargoInstituidor(String cargoInstituidor) {
		this.cargoInstituidor = cargoInstituidor;
	}
	
	public String getCnpj() {
		return this.holerites.getCnpj();
	}

	public void setCnpj(String cnpj) {
		this.holerites.setCnpj(cnpj);
	}

	public double getSalarioBase() {
		return this.holerites.getSalarioBase();
	}

	public void setSalarioBase(String salarioBase) {
		this.holerites.setSalarioBase(salarioBase);
	}

	public double getSalarioLiq() {
		return this.holerites.getSalarioLiq();
	}

	public void setSalarioLiq(String salarioLiq) {
		this.holerites.setSalarioLiq(salarioLiq);
	}

	public double getTotalDescontos() {
		return this.holerites.getTotalDescontos();
	}

	public void setTotalDescontos(String totalDescontos) {
		this.holerites.setTotalDescontos(totalDescontos);
	}
	
	public Holerites getHolerite() {
		return holerites;
	}
}
