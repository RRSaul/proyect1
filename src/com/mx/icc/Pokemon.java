package com.mx.icc;

/**
 * Clase para representar estudiantes. Un estudiante tiene nombre, número de
 * cuenta, promedio y edad. La clase implementa {@link Registro}, por lo que
 * puede serializarse en una línea de texto y deserializarse de una línea de
 * texto; además de determinar si sus campos cazan valores arbitrarios y
 * actualizarse con los valores de otro estudiante.
 */
public class Pokemon implements Registro {

    /** Nombre del estudiante. */
    private String nombreomote;
    /** Número de cuenta. */
    private int numPokedex;
    /** Pormedio del estudiante. */
    private double podAtq;
    /** Tipo primario del com.mx.icc.Pokemon*/
    private String tipoPrim;
    /** Tipo segundario del com.mx.icc.Pokemon*/
    private String tipoSegu;


    /**
     * Define el estado inicial de un estudiante.
     * @param nombreomote el nombre del estudiante.
     * @param numPokedex el número de cuenta del estudiante.
     * @param podAtq el promedio del estudiante.
     * @param tipoPrim f
     * @param tipoSegu f
     *
     */
    public Pokemon(String nombreomote,
                   int numPokedex,
                   double podAtq,
                   String tipoPrim,
                   String tipoSegu) {
    }
    /**
     * Regresa el nombre del estudiante.
     * @return el nombre del estudiante.
     */
    public String getNombreomote() {
        return nombreomote;
    }

    /**
     * Define el nombre del estudiante.
     * @param nombreomote el nuevo nombre del estudiante.
     */
    public void setNombreomote(String nombreomote) {
        this.nombreomote = nombreomote;
    }

    /**
     * Regresa el número de cuenta del estudiante.
     * @return el número de cuenta del estudiante.
     */
    public int getNumPokedex() {
        return numPokedex;
    }

