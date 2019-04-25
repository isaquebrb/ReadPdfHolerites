
public class Holerite {
  
  private String cnpj;
  private String nome;
  private double salarioBase;
  private double salarioLiq;
  private double totalDescontos;
  private String cargo;
  private String cargoInstituidor;
  private TipoHolerite tipoHolerite;
  
  public String getCnpj() {
    return cnpj;
  }
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
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
    
    if(this.totalDescontos != (this.getSalarioBase() - this.getSalarioLiq())) {
      Print.ImprimirMensagem("O desconto capturado não bate com o valor do desconto calculado (salário base - salário liquido)");
      this.totalDescontos = 0;
    }
  }
  public String getCargo() {
    return cargo;
  }
  public void setCargo(String cargo) {
    this.cargo = cargo;
  }
  public String getCargoInstituidor() {
    return cargoInstituidor;
  }
  public void setCargoInstituidor(String cargoInstituidor) {
    this.cargoInstituidor = cargoInstituidor;
  }

  public double FormatStringToDouble(String strValor) {
    strValor = strValor.substring(0, strValor.length() - 2).replaceAll("[R$\\,\\.]", "");
    double valor = Double.valueOf(strValor);
    return valor;
  }
  
  public TipoHolerite getTipoHolerite() {
    return tipoHolerite;
  }
  
  public void setTipoHolerite(TipoHolerite tipo) {
    this.tipoHolerite = tipo;
  }
}
