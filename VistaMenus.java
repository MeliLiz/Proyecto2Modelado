import java.util.Scanner;

public class VistaMenus {
    private TiendaUsuario tiendaUsuario;
    private Scanner scanner1 = new Scanner(System.in);// Scanner para líneas
    private Scanner scanner2 = new Scanner(System.in);// Scanner para números
    private Scanner scanner3 = new Scanner(System.in);// Scanner para long

    public VistaMenus(TiendaUsuario tienda) {
        tiendaUsuario = tienda;
    }

    public void bienvenida() {
        System.out.println("Bienvenid@ a InkSpace");
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

    public int ingresarCodigoLibro() {
        int respuesta = 0;

        while (true) {
            System.out.println("Si ya ha terminado de agregar libros al carrito, ingrese -1");
            System.out.print("Por favor, ingrese el id del libro");
            try {
                respuesta = scanner2.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("No has ingresado un número");
            }
        }
        return respuesta;
    }

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

    public void elegirLibro(){
        while (true) {
            System.out.println("Ingresa el id del libro que deseas leer");
            int id=0;
            try {
                id = scanner2.nextInt();
                
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        }
    }

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
