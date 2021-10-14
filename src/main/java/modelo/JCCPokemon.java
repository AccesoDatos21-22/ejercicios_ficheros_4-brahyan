package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class JCCPokemon implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Pokemon> pokemones;
	private Date fechaLanzamiento;
	private int numCartas;
}
