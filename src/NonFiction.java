import java.util.Iterator;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que contiene a los llibros de género NonFiction
 */
public class NonFiction extends Genero implements Serializable{
    private ArrayList<Libro> libros;
    private final String NOMBRE = "NonFiction";

    /**
     * Constructor
     */
    public NonFiction() {
        libros = new ArrayList<Libro>();
        libros.add(new Libro("The truth about Crypto", "Ric Edelman", "non-fiction", "https://drive.google.com/file/d/1h5ME4OGtW6-6KnWRi1h5cl1T-XdEah_A/view?usp=share_link", 421, 30, 7));
        libros.add(new Libro("Will", "Will Smith", "non-fiction", "https://drive.google.com/file/d/1eoXou1_XmxA2Nqsodi3Ea8h938B1NYa1/view?usp=share_link", 480, 25, 8));
        libros.add(new Libro("The anrthropocene reviewed", "John Green", "non-fiction", "https://drive.google.com/file/d/1aQ1zNQDcBfTnajwhbVxYnjfdmTMFRxmG/view?usp=share_link", 298, 30, 9));


    }

    /**
     * Método para obtener la lista de libros del género NonFiction
     * @return ArayList<Libro> La lista de libros de género NonFiction
     */
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    /**
     * Método para asignar los libros de género NonFiction
     * @param libros El arraylist de los libros de género NonFiction
     */
    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Método para agregar un libro a la lista de libros de género NonFiction
     * @param libro El libro a agregar a la lista de libros de género NonFiction
     */
    @Override
    public void addLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Método para eliminar un libro de la lista de libros de género NonFiction
     * @param aEliminar El libro a eliminar de la lista del género NonFiction
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
     * @return String El nombre del género
     */
    @Override
    public String getNombre() {
        return NOMBRE;
    }

    /**
     * Método para obtener un iterador del género
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
