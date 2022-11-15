/**
 * Interfaz para regresar los datos necesarios de un género de libros
 */
public interface DatosGenero {
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

    /**
     * Método para agregar un libro al género
     * @param libro El nuevo libro a agregar
     */
    public void addLibro(Libro libro);
}
