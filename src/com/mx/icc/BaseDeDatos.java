package com.mx.icc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Clase abstracta para bases de datos. Provee métodos para agregar y eliminar
 * registros, y para guardarse y cargarse de una entrada y salida dados. Además,
 * puede hacer búsquedas con valores arbitrarios sobre los campos de los
 * registros.
 *
 * Las clases que extiendan a com.mx.icc.BaseDeDatos deben implementar el método {@link
 * #creaRegistro}, que crea un registro en blanco. 
 */
public abstract class BaseDeDatos {

    /* com.mx.icc.Lista de registros en la base de datos. */
    private Lista registros;

    /**
     * Constructor único.
     */
    public BaseDeDatos() {
        registros = new Lista();
        // Aquí va su código.
    }

    /**
     * Regresa el número de registros en la base de datos.
     * @return el número de registros en la base de datos.
     */
    public int getNumRegistros() {
        return registros.getLongitud();
        // Aquí va su código.
    }

    /**
     * Regresa una lista con los registros en la base de datos. Modificar esta
     * lista no cambia a la información en la base de datos.
     * @return una lista con los registros en la base de datos.
     */
    public Lista getRegistros() {
        return registros.copia();
        // Aquí va su código.
    }

    /**
     * Agrega el registro recibido a la base de datos.
     * @param registro el registro que hay que agregar a la base de datos.
     */
    public void agregaRegistro(Registro registro) {
        registros.agregaFinal(registro);
        // Aquí va su código.
    }

    /**
     * Elimina el registro recibido de la base de datos.
     * @param registro el registro que hay que eliminar de la base de datos.
     */
    public void eliminaRegistro(Registro registro) {
        registros.elimina(registro);
        // Aquí va su código.
    }

    /**
     * Limpia la base de datos.
     */
    public void limpia() {
        registros.limpia();
        // Aquí va su código.
    }

    /**
     * Guarda todos los registros en la base de datos en la salida recibida.
     * @param out la salida donde hay que guardar los registos.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    public void guarda(BufferedWriter out) throws IOException {
        Lista.Nodo n = registros.getCabeza();
        while(n!= null){
            Registro r = (Registro) n.get();
            out.write(r.serializa());
            n = n.getSiguiente();
        }

        // Aquí va su código.
    }

    /**
     * Carga los registros de la entrada recibida en la base de datos. Si antes
     * de llamar el método había registros en la base de datos, estos son
     * eliminados.
     * @param in la entrada de donde hay que cargar los registos.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    public void carga(BufferedReader in) throws IOException {
        // Aquí va su código.
        try{ this.registros.limpia();
            while (true){
                Registro r = creaRegistro();
                String v = in.readLine();
                if(v == null ||v.isEmpty() ||v.length()<5 )
                    break;
                r.deserializa(v);
                agregaRegistro(r);
            }
            in.close();
        }catch (IOException e){
            throw new IOException("A ocurrido un error en la matrix, debes desconectarte del sistema llamado vida");
        }
    }



    /**
     * Busca registros por un campo específico.
     * @param campo el campo del registro por el cuál buscar.
     * @param valor el valor a buscar.
     * @return una lista con los registros tales que cazan el campo especificado
     *         con el valor dado.
     * @throws IllegalArgumentException si el campo no es de la enumeración
     *         correcta.
     */
    public Lista buscaRegistros(Enum campo, Object valor) {
        if(!(campo instanceof CampoPokemon))
            throw new IllegalArgumentException();
        Lista l = new Lista();
        Lista.Nodo n = registros.getCabeza();
        while(n != null){
            Registro r = (Registro) n.get();
            if(r.caza(campo, valor))l.agregaFinal(r);
            n = n.getSiguiente();
        }
        return l;
    }

    /**
     * Crea un registro en blanco.
     * @return un registro en blanco.
     */
    public abstract Registro creaRegistro();

}
