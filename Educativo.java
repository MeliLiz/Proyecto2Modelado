import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que contiene a los llibros de género educativo
 */
public class Educativo implements Genero {
    private ArrayList<Libro> libros;
    private final String NOMBRE = "Educativo";

    /**
     * Constructor
     */
    public Educativo() {
        libros = new ArrayList<Libro>();
    }

    /**
     * Método para obtener la lista de libros del género Educativo
     * 
     * @return ArayList<Libro> La lista de libros de género Educativo
     */
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    /**
     * Método para asignar los libros de género Educativo
     * 
     * @param libros El arraylist de los libros de género Educativo
     */
    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Método para agregar un libro a la lista de libros de género Educativo
     * 
     * @param libro El libro a agregar a la lista de libros de género Educativo
     */
    public void addLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Método para eliminar un libro de la lista de libros de género Educativo
     * 
     * @param aEliminar El libro a eliminar de la lista del género Educativo
     */
    public void eliminarLibro(Libro aEliminar) {
        for (Libro libro : libros) {
            if (libro.getID() == aEliminar.getID()) {
                libros.remove(libro);
            }
        }
    }

    /**
     * Método para obtener el nombre del género
     * 
     * @return String El nombre del género
     */
    @Override
    public String getNombre() {
        return NOMBRE;
    }

    /**
     * Método para obtener un iterador del género
     * 
     * @return Iterator el iterador del género
     */
    @Override
    public Iterator crearIterador() {
        return libros.iterator();
    }

    /**
     * Método para obtener el número de libros del género
     * 
     * @return int El número de libros del género
     */
    @Override
    public int getNumeroDeLibros() {
        return libros.size();
    }

    @Override
    public String toString() {
        String libros = "";
        for (Libro libro : this.libros) {
            libros += libro;
        }
        return libros;
    }
}
