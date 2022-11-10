import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que simula una coleccion de generos delibros
 */
public class Coleccion implements Genero {
    private ArrayList<Genero> listaGeneros;

    /**
     * Constructor
     */
    public Coleccion() {
        listaGeneros = new ArrayList<Genero>();
        listaGeneros.add(new Educativo());
        listaGeneros.add(new Literario());
        listaGeneros.add(new NonFiction());
    }

    /**
     * Método para obtener la lista de los géneros disponibles en la colección
     * 
     * @return ArrayList<Genero> La lista de géneros de la colección
     */
    public ArrayList<Genero> getGeneros() {
        return listaGeneros;
    }

    /**
     * Método para asignar los géneros de la colección
     * 
     * @param generos La lista de géneros de la colección
     */
    public void setGeneros(ArrayList<Genero> generos) {
        listaGeneros = generos;
    }

    /**
     * Método para agregar un género a la lista de géneros de la colección
     * 
     * @param nuevoGenero El género a agregar en la lista de géneros de la
     *                    colección.
     */
    public void addGenero(Genero nuevoGenero) {
        listaGeneros.add(nuevoGenero);
    }

    /**
     * Método para eliminar un género de la lista de géneros de la colección
     * 
     * @param genero El género a eliminar de la lista de géneros de la colección
     */
    public void eliminarGenero(Genero genero) {
        listaGeneros.remove(genero);
    }

    /**
     * Método para obtener un libro de la colección
     * 
     * @param id El id del libro buscado
     * @return Libro El libro buscado, null si el libro no está en la colección
     */
    public Libro getLibro(int id) {
        for (Genero genero : listaGeneros) {
            Iterator iterador = genero.crearIterador();
            while (iterador.hasNext()) {
                Libro libro = (Libro) iterador.next();
                if (libro.getID() == id) {
                    return libro;
                }
            }
        }
        return null;
    }

    /**
     * Método para obtener el número de libros en la colección
     * 
     * @return int El número de libros en la colección
     */
    public int getNumLibros() {
        int numLibros = 0;
        for (Genero genero : listaGeneros) {
            numLibros += genero.getNumeroDeLibros();
        }
        return numLibros;
    }

    /**
     * Método para obtener un iterador de la colección de libros
     * @return Iterator El iterador de la colección
     */
    @Override
    public Iterator crearIterador() {
        return listaGeneros.iterator();
    }

    /**
     * Método para obtener el nombre de la colección
     * @retur String El nombre de la colección
     */
    @Override
    public String getNombre() {
        return "Libros InksSpace";
    }

    /**
     * Método para obtener el número de libros que hay en la colección
     * @return int El número de libros de la colección
     */
    @Override
    public int getNumeroDeLibros() {
        int numLibros = 0;
        for (Genero genero : listaGeneros) {
            numLibros += genero.getNumeroDeLibros();
        }
        return numLibros;
    }

    /**
     * Método para poder visualizar los libros de la colección con el nombre de cada género
     * @return String La representación en cadena de los libros y el nombre de sus géneros correspondientes
     */
    @Override
    public String toString() {
        String toString = getNombre();

        for (Genero genero : listaGeneros) {
            toString += genero.getNombre();
            toString += genero.toString();
        }
        return toString;
    }

    /**
     * Método para agregar un libro a la colección
     * @param libro El libro a agregar en la colección
     */
    @Override
    public void addLibro(Libro libro){
        if(libro!=null){
            String genero=libro.getGenero();
            if(genero.equals("educativo")){
                listaGeneros.get(0).addLibro(libro);
            }else if(genero.equals("literario")){
                listaGeneros.get(1).addLibro(libro);
            }else if(genero.equals("non-fiction")){
                listaGeneros.get(2).addLibro(libro);
            }
        }
    }

}
