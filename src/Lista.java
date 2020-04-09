import java.util.NoSuchElementException;

/**
 * <p>Clase para listas doblemente ligadas.</p>
 *
 * <p>Las listas nos permiten agregar elementos al inicio o final de la lista,
 * eliminar elementos de la lista, comprobar si un elemento está o no en la
 * lista, y otras operaciones básicas.</p>
 *
 * <p>Las listas son iterables utilizando sus nodos. Las listas no aceptan a
 * <code>null</code> como elemento.</p>
 */
public class Lista {

    /**
     * Clase interna para nodos.
     */
    public class Nodo {

        /* El elemento del nodo. */
        private Object elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nodo con un elemento. */
        private Nodo(Object elemento) {
            // Aquí va su código.

            this.elemento = elemento;
        }

        public Nodo getAnterior() {
            // Aquí va su código.
            return this.anterior;

        }

        public Nodo getSiguiente() {
            // Aquí va su código.
            return this.siguiente;
        }

        public Object get() {
            // Aquí va su código.
            return this.elemento;

        }
    }

    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Número de elementos en la lista. */
    private int longitud;

    public int getLongitud() {
        // Aquí va su código.
        return this.longitud;
    }

    public boolean esVacia() {
        // Aquí va su código. Si la logngituf=0 o cabeza y rabo = 0
        return(cabeza == null);
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(Object elemento) {
        if(elemento == null)
            throw new IllegalArgumentException("El elemento presentado es nullo.");

        Nodo nodo = new Nodo(elemento);
        longitud++;

        if(esVacia())
            cabeza = rabo = nodo;
        else {
            rabo.siguiente = nodo;
            nodo.anterior = rabo;
            rabo = nodo;
        }
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaInicio(Object elemento) {
        if(elemento == null)
            throw new IllegalArgumentException("El elemento presentado es nullo.");

        Nodo nodo = new Nodo(elemento);
        longitud++;

        if(esVacia())
            cabeza = rabo = nodo;
        else {
            cabeza.anterior = nodo;
            nodo.siguiente = cabeza;
            cabeza = nodo;
        }
    }

    /**
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor o igual que cero, el elemento se agrega al inicio
     * de la lista. Si el índice es mayor o igual que el número de elementos en
     * la lista, el elemento se agrega al fina de la misma. En otro caso,
     * después de mandar llamar el método, el elemento tendrá el índice que se
     * especifica en la lista.
     * @param i el índice dónde insertar el elemento. Si es menor que 0 el
     *          elemento se agrega al inicio de la lista, y si es mayor o igual
     *          que el número de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void inserta(int i, Object elemento) {
        if(elemento == null)
            throw new IllegalArgumentException("El elemento es null.");

        if(i <= 0)
            agregaInicio(elemento);
        else if(i >= longitud)
            agregaFinal(elemento);
        else {
            longitud++;
            Nodo auxiliar = getNodos(cabeza, i, 1);
            Nodo nodo = new Nodo(elemento);
            nodo.anterior = auxiliar;
            nodo.siguiente = auxiliar.siguiente;
            nodo.siguiente.anterior = nodo;
            nodo.anterior.siguiente = nodo;
        }
    }
    private Nodo getNodos(Nodo nodo, int i, int j) {
        if (i == j)
            return nodo;
        return getNodos(nodo.siguiente, i, ++j);
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica.
     * @param elemento el elemento a eliminar.
     */
    public void elimina(Object elemento) {
        // Aquí va su código.
        if (elemento != null) {
            Nodo nodo = this.elBuscadormagicorecursivo(cabeza,elemento);
            if (nodo == null)
                return;
            else if (cabeza == rabo) {
                cabeza = rabo = null;
            } else if (cabeza == nodo) {
                cabeza = cabeza.siguiente;
                cabeza.anterior = null;
            } else if (rabo == nodo) {
                rabo = rabo.anterior;
                rabo.siguiente = null;
            } else {
                nodo.siguiente.anterior = nodo.anterior;
                nodo.anterior.siguiente = nodo.siguiente;
            }
            longitud--;
        }
    }
    private Nodo elBuscadormagicorecursivo(Nodo scan, Object elemento) {
        if (scan == null || scan.elemento.equals(elemento))
            return scan;
        return elBuscadormagicorecursivo(scan.siguiente, elemento);
    }

    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    private void eliminaNodo(Nodo nodo) {
        longitud--;

        if(cabeza == rabo) {
            cabeza = rabo = null;
        } else if(nodo == cabeza) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        } else if(nodo == rabo) {
            rabo = rabo.anterior;
            rabo.siguiente = null;
        } else {
            nodo.anterior.siguiente = nodo.siguiente;
            nodo.siguiente.anterior = nodo.anterior;
        }
    }
    public Object eliminaPrimero() {
        if(esVacia())
            throw new NoSuchElementException("La lista es vacía.");
        Object s = cabeza.elemento;
        eliminaNodo(cabeza);
        return s;
    }
    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object eliminaUltimo() {
        if(esVacia())
            throw new NoSuchElementException("La lista es vacía.");
        Object s = rabo.elemento;
        eliminaNodo(rabo);
        return s;
    }

    /**
     * Nos dice si un elemento está en la lista.
     * @param elemento el elemento que queremos saber si está en la lista.
     * @return <code>true</code> si <code>elemento</code> está en la lista,
     *         <code>false</code> en otro caso.
     */
    public boolean contiene(Object elemento) {
        // Aquí va su código.
        return this.elBuscadormagicorecursivo(cabeza, elemento) != null;
    }

    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */
    public Lista reversa() {
        Lista lista = new Lista();
        Nodo nodo = rabo;

        while(nodo != null) {
            lista.agregaFinal(nodo.elemento);
            nodo = nodo.anterior;
        }

        return lista;
    }


    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * @return una copiad de la lista.
     */
    public Lista copia() {
        Lista lista = new Lista();
        Nodo nodo = cabeza;

        while(nodo != null) {
            lista.agregaFinal(nodo.elemento);
            nodo = nodo.siguiente;
        }

        return lista;
    }


    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    public void limpia() {
        cabeza = rabo = null;
        longitud = 0;
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object getPrimero() {
        if(esVacia())
            throw new NoSuchElementException("La lista es vacía.");
        return cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object getUltimo() {
        if(esVacia())
            throw new NoSuchElementException("La lista es vacía.");
        return rabo.elemento;
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista.
     * @throws ExcepcionIndiceInvalido si <em>i</em> es menor que cero o mayor o
     *         igual que el número de elementos en la lista.
     */
    public Object get(int i) {
        if(i < 0 || i >= longitud)
            throw new ExcepcionIndiceInvalido("El índice es inválido.");;
        Nodo nodo = getNodos(cabeza, i, 0);
        return nodo.elemento;
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */
    public int indiceDe(Object elemento) {
        Nodo nodo = cabeza;
        for(int i = 0; nodo != null; i++) {
            if(nodo.elemento.equals(elemento))
                return i;
            nodo = nodo.siguiente;
        }

        return -1;
    }
    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */
    @Override public String toString() {
        String s = "[";
        Nodo nodo = cabeza;

        while(nodo != null) {
            s += nodo.elemento;
            nodo = nodo.siguiente;

            if(nodo != null)
                s += ", ";
        }

        s += "]";
        return s;
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * @param objeto el objeto con el que hay que comparar.
     * @return <code>true</code> si la lista es igual al objeto recibido;
     *         <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object objeto) {
        if (!(objeto instanceof Lista))
            return false;
        Lista lista = (Lista)objeto;
        if(lista.getLongitud() != longitud)
            return false;
        Nodo n = lista.cabeza;
        Nodo m = cabeza;
        while(n != null) {
            if(n.elemento.equals(m.elemento)) {
                n = n.siguiente;
                m = m.siguiente;
            } else
                return false;
        }

        return true;
    }

    /**
     * Regresa el nodo cabeza de la lista.
     * @return el nodo cabeza de la lista.
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    /**
     * Regresa el nodo rabo de la lista.
     * @return el nodo rabo de la lista.
     */
    public Nodo getRabo() {
        return rabo;
    }
}
