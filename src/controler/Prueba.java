package controler;

import dao.MedicamentoAleatorio;
import modelo.Medicamento;

public class Prueba {

	public static void main(String[] args) {
		
		try {
			//Lanza excepcion si no se puede trabajar con el fichero binario
			MedicamentoAleatorio practicaRandom = new MedicamentoAleatorio();
			
			//Medicamentos a escribir
			Medicamento med1 = new Medicamento(1,"aspirina 1gr",21.50,100,200,12,3);
			Medicamento med2 = new Medicamento(2,"Ibuprofeno",10.13,50,200,5,2);
			Medicamento med3 = new Medicamento(12,"Frenadol",15.50,25,200,15,3);
			//Escritura de medicamentos
			practicaRandom.guardar(med1); 
			practicaRandom.guardar(med2); 
			practicaRandom.guardar(med3); 
			
			Medicamento medBuscado = practicaRandom.buscar("Frenadol");
			if ( medBuscado !=null  ) {
				System.out.println(medBuscado);
			}else {
				System.out.println("Medicamento no encontrado");
			}
		} catch (Exception e) {
			System.err.println( e.getMessage() );
			System.exit(-1);
		}
		
		
		
	}

}
