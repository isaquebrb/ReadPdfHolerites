import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexHolerite {
  private static String texto;
  
  public static String GetCargoInstituidor() {
    String pattern = "Cargo\\D*\\n(\\w*\\s\\w*)\\s";
    return GetValue(pattern);
  }
  
  public static String GetCargo() {
    String pattern = "Cargo.*\\d{1,9}\\w*\\s\\w*\\s\\w*\\s(\\w*\\s\\w*).*Cód";
    return GetValue(pattern);
  }
  
  public static String GetNome() {
    String pattern = "Nome\\D*\\d*\\s(\\w*\\s\\w*)";
    return GetValue(pattern);
  }
  
  public static String GetCnpj() {
    String pattern = "CPNJ(.*)Recibo";
    return GetValue(pattern);
  }
  
  public static String GetSalarioBase() {
    String pattern = "Salário Base.*\\n(R\\$\\d{1,3}?\\.?\\d{1,3}\\,\\d{2})";
    return GetValue(pattern);
  }
  
  public static String GetSalarioLiq() {
    String pattern = "líquido\\s*(R\\$\\d{1,3}?\\.?\\d{1,3}\\,\\d{2})";
    return GetValue(pattern);
  }
  
  public static String GetTotalDescontos() {
    String pattern = "(R\\$\\d{1,3}?\\.?\\d{1,3}\\,\\d{2})\\s*Valor";
    return GetValue(pattern);
  }
  
  private static String GetValue(String pattern) {
    Matcher matcher = Pattern.compile(pattern, Pattern.DOTALL).matcher(texto);
    if (matcher.find()) {
      return matcher.group(1).trim();
    }
    else {
      return null;
    }
  }
  
  public static void setTexto(String texto) {
    RegexHolerite.texto = texto;
  }
  
  public static String getTexto() {
    return RegexHolerite.texto;
  }
}
