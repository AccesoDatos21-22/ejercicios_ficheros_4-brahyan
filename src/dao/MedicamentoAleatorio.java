package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import java.util.List;

import modelo.Medicamento;

public class MedicamentoAleatorio implements MedicamentoDAO  {
	
	public final static int TAM_NOMBRE = 30;
	public final static int TAM_REGISTRO = 88;
	
	private final String FILENOTFOUD="No se ha encontrado el fichero";
	private final String WRITTINGERROR="Error el la escritura del medicamento";
	
	private File fich;
	
	public MedicamentoAleatorio() throws Exception{
		//File para que el fichero se cree dentro del directorio de trabajo 
		this.fich = Paths.get("").toAbsolutePath().resolve("medicamentos.bin").toFile();
		//Creacion de fichero para trabajar si no existe ya
		if ( !fich.exists() ) {
			try {
				fich.createNewFile();
			} catch (Exception e) {
				throw new Exception("no se puede crear fichero para medicamentos");
			}
		}
	}
	
	@Override
	public boolean guardar(Medicamento medicamento) {
		
		//verifica que toda la informacion se ha escrito correctamente
		boolean todoBien = true;
		
		try ( RandomAccessFile raf = new RandomAccessFile(fich,"rw") ){
			//Se coloca el puntero en la posicion correspondiente al ID del producto empezando por 0
			raf.seek(TAM_REGISTRO*(medicamento.getCod()-1));
			//Se escribe el codigo del medicamento
			raf.writeInt(medicamento.getCod());
			//Se escribe el nombre del medicamento usando StringBuilder para que tenga el tamaño que debe
			StringBuilder sb = new StringBuilder(medicamento.getNombre());
			sb.setLength(TAM_NOMBRE);
			raf.writeChars(sb.toString());
			//se escribe precio
			raf.writeDouble(medicamento.getPrecio());
			//se escribe Stock
			raf.writeInt(medicamento.getStock());
			//	Stock maximo
			raf.writeInt(medicamento.getStockMaximo());
			//	Stock minimo
			raf.writeInt(medicamento.getStockMinimo());
			//	Codigo de proveedor
			raf.writeInt(medicamento.getCodProveedor());
			
		}catch (FileNotFoundException e) {
			System.err.println(FILENOTFOUD);
			todoBien = false;
		} catch (IOException e) {
			System.err.println(WRITTINGERROR);
			todoBien = false;
		}
		
		return todoBien;
	}

	@Override
	public Medicamento buscar(String nombre) {
		
		try(RandomAccessFile raf = new RandomAccessFile(fich, "r") ){
			//Lee los nombres desde el principio del fichero
			for (int i=4; i<raf.length() ;i+=TAM_REGISTRO) {
				//Se coloca al principio del nombre de cada registro
				raf.seek(i);
				//Se leen los 60 bytes que componen el nombre
				byte[] nombreBytes = new byte[TAM_NOMBRE*2];
				raf.read(nombreBytes);
				//Se construye cadena a partie de bytes leidos y se elimninan los caracteres nulos
				//con los que el StringBuilder rellena las cadenas para que tengan el tamaño deseado
				String nombreMed = new String(nombreBytes); 
				nombreMed = nombreMed.replace("\u0000", "");
				//Si el nombre leido coincide con el buscaco, se leen el resto de campos y se devuelve el Medicamento
				if ( nombreMed.equals(nombre) ) {
					int codigo = i/TAM_REGISTRO + 1;
					double precio = raf.readDouble();
					int stock = raf.readInt();
					int stockMaximo = raf.readInt();
					int stockMinimo = raf.readInt();
					int proveedor = raf.readInt();
					
					return new Medicamento(codigo,nombre,precio,stock,stockMaximo,stockMinimo,proveedor);
				}
			}
			
		}catch (Exception e) {
			System.err.println("error al leer el fichero de medicamentos");
		}
		//Se devuelve null si no se encuentra coincidencia
		return null;
	}

	@Override
	public boolean actualizar(Medicamento medicamento) {
		//Dado que se hace coincidir el codigo con la posicion
		//en el fichero, actualizar el lo mismo que guardar
		boolean todoBien = this.guardar(medicamento);
	
		return todoBien;
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
