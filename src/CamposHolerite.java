public class CamposHolerite extends CapturarCampos {

	public CamposHolerite(String texto) {
		super(texto);
	}

	public String GetCargoInstituidor() {
		String pattern = "Cargo\\D*\\n(\\w*\\s\\w*)\\s";
		return GetValue(pattern);
	}

	public String GetCargo() {
		String pattern = "Cargo.*\\d{1,9}\\w*\\s\\w*\\s\\w*\\s(\\w*\\s\\w*).*Cód";
		return GetValue(pattern);
	}

	public String GetNome() {
		String pattern = "Nome\\D*\\d*\\s(\\w*\\s\\w*)";
		return GetValue(pattern);
	}

	public String GetCnpj() {
		String pattern = "CPNJ(.*)Recibo";
		return GetValue(pattern);
	}

	public String GetSalarioBase() {
		String pattern = "Salário Base.*\\n(R\\$\\d{1,3}?\\.?\\d{1,3}\\,\\d{2})";
		return GetValue(pattern);
	}

	public String GetSalarioLiq() {
		String pattern = "líquido\\s*(R\\$\\d{1,3}?\\.?\\d{1,3}\\,\\d{2})";
		return GetValue(pattern);
	}

	public String GetTotalDescontos() {
		String pattern = "(R\\$\\d{1,3}?\\.?\\d{1,3}\\,\\d{2})\\s*Valor";
		return GetValue(pattern);
	}

	public void SalvarCampos(Holerites holerite) {
		holerite.setCnpj(GetCnpj());
		holerite.setSalarioBase(GetSalarioBase());
		holerite.setSalarioLiq(GetSalarioLiq());
		holerite.setTotalDescontos(GetTotalDescontos());

		if (GetTexto().contains("Beneficiário Pensionista")) {
			holerite.setTipoHolerite(TipoHolerite.PENSIONISTA);
		} else if (GetTexto().contains("Servidor")) {
			holerite.setTipoHolerite(TipoHolerite.SERVIDOR);
		}
	}

	public void SalvarCamposPensionista(HoleritePensionista holerite) {
		holerite.setCargoInstituidor(GetCargoInstituidor());    	  
		holerite.setNome(GetNome());    	
	}
	
	public void SalvarCamposServidor(HoleriteServidor holerite) {
		holerite.setCargo(GetCargo());
		holerite.setNome(GetNome());
	}

}
