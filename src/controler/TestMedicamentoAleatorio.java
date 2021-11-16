package controler;

import dao.MedicamentoAleatorio;
import modelo.Medicamento;

public class TestMedicamentoAleatorio {

	public static void main(String[] args) {
		
		try {
			//Lanza excepcion si no se puede trabajar con el fichero binario
			MedicamentoAleatorio practicaRandom = new MedicamentoAleatorio();
			
			//Medicamentos a escribir
			Medicamento med1 = new Medicamento(12,"aspirina 1gr",21.50,100,200,12,3);
			Medicamento med2 = new Medicamento(2,"Ibuprofeno",10.13,50,200,5,2);
			Medicamento med4 = new Medicamento(5,"Frenadol",15.50,25,200,15,3);
			Medicamento med3 = new Medicamento(1,"Naproxeno 500mg",18.50,210,300,50,1);
			
			//Escritura de medicamentos
			practicaRandom.guardar(med1); 
			practicaRandom.guardar(med2); 
			practicaRandom.guardar(med3); 
			practicaRandom.guardar(med4); 
			
			//Busqueda del medicameto, si no se ecuentra el metodo devuelve null
			System.out.println("-------Busqueda de medicamento");
			Medicamento medBuscado = practicaRandom.buscar("Frenadol");
			if ( medBuscado !=null  ) {
				System.out.println(medBuscado);
			}else {
				System.out.println("Medicamento no encontrado");
			}
			
			//Lectura de los medicamentos antes de borrar y muesta por pantalla
			
			System.out.println("-------Medicamentos ANTES de borrar");
			for ( Medicamento med: practicaRandom.leerTodos() ) {
				System.out.println(med);
			}
			
			//Borrado de un medicamento
			practicaRandom.borrar(med4);
			
			//lectura de todos los mediamentos despues de borrar y muesta por pantalla
			System.out.println("-------Medicamentos DESPUES de borrar");
			for ( Medicamento med: practicaRandom.leerTodos() ) {
				System.out.println(med);
			}
			
			
		} catch (Exception e) {
			System.err.println( e.getMessage() );
			System.exit(-1);
		}
		
		
		
	}

}
