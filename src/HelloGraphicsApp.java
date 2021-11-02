import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;
import de.ur.mi.oop.colors.*;
import de.ur.mi.oop.graphics.*;

/*
 * In dieser ersten Graphics App-Anwendung werden vier verschieden farbige Kreise
 * animiert. Die Kreise befinden sich initial in etwas am Mittelpunkt der Zeichenfläche
 * und werden im Rahmen des Draw Loops schrittweisen in Richtung jeweils einer der
 * Ecken des Fensters bewegt. Die Kreise verlassen dabei die sichtbare Fläche der Anwendung.
 */
public class HelloGraphicsApp extends GraphicsApp {

    /*
     * Diese Methode wird automatisch beim Programmstart aufgerufen und genau einmal ausgeführt. Auslöser ist
     * die main-Methode die den Einstiegspunkt in das gesamte Programm markiert.
     */
    @Override
    public void initialize() {
    }

    /*
     * Diese Methode wird nach dem Programmstart regelmäßig ausgeführt. Ihr Rechner versucht dabei ca. alle 16ms einmal
     * die Methode aufzurufen. Wenn das klappt, können Sie ~ 60-mal pro Sekunde die Zeichenfläche neu gestalten. Das ergibt
     * dann idealerweise eine Framerate von 60.
     */
    @Override
    public void draw() {
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch("HelloGraphicsApp");
    }
}