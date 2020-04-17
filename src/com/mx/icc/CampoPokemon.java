package com.mx.icc;

/**
 * Enumeración para los campos de un {@link Pokemon}.
 */
public enum CampoPokemon {

    /** El nombre del Pokemon. */
    NOMBREOMOTE,
    /** El numero en la Pokedex Mundial del Pokemon. */
    NUMPOKEMON,
    /** El nivel del Pokemon. */
    NIVEL,
    /** El sexo del Pokemon. */
    SEXO,
    /** El tipo primario del Pokemon. */
    TIPOPRIM,
    /** El tipo segundario del pokemon*/
    TIPOSEGU;

    /**
     * Regresa una representación en cadena del campo para ser usada en
     * interfaces gráficas.
     * @return una representación en cadena del campo.
     */
    @Override public String toString() {
        switch(this){
            case NOMBREOMOTE: return "Nombre: ";
            case NUMPOKEMON: return "Numero en la Pokedex: ";
            case NIVEL: return "Nivel ";
            case SEXO: return "Sexo ";
            case TIPOPRIM: return "Tipo primario ";
            case TIPOSEGU:return "Tipo secundario ";
            default: throw new IllegalArgumentException();
        }
    }
}
