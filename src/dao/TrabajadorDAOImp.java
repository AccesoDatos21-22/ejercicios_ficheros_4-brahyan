package dao;

import java.io.IOException;
import java.io.RandomAccessFile;

import modelo.NoExisteTrabajador;
import modelo.Trabajador;

public class TrabajadorDAOImp implements TrabajadorDAO {

	public static final String FICHERO = "empleado.bin";

	@Override
	public boolean insertar(Trabajador e) {
		try (RandomAccessFile raf = new RandomAccessFile(FICHERO, "rw")) {
			// posiciono en el registro del empleado a insertar
			raf.seek(e.getId() * Trabajador.TAM_REGISTRO);
			raf.writeInt(e.getId());
			raf.writeInt(e.getDep());
			raf.writeDouble(e.getSalario());
			StringBuilder nombre = new StringBuilder(e.getNombre());
			nombre.setLength(Trabajador.TAM_NOMBRE);
			raf.writeChars(nombre.toString());
		} catch (IOException exception) {
			return false;
		}
		return true;
	}

	@Override
	public Trabajador leer(int idEmpleado) throws NoExisteTrabajador {
		int id, dep;
		double salario;
		char[] aNombre = new char[Trabajador.TAM_NOMBRE];
		char letra;
		String nombre;
		Trabajador emple = new Trabajador();
		try (RandomAccessFile raf = new RandomAccessFile(FICHERO, "r")) {
			// posiciono en el registro del empleado a insertar
			if (raf.length() < Trabajador.TAM_REGISTRO * idEmpleado)
				throw new NoExisteTrabajador("no existe" + idEmpleado);

			raf.seek(idEmpleado * Trabajador.TAM_REGISTRO);

			id = raf.readInt();
			dep = raf.readInt();
			salario = raf.readDouble();
			for (int i = 0; i < Trabajador.TAM_NOMBRE; i++) {
				letra = raf.readChar();

				aNombre[i] = letra != 0 ? letra : ' ';
			}
			nombre = new String(aNombre);
			emple = new Trabajador(id, dep, salario, nombre);
		} catch (IOException exception) {
			System.err.println("Error al escribir");
		}
		return emple;
	}

	@Override
	public boolean actualizar(Trabajador e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(int id) throws NoExisteTrabajador {
		// TODO Auto-generated method stub
		return false;
	}

}