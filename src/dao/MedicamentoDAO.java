package dao;

import java.util.List;

import modelo.Medicamento;

public interface MedicamentoDAO {
	
	// Operaciones CRUD
	
	public boolean guardar(Medicamento medicamento);
	
	public Medicamento buscar(String nombre);

	public boolean actualizar(Medicamento medicamento);
	
	public boolean borrar(Medicamento medicamento);	
	
	public List<Medicamento> leerTodos();




}
