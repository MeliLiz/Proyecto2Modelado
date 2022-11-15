import java.util.ArrayList;
import java.util.Scanner;

public class VistaTienda {
    public static final String RESET = "\033[0m"; // para resetear el color en la terminal
    public static final String ROJO = "\033[0;31m"; // para mensajes de error en la terminal
    public static final String CYAN = "\033[0;36m"; // color Cyan para los menus.
    public static final String VERDE = "\033[0;92m"; // para cuando se le indique al usuario ingresar una opción
    public static final String MORADO = "\033[0;95m"; // color morado para resaltar algunas cosas como el nombre del
                                                      // libro al momento de añadirlo al carrito

    private TiendaUsuario tiendaUsuario;// La tiendaUsuario asociada
    private Scanner scanner1 = new Scanner(System.in);// Scanner para líneas
    private Scanner scanner2 = new Scanner(System.in);// Scanner para números
    private Scanner scanner3 = new Scanner(System.in);// Scanner para Long

    /**
     * Constructor
     * 
     * @param tienda La TiendaUsuario asociada
     */
    public VistaTienda(TiendaUsuario tienda) {
        tiendaUsuario = tienda;
    }

    /**
     * Método para dar la bienvenida a la tienda InkSpace
     */
    public void mostrarBienvenida() {
        System.out.println(CYAN + "Bienvenid@ a InkSpace" + RESET);
    }

    /**
     * Método para imprimir el catálogo de la tienda
     * 
     * @param catalogoImpreso El String del catálogo
     */
    public void imprimirCatalogo(String catalogoImpreso) {
        System.out.println(catalogoImpreso);
    }

    /**
     * Método para notificar que el id ingresado no está asociado a nungún libro del
     * catálogo
     */
    public void noExisteLibro() {
        System.out.println(ROJO + "Lo sentimos, el id del libro ingresado no existe\n" + RESET);
    }

    /**
     * Método para notificar que un libro ha sido agregado
     * 
     * @param nombreLibro
     */
    public void libroAgregado(String nombreLibro) {
        System.out.println(CYAN + "El libro " + RESET + MORADO + nombreLibro + RESET + CYAN
                + " se ha agregado al carrito\n" + RESET);
    }

    /**
     * Método para imprimir los libros a pagar y el total a pagar
     * 
     * @param carrito La lista de libros por pagar
     * @param suma    El total a pagar
     */
    public void imprimirPago(ArrayList<Libro> carrito, double suma) {
        System.out.println(CYAN + "**Libros a pagar**" + RESET);
        for (Libro libro : carrito) {
            System.out.println("\n" + libro.getNombre() + "\n" + libro.getPrecio() + "\n");
        }

        System.out.println("Total a pagar: $" + suma + "\n");
    }

