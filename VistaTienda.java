import java.util.ArrayList;
import java.util.Scanner;

public class VistaTienda {
    private TiendaUsuario tiendaUsuario;
    private Scanner scanner1 = new Scanner(System.in);// Scanner para líneas
    private Scanner scanner2 = new Scanner(System.in);// Scanner para números
    private Scanner scanner3 = new Scanner(System.in);// Scanner para long

    public VistaTienda(TiendaUsuario tienda) {
        tiendaUsuario = tienda;
    }

    public void imprimirCatalogo(String catalogoImpreso) {
        System.out.println(catalogoImpreso);
    }

    public void noExisteLibro() {
        System.out.println("Lo sentimos, el id del libro ingresado no existe");
    }

    public void libroAgregado(String nombreLibro) {
        System.out.println("El libro " + nombreLibro + " se ha agregado al carrito");
    }

    public void imprimirPago(ArrayList<Libro> carrito, double suma) {
        System.out.println("**Libros a pagar**");
        for (Libro libro : carrito) {
            System.out.println("\n" + libro.getNombre() + "\n" + libro.getPrecio() + "\n");
        }

        System.out.println("Total a pagar: " + suma);
    }

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

    public void pagoExitoso() {
        System.out.println("Su compra se ha realizado con exito");
        System.out.println("Puede empezar a leer sus libros ingresando a la bliblioteca");
    }

    public void pagoFallido() {
        System.out.println("Error al ingresar su cvv, su compra ha sido cancelada");
        System.out.println("Regresando al menu principal...");
    }

    public void mostrarLibrosBiblioteca(Biblioteca biblioteca){
        ArrayList<Libro> libros=biblioteca.getPorLeer();
        imprimirLibros(libros, "Por leer");
        libros=biblioteca.getEnProgreso();
        imprimirLibros(libros, "En progreso");
        libros=biblioteca.getLeidos();
        imprimirLibros(libros, "Leídos");
    }

    private void imprimirLibros(ArrayList<Libro> libros, String estadoLibros){
        System.out.println(estadoLibros);
        for (Libro libro : libros) {
            System.out.println(libro.getNombre());
            System.out.println("ID: "+libro.getID());
            System.out.println("Última página leída: "+libro.getNumPaginasLeyendo());
        }
    }

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

    public void errorNumPaginas(){
        System.out.println("El número de página ingresado no es correcto");
    }

    public String pedirTituloLibro(){
        System.out.println("Ingresa el título del libro");
        return scanner1.nextLine();
    }

    public String pedirAutor(){
        System.out.println("Ingresa el título del libro");
        return scanner1.nextLine();
    }

    public String pedirLinkLibro(){
        System.out.println("Ingresa el link del libro");
        return scanner1.nextLine();
    }

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


    public void libroRegistrado(){
        System.out.println("El libro ha sido registrado");
    }

}
