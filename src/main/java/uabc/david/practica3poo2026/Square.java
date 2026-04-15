package uabc.david.practica3poo2026;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square {
    private Rectangle rectangulo;

    public Square() {
        rectangulo = new Rectangle(60, 60);
        rectangulo.setFill(Color.RED);
        rectangulo.setVisible(false);
    }

    public void mover(int x, int y) {
        rectangulo.setX(x);
        rectangulo.setY(y);
    }

    public void changeSize(int newSize) {
        rectangulo.setWidth(newSize);
        rectangulo.setHeight(newSize);
    }

    public void changeColor(String colorString) {
        try {
            rectangulo.setFill(Color.web(colorString));
        } catch (Exception e) {
            rectangulo.setFill(Color.BLACK);
        }
    }
    
    public void makeVisible() {
        rectangulo.setVisible(true);
    }

    public void makeInvisible() {
        rectangulo.setVisible(false);
    }
    
    public Rectangle getRectangulo() {
        return rectangulo;
    }
}
