package modelo;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="Empleado")
public class Empleado {
 
    private int id;
    private String nombre;
    private String titulo;
    private boolean activo=false;
    private Integer numeroEmpl;
    private Date fechaAlta;
 
    public int getId() {
        return id;
    }
 
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getTitulo() {
        return titulo;
    }
 
    @XmlElement
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
 
    public boolean isActivo() {
        return activo;
    }
 
    @XmlElement
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
 
    public Integer getNumeroEmpl() {
        return numeroEmpl;
    }
 
    @XmlElement
    public void setNumeroEmpl(Integer numeroEmpl) {
        this.numeroEmpl = numeroEmpl;
    }
 
    public Date getFechaAlta() {
        return fechaAlta;
    }
 
    @XmlElement
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", titulo=" + titulo + ", activo=" + activo
				+ ", numeroEmpl=" + numeroEmpl + ", fechaAlta=" + fechaAlta + "]";
	}

	
    
 
}


