
public class HoleriteServidor {
	private String nome;
	private String cargo;
	private Holerites holerites;
	
	
	public HoleriteServidor(Holerites holerites) {
		this.holerites = holerites;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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
