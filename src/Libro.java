import java.io.Serializable;

/**
 * Clase que representa un libro
 */
public class Libro implements Serializable{

    private String nombre;//El título del libro
    private String autor;
    private String genero;
    private String link;//El link de la página de internet donde se encuentra el libro
    private int numPaginas;//El número de páginas del libro
    private int numPaginasLeyendo;//La página donde se quedó leyendo el usuario
    private final int ID;//El número de identificador del libro
    private double precio;
    private String estadoLibro;//"Por leer", "En progreso" o "Leido"

    /**
     * Constructor de un libro
     * @param nombre El título del libro
     * @param autor El autor del libro
     * @param genero El género del libro
     * @param link El link de la página de internet donde se encuentra el libro
     * @param numPaginas El número de páginas del libro
     * @param precio El precio del libro
     * @param ID El numero de identificación del libro
     */
    public Libro(String nombre, String autor, String genero, String link, int numPaginas, double precio,
            int ID) {
        this.nombre = nombre;
        this.autor = autor;
        this.precio = precio;
        this.genero = genero;
        this.link = link;
        this.numPaginas = numPaginas;
        this.ID = ID;
        estadoLibro="Por leer";
    }

    /**
     * Método para obtener el título del libro
     * @return String El título del libro
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener el nombre del autor del libro
     * @return String El nombre del autor del libro del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Método para obtener el precio del libro
     * @return double El precio del libro
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Método para obtener el nombre del género del libro
     * @return El nombre del género del libro
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Método para obtener el número de páginas que tiene el libro
     * @return int El número de páginas del libro
     */
    public int getNumPaginas() {
        return numPaginas;
    }

    /**
     * Método para obtener el número de identificador del libro
     * @return int El número de identificador del libro
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Método para obtener el link del libro
     * @return String El link del libro
     */
    public String getLink() {
        return link;
    }

    /**
     * Método para asignar el título del libro
     * @param nombre El título del libro
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para asignar el nombre del autor del libro
     * @param autor El nombre del autor del libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Método para asignar el precio del libro
     * @param precio El precio del libro
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Método para asignar el género del libro
     * @param genero El nombre del género al que pertenece el libro
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Método para asignar el número de páginas que tiene el libro
     * @param numPaginas El número de páginas que tiene el libro
     */
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    /**
     * Método para obtener el número de página en la que se quedó el usuario
     * @return El número de la página en la que se quedó el usuario
     */
    public int getNumPaginasLeyendo() {
        return this.numPaginasLeyendo;
    }

    /**
     * Método para asignar el número de página en la que se quedó el usuario
     * @param numPaginasLeyendo La última página que el usuario ha leído
     */
    public void setNumPaginasLeyendo(int numPaginasLeyendo) {
        this.numPaginasLeyendo = numPaginasLeyendo;
    }

    /**
     * Método para obtener el estado del libro
     * @return String El estado del libro: "Por leer", "En progreso" o "Leido"
     */
    public String getEstadoLibro() {
        return this.estadoLibro;
    }

    /**
     * Método para asignar el estado del libro 
     * @param estadoLibro El estado del libro: "Por leer", "En progreso" o "Leido"
     */
    public void setEstadoLibro(String estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

    /**
     * Método para poder visualizar los datos básicos del libro
     * @return String El nombre, autor, género, precio e id del libro
     */
    @Override
    public String toString() {
        return "\n" + "Nombre: " + this.nombre + "\n" +
                "Autor: " + this.autor + "\n" +
                "Genero: " + this.genero + "\n" +
                "Precio: " + this.precio + "\n" +
                "ID: " + this.ID + "\n";
    }
}
