import java.util.ArrayList;

/**
 * Clase para la Tienda Usuario, sirve como controlador del usuario y la tienda
 */
public class TiendaUsuario {
    private Tienda tienda;
    private VistaMenus vistaMenus;
    private VistaTienda vistaTienda;
    private Usuario usuario;
    private Admin admin;
    private ArrayList<Libro> carrito;
    private String tipoUsuario;

    /**
     * Cosntructor
     * 
     * @param tienda      La tienda
     * @param usuario     El usuario que entrara a la tienda
     * @param tipoUsuario El tipo de usuario de la tinda: "usuario" si es usuario
     *                    normal , "admin" si es administrador
     */
    public TiendaUsuario(Tienda tienda, Usuario usuario, String tipoUsuario) {
        this.tienda = tienda;
        vistaMenus = new VistaMenus(this);
        vistaTienda = new VistaTienda(this);
        this.usuario = usuario;
        carrito = new ArrayList<Libro>();
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Constructor sin el usuario
     * 
     * @param tienda      La tienda
     * @param tipoUsuario El tipo de usuario de la tinda: "usuario" si es usuario
     *                    normal , "admin" si es administrador
     */
    public TiendaUsuario(Tienda tienda, String tipoUsuario) {
        this.tienda = tienda;
        vistaMenus = new VistaMenus(this);
        vistaTienda = new VistaTienda(this);
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Método que daŕa inicio al progama, se verifica qué tipo de usuario es
     * Si es usuario normal, se le imprimira un mensaje diferente al del
     * administrador
     */
    public void inicio() {
        if (this.tipoUsuario.equals("usuario")) {
            vistaMenus.bienvenida();
        } else {
            vistaMenus.bienvenidaAdmin();
        }
    }

    /**
     * Método para recibir la respuesta del usuario en el menu de opciones
     * siendo usuario tipo "usuario"
     * 
     * @param respuesta La respuesta que envió la vista
     */
    public void menuOpciones(int respuesta) {
        switch (respuesta) {
            case 1:
                mostrarCatalogo();
                break;
            case 2:
                comprar();
                break;
            case 3:
                irABiblioteca();
                break;
            case 4:
                salir();
                break;

            default:
                break;
        }
    }

    /**
     * Método para recibir la respuesta del usuario en el menu de opciones
     * siendo usuario tipo "admin"
     * 
     * @param respuesta La respuesta que envió la vista
     */
    public void menuOpcionesAdmin(int respuesta) {
        switch (respuesta) {
            case 1:
                subirLibro();
                break;
            case 2:
                salir();
                break;
            default:
                break;
        }
    }

    /**
     * Método que para mostrar el catálogo de la tieda
     */
    public void mostrarCatalogo() {
        vistaTienda.imprimirCatalogo(tienda.mostrarCatalogo());
    }

    /**
     * Método para comprar un libro
     */
    public void comprar() {
        mostrarCatalogo();
        vistaMenus.imprimirMenuCompra();
    }

    /**
     * Método para ir a la biblioteca de libros que tiene el usuario
     */
    public void irABiblioteca() {

    }

    /**
     * Método para salir del menú en que se encuentra el usuario
     */
    public void salir() {

    }

    /**
     * Método para subir un libro a la biblioteca de libros de la tienda
     * Este metodo solo lo usan los administradores
     */
    public void subirLibro() {

    }

    /**
     * Método que recibe la respuesta de la vista para las opciones en el menú
     * cuando compras un libro
     * 
     * @param respuesta La respuesta de que envió la vista
     */
    public void menuOpcionesCarrito(int respuesta) {
        if (respuesta == 1) {
            int codigoDeBarras = 0;
            do {
                codigoDeBarras = vistaMenus.ingresarCodigoLibro();
                Libro libro = tienda.getLibro(codigoDeBarras);
                if (libro != null) {
                    argregarAlCarrito(libro);
                    vistaTienda.libroAgregado(libro.getNombre());

                } else {
                    vistaTienda.noExisteLibro();

                }
            } while (codigoDeBarras != -1);
            vistaMenus.pagar();
        } else {
            inicio();
        }
    }

    /**
     * Método para agregar un libro al carrito del usuario
     * 
     * @param libro El nuevo libro a agregar
     */
    public void argregarAlCarrito(Libro libro) {
        carrito.add(libro);
    }

    public void iniciarPagoMenu(int respuesta) {
        if (respuesta == 1) {
            iniciarPago();

        } else {
            inicio();
        }
    }

    public void iniciarPago() {
        double suma = 0;
        for (Libro libro : carrito) {
            suma += libro.getPrecio();
        }
        vistaTienda.imprimirPago(this.carrito, suma);
        int cvvUsuario = vistaTienda.pedirDatosBancariosUsuario();
        if (tienda.hacerPago(suma, usuario.getNumeroDeCuenta(), cvvUsuario)) {
            vistaTienda.pagoExitoso();
            for (Libro libro : carrito) {
                usuario.getBiblioteca().addLibro(libro);
            }
        } else {
            vistaTienda.pagoFallido();

        }
        inicio();
    }

}
