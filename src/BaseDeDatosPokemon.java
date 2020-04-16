/**
 * Clase para bases de datos de estudiantes.
 */
public class BaseDeDatosPokemon extends BaseDeDatos {

    /**
     * Crea un estudiante en blanco.
     * @return un estudiante en blanco.
     */
    @Override public Registro creaRegistro() {
        return new Pokemon(null, 0, 0.0,null,null);
    }

}
