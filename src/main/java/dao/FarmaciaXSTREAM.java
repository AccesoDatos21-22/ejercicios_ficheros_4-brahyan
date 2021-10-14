package dao;

import modelo.Farmacia;
import modelo.Medicamento;

public class FarmaciaXSTREAM implements FarmaciaDAO{
	
	final static String rutaFarmcia =""; // localizacion del fichero XML
	final static String rutaMedicamento =""; // localizacion del fichero XML

	@Override
	public Farmacia leer() {
		return null;
	}

	@Override
	public boolean guardar(Farmacia farmacia) {
		return false;
	}


	public Medicamento leerMedicamento() {
		
		return null;
	}

	public void guardarMedicamento(Medicamento medicamento) {
	}

	
}
