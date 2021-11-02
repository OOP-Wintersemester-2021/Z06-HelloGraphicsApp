import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class HelloGraphicsApp extends GraphicsApp {

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private static final int CIRCLE_RADIUS = 10;
    private static final Color RED = new Color(234, 49, 63);
    private static final Color YELLOW = new Color(234, 182, 56);
    private static final Color GREEN = new Color(76, 149, 80);
    private static final Color BLUE = new Color(47, 61, 76);

    private Circle redCircle;
    private Circle yellowCircle;
    private Circle greenCircle;
    private Circle blueCircle;

    @Override
    public void initialize() {
        setCanvasSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        initCircles();
    }

    private void initCircles() {
        redCircle = new Circle(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, CIRCLE_RADIUS, RED);
        yellowCircle = new Circle(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, CIRCLE_RADIUS, YELLOW);
        greenCircle = new Circle(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, CIRCLE_RADIUS, GREEN);
        blueCircle = new Circle(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, CIRCLE_RADIUS, BLUE);
    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
        moveAndDrawCircles();
    }

    private void moveAndDrawCircles() {
        redCircle.move(1, 1);
        yellowCircle.move(1,-1);
        greenCircle.move(-1,1);
        blueCircle.move(-1,-1);
        redCircle.draw();
        yellowCircle.draw();
        greenCircle.draw();
        blueCircle.draw();
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch("HelloGraphicsApp");
    }
}