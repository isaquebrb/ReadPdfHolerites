import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Arquivos {
  
  String pathFile;
  
  public Arquivos(String pathFile) {
    this.pathFile = pathFile;
  }
  
  public List<File> GetArquivos() throws IOException{
    
    List<File> files = Files.walk(Paths.get(pathFile))
        .filter(p -> p.toString().endsWith(".pdf"))
        .map(Path::toFile)
        .collect(Collectors.toList());
    
    return files;
  }
}
