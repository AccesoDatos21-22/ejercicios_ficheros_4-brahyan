package controler;

import dao.FarmaciaDOM;
import modelo.Farmacia;
import modelo.Medicamento;

public class TestFarmaciaDOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Farmacia farmacia = new Farmacia();
		FarmaciaDOM farmaciaDOM = new FarmaciaDOM();
		//creacion de medicamentos
		Medicamento med1 = new Medicamento(12,"aspirina 1gr",21.50,100,200,12,3);
		Medicamento med2 = new Medicamento(2,"Ibuprofeno",10.13,50,200,5,2);
		Medicamento med3 = new Medicamento(1,"Naproxeno 500mg",18.50,210,300,50,1);
		//guardamos los medicamentos
		farmacia.guardar(med1);
		farmacia.guardar(med2);
		farmacia.guardar(med3);
		
		farmaciaDOM.guardar(farmacia);

	}

}
