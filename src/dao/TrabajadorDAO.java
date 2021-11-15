package dao;

import modelo.NoExisteTrabajador;
import modelo.Trabajador;

public interface TrabajadorDAO {
	

	public boolean insertar(Trabajador e);
	
	public boolean actualizar(Trabajador e);

	public Trabajador leer(int id) throws NoExisteTrabajador;

	public boolean borrar(int id) throws NoExisteTrabajador;


}
