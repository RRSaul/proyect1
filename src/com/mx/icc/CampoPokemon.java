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
<<<<<<< HEAD:src/CampoPokemon.java
            case NOMBREOMOTE: return "Nombre del Pokemon";
            case NUMPOKEMON: return "Numero en la Pokedex del Pokemon";
            case NIVEL: return "Nivel del Pokemon";
            case SEXO: return "Sexo del Pokemon";
            case TIPOPRIM: return "Tipo primario del Pokemon";
            case TIPOSEGU:return "Tipo segundario del Pokemon";
=======
            case NOMBRE: return "Nombre del com.mx.icc.Pokemon";
            case NUMPOKEMON: return "# Numero en la Pokedex del com.mx.icc.Pokemon";
            case PODATQ: return "Poder de Ataque del com.mx.icc.Pokemon";
            case TIPOPRIM: return "Tipo primario del com.mx.icc.Pokemon";
            case TIPOSEGU:return "Tipo segundario del com.mx.icc.Pokemon";
>>>>>>> b13789947fe023d5fe0da756f59cd1837584b7ba:src/com/mx/icc/CampoPokemon.java
            default: throw new IllegalArgumentException();
        }
    }
}
