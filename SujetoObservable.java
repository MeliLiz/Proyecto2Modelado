/**
 * Interfaz para los sujetos observables
 */
public interface SujetoObservable {

    /**
     * Método para registrar a un observador del sujeto observable
     * @param Usuario El observador a registrar
     */
    public void registrar(Observador Usuario);

    /**
     * Método para quitar a un observador del sujeto observable
     * @param usuario El usuario a quitar de los observadores
     */
    public void remover(Observador usuario);

    /**
     * Método para notificar a los observadores de un cambio
     */
    public void notificar();
}
