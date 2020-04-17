package com.mx.icc;

/**
 * Clase para representar Pokemon. Un Pokemon tiene nombre o mote, número en la Pokedex Mundial, puntos de ataque . La clase implementa {@link Registro}, por lo que
 * puede serializarse en una línea de texto y deserializarse de una línea de
 * texto; además de determinar si sus campos cazan valores arbitrarios y
 * actualizarse con los valores de otro Pokemon.
 */
public class Pokemon implements Registro {

    /* Nombre o mote del Pokemon. */
    private String nombreomote;
    /* Número en la Pokemex Mundial. */
    private int numPokedex;
    /* Nivel del Pokemon. */
    private double nivel;
    /*El sexo del Pokemon*/
    private String sexo;
    /*Tipo primario del Pokemon*/
    private String tipoPrim;
    /** Tipo segundario del com.mx.icc.Pokemon*/
    private String tipoSegu;


    /**
     * Define el estado inicial de un Pokemon.
     * @param nombreomote el nombre del Pokemon,tambei puede ser un mote/apodo 
     *                    ya que la informacion de que Pokemon es esta en el numero de la Pokedex mundial.
     * @param numPokedex el número en la Pokedex mundial del Pokemon.
     * @param nivel el nivel con el porcentaje al siguiente nivel del Pokemon.
     * @param sexo el sexo del Pokemon.
     * @param tipoPrim f
     * @param tipoSegu f
     */
    public Pokemon(String nombreomote,
                   int numPokedex,
                   double nivel,
                   String sexo,
                   String tipoPrim,
                   String tipoSegu) {
    }
    /**
     * Regresa el nombre o mote del Pokemon.
     * @return el nombreomote o mote del Pokemon.
     */
    public String getNombreomote() {
        return nombreomote;
    }

    /**
     * Define el nombre o mote del Pokemon.
     * @param nombreomote el nuevo nombre o mote del Pokemon.
     */
    public void setNombreomote(String nombreomote) {
        this.nombreomote = nombreomote;
    }

    /**
     * Regresa el número de la Pokedex Mundial del Pokemon.
     * @return el número de la Pokedex Mundial del Pokemon.
     */
    public int getNumPokedex() {
        return numPokedex;
    }

