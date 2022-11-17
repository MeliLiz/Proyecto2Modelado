/**
 * Interfaz para los sujetos observables
 */
public interface SujetoObservable {

    /**
     * Método para registrar a un observador del sujeto observable
     * @param Usuario El observador a registrar
     */
    public void registrar(Usuario usuario);

    /**
     * Método para quitar a un observador del sujeto observable
     * @param usuario El usuario a quitar de los observadores
     */
    public void remover(Usuario usuario);

    /**
     * Método para notificar a los observadores de un cambio
     */
    public void notificar();
}