    /**
     * Define el número cuenta del estudiante.
     * @param numPokedex el nuevo número de cuenta del estudiante.
     */
    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }

    /**
     * Regresa el promedio del estudiante.
     * @return el promedio del estudiante.
     */
    public double getPodAtq() {
        return podAtq;
    }

    /**
     * Define el promedio del estudiante.
     * @param podAtq el nuevo promedio del estudiante.
     */
    public void setPodAtq(double podAtq) {
        this.podAtq = podAtq;
    }


    /**
     * Regresa el nombre del estudiante.
     * @return el nombre del estudiante.
     */
    public String getTipoPrim() {
        return tipoPrim;
    }

    /**
     * Define el nombre del estudiante.
     * @param tipoSegu el nuevo nombre del estudiante.
     */
    public void setTipoSegu(String tipoSegu) {
        if (this.tipoPrim == null)
            setTipoPrim(tipoSegu);
        if (tipoSegu==this.tipoPrim)
            return;
        this.tipoSegu = tipoSegu;
    }
    /**
     * Regresa el nombre del estudiante.
     * @return el nombre del estudiante.
     */
    public String getTipoSegu() {
        if (this.tipoSegu == null )
            return "el com.mx.icc.Pokemon solo tiene tipo primario y es"+getTipoPrim();
        return tipoSegu;
    }

    /**
     * Define el nombre del estudiante.
     * @param tipoPrim el nuevo nombre del estudiante.
     */
    public void setTipoPrim(String tipoPrim) {
        this.tipoPrim = tipoPrim;
    }
    /**
     * Regresa una representación en cadena del estudiante.
     * @return una representación en cadena del estudiante.
     *
     */
    @Override public String toString() {
        return String.format("Nombre   : %s\n" +
                        "Numero pokemon   : %09d\n" +
                        "Poder de ataque : %2.2f\n" +
                        "Tipo primero: %s\n" +
                        "Tipo segndo:  %s\n",
                nombreomote, numPokedex, podAtq, tipoPrim, tipoSegu);
    }

    /**
     * Nos dice si el objeto recibido es un estudiante igual al que manda llamar
     * el método.
     * @param objeto el objeto con el que el estudiante se comparará.
     * @return <code>true</code> si el objeto recibido es un estudiante con las
     *         mismas propiedades que el objeto que manda llamar al método,
     *         <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object objeto) {
        if (!(objeto instanceof Pokemon))
            return false;
        Pokemon e = (Pokemon)objeto;
        if((e.nombreomote.equals(nombreomote)) && (e.numPokedex == numPokedex) &&
                (e.podAtq == podAtq) && (e.tipoPrim.equals(tipoPrim)) && (e.tipoSegu.equals(tipoSegu)))
            return true;
        return false;
    }


    /**
     * Regresa el estudiante serializado en una línea de texto. La línea de
     * texto que este método regresa debe ser aceptada por el método {@link
     * Pokemon#deserializa}.
     * @return la serialización del estudiante en una línea de texto.
     */
    @Override public String serializa() {
        return String.format("%s\t%d\t%2.2f\t%d\n",
                nombreomote, numPokedex, podAtq, tipoPrim, tipoSegu);
    }

    /**
     * Deserializa una línea de texto en las propiedades del estudiante. La
     * serialización producida por el método {@link Pokemon#serializa} debe
     * ser aceptada por este método.
     * @param linea la línea a deserializar.
     * @throws ExcepcionLineaInvalida si la línea recibida es nula, vacía o no
     *         es una serialización válida de un estudiante.
     */
    @Override public void deserializa(String linea) {
       if (linea == null || linea.trim().isEmpty() )
           throw new ExcepcionLineaInvalida("La linea es nula o es vacia");
       String t[] = linea.trim().split("\t");
       if (t.length != 4 || t[1].length()<5)
           throw new ExcepcionLineaInvalida("El registro no es un estudiante");
       this.nombreomote =  t[0];
       try {
           this.numPokedex = (int)Integer.parseInt(t[1]);

       }catch (NumberFormatException e){
           System.out.println(e);
       }
       String proaux = t[2].replace(",", ".");
       this.podAtq = Double.valueOf(proaux);
       //this.edad = Integer.parseInt(t[3]);
    }   // Aquí va su código.


    /**
     * Actualiza los valores del estudiante con los del registro recibido.
     * @param registro el registro con el cual actualizar los valores.
     * @throws IllegalArgumentException si el registro no es instancia de {@link
     *         Pokemon}.
     */
    public void actualiza(Registro registro) {
        if (!(registro instanceof Pokemon)){
        throw new IllegalArgumentException("Tas mal bro, no es instancia de estudiante");}
        Pokemon ac =(Pokemon)registro;
        this.nombreomote = ac.nombreomote;
        this.numPokedex = ac.numPokedex;
        this.podAtq = ac.podAtq;
        this.tipoPrim = ac.tipoPrim;
        this.tipoSegu = ac.tipoSegu;

        // Aquí va su código.
    }

    /**
     * Nos dice si el estudiante caza el valor dado en el campo especificado.
     * @param campo el campo que hay que cazar.
     * @param valor el valor con el que debe cazar el campo del registro.
     * @return <code>true</code> si:
     *         <ul>
     *           <li><code>campo</code> es {@link CampoPokemon#NOMBRE} y
     *              <code>valor</code> es instancia de {@link String} y es una
     *              subcadena del nombre del estudiante.</li>
     *           <li><code>campo</code> es {@link CampoPokemon#NUMPOKEMON} y
     *              <code>valor</code> es instancia de {@link Integer} y su
     *              valor entero es menor o igual a la cuenta del
     *              estudiante.</li>
     *           <li><code>campo</code> es {@link CampoPokemon#PODATQ} y
     *              <code>valor</code> es instancia de {@link Double} y su
     *              valor doble es menor o igual al promedio del
     *              estudiante.</li>
     *           <li><code>campo</code> es {@link CampoPokemon#TIPOPRIM} y
     *              <code>valor</code> es instancia de {@link Integer} y su
     *              valor entero es menor o igual a la edad del
     *              estudiante.</li>
     *         </ul>
     *         <code>false</code> en otro caso.
     * @throws IllegalArgumentException si el campo no es instancia de {@link
     *         CampoPokemon}.
     */
    public boolean caza(Enum campo, Object valor) {
        if (!(campo instanceof CampoPokemon))
            throw new IllegalArgumentException("El campo debe ser " +
                    "CampoEstudiante");
        CampoPokemon c = (CampoPokemon)campo;
        switch(c){
            case NOMBRE:
                return cazaNombre(valor);
            case NUMPOKEMON:
                return cazaCuenta(valor);
            case TIPOPRIM:
                return cazaEdad(valor);
            case PODATQ:
                return cazaPromedio(valor);
            default:
                return false;
        }
    }
    private boolean cazaNombre(Object o){
        if(!(o instanceof String))return false;
        String v = (String) o;
        if(v.isEmpty()) return false;
        return nombreomote.contains(v);
    }
    private boolean cazaCuenta(Object o){
        if(!(o instanceof Integer)) return false;
        Integer v = (Integer) o;
        return numPokedex >= v;
    }
    private boolean cazaEdad(Object o){
        if(!(o instanceof Integer)) return false;
        Integer v = (Integer) o;
        return false;
    }
    private boolean cazaPromedio(Object o){
        if(!(o instanceof Double)) return false;
        Double v = (Double) o;
        return podAtq >= v;
    }
}
