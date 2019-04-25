
public final class Print {
  
  public static void ImprimirMensagem(String message) {
    System.out.println(message);
  }
  
  public static void ImprimirDadosHolerite(Holerite holerite) {
    
    if(holerite.getTipoHolerite() == TipoHolerite.PENSIONISTA) {
      System.out.println("Cargo: " + holerite.getCargoInstituidor());
    }
    
    if(holerite.getTipoHolerite() == TipoHolerite.SERVIDOR) {
      System.out.println("Cargo: " + holerite.getCargo());  
    }
    
    System.out.println("Tipo: " + holerite.getTipoHolerite().name());
    System.out.println("Nome Funcion�rio: " + holerite.getNome());
    System.out.println("CNPJ Empresa: " + holerite.getCnpj());
    System.out.println("Sal�rio Base: " + holerite.getSalarioBase());
    System.out.println("Sal�rio Liqu�do: " + holerite.getSalarioLiq());
    System.out.println("Total Descontos: " + holerite.getTotalDescontos());
  }
}
