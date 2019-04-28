import java.io.File;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Arquivos arquivos = new Arquivos("C:\\Users\\Isaque\\eclipse-workspace\\Holerites\\files");
    for (File file : arquivos.GetArquivos()) {
      LeituraPdf pdfReader = new LeituraPdf(file);
      CamposHolerite campos = new CamposHolerite(pdfReader.GetTexto());
      Holerites holerites = new Holerites();
      campos.SalvarCampos(holerites);
      if (holerites.getTipoHolerite() == TipoHolerite.PENSIONISTA) {
    	  HoleritePensionista holeritePen = new HoleritePensionista(holerites);
    	  campos.SalvarCamposPensionista(holeritePen);
    	  PrintPensionista print = new PrintPensionista();
          print.enviarMensagem("## Dados do Servidor ##");
          print.enviarMensagemHolerite(holeritePen);
        }
        else if (holerites.getTipoHolerite() == TipoHolerite.SERVIDOR) {
          HoleriteServidor holeriteServ = new HoleriteServidor(holerites);
          campos.SalvarCamposServidor(holeriteServ);
          PrintServidor print = new PrintServidor();
          print.enviarMensagem("## Dados do Pensionista ##");
          print.enviarMensagemHolerite(holeriteServ);
        }
    }
  }
}