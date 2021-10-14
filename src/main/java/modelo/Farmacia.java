package modelo;

import java.util.List;

import dao.MedicamentoDAO;

public class Farmacia implements MedicamentoDAO {
	private List<Medicamento> medicamentos;

	/**
	 * Constructor de la farmacia
	 */
	public Farmacia() {

	}

	@Override
	public boolean guardar(Medicamento medicamento) {

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

	@Override
	public Medicamento buscar(String nombre) {
		return null;
	}

	@Override
	public boolean actualizar(Medicamento medicamento) {
		return false;
	}
}
