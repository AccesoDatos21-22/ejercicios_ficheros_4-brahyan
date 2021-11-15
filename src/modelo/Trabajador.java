package modelo;

public class Trabajador {

	public final static int TAM_NOMBRE = 20;
	public final static int TAM_REGISTRO = 56;

	public Trabajador() {
		this(0,0,0.0,"");
	}

	public Trabajador(int id, int dep, double salario, String nombre) {
		super();
		this.id = id;
		this.dep = dep;
		this.salario = salario;
		this.nombre = nombre;
	}
	private int id; // 4 bytes
	private int dep; // 4 bytes 
	private double salario; // 8 bytes
	private String nombre; // 40 bytes
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDep() {
		return dep;
	}
	public void setDep(int dep) {
		this.dep = dep;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", dep=" + dep + ", salario=" + salario + ", nombre=" + nombre + "]";
	}
	
	

}