    /**
     * Método para pedir el cvv de la cuenta del usuario para poder hacer la compra
     * 
     * @return int El cvv ingresado por el usuario
     */
    public int pedirDatosBancariosUsuario() {
        int respuesta;
        System.out.println(CYAN + "**Datos Bancarios**" + RESET);
        while (true) {
            System.out.print(VERDE + "Ingrese el cvv de su cuenta bancaria registrada:" + RESET);
            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                break;

            } catch (Exception e) {
                System.out.println(ROJO + "No ha ingresado un numero\n" + RESET);
            }
        }
        return respuesta;
    }

    /**
     * Método para notificar de un pago exitoso
     */
    public void pagoExitoso() {
        System.out.println(CYAN + "Su compra se ha realizado con exito" + RESET);
        System.out.println(CYAN + "Puede empezar a leer sus libros ingresando a su bliblioteca\n" + RESET);
    }

    /**
     * Método para notificar de un pago fallido
     */
    public void pagoFallido() {
        System.out.println(
                ROJO + "Ha ocurrido un error en el pago, revise el estado de su cuenta, su compra ha sido cancelada"
                        + RESET);
        System.out.println(VERDE + "Regresando al menu principal...\n" + RESET);
    }

    /**
     * Método para mandar un error cuando el usuario ingresa un cvv erroneo
     */
    public void errorCVV() {
        System.out.println(ROJO + "\nEL cvv que ingresó no existe,su compra ha sido cancelada" + RESET);
        System.out.println(CYAN + "Regresando al menu principal...\n" + RESET);
    }

    /**
     * Método para mostrar los datos de los libros que están en la biblioteca
     * 
     * @param biblioteca La biblioteca del usuario
     * @return Un contador que ve si al menos una lista no esta vacia
     */
    public int mostrarLibrosBiblioteca(Biblioteca biblioteca) {
        ArrayList<Libro> libros = biblioteca.getPorLeer();
        int contadorLibrosLLenos = 0; // para contar si cada lista de libros tiene al menos un libro
        if (libros.size() == 0) {
            imprimirLibros(libros,
                    CYAN + "***Por leer***\n" + RESET + ROJO + "\nNo hay libros en esta sección\n" + RESET);
        } else {
            contadorLibrosLLenos++;
            imprimirLibros(libros, CYAN + "***Por leer***" + RESET);
        }

        libros = biblioteca.getEnProgreso();
        if (libros.size() == 0) {
            imprimirLibros(libros,
                    CYAN + "***En progreso***\n" + RESET + ROJO + "\nNo hay libros en esta sección\n" + RESET);
        } else {
            contadorLibrosLLenos++;
            imprimirLibros(libros, CYAN + "***En progreso***" + RESET);
        }

        libros = biblioteca.getLeidos();
        if (libros.size() == 0) {
            imprimirLibros(libros,
                    CYAN + "***Leídos***\n" + RESET + ROJO + "\nNo hay libros en esta sección\n" + RESET);
        } else {
            contadorLibrosLLenos++;
            imprimirLibros(libros, CYAN + "***Leídos***" + RESET);
        }

        return contadorLibrosLLenos;

    }

    /***
     * Método para mosttar que el usuario no tiene libros en su biblioteca
     */
    public void noHayLibrosEnBibliotecaUsuario() {
        System.out.println(CYAN + "\nNo tienes ningun libro en tu biblioteca\n" + RESET);
        System.out.println(VERDE + "Regresando al menú principal...\n" + RESET);
    }

    /**
     * Método para imprimir los libros en una lista con el nombre del estado de cada
     * lista
     * 
     * @param libros       La lista de libros a mostrar
     * @param estadoLibros El estado en la que están los libros de la lista del
     *                     parámetro
     */
    private void imprimirLibros(ArrayList<Libro> libros, String estadoLibros) {
        System.out.println(estadoLibros);
        for (Libro libro : libros) {
            System.out.println(libro.getNombre());
            System.out.println(MORADO + "ID: " + RESET + libro.getID());
            System.out.println(MORADO + "Última página leída: " + RESET + libro.getNumPaginasLeyendo() + "\n");
        }
    }

    /**
     * Método para pedir la página del libro en la que se quedó el usuario
     * 
     * @return int El número de página ingresada por el usuario
     */
    public int pedirPagina() {

        int pagina = 0;
        while (true) {
            System.out.print(VERDE + "Ingresa la página en la que te quedaste: " + RESET);
            try {
                pagina = scanner2.nextInt();
                System.out.println();
                break;

            } catch (Exception e) {
                System.out.println(ROJO + "\nNo ingresaste un número\n" + RESET);
                scanner2.next();

            }
        }
        return pagina;
    }

    /**
     * Método para informar que el número de página ingresado por el usuario no es
     * válido
     */
    public void errorNumPaginas() {
        System.out.println(ROJO + "El número de página ingresado no es correcto\n" + RESET);
    }

    /**
     * Método para notificar al usuario que el numero de paginas de progreso en el
     * libro se ha acrtualizado
     */
    public void progresoRegistrado() {
        System.out.println(CYAN + "Se ha registrado tu progreso exitosamente\n" + RESET);
    }

    /**
     * Método para pedir el título de un libro a registrar
     * 
     * @return String El título del libro ingresado por el usuario
     */
    public String pedirTituloLibro() {
        System.out.print(VERDE + "Ingresa el título del libro: " + RESET);
        return scanner1.nextLine();
    }

    /**
     * Método para pedir el autor de un libro a registrar
     * 
     * @return String El autor del libro ingresado por el usuario
     */
    public String pedirAutor() {
        System.out.print(VERDE + "Ingresa el autor del libro: " + RESET);
        return scanner1.nextLine();
    }

    /**
     * Método para pedir el link de un libro a registrar
     * 
     * @return String El link del libro ingresado por el usuario
     */
    public String pedirLinkLibro() {
        System.out.print(VERDE + "Ingresa el link del libro: " + RESET);
        return scanner1.nextLine();
    }

    /**
     * Método para pedir el numero de páginas de un libro a registrar
     * 
     * @return int El número de páginas del libro ingresado por el usuario
     */
    public int pedirNumPaginasLibro() {
        Integer numPaginas = 0;
        while (true) {
            System.out.print(VERDE + "Ingresa el numero de páginas: " + RESET);
            try {
                System.out.println();
                return numPaginas;
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un número\n" + RESET);
            }
        }
    }

    /**
     * Método para pedir el precio de un libro a registrar
     * 
     * @return double El precio del libro ingresado por el usuario
     */
    public double pedirPrecioLibro() {
        Double precio;
        while (true) {
            System.out.print(VERDE + "Ingresa el precio del libro: " + RESET);
            try {
                precio = scanner3.nextDouble();
                return precio;
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un número\n" + RESET);
            }
        }
    }

    /**
     * Método para informar que se registró un libro
     */
    public void libroRegistrado() {
        System.out.println(CYAN + "\nEl libro ha sido registrado exitósamente\n" + RESET);
    }

    /**
     * Método para mostrar el número de libros gratis en la tienda desde la última
     * visita del usuario
     * 
     * @param numLibrosGratis
     */
    public void mostrarNumLibrosGratis(int numLibrosGratis) {
        System.out.println(MORADO + "\nSe ha(n) agregado " + RESET + CYAN + numLibrosGratis + RESET
                + MORADO + " libro(s) gratis en la tienda desde tu última visita!. Écha un vistazo! \n" + RESET);
    }

    /**
     * Método para indicar al usuario que no hay libros en su carrito
     */
    public void noHayLibrosEnCarrito() {
        System.out.println(ROJO + "No se agregaron libros al carrito" + RESET);
        System.out.println(CYAN + "Regresando al menu principal...\n" + RESET);
    }

}
