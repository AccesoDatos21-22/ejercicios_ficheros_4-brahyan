package dao;

import modelo.JCCPokemon;

public interface JCCPokemonDAO {
	
	public JCCPokemon leer();
	
	
	public boolean guardar(JCCPokemon pokemones);

}
