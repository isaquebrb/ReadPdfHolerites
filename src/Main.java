import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String pathFiles = "C:\\Users\\Isaque\\eclipse-workspace\\Holerites\\files";
		
		List<File> files = Files.walk(Paths.get(pathFiles)).filter(p -> p.toString().endsWith(".pdf")).map(Path::toFile).collect(Collectors.toList());
		
		for(File file : files) {
			
			PDDocument pdfDocument = PDDocument.load(file);	
			
			PDFTextStripper pdfStripper = new PDFTextStripper();
			
			String texto = pdfStripper.getText(pdfDocument);
			
			String cnpj = null, nome = null, salarioBase = null, salarioLiq = null, descontos = null, cargo = null, cargoInstituidor = null;
			
			System.out.print("Holerite ");
			
			if(texto.contains("Beneficiário Pensionista")) {
				System.out.println("Pensionista");
				
				Matcher matcher = Pattern.compile("Cargo\\D*\\n(\\w*\\s\\w*)\\s", Pattern.DOTALL).matcher(texto);
				
				if(matcher.find()) {
					cargoInstituidor = matcher.group(1).trim();				
					System.out.println("Cargo: "+cargoInstituidor);
				}
			}else {
				System.out.println("Servidor");
				
				Matcher matcher = Pattern.compile("Cargo.*\\d{1,9}\\w*\\s\\w*\\s\\w*\\s(\\w*\\s\\w*).*Cód", Pattern.DOTALL).matcher(texto);
				
				if(matcher.find()) {
					cargo = matcher.group(1).trim();				
					System.out.println("Cargo: "+cargo);
				}
				
			}
			
			Matcher matcher = Pattern.compile("Nome\\D*\\d*\\s(\\w*\\s\\w*)", Pattern.DOTALL).matcher(texto);
			
			if(matcher.find()) {
				nome = matcher.group(1).trim();
				System.out.println("Nome Funcionário: "+nome);
			}
			
			matcher = Pattern.compile("CPNJ(.*)Recibo", Pattern.DOTALL).matcher(texto);
				
			if(matcher.find()) {
				cnpj = matcher.group(1).trim();				
				System.out.println("CNPJ Empresa: "+cnpj);
			}
			
			matcher = Pattern.compile("Salário Base.*\\n(R\\$\\d{1,3}?\\.?\\d{1,3}\\,\\d{2})", Pattern.DOTALL).matcher(texto);
			
			if(matcher.find()) {
				salarioBase = matcher.group(1).trim();				
				System.out.println("Salário Base: "+salarioBase);
			}
			
			matcher = Pattern.compile("líquido\\s*(R\\$\\d{1,3}?\\.?\\d{1,3}\\,\\d{2})", Pattern.DOTALL).matcher(texto);
			
			if(matcher.find()) {
				salarioLiq = matcher.group(1).trim();				
				System.out.println("Salário Liquído: "+salarioLiq);
			}
			
			matcher = Pattern.compile("(R\\$\\d{1,3}?\\.?\\d{1,3}\\,\\d{2})\\s*Valor", Pattern.DOTALL).matcher(texto);
			
			if(matcher.find()) {
				descontos = matcher.group(1).trim();				
				System.out.println("Total Descontos: "+descontos);
			}
			
			//Calcular Desconto
			salarioLiq = salarioLiq.substring(0, salarioLiq.length() - 2).replaceAll("[R$\\,\\.]", "");
			salarioBase = salarioBase.substring(0, salarioBase.length() - 2).replaceAll("[R$\\,\\.]", "");
			double doubleSalarioLiq = Double.valueOf(salarioLiq);
			double doubleSalarioBase = Double.valueOf(salarioBase);
			double doubleDesconto = doubleSalarioBase - doubleSalarioLiq;
			
			System.out.println("Desconto Calculado: "+doubleDesconto);
			
			System.out.println("Fim leitura\r");
			pdfDocument.close();
		}
	}
}