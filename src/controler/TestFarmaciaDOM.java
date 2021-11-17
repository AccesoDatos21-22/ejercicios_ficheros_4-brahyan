package controler;

import java.nio.file.Path;
import java.nio.file.Paths;

import dao.FarmaciaDOM;
import modelo.Farmacia;
import modelo.Medicamento;

public class TestFarmaciaDOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Farmacia farmacia = new Farmacia();
		FarmaciaDOM farmaciaDOM = new FarmaciaDOM();
		//creacion de medicamentos
		Medicamento med1 = new Medicamento(92,"Ritalin",21.50,100,200,12,3);
		Medicamento med2 = new Medicamento(12,"Omeprazol",10.13,50,200,5,2);
		Medicamento med3 = new Medicamento(85,"Insulina",18.50,210,300,50,1);
		//guardamos los medicamentos
		farmacia.guardar(med1);
		farmacia.guardar(med2);
		farmacia.guardar(med3);
		//Guardamos los medicamentos de la farmacia en el fichero XML en el directorio de trabajo
		farmaciaDOM.guardar(farmacia);
		//Lectura del ficheo XML anteriormente creado
		Path workingDirectory = Paths.get("").toAbsolutePath();
		 for ( Medicamento med : farmaciaDOM.leer(workingDirectory).leerTodos() ) {
			 System.out.println( med );
		 }

	}

}
