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

}
