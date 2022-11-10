import java.util.ArrayList;
import java.util.Scanner;

public class VistaTienda {
    private TiendaUsuario tiendaUsuario;//La tiendaUsuario asociada
    private Scanner scanner1 = new Scanner(System.in);// Scanner para líneas
    private Scanner scanner2 = new Scanner(System.in);// Scanner para números
    private Scanner scanner3 = new Scanner(System.in);// Scanner para long

    /**
     * Constructor
     * @param tienda La TiendaUsuario asociada
     */
    public VistaTienda(TiendaUsuario tienda) {
        tiendaUsuario = tienda;
    }

    /**
     * Método para dar la bienvenida a la tienda InkSpace
     */
    public void mostrarBienvenida(){
        System.out.println("Bienvenid@ a InkSpace");
    }

    /**
     * Método para imprimir el catálogo de la tienda
     * @param catalogoImpreso El String del catálogo
     */
    public void imprimirCatalogo(String catalogoImpreso) {
        System.out.println(catalogoImpreso);
    }

    /**
     * Método para notificar que el id ingresado no está asociado a nungún libro del catálogo
     */
    public void noExisteLibro() {
        System.out.println("Lo sentimos, el id del libro ingresado no existe");
    }

    /**
     * Método para notificar que un libro ha sido agregado
     * @param nombreLibro
     */
    public void libroAgregado(String nombreLibro) {
        System.out.println("El libro " + nombreLibro + " se ha agregado al carrito");
    }

    /**
     * Método para imprimir los libros a pagar y el total a pagar
     * @param carrito La lista de libros por pagar
     * @param suma El total a pagar
     */
    public void imprimirPago(ArrayList<Libro> carrito, double suma) {
        System.out.println("**Libros a pagar**");
        for (Libro libro : carrito) {
            System.out.println("\n" + libro.getNombre() + "\n" + libro.getPrecio() + "\n");
        }

        System.out.println("Total a pagar: " + suma);
    }

    /**
     * Método para pedir el cvv de la cuenta del usuario para poder hacer la compra
     * @return int El cvv ingresado por el usuario
     */
    public int pedirDatosBancariosUsuario() {
        int respuesta;
        System.out.println("**Datos Bancarios**");
        while (true) {
            System.out.print("Ingrese el cvv de su cuenta bamcaria registrada:");
            try {
                respuesta = scanner2.nextInt();
                break;

            } catch (Exception e) {
                System.out.println("No ha ingresado un numero");
            }
        }
        return respuesta;
    }

    /**
     * Método para notificar de un pago exitoso
     */
    public void pagoExitoso() {
        System.out.println("Su compra se ha realizado con exito");
        System.out.println("Puede empezar a leer sus libros ingresando a la bliblioteca");
    }

    /**
     * Método para notificar de un pago fallido
     */
    public void pagoFallido() {
        System.out.println("Error al ingresar su cvv, su compra ha sido cancelada");
        System.out.println("Regresando al menu principal...");
    }

    /**
     * Método para mostrar los datos de los libros que están en la biblioteca
     * @param biblioteca La biblioteca del usuario
     */
    public void mostrarLibrosBiblioteca(Biblioteca biblioteca){
        ArrayList<Libro> libros=biblioteca.getPorLeer();
        imprimirLibros(libros, "***Por leer***");
        libros=biblioteca.getEnProgreso();
        imprimirLibros(libros, "***En progreso***");
        libros=biblioteca.getLeidos();
        imprimirLibros(libros, "***Leídos***");
    }

    /**
     * Método para imprimir los libros en una lista con el nombre del estado de cada lista
     * @param libros La lista de libros a mostrar
     * @param estadoLibros El estado en la que están los libros de la lista del parámetro
     */
    private void imprimirLibros(ArrayList<Libro> libros, String estadoLibros){
        System.out.println(estadoLibros);
        for (Libro libro : libros) {
            System.out.println(libro.getNombre());
            System.out.println("ID: "+libro.getID());
            System.out.println("Última página leída: "+libro.getNumPaginasLeyendo());
        }
    }

    /**
     * Método para pedir la página del libro en la que se quedó el usuario
     * @return int El número de página ingresada por el usuario
     */
   public int pedirPagina(){
        System.out.print("Ingresa la página en la que te quedaste: ");
        int pagina=0;
        while(true){
            try {
                pagina=scanner2.nextInt();
                return pagina;
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        }
    }

    /**
     * Método para informar que el número de página ingresado por el usuario no es válido
     */
    public void errorNumPaginas(){
        System.out.println("El número de página ingresado no es correcto");
    }

    /**
     * Método para pedir el título de un libro a registrar
     * @return String El título del libro ingresado por el usuario
     */
    public String pedirTituloLibro(){
        System.out.println("Ingresa el título del libro");
        return scanner1.nextLine();
    }

    /**
     * Método para pedir el autor de un libro a registrar
     * @return String El autor del libro ingresado por el usuario
     */
    public String pedirAutor(){
        System.out.println("Ingresa el título del libro");
        return scanner1.nextLine();
    }

    /**
     * Método para pedir el link de un libro a registrar
     * @return String El link del libro ingresado por el usuario
     */
    public String pedirLinkLibro(){
        System.out.println("Ingresa el link del libro");
        return scanner1.nextLine();
    }

    /**
     * Método para pedir el numero de páginas de un libro a registrar
     * @return int El número de páginas del libro ingresado por el usuario
     */
    public int pedirNumPaginasLibro(){
        Integer numPaginas=0;
        while(true){
            System.out.println("Ingresa el numero de página");
            try {
                numPaginas=scanner2.nextInt();
                return numPaginas;
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        }
    }

    /**
     * Método para pedir el precio de un libro a registrar
     * @return double El precio del libro ingresado por el usuario
     */
    public double pedirPrecioLibro(){
        System.out.println("Ingresa el precio del libro");
        Double precio;
        while(true){
            System.out.println("Ingresa el precio del libro");
            try {
                precio=scanner3.nextDouble();
                return precio;
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        }
    }

    /**
     * Método para informar que se registró un libro
     */
    public void libroRegistrado(){
        System.out.println("El libro ha sido registrado");
    }

    /**
     * Método para mostrar el número de libros gratis en la tienda desde la última visita del usuario
     * @param numLibrosGratis
     */
    public void mostrarNumLibrosGratis(int numLibrosGratis) {
        System.out.println("Se han agregado "+ numLibrosGratis+" en la tienda desde tu última visita!. Échales un vistazo ");
    }

}
