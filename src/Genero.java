import java.util.Iterator;

/**
 * Interfaz de un género de libro
 */
public abstract class Genero implements Iterador, DatosGenero{

    /**
     * Método para obtener un iterador del género
     * 
     * @return
     */
    public abstract Iterator crearIterador();

    /**
     * Método para obtener el nombre del género
     * 
     * @return
     */
    public abstract String getNombre();

    /**
     * Método para obtener el número de libros que hay del género
     */
    public abstract int getNumeroDeLibros();

    /**
     * Método que imprime todos los libros del género
     * 
     * @return Todos los libros del género
     */
    public abstract String toString();

    /**
     * Método para agregar un libro al género
     * @param libro El nuevo libro a agregar
     */
    public abstract void addLibro(Libro libro);
}
