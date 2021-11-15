package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import java.util.List;

import modelo.Medicamento;

public class MedicamentoAleatorio implements MedicamentoDAO {
	
	public final static int TAM_NOMBRE = 30;
	public final static int TAM_REGISTRO = 88;
	
	private final String FILENOTFOUD="No se ha encontrado el fichero";
	
	@Override
	public boolean guardar(Medicamento medicamento) {
		//File para que el fichero se cree dentro del directorio de trabajo 
		File fich = Paths.get("").toAbsolutePath().resolve("medicamentos.bin").toFile();
		//Creacion de fichero si y directorios si es necesario
		if ( !fich.exists() ) {
			try {
				fich.createNewFile();
			} catch (Exception e) {
				System.err.println("no se puede crear fichero para medicamentos");
			}
		}
		
		try ( RandomAccessFile raf = new RandomAccessFile(fich,"rw") ){
			//Se coloca el puntero en la posicion correspondiente al ID del producto
			raf.seek(TAM_REGISTRO*(medicamento.getCod()-1));
			//Se escribe el codigo del medicamento
			raf.writeInt(medicamento.getCod());
			//Se escribe el nombre del medicamento usando StringBuilder para que tenga el tamaño que debe
			StringBuilder sb = new StringBuilder(medicamento.getNombre());
			sb.setLength(TAM_NOMBRE);
			raf.writeChars(sb.toString());
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			System.err.println(FILENOTFOUD);
		} catch (IOException e) {
			System.err.println("Error en la escritura del medicamento");
		}
		
		return true;
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