    /**
     * Define el número de la Pokedex Mundial del Pokemon.
     * @param numPokedex el nuevo número de la Pokedex Mundial del Pokemon.
     */
    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }

    /**
     * Regresa el nivel del Pokemon.
     * @return el nivel del Pokemon.
     */
    public double getNivel() {
        return nivel;
    }

    /**
     * Define el nivel del Pokemon.
     * @param nivel el nuevo nivel del Pokemon.
     */
    public void setNivel(double nivel) {
        this.nivel = nivel;
    }
    /**
     * Regresa el sexo o mote del Pokemon.
     * @return el sexo del Pokemon.
     */
    public String getSexo() {
        return this.sexo;
    }

    /**
     * Define el sexo del Pokemon.
     * @param sexo del Pokemon.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    /**
     * Regresa el tipo primario del Pokemon.
     * @return el tipo primario del Pokemon.
     */
    public String getTipoPrim() {
        return tipoPrim;
    }

    /**
     * Define el tipo segundario del Pokemon.
     * @param tipoSegu el nuevo tipo segundario del Pokemon, si es mismo que el primario actual no hace nada.
     */
    public void setTipoSegu(String tipoSegu) {
        if (this.tipoPrim == null)
            setTipoPrim(tipoSegu);
        if (tipoSegu==this.tipoPrim)
            return;
        this.tipoSegu = tipoSegu;
    }
    /**
     * Regresa el tipo segundario del Pokemon.
     * @return el tipo segundario del Pokemon, si el Pokemon solo tiene un tipo regresa este junto con un comentario.
     */
    public String getTipoSegu() {
        if (this.tipoSegu == null )
            return nombreomote + " solo tiene tipo primario y es " + tipoPrim;
        return tipoSegu;
    }

    /**
     * Define el tipo primario del Pokemon.
     * @param tipoPrim el tipo primario del Pokemon.
     */
    public void setTipoPrim(String tipoPrim) {
        this.tipoPrim = tipoPrim;
    }
    /**
     * Regresa una representación en cadena del Pokemon.
     * @return una representación en cadena del Pokemon.
     *
     */
    @Override public String toString() {
        return String.format(": %s\n" +
                        "%s\n" +
                        "#  : %04d\n" +
                        "Nivel : %2.2f\n" +
                        "Tipos:%s\n" + "%s\n",
                nombreomote, sexo, numPokedex, nivel, tipoPrim, tipoSegu);
    }

    /**
     * Nos dice si el objeto recibido es un Pokemon igual al que manda llamar
     * el método.
     * @param objeto el objeto con el que el Pokemon se comparará.
     * @return <code>true</code> si el objeto recibido es un Pokemon con las
     *         mismas propiedades que el objeto que manda llamar al método,
     *         <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object objeto) {
        if (!(objeto instanceof Pokemon))
            return false;
        Pokemon e = (Pokemon)objeto;
        if((e.nombreomote.equals(nombreomote)) && (e.numPokedex == numPokedex) &&
                (e.nivel == nivel) && (e.tipoPrim.equals(tipoPrim)) && (e.tipoSegu.equals(tipoSegu)) && e.sexo.equals(sexo))
            return true;
        return false;
    }


    /**
     * Regresa el Pokemon serializado en una línea de texto. La línea de
     * texto que este método regresa debe ser aceptada por el método {@link
     * Pokemon#deserializa}.
     * @return la serialización del Pokemon en una línea de texto.
     */
    @Override public String serializa() {
        return String.format("%s\t%d\t%2.2f\t%d\n");
    }

    /**
     * Deserializa una línea de texto en las propiedades del Pokemon. La
     * serialización producida por el método {@link Pokemon#serializa} debe
     * ser aceptada por este método.
     * @param linea la línea a deserializar.
     * @throws ExcepcionLineaInvalida si la línea recibida es nula, vacía o no
     *         es una serialización válida de un Pokemon.
     */
    @Override public void deserializa(String linea) {
        if (linea == null || linea.trim().isEmpty() )
            throw new ExcepcionLineaInvalida("La linea es nula o es vacia");
        String t[] = linea.trim().split("\t");
        if (t.length != 4 || t[1].length()<5)
            throw new ExcepcionLineaInvalida("El registro no es un Pokemon");
        this.nombreomote =  t[0];
        try {
            this.numPokedex = (int)Integer.parseInt(t[1]);

        }catch (NumberFormatException e){
            System.out.println(e);
        }
        String proaux = t[2].replace(",", ".");
        this.nivel = Double.valueOf(proaux);
        this.edad = Integer.parseInt(t[3]);
    }

    /**
     * Actualiza los valores del Pokemon con los del registro recibido.
     * @param registro el registro con el cual actualizar los valores.
     * @throws IllegalArgumentException si el registro no es instancia de {@link
     *         Pokemon}.
     */
    public void actualiza(Registro registro) {
        if (!(registro instanceof Pokemon)){
        throw new IllegalArgumentException("Tas mal bro, no es instancia de Pokemon");}
        Pokemon ac =(Pokemon)registro;
        this.nombreomote = ac.nombreomote;
        this.numPokedex = ac.numPokedex;
        this.nivel = ac.nivel;
        this.sexo = ac.sexo;
        this.tipoPrim = ac.tipoPrim;
        this.tipoSegu = ac.tipoSegu;

        // Aquí va su código.
    }

    /**
     * Nos dice si el Pokemon caza el valor dado en el campo especificado.
     * @param campo el campo que hay que cazar.
     * @param valor el valor con el que debe cazar el campo del registro.
     * @return <code>true</code> si:
     *         <ul>
     *           <li><code>campo</code> es {@link CampoPokemon#NOMBREOMOTE} y
     *              <code>valor</code> es instancia de {@link String} y es una
     *              subcadena del nombre o mote del Pokemon.</li>
     *           <li><code>campo</code> es {@link CampoPokemon#NUMPOKEMON} y
     *              <code>valor</code> es instancia de {@link Integer} y su
     *              valor entero es menor o igual al numero de la Pokedex Mundial del
     *              Pokemon.</li>
     *           <li><code>campo</code> es {@link CampoPokemon#NIVEL} y
     *              <code>valor</code> es instancia de {@link Double} y su
     *              valor doble es menor o igual al nivel del
     *              Pokemon.</li>
     *           <li><code>campo</code> es {@link CampoPokemon#TIPOPRIM} y
     *              <code>valor</code> es instancia de {@link Integer} y su
     *              valor entero es menor o igual a la edad del
     *              Pokemon.</li>
     *         </ul>
     *         <code>false</code> en otro caso.
     * @throws IllegalArgumentException si el campo no es instancia de {@link
     *         CampoPokemon}.
     */
    public boolean caza(Enum campo, Object valor) {
        if (!(campo instanceof CampoPokemon))
            throw new IllegalArgumentException("El campo debe ser " +
                    "CampoPokemon");
        CampoPokemon c = (CampoPokemon)campo;
        switch(c){
            case NOMBREOMOTE:
                return cazaNombreomote(valor);
            case NUMPOKEMON:
                return cazaNumPokemon(valor);
            case SEXO:
                return cazaSexo(valor);
            case TIPOPRIM:
                return cazaTipoPrim(valor);
            case TIPOSEGU:
                return cazaTipoSeg(valor);
            case NIVEL:
                return cazaNivel(valor);
            default:
                return false;
        }
    }
    private boolean cazaNombreomote(Object o){
        if(!(o instanceof String))return false;
        String v = (String) o;
        if(v.isEmpty()) return false;
        return nombreomote.contains(v);
    }
    private boolean cazaNumPokemon(Object o){
        if(!(o instanceof Integer)) return false;
        Integer v = (Integer) o;
        return numPokedex >= v;
    }
    private boolean cazaNivel(Object o){
        if(!(o instanceof Double)) return false;
        Double v = (Double) o;
        return nivel >= v;
    }
    private boolean cazaTipoSeg(Object o){
        if(!(o instanceof String))return false;
        String v = (String) o;
        if(v.isEmpty()) return false;
        return tipoSegu.contains(v);
    }
    private boolean cazaTipoPrim(Object o){
        if(!(o instanceof String))return false;
        String v = (String) o;
        if(v.isEmpty()) return false;
        return nombreomote.contains(v);
    }
    private boolean cazaSexo(Object o){
        if(!(o instanceof String))return false;
        String v = (String) o;
        if(v.isEmpty()) return false;
        return nombreomote.contains(v);
    }
}
