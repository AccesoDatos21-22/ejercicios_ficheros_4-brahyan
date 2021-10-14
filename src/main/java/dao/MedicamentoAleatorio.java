package dao;

import java.util.List;

import modelo.Medicamento;

public class MedicamentoAleatorio implements MedicamentoDAO {
	
	public final static int TAM_NOMBRE = 30;
	public final static int TAM_REGISTRO = 88;
	
	@Override
	public boolean guardar(Medicamento medicamento) {
		
		return false;
	}

	@Override
	public Medicamento buscar(String nombre) {
		
		return null;
	}

	@Override
	public boolean actualizar(Medicamento medicamento) {
		
		return false;
	}

	@Override
	public boolean borrar(Medicamento medicamento) {
		
		return false;
	}



	@Override
	public List<Medicamento> leerTodos() {
		return null;
	}

}
