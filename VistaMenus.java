import java.util.Scanner;

/**
 * Clase de la parte de la vista de los menús de la tiendaUsuario
 */
public class VistaMenus {
    private TiendaUsuario tiendaUsuario;//La tiendaUsuario asociada
    private Scanner scanner1 = new Scanner(System.in);// Scanner para líneas
    private Scanner scanner2 = new Scanner(System.in);// Scanner para números
    private Scanner scanner3 = new Scanner(System.in);// Scanner para double

    /**
     * Constructor
     * @param tienda la tiendaUsuario asociada
     */
    public VistaMenus(TiendaUsuario tienda) {
        tiendaUsuario = tienda;
    }

    /**
     * Método para mostrar las opciones de la tienda al usuario:
     * Ver los libros disponibles en la tienda, comprar libros, ir a la biblioteca del usuario o salir
     */
    public void bienvenida() {
        
        int respuesta;
        while (true) {
            System.out.println("Selecciona una opcion");
            System.out.println("1) Ver nuestra biblioteca de libros");
            System.out.println("2) Comprar un libro");
            System.out.println("3) Ir a tu biblioteca");
            System.out.println("4) Salir");
            try {
                respuesta = scanner2.nextInt();
                if (respuesta > 1 && respuesta < 5) {
                    tiendaUsuario.menuOpciones(respuesta);
                    break;
                } else {
                    System.out.println("No ingresaste una opción válida");
                }
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        }

    }

    /**
     * Método para dar las opciones de acciones a un administrador:
     * Registrar un nuevo libro en la tienda o salir
     */
    public void bienvenidaAdmin() {
        System.out.println("**Estas ingresando como Administrador**");
        int respuesta;
        System.out.println("¿Qué desea hacer?");
        while (true) {
            System.out.println("1) Agregar un libro nuevo a la biblioteca");
            System.out.println("2) Salir");
            try {
                respuesta = scanner2.nextInt();
                if (respuesta > 0 && respuesta < 3) {
                    tiendaUsuario.menuOpcionesAdmin(respuesta);
                    break;
                } else {
                    System.out.println("No ingresaste una opción válida");
                }
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }

        }
    }

    /**
     * Método para mostrar el menú de opciones para comenzar a agregar al carrito o salir
     */
    public void imprimirMenuCompra() {
        int respuesta;
        System.out.println("Bienvenido al menu de compras");
        while (true) {
            System.out.println("¿Qué quieres hacer?");
            System.out.println("1) Agregar al carrito");
            System.out.println("2) Salir");
            try {
                respuesta = scanner2.nextInt();
                if (respuesta > 0 && respuesta < 3) {
                    tiendaUsuario.menuOpcionesCarrito(respuesta);
                    break;
                } else {
                    System.out.println("No ingresaste una opción válida");
                }
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        }
    }

    /**
     * Método para pedir el id de un libro para agregar al carrito
     * @return int el id del libro ingresado por el usuario
     */
    public int ingresarCodigoLibro() {
        int respuesta = 0;

        while (true) {
            System.out.print("Por favor ingrese el id del libro");
            System.out.println("Si ya ha terminado de agregar libros al carrito, ingrese -1");
            try {
                respuesta = scanner2.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("No has ingresado un número");
            }
        }
        return respuesta;
    }

    /**
     * Método para mostrar el menú para pagar los libros en el carrito o salir
     */
    public void pagar() {
        int respuesta = 0;
        System.out.println("**Menu de Pago**");
        while (true) {
            System.out.println("1) Pagar libro(s) en carrito");
            System.out.println("2) salir");
            try {
                respuesta = scanner2.nextInt();
                if (respuesta > 0 && respuesta < 3) {
                    tiendaUsuario.iniciarPagoMenu(respuesta);
                } else {
                    System.out.println("No ha ingresado una opcion valida");
                }
            } catch (Exception e) {
                System.out.println("No ha ingreado un número");
            }
        }
    }

    /**
     * Método para preguntar al usuario si quiere leer un libro o salir
     */
    public void quererLeer() {
        System.out.println("Bienvenid@ a tu biblioteca");
        while (true) {
            System.out.println("Elige una opción");
            System.out.println("1) Leer un libro");
            System.out.println("2) Salir");
            int respuesta=0;
            try {
                respuesta = scanner2.nextInt();
                if (respuesta > 0 && respuesta < 3) {
                    tiendaUsuario.verBiblioteca(respuesta);
                    break;
                } else {
                    System.out.println("No ingresaste una opción válida");
                }
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        } 
    }

    /**
     * Método para pedir al usuario el id del libro que quiere leer
     */
    public void elegirLibro(){
        while (true) {
            System.out.println("Ingresa el id del libro que deseas leer");
            int id=0;
            try {
                id = scanner2.nextInt();
                tiendaUsuario.getLibro(id);
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        }
    }

    /**
     * Método para mostrar el menú de acciones a hacer con un libro:
     * Leer, registrar progreso, marcar como leido o salir
     * @return int La respuesta del usuario: 1 para leer, 2 para registrar progreso, 3 para marcar como leido, 4 para salir
     */
    public int opcionesLectura(){
        int respuesta=0;
        while (true) {
            System.out.println("¿Qué deseas hacer con el libro?");
            System.out.println("1) Leer");
            System.out.println("2) Registrar progreso (página en la que te quedaste)");
            System.out.println("3) Marcar como leído");
            System.out.println("4) Salir");
            
            try {
                respuesta = scanner2.nextInt();
                if (respuesta > 0 && respuesta < 5) {
                    return respuesta;
                } else {
                    System.out.println("No ingresaste una opción válida");
                }
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        }
    }

    /**
     * Método para mostrar el menú de los géneros disponibles en la tienda para poder subir un libro
     * @return String El género elegido: "ducativo", "literario", "non-fiction"
     */
    public String elegirGenero(){
        int respuesta=0;
        while (true) {
            System.out.println("Elige el género del libro");
            System.out.println("1) Educativo");
            System.out.println("2) Literario");
            System.out.println("3) Non-fiction");
            
            try {
                respuesta = scanner2.nextInt();
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
                    System.out.println("No ingresaste una opción válida");
                }
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        }
    }
}
