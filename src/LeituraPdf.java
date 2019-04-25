import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class LeituraPdf {
  
  private String texto;
  
  public LeituraPdf(File file) throws IOException {
    
    PDDocument pdfDocument = PDDocument.load(file);
    
    PDFTextStripper pdfStripper = new PDFTextStripper();
    
    String textoCapturado = pdfStripper.getText(pdfDocument);
    
    pdfDocument.close();
    
    this.texto = textoCapturado;
  }
  
  public String GetTexto() {
    return texto;
  }
  
}
