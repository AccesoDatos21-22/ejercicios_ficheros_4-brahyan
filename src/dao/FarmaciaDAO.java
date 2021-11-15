package dao;

import modelo.Farmacia;

public interface FarmaciaDAO {
	
	/**
	 * Lee los medicamentos de la farmacia de un fichero xml
	 * mediante XSTREAM	
	 * @return devuelve si se ha leido correctamente
	 */
	public Farmacia leer();
	
	/**
	 * Guarda los medicamentos de la farmacia en un fichero XML 
	 * mediamente XSTREAM
	 * @param farmacia
	 * @return devuelve si se ha guardado correctamente
	 */
	public boolean guardar(Farmacia farmacia);

}
