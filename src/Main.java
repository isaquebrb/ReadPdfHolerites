import java.io.File;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Arquivos arquivos = new Arquivos("C:\\Users\\iribeirb\\eclipse-workspace\\ReadPdfHolerites\\files");
    for (File file : arquivos.GetArquivos()) {
      LeituraPdf pdfReader = new LeituraPdf(file);
      Holerite holerite = new Holerite();
      RegexHolerite.setTexto(pdfReader.GetTexto());
      Print.ImprimirMensagem("## Dados do Holerite ##");
      if (RegexHolerite.getTexto().contains("Beneficiário Pensionista")) {
        holerite.setCargoInstituidor(RegexHolerite.GetCargoInstituidor());
        holerite.setTipoHolerite(TipoHolerite.PENSIONISTA);
      }
      else if (RegexHolerite.getTexto().contains("Servidor")) {
        holerite.setTipoHolerite(TipoHolerite.SERVIDOR);
        holerite.setCargo(RegexHolerite.GetCargo());
      }
      holerite.setNome(RegexHolerite.GetNome());
      holerite.setCnpj(RegexHolerite.GetCnpj());
      holerite.setSalarioBase(RegexHolerite.GetSalarioBase());
      holerite.setSalarioLiq(RegexHolerite.GetSalarioLiq());
      holerite.setTotalDescontos(RegexHolerite.GetTotalDescontos());
      Print.ImprimirDadosHolerite(holerite);
    }
  }
}