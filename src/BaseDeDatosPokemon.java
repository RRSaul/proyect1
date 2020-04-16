/**
 * Clase para bases de datos de Pokemons, actua como una caja en el PC visto en los videojuegos.
 */
public class BaseDeDatosPokemon extends BaseDeDatos {

    /**
     * Crea un Pokemon en blanco.
     * @return un Pokemon en blanco.
     */
    @Override public Registro creaRegistro() {
        return new Pokemon(null, 0, 0.0,null,null, null);
    }

}
