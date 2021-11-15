package modelo;

import java.io.Serializable;

public class Medicamento implements Serializable {
	
	public final static float IVA = 0.04f;
	
	private final static long serialVersionUID = 1L; //Version de la clase
	
	private String nombre; // tamaño 30, 60 bytes
	private double precio; // 8 bytes
	private int cod; // 4 bytes
	private int stock; // 4 bytes
	private int stockMaximo; // 4 bytes
	private int stockMinimo; // 4 bytes
	private int codProveedor; // 4 bytes

	public Medicamento() {
		this.nombre = "";
		this.precio = 0.0;
		this.cod=0;
		this.stock=0;
		this.stockMaximo=0;
		this.stockMinimo=0;
		this.codProveedor=0;
	}
	@Override
	public String toString() {
		//Devuelve estado del objeto en cadena
		return	"Código: " + this.cod +
					"\n\t Nombre: " + this.nombre +
					"\n\t Precio: " + this.precio +
					"\n\t Stock: " + this.stock +
					"\n\t Provedoor: " + this.codProveedor ;
	}
	
	@Override
	public boolean equals(Object obj) {
		//Si ambos medicamentos tienen el mismo codigo
		//se consideran igules.
		if ( obj instanceof Medicamento ) {
			Medicamento med = (Medicamento) obj;
			return med.cod == this.cod ? true : false; 
		}else {
			return false;
		}
	}
	
	//-------GETTERS Y SETTERS------------------------

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(int codProveedor) {
		this.codProveedor = codProveedor;
	}
	
}