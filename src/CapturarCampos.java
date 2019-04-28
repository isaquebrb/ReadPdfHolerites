import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CapturarCampos {

	private String texto;

	public CapturarCampos(String texto) {
		this.texto = texto;
	}
	
	public String GetTexto() {
		return this.texto;
	}

	protected String GetValue(String pattern) {
		Matcher matcher = Pattern.compile(pattern, Pattern.DOTALL).matcher(texto);
		if (matcher.find()) {
			return matcher.group(1).trim();
		} else {
			return null;
		}
	}
}
