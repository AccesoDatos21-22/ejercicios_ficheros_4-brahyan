package modelo;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;



/*
 * Si os fij�is usamos 3 anotaciones: XmlRootElement, XmlType y XmlElement.
 * 
 * La primera marca el elemento ra�z de nuestra clase (en nuestro caso el nombre
 * de la clase).Con XmlType y la propiedad �propOrder� cambiamos el orden en que
 * se escribir�n los atributos en el xml resultante.Finalmente usando XmlElement
 * en el setter de los atributos que nos interesa que se incluyan en el xml,
 * marcamos los campos de nuestro inter�s.
 */

@XmlRootElement(name="Empresa")
@XmlType(propOrder = { "nombreEmpresa", "idEmpresa", "direccion",
		"numEmpleados", "empleados" })
public class Empresa  {


	private int idEmpresa;
	private String nombreEmpresa;
	private String direccion;
	private int numEmpleados;
	private ArrayList<Empleado> empleados;

	public int getIdEmpresa() {
		return idEmpresa;
	}

	@XmlElement
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	@XmlElement
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getDireccion() {
		return direccion;
	}

	@XmlElement
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNumEmpleados() {
		return numEmpleados;
	}

	@XmlElement
	public void setNumEmpleados(int numEmpleados) {
		this.numEmpleados = numEmpleados;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	@XmlElement
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
}
