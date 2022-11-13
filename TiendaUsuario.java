import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase para la Tienda Usuario, sirve como controlador del usuario y la tienda
 */
public class TiendaUsuario implements Serializable {
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
        vistaTienda.mostrarBienvenida();
        if (this.tipoUsuario.equals("usuario")) {//Si el usuario es un usuario normal
            //El número de libros gratis que tiene la tienda desde la última vez que el usuario visitó su cuenta
            if(usuario.getNumLibrosGratis()!=0){
                vistaTienda.mostrarNumLibrosGratis(usuario.getNumLibrosGratis());
                usuario.setNumLibrosGratis(0);
            }
            //Mostrar al usuario las opciones de la tienda: ver catalogo, comprar, ir a su biblioteca o salir
            vistaMenus.bienvenida();
        } else { //Si el usuario es un administrador, se mustra el menú de administrador
            vistaMenus.bienvenidaAdmin();
        }
    }

    /**
     * Método para recibir la respuesta del usuario en el menu de opciones
     * siendo usuario tipo "usuario"
     * 
     * @param respuesta La respuesta que envió la vista: 1 para mostrar catáogo, 2 para comprar libros, 3 para ir a la biblioteca del usuario, 4 para salir
     */
    public void menuOpciones(int respuesta) {

        switch (respuesta) {
            case 1:
                mostrarCatalogo();
                inicio();
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
     * @param respuesta La respuesta que envió la vista: 1 para registrar un libro nuevo en la tienda, 2 para salir
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
        vistaMenus.quererLeer();
        
    }

    /**
     * Método para ver los libros disponibles en la biblioteca del usuario y dar las opciones de lectura
     * @param respuesta 1 para ir a la biblioteca del usuario, 2 para salir
     */
    public void verBiblioteca(int respuesta){
        if(respuesta==1){
            Biblioteca biblioteca=usuario.getBiblioteca();
            vistaTienda.mostrarLibrosBiblioteca(biblioteca);
            vistaMenus.elegirLibro();
        }else{
            inicio();
        } 
    }


    /**
     * Método para obtener un libro
     * @param id El id del libro
     */
    public void getLibro(int id){
        //Se obtiene el libro de la biblioteca del usuario
        Libro libro=usuario.getBiblioteca().getLibro(id);

        if(libro!=null){//Si el libro está en la biblioteca del usuario

            int respuesta=vistaMenus.opcionesLectura();//La respuesta de las opciones de lectura que tiene el usuario
            Biblioteca biblioteca=usuario.getBiblioteca();
            switch (respuesta) {
               
                case 1://Leer libro
                    //Si el libro no se había abierto antes, se cambia el estado del libro a "En progreso"
                    if(libro.getEstadoLibro().equals("Por leer")){
                        biblioteca.addLibroEnProgreso(libro);
                        libro.setEstadoLibro("En progreso");
                    }
                    //Sea abre el libro y se regresa al inicio
                    biblioteca.abrirLibro(libro);
                    irABiblioteca();
                    break;
                case 2://Registrar la última página leída del libro
                    while(true){
                        int pagina=vistaTienda.pedirPagina();
                        //Se verifica que la página ingresada sea válida para el libro
                        if(pagina<0||pagina>libro.getNumPaginas()){
                            vistaTienda.errorNumPaginas();
                        }else{
                            libro.setNumPaginasLeyendo(pagina);
                            vistaTienda.progresoRegistrado();
                            irABiblioteca();
                            break;
                        }
                    }
                    break;
                case 3://Marcar el libro como leido
                    //Se cambia el estado del libro a "Leido"
                    biblioteca.addLibroLeido(libro);
                    libro.setEstadoLibro("Leido");
                    irABiblioteca();
                    break;
                case 4://Salir
                    //Regresamos al menu de opciones de la bibioteca del usuario
                    inicio();
                    break;
            
                default:
                    break;
            }
        }else{ //Si el libro no está en la biblioteca de usuario
            vistaTienda.noExisteLibro();
            irABiblioteca();
        }
    }


    /**
     * Método para subir un libro a la biblioteca de libros de la tienda
     * Este metodo solo lo usan los administradores
     */
    public void subirLibro() {
        //Pedimos los datos del libro a registrar a través de la vistr
        String titulo=vistaTienda.pedirTituloLibro();
        String autor=vistaTienda.pedirAutor();
        String link=vistaTienda.pedirLinkLibro();
        int numPaginas=vistaTienda.pedirNumPaginasLibro();
        double precio=vistaTienda.pedirPrecioLibro();
        String genero=vistaMenus.elegirGenero();
        //Hacemos el libro y lo registramos en la tienda
        Libro libro=new Libro(titulo, autor, genero, link, numPaginas, precio, tienda.numLibros+1);
        tienda.addLibro(libro);
        vistaTienda.libroRegistrado();
        //Volvemos al inicio de la tienda
        inicio();
    }

    /**
     * Método que recibe la respuesta de la vista para las opciones en el menú
     * cuando compras un libro
     * 
     * @param respuesta La respuesta de que envió la vista: 1 para agregar libros al carrito, 2 para ir al inicio
     */
    public void menuOpcionesCarrito(int respuesta) {
        if (respuesta == 1) {//agregar libros al carrito
            int codigoDeBarras = 0;
            //Se pide el id de un libro hasta que se ingrese el número -1
            do {
                codigoDeBarras = vistaMenus.ingresarCodigoLibro();
                if(codigoDeBarras!=-1){
                    //Se verifica que exista el libro con el id ingresado por el usuario
                    Libro libro = tienda.getLibro(codigoDeBarras);
                    if (libro != null) {
                        argregarAlCarrito(libro);
                        vistaTienda.libroAgregado(libro.getNombre());
                    } else {
                        vistaTienda.noExisteLibro();
                    }
                }
                
            } while (codigoDeBarras != -1);
            //se muestra el menú para pagar
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

    /**
     * Método para iniciar el pago de los libros que están en el carrito
     * @param respuesta 1 si se quiere pagar lo que hay en el carrito, 2 para regresar al inicio
     */
    public void iniciarPagoMenu(int respuesta) {
        if (respuesta == 1) { //pagar
            iniciarPago();
        } else {//salir
            carrito.clear();//Se quitan los libros agregados del carrito
            inicio();//regrasamos al inicio
        }
    }

    /**
     * Método para iniciar el pago de los libros en el carrito
     */
    public void iniciarPago() {
        //Hacemos la suma del precio de los libros
        double suma = 0;
        for (Libro libro : carrito) {
            suma += libro.getPrecio();
        }
        //Mostramos los productos a pagar y el total a pagar
        vistaTienda.imprimirPago(this.carrito, suma);
        //Pedir datos bancarios del usuario
        int cvvUsuario = vistaTienda.pedirDatosBancariosUsuario();
        //Se verifica que se pueda hacer el pago
        if (tienda.hacerPago(suma, usuario.getNumeroDeCuenta(), cvvUsuario)) {
            vistaTienda.pagoExitoso();
            //Ponemos los libros en la biblioteca del usuario
            for (Libro libro : carrito) {
                usuario.getBiblioteca().addLibro(libro);
            }
        } else {//Si el pago no se puede hacer
            vistaTienda.pagoFallido();
        }
        //Quitamos los libros del carrito y regresamos al inicio
        carrito.clear();
        inicio();
    }

    /**
     * Método para salir del menú en que se encuentra el usuario
     */
    public void salir() {

    }

}
