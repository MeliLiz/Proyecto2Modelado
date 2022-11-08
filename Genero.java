import java.util.Iterator;

/**
 * Interfaz de un género de libro
 */
public interface Genero {

    /**
     * Método para obtener un iterador del género
     * 
     * @return
     */
    public Iterator crearIterador();

    /**
     * Método para obtener el nombre del género
     * 
     * @return
     */
    public String getNombre();

    /**
     * Método para obtener el número de libros que hay del género
     */
    public int getNumeroDeLibros();

    /**
     * Método que imprime todos los libros del género
     * 
     * @return Todos los libros del género
     */
    public String toString();
}
