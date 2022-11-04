public class Libro {
    private String nombre;
    private String autor;
    private String resumen;
    private String genero;
    private String link;
    private int numPaginas;
    private final int ID;
    private double precio;

    public Libro(String nombre, String autor, String resumen, String genero, String link, int numPaginas, double precio, int ID){
        this.nombre=nombre;
        this.autor=autor;
        this.precio=precio;
        this.resumen=resumen;
        this.genero=genero;
        this.link=link;
        this.numPaginas=numPaginas;
        this.ID=ID;
    }


    public String getNombre(){
        return nombre;
    }

    public String getAutor(){
        return autor;
    }

    public double getPrecio(){
        return precio;
    }

    public String getResumen(){
        return resumen;
    }

    public String getGenero(){
        return genero;
    }

    public int getNumPaginas(){
        return numPaginas;
    }

    public int getID(){
        return this.ID;
    }

    public String getLink(){
        return link;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setAutor(String autor){
        this.autor=autor;
    }

    public void setPrecio(double precio){
        this.precio=precio;
    }

    public void setResumen(String resumen){
        this.resumen=resumen;
    }

    public void setGenero(String genero){
        this.genero=genero;
    }

    public void setNumPaginas(int numPaginas){
        this.numPaginas=numPaginas;
    }
}
