import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

/*
 * In dieser ersten Graphics App-Anwendung werden vier verschieden farbige Kreise
 * animiert. Die Kreise befinden sich initial in etwas am Mittelpunkt der Zeichenfläche
 * und werden im Rahmen des Draw Loops schrittweisen in Richtung jeweils einer der
 * Ecken des Fensters bewegt. Die Kreise verlassen dabei die sichtbare Fläche der Anwendung.
 */
public class HelloGraphicsApp extends GraphicsApp {

    /*
     * Mithilfe dieser Konstanten legen wir fixe Werte fest, die zur Konfiguration der
     * Zeichenfläche sowie zur Gestaltung und Animation der Kreise verwendet werden. Über
     * die Namen der Konstanten werden die festgelegten Werte im Code eingesetzt.
     */
    private static final int WINDOW_WIDTH = 500; // Breite der Zeichenfläche bzw. des Fensters in Pixel
    private static final int WINDOW_HEIGHT = 500; // Höhe der Zeichenfläche bzw. des Fensters in Pixel
    private static final int CIRCLE_RADIUS = 10; // Radius der vier Kreise in Pixel
    private static final int CIRCLE_START_OFFSET = 10; // Abstand der Kreise vom Mittelpunkt des Fensters in Pixel
    private static final int CIRCLE_SPEED = 1; // Geschwindigkeit der Kreise pro Frame in Pixel
    private static final Color RED = new Color(234, 49, 63); // "Selbstgemischter" RGB-Farbe (rot)
    private static final Color YELLOW = new Color(234, 182, 56); // "Selbstgemischter" RGB-Farbe (gelb)
    private static final Color GREEN = new Color(76, 149, 80); // "Selbstgemischter" RGB-Farbe (grün)
    private static final Color BLUE = new Color(47, 61, 76); // "Selbstgemischter" RGB-Farbe (blau)

    /*
     * In diesen Variablen speichern wir die vier Objekte, die unserer Kreise repräsentieren.
     * Beim Start der Anwendung erstellen wir vier unterschiedliche Kreise und speichern diese
     * in diesen Variablen. Bei jedem Aufruf der draw-Methode bewegen wir die Kreise in diesen
     * Variablen und zeichnen sie an der neuen Position ein.
     */
    private Circle redCircle;
    private Circle yellowCircle;
    private Circle greenCircle;
    private Circle blueCircle;

    /*
     * Diese Methode wird automatisch beim Programmstart aufgerufen und genau einmal ausgeführt. Auslöser ist
     * die main-Methode die den Einstiegspunkt in das gesamte Programm markiert.
     */
    @Override
    public void initialize() {
        // Wir legen fest, dass unser Anwendungsfenster 500x500 Pixel groß sein soll
        setCanvasSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // Das Erstellen der Kreise haben wir in eine separate Methode ausgelagert, um den Quellcode übersichtlicher zu gestalten
        initCircles();
    }

    /*
     * In dieser Methode werden die vier Kreis-Objekte auf Basis der Circle-Klasse erstellt und in den
     * auf Klassenebene vorbereiteten Variablen gespeichert.
     */
    private void initCircles() {
        /*
         * Das eigentliche Erstellen der Kreise wird in eine separate Methode ausgelagert. Diese erhält mehrere
         * Parameter, die beim Erzeugen des neuen Kreises verwendet werden sollen: den Abstand vom Mittelpunkt
         * auf der x- bzw. y-Achse und die Farbe des Kreises. Das Erstellen aller Kreise läuft gleich ab. Deshalb
         * können wir diesen Vorgang in einer einzelnen Methode durchführen. Damit wir aber unterschiedliche Kreise,
         * an unterschiedlichen Positionen und mit unterschiedlichen Farben erzeugen, übergeben wir der gleichen
         * Methode bei jedem Aufruf unterschiedliche Parameter bzw. Werte. Die Methode erzeugt auf dieser Basis einen
         * spezifischen Kreis und gibt diesen als Ergebnis zurück (rechte Seite der "Gleichung"). Diesen Kreis speichern
         * wir dann in die jeweilige Variable (linke Seite der "Gleichung").
         *
         * Mit dem vorangestellten "-" erzeugen wir aus dem eigentlich positiven Wert in der Konstanten einen negativen
         * Wert, um die Position innerhalb des Koordinatensystems zu verschieben.
         */
        redCircle = createCircle(-CIRCLE_START_OFFSET, -CIRCLE_START_OFFSET, RED);
        yellowCircle = createCircle(CIRCLE_START_OFFSET, -CIRCLE_START_OFFSET, YELLOW);
        greenCircle = createCircle(-CIRCLE_START_OFFSET, CIRCLE_START_OFFSET, GREEN);
        blueCircle = createCircle(CIRCLE_START_OFFSET, CIRCLE_START_OFFSET, BLUE);
    }

