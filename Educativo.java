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
        libros.add(new Libro("A short story of nearly everything", "Bill Bryson", "educativo", "https://drive.google.com/file/d/1HqoTNNVMe9n4d4zXVakVUEWUEGjYffr6/view?usp=sharing", 489, 40, 1));
        libros.add(new Libro("Artificial intelligence for dummies", "John Paul Mueller, Luca Massaron", "educativo", "https://drive.google.com/file/d/1DJKLEVQ4Lz3A9-z2pTAnzarAkru6_o7n/view?usp=sharing", 339, 50, 2));
        libros.add(new Libro("Neuroscience for dummies", "Frank Amthor", "educativo", "https://drive.google.com/file/d/1JOWKYHI_AvEtBm3zHsNoWInelNS1QZN7/view?usp=share_link", 387, 45, 3));

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
    @Override
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

    /**
     * Método para poder visualizar los libros registrados del género educativo
     * @return String La representación en cadena de los libros del género educativo
     */
    @Override
    public String toString() {
        String libros = "";
        for (Libro libro : this.libros) {
            libros += libro;
        }
        return libros;
    }

}
