import java.util.Scanner;

/**
 * Clase de la parte de la vista de los menús de la tiendaUsuario
 */
public class VistaMenus {
    public static final String RESET = "\033[0m"; // para colores en la terminal
    public static final String ROJO = "\033[0;31m"; // para mensajes de error en la terminal
    public static final String CYAN = "\033[0;36m"; // color Cyan para los menus.
    public static final String VERDE = "\033[0;92m"; // para cuando se le indique al usuario ingresar una opción

    private TiendaUsuario tiendaUsuario;// La tiendaUsuario asociada
    private Scanner scanner1 = new Scanner(System.in);// Scanner para líneas
    private Scanner scanner2 = new Scanner(System.in);// Scanner para números
    private Scanner scanner3 = new Scanner(System.in);// Scanner para double

    /**
     * Constructor
     * 
     * @param tienda la tiendaUsuario asociada
     */
    public VistaMenus(TiendaUsuario tienda) {
        tiendaUsuario = tienda;
    }

    /**
     * Método para mostrar las opciones de la tienda al usuario:
     * Ver los libros disponibles en la tienda, comprar libros, ir a la biblioteca
     * del usuario o salir
     */
    public void bienvenida() {

        int respuesta;
        while (true) {
            System.out.println(CYAN + "Bienvenid@ a la tienda de libros" + RESET);
            System.out.println("1) Ver nuestra biblioteca de libros");
            System.out.println("2) Comprar un libro");
            System.out.println("3) Ir a tu biblioteca");
            System.out.println("4) Salir");
            System.out.print(VERDE + "Ingrese una opción:" + RESET);
            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                if (respuesta > 0 && respuesta < 5) {
                    tiendaUsuario.menuOpciones(respuesta);
                    break;
                } else {
                    System.out.println(ROJO + "No ingresaste una opción válida\n" + RESET);
                }
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un número\n" + RESET);
                scanner2.next();
            }
        }

    }

    /**
     * Método para dar las opciones de acciones a un administrador:
     * Registrar un nuevo libro en la tienda o salir
     */
    public void bienvenidaAdmin() {
        System.out.println(CYAN + "**Estas ingresando como Administrador**" + RESET);
        int respuesta;
        System.out.println("¿Qué desea hacer?");
        while (true) {
            System.out.println("1) Agregar un libro nuevo a la biblioteca");
            System.out.println("2) Salir");
            System.out.print(VERDE + "Ingrese una opción: " + RESET);
            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                if (respuesta > 0 && respuesta < 3) {
                    tiendaUsuario.menuOpcionesAdmin(respuesta);
                    break;
                } else {
                    System.out.println(ROJO + "No ingresaste una opción válida\n" + RESET);
                }
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un número\n" + RESET);
                scanner2.next();
            }

        }
    }

    /**
     * Método para mostrar el menú de opciones para comenzar a agregar al carrito o
     * salir
     */
    public void imprimirMenuCompra() {
        int respuesta;
        System.out.println(CYAN + "Bienvenido al menu de compras" + RESET);
        ciclo: while (true) {
            System.out.println("¿Qué quieres hacer?");
            System.out.println("1) Agregar al carrito");
            System.out.println("2) Salir");
            System.out.print(VERDE + "Ingrese una opción: " + RESET);
            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                if (respuesta == 1) {
                    tiendaUsuario.menuOpcionesCarrito(respuesta);
                    break;
                } else if (respuesta == 2) {
                    tiendaUsuario.inicio();
                    break ciclo;
                } else {
                    System.out.println(ROJO + "No ingresaste una opción válida\n" + RESET);
                }
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un número\n" + RESET);
                scanner2.next();
            }
        }
    }

    /**
     * Método para pedir el id de un libro para agregar al carrito
     * 
     * @return int el id del libro ingresado por el usuario
     */
    public int ingresarCodigoLibro() {
        int respuesta = 0;

        while (true) {
            System.out.print("Por favor ingrese el id del libro");
            System.out.println(CYAN + "\nSi ya ha terminado de agregar libros al carrito, ingrese -1" + RESET);
            System.out.print(VERDE + "Id del libro: " + RESET);
            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                break;
            } catch (Exception e) {
                System.out.println(ROJO + "No has ingresado un número\n" + RESET);
                scanner2.next();
            }
        }
        return respuesta;
    }

    /**
     * Método para mostrar el menú para pagar los libros en el carrito o salir
     */
    public void pagar() {
        int respuesta = 0;
        System.out.println(CYAN + "\n**Menu de Pago**" + RESET);
        ciclo: while (true) {
            System.out.println("1) Pagar libro(s) en carrito");
            System.out.println("2) Salir");
            System.out.print(VERDE + "Ingrese una opción: " + RESET);
            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                if (respuesta == 1) {
                    tiendaUsuario.iniciarPagoMenu(respuesta);
                    break;
                } else if (respuesta == 2) {
                    tiendaUsuario.inicio();
                    break ciclo;
                } else {
                    System.out.println(ROJO + "No ha ingresado una opcion valida\n" + RESET);

                }
            } catch (Exception e) {
                System.out.println(ROJO + "No ha ingreado un número\n" + RESET);
                scanner2.next();
            }
        }
    }

    /**
     * Método para preguntar al usuario si quiere leer un libro o salir
     */
    public void quererLeer() {
        System.out.println(CYAN + "Bienvenid@ a tu biblioteca" + RESET);
        ciclo: while (true) {
            System.out.println("Elige una opción");
            System.out.println("1) Leer un libro");
            System.out.println("2) Salir");
            System.out.println(VERDE + "Ingrese una opción: " + RESET);
            int respuesta = 0;
            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                if (respuesta == 1) {
                    tiendaUsuario.verBiblioteca(respuesta);
                    break;
                } else if (respuesta == 2) {
                    tiendaUsuario.inicio();
                    break ciclo;
                } else {
                    System.out.println(ROJO + "No ingresaste una opción válida\n" + RESET);

                }
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un número\n" + RESET);
                scanner2.next();
            }
        }
    }

    /**
     * Método para pedir al usuario el id del libro que quiere leer
     */
    public void elegirLibro() {
        while (true) {
            System.out.print(VERDE + "Ingresa el id del libro que deseas leer: " + RESET);
            int id = 0;
            try {
                id = scanner2.nextInt();
                System.out.println();
                tiendaUsuario.getLibro(id);
                break;
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un número\n" + RESET);
                scanner2.next();
            }
        }
    }

    /**
     * Método para mostrar el menú de acciones a hacer con un libro:
     * Leer, registrar progreso, marcar como leido o salir
     * 
     * @return int La respuesta del usuario: 1 para leer, 2 para registrar progreso,
     *         3 para marcar como leido, 4 para salir
     */
    public int opcionesLectura() {
        int respuesta = 0;
        ciclo: while (true) {
            System.out.println(CYAN + "¿Qué deseas hacer con el libro?" + RESET);
            System.out.println("1) Leer");
            System.out.println("2) Registrar progreso (página en la que te quedaste)");
            System.out.println("3) Marcar como leído");
            System.out.println("4) Salir");
            System.out.print(VERDE + "Ingresa una opción: " + RESET);

            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                if (respuesta > 0 && respuesta < 5) {
                    break ciclo;
                } else {
                    System.out.println(ROJO + "No ingresaste una opción válida\n" + RESET);
                }
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un número\n" + RESET);
                scanner2.next();
            }
        }
        return respuesta;
    }

    /**
     * Método para mostrar el menú de los géneros disponibles en la tienda para
     * poder subir un libro
     * 
     * @return String El género elegido: "ducativo", "literario", "non-fiction"
     */
    public String elegirGenero() {
        int respuesta = 0;
        while (true) {
            System.out.println(CYAN + "Elige el género del libro" + RESET);
            System.out.println("1) Educativo");
            System.out.println("2) Literario");
            System.out.println("3) Non-fiction");
            System.out.print(VERDE + "Ingresa una opción: " + RESET);

            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                if (respuesta > 0 && respuesta < 4) {
                    switch (respuesta) {
                        case 1:
                            return "educativo";
                        case 2:
                            return "literario";
                        case 3:
                            return "non-fiction";
                        default:
                            break;
                    }
                } else {
                    System.out.println(ROJO + "No ingresaste una opción válida\n" + RESET);
                    scanner2.next();
                }
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un número\n" + RESET);
                scanner2.next();
            }
        }
    }
}
