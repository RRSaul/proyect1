package com.mx.icc;

/**
 * Enumeración para los campos de un {@link Pokemon}.
 */
public enum CampoPokemon {

    /** El nombre del estudiante. */
    NOMBRE,
    /** El número de cuenta del estudiante. */
    NUMPOKEMON,
    /** El promedio del estudiante. */
    PODATQ,
    /** La edad del estudiante. */
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
            case NOMBRE: return "Nombre del com.mx.icc.Pokemon";
            case NUMPOKEMON: return "# Numero en la Pokedex del com.mx.icc.Pokemon";
            case PODATQ: return "Poder de Ataque del com.mx.icc.Pokemon";
            case TIPOPRIM: return "Tipo primario del com.mx.icc.Pokemon";
            case TIPOSEGU:return "Tipo segundario del com.mx.icc.Pokemon";
            default: throw new IllegalArgumentException();
        }
    }
}
