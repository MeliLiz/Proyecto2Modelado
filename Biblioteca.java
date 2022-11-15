import java.util.ArrayList;
import java.io.IOException;
import java.io.Serializable;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Clase que simula la bibliloteca de un usuario
 */
public class Biblioteca implements Serializable{

    private ArrayList<Libro> porLeer;
    private ArrayList<Libro> enProgreso;
    private ArrayList<Libro> leidos;

    /**
     * Constructor
     */
    public Biblioteca(){
        porLeer=new ArrayList<Libro>();
        enProgreso=new ArrayList<Libro>();
        leidos=new ArrayList<Libro>();
    }

    /**
     * Método para obtener la lista de libros por leer
     * @return ArrayList<Libro> La lista de libros por leer
     */
    public ArrayList<Libro> getPorLeer(){
        return porLeer;
    }

    /**
     * Método para obtener la lista de libros en progreso
     * @return ArrayList<Libro> La lista de libros en progreso
     */
    public ArrayList<Libro> getEnProgreso(){
        return enProgreso;
    }

    /**
     * Método para obtener la lista de libros leídos
     * @return ArrayList<Libro> La llista de libros leídos
     */
    public ArrayList<Libro> getLeidos(){
        return leidos;
    }

    /**
     * Método para abrir un libro en una página de iternet
     * @param libro El libro por abrir
     */
    public void abrirLibro(Libro libro){
        abrirURL(libro.getLink());
    }

    /**
     * Metodo para abrir una url
     * @param URL La url por abrir
     */
    private static void abrirURL(String URL) {
        try {
            Desktop.getDesktop().browse(new URI(URL));
        } catch (URISyntaxException ex) {
            // System.out.println(ex);
        } catch (IOException e) {
            // System.out.println(e);
        }
    }

    /**
     * Método para obtener un libro de la biblioteca
     * @param id El id del libro buscado
     * @return Libro el libro buscado, null si el libro no está en la biblioteca
     */
    public Libro getLibro(int id){
        Libro libro=iterarLista(porLeer, id);
        if(libro==null){
            libro=iterarLista(enProgreso, id);
            if(libro==null){
                libro=iterarLista(leidos, id);
            }
        }
        return libro;
    }

    /**
     * Método para iterar una lista de libros
     * @param lista El ArrayList de libros a iterar
     * @param id El id del libro biuscado
     * @return Libro El libro buscado, null si el libro no está en la lista
     */
    private static Libro iterarLista(ArrayList<Libro> lista, int id){
        for (Libro libro : lista) {
            if(libro.getID()==id){
                return libro;
            }
        }
        return null;
    }

    /**
     * Método para agregar un libro a la lista de libros por leer
     * @param nuevo El libro nuevo
     */
    public void addLibro(Libro nuevo){
        porLeer.add(nuevo);
        nuevo.setEstadoLibro("Por leer");
    }

    /**
     * Método para agregar un libro a la lista de libros en progreso y quitarlo de la lista de libros por leer
     * @param libro El libro que estará en progreso
     */
    public void addLibroEnProgreso(Libro libro){
        if(!libro.getEstadoLibro().equals("En Progreso")){
            enProgreso.add(libro);
        }
        //Si el libro está por leer, lo eliminamos de la lista de por leer
        if(libro.getEstadoLibro().equals("Por leer")){
        porLeer.remove(libro);
        }else if(libro.getEstadoLibro().equals("Leido")){ //Si el libro está leido, lo eliminamos de la lista de leídos
            leidos.remove(libro);
        } 
        libro.setEstadoLibro("En progreso");
    }

    /**
     * Método para agregar un libro a la lista de libros leídos y quitarlo de la lista de libros en progreso
     * @param libro El libro que estará en la lista de leidos
     */
    public void addLibroLeido(Libro libro){
        //Si el libro no está ya en la lista d4 elibros leidos, se agrega a la lista de leidos
        if(!libro.getEstadoLibro().equals("Leido")){
            leidos.add(libro);
        }
        //Si el libro está por leer, lo eliminamos de la lista de por leer
        if(libro.getEstadoLibro().equals("Por leer")){
            porLeer.remove(libro);
        }else if(libro.getEstadoLibro().equals("En progreso")){ //Si el libro está en progreso, lo eliminamos de la lista en progreso
            enProgreso.remove(libro);
        } 
        libro.setEstadoLibro("Leido");
    }
}
