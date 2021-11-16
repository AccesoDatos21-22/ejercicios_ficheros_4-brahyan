package controler;

import modelo.Farmacia;
import modelo.Medicamento;

public class TestFarmacia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Farmacia farmacia = new Farmacia();
		
		//creacion de medicamentos
		
		Medicamento med1 = new Medicamento(12,"aspirina 1gr",21.50,100,200,12,3);
		Medicamento med2 = new Medicamento(2,"Ibuprofeno",10.13,50,200,5,2);
		Medicamento med3 = new Medicamento(1,"Naproxeno 500mg",18.50,210,300,50,1);
		
		//guardamos los medicamentos
		
		farmacia.guardar(med1);
		farmacia.guardar(med2);
		farmacia.guardar(med3);
		
		//prueba buscar medicamento
		System.out.println("---------medicamento buscado-----");
		System.out.println( farmacia.buscar("Ibuprofeno") );
		
		//prueba leertodos
		System.out.println("----- leer todos los medicamentos---");
		for(Medicamento med:farmacia.leerTodos()) {
			System.out.println(med);
		}
		
		//borrar medicamento
		farmacia.borrar(med2);
		
		//prueba leertodos
		System.out.println("----- leer todos DESPUES DE BORRAR los medicamentos---");
		for(Medicamento med:farmacia.leerTodos()) {
			System.out.println(med);
		}
		
		//Prueba actualizar---------Con impresion
		farmacia.actualizar(new Medicamento(1,"Naproxeno 1g",500,500,500,500,500));
		System.out.println("-------------Medicamento despues de modificar--------");
		System.out.println( farmacia.buscar("Naproxeno 1g") );
		
		
	}

}