    /*
     * Die Methode erzeugt ein neues Kreis-Objekt. Alle Objekte werden am Mittelpunkt der Zeichenfläche ausgerichtet und
     * um die angegebenen Werte (Parameter) auf der x- bzw. y-Achse verschoben. Die Farbe des neuen Kreises wird ebenfalls
     * über einen Parameter bestimmt. Der Radius ist für alle Kreise gleich und wird aus der entsprechenden Konstanten
     * ausgelesen.
     */
    private Circle createCircle(int xOffset, int yOffset, Color color) {
        /*
         * Hier Berechnen wir den Mittelpunkt der Zeichenfläche, in dem wir jeweils Höhe und Breite durch zwei teilen.
         * Anschließend wird der übergebene Versatz addiert, um die genaue Position des neuen Kreises zu bestimmen. Die
         * Positionsangaben werden in der Graphics App als float-Werte angegeben. Damit wir bei der Division einen solchen
         * Wert erhalten, legen wir explizit fest, dass wir für den Divisor einen float-Wert (f hinter 2.0) verwenden wollen.
         */
        float xPosition = (WINDOW_WIDTH / 2.0f) + xOffset;
        float yPosition = (WINDOW_HEIGHT / 2.0f) + yOffset;
        return new Circle(xPosition, yPosition, CIRCLE_RADIUS, color);
    }

    /*
     * Diese Methode wird nach dem Programmstart regelmäßig ausgeführt. Ihr Rechner versucht dabei ca. alle 16ms einmal
     * die Methode aufzurufen. Wenn das klappt, können Sie ~ 60-mal pro Sekunde die Zeichenfläche neu gestalten. Das ergibt
     * dann idealerweise eine Framerate von 60.
     */
    @Override
    public void draw() {
        // Bei jedem Aufruf der Methode wird zuerst die gesamte Zeichenfläche weiß eingefärbt
        drawBackground(Colors.WHITE);
        // Im Anschluss werden in dieser Methode alle Kreis bewegt und neu eingezeichnet
        moveAndDrawCircles();
    }

    /*
     * Diese Methode bewegt alle Kreise und zeichnen diese anschließend an der neuen Position ein. Jeder Kreis bewegt sich,
     * ausgehend von seiner aktuellen Position in Richtung einer der vier Ecken der Zeichenfläche.
     */
    private void moveAndDrawCircles() {
        // Wir bewegen den roten Kreis innerhalb des Koordinatensystems nach oben links
        redCircle.move(-CIRCLE_SPEED, -CIRCLE_SPEED);
        // Wir bewegen den gelben Kreis innerhalb des Koordinatensystems nach oben rechts
        yellowCircle.move(CIRCLE_SPEED,-CIRCLE_SPEED);
        // Wir bewegen den grünen Kreis innerhalb des Koordinatensystems nach unten links
        greenCircle.move(-CIRCLE_SPEED,CIRCLE_SPEED);
        // Wir bewegen den blauen Kreis innerhalb des Koordinatensystems nach unten rechts
        blueCircle.move(CIRCLE_SPEED,CIRCLE_SPEED);
        // Wenn alle Kreise neu positioniert sind, werden sie durch Aufruf der jeweiligen draw-Methode neu eingezeichnet
        redCircle.draw();
        yellowCircle.draw();
        greenCircle.draw();
        blueCircle.draw();
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch("HelloGraphicsApp");
    }
}