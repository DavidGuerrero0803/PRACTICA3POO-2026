package uabc.david.practica3poo2026;

import javafx.scene.Group;

import java.util.ArrayList;

public class FichaNumero {
    private Group vista;
    private Square fondoDeLaFicha;
    private ArrayList<Square> pixeles;

    private int valor;
    private String color;

    private int tamañoDeLaFicha;
    private int tamañoDelPixel;
    private int bordeX;
    private int bordeY;
    private int mediaFicha;

    private int xInicial;
    private int yInicial;

    public FichaNumero(int valor, String color) {
        this.vista = new Group();
        this.valor = valor;
        this.color = color;
        this.pixeles = new ArrayList<>();
        this.tamañoDeLaFicha = 60;

        fondoDeLaFicha = new Square();
        fondoDeLaFicha.changeColor("white");
        vista.getChildren().add(fondoDeLaFicha.getRectangulo());

        for (int i = 0; i < 15; i++) {
            Square pixel = new Square();
            pixel.changeColor(color);
            pixeles.add(pixel);
            vista.getChildren().add(pixel.getRectangulo());
        }

    }

}
