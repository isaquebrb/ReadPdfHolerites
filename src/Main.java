import java.io.File;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Arquivos arquivos = new Arquivos("C:\\Users\\Isaque\\eclipse-workspace\\Holerites\\files");
    for (File file : arquivos.GetArquivos()) {
      LeituraPdf pdfReader = new LeituraPdf(file);
      Holerite holerite = new Holerite();
      RegexHolerite.setTexto(pdfReader.GetTexto());
      holerite.setNome(RegexHolerite.GetNome());
      holerite.setCnpj(RegexHolerite.GetCnpj());
      holerite.setSalarioBase(RegexHolerite.GetSalarioBase());
      holerite.setSalarioLiq(RegexHolerite.GetSalarioLiq());
      holerite.setTotalDescontos(RegexHolerite.GetTotalDescontos());
      if (RegexHolerite.getTexto().contains("Beneficiário Pensionista")) {
          holerite.setCargoInstituidor(RegexHolerite.GetCargoInstituidor());
          holerite.setTipoHolerite(TipoHolerite.PENSIONISTA);
          Print print = new PrintHoleritePensionista();
          print.enviarMensagem("## Dados do Servidor ##");
          print.enviarMensagemHolerite(holerite);
        }
        else if (RegexHolerite.getTexto().contains("Servidor")) {
          holerite.setTipoHolerite(TipoHolerite.SERVIDOR);
          holerite.setCargo(RegexHolerite.GetCargo());
          Print print = new PrintHoleriteServidor();
          print.enviarMensagemHolerite(holerite);
          print.enviarMensagem("## Dados do Pensionista ##");
        }
      
    }
  }
}