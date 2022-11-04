import java.util.ArrayList;

public class TiendaUsuario {
    private Tienda tienda;
    private VistaMenus vistaMenus;
    private VistaTienda vistaTienda;
    private String usuario;
    private ArrayList<Libro> carrito;

    public TiendaUsuario(Tienda tienda){
        this.tienda=tienda;
        vistaMenus=new VistaMenus(this);
        vistaTienda=new VistaTienda(this);
        carrito=new ArrayList<Libro>();
    }
}
