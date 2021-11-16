package modelo;

import java.util.ArrayList;
import java.util.List;

import dao.MedicamentoDAO;

public class Farmacia implements MedicamentoDAO {
	private List<Medicamento> medicamentos;

	/**
	 * Constructor de la farmacia
	 */
	public Farmacia() {
		//Inicializacion de lista de medicametos.
		medicamentos = new ArrayList<Medicamento>();
	}

	@Override
	public boolean guardar(Medicamento medicamento) {
		//Se devuelve true si el medicamento no estaba y se ha añadido
		//false en caso contrario
		boolean added = false;
		
		if ( !medicamentos.contains(medicamento) ) {
			medicamentos.add(medicamento);
			added = true;
		}
		return added;
	}

	@Override
	public boolean borrar(Medicamento medicamento) {
		
		boolean deleted = false;
		
		if ( medicamentos.contains(medicamento) ) {
			medicamentos.remove(medicamento);
			deleted = true;
		}
		
		return deleted;
	}

	@Override
	public List<Medicamento> leerTodos() {

		return this.medicamentos;
	}

	@Override
	public Medicamento buscar(String nombre) {
		//Si alguno de los medicamentos de la lista tiene el nombre buscado se devuelve
		//el medicamento, si no se vulve null
		for (Medicamento medicamento : medicamentos) {
			if(medicamento.getNombre().equals(nombre)) {
				return medicamento;
			}
		}
		return null;
	}

	@Override
	public boolean actualizar(Medicamento medicamento) {
		//Dado que para comprobar si un elemento esta contenido en la lista, llama al metodo equals del objeto
		//Con que el medicamento pasado tenga el mismo codigo que alguno de los contenidos en la lista
		//Se sustituyen el resto de campos con la informacion del medicamento pasado por parametro
		boolean actualizado = false;
		
		if (medicamentos.contains(medicamento)) {
			medicamentos.set(  medicamentos.indexOf(medicamento) , medicamento);
			actualizado = true;
		}
		return actualizado;
	}
}