import java.io.File;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Arquivos arquivos = new Arquivos("C:\\Users\\Isaque\\eclipse-workspace\\Holerites\\files");
    for (File file : arquivos.GetArquivos()) {
      LeituraPdf pdfReader = new LeituraPdf(file);
      RegexHolerite.setTexto(pdfReader.GetTexto());
      Holerites holerites = new Holerites();
      holerites.setCnpj(RegexHolerite.GetCnpj());
      holerites.setSalarioBase(RegexHolerite.GetSalarioBase());
      holerites.setSalarioLiq(RegexHolerite.GetSalarioLiq());
      holerites.setTotalDescontos(RegexHolerite.GetTotalDescontos());
      if (RegexHolerite.getTexto().contains("Beneficiário Pensionista")) {
    	  holerites.setTipoHolerite(TipoHolerite.PENSIONISTA);
    	  HoleritePensionista holeritePen = new HoleritePensionista(holerites);
    	  holeritePen.setCargoInstituidor(RegexHolerite.GetCargoInstituidor());    	  
    	  holeritePen.setNome(RegexHolerite.GetNome());    	  
          IPrintPensionista print = new PrintPensionista();
          print.enviarMensagem("## Dados do Servidor ##");
          print.enviarMensagemHolerite(holeritePen);
        }
        else if (RegexHolerite.getTexto().contains("Servidor")) {
          holerites.setTipoHolerite(TipoHolerite.SERVIDOR);
          HoleriteServidor holeriteServ = new HoleriteServidor(holerites);
          holeriteServ.setCargo(RegexHolerite.GetCargo());
          holeriteServ.setNome(RegexHolerite.GetNome());
          IPrintServidor print = new PrintServidor();
          print.enviarMensagem("## Dados do Pensionista ##");
          print.enviarMensagemHolerite(holeriteServ);
        }
    }
  }
}