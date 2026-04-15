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

    public Group getVista() {
        return vista;
    }

    public void mover(int dx, int dy) {
        this.xInicial = dx;
        this.yInicial = dy;

    }

    public void mostrar() {

    }

    private void recalcularMedidas() {
        tamañoDelPixel = tamañoDeLaFicha / 7;
        bordeX = (tamañoDeLaFicha / 7) * 2;
        bordeY = tamañoDeLaFicha / 7;
        mediaFicha = (tamañoDeLaFicha / 14) * 6;
    }

    private void ordenarLaFicha() {
        fondoDeLaFicha.mover(xInicial, yInicial);
        fondoDeLaFicha.changeSize(tamañoDeLaFicha);

        for (Square pixel : pixeles) {
            pixel.changeSize(tamañoDelPixel);
        }

        pixeles.get(0).mover(xInicial + bordeX, yInicial + bordeY);
        pixeles.get(1).mover(xInicial + mediaFicha, yInicial + bordeY);
        pixeles.get(2).mover(xInicial + bordeX * 2, yInicial + bordeY);

        pixeles.get(3).mover(xInicial + bordeX, yInicial + bordeY * 2);
        pixeles.get(4).mover(xInicial + mediaFicha, yInicial + bordeY * 2);
        pixeles.get(5).mover(xInicial + bordeX * 2, yInicial + bordeY * 2);

        pixeles.get(6).mover(xInicial + bordeX, yInicial + bordeY * 3);
        pixeles.get(7).mover(xInicial + mediaFicha, yInicial + bordeY * 3);
        pixeles.get(8).mover(xInicial + bordeX * 2, yInicial + bordeY * 3);

        pixeles.get(9).mover(xInicial + bordeX, yInicial + bordeY * 4);
        pixeles.get(10).mover(xInicial + mediaFicha, yInicial + bordeY * 4);
        pixeles.get(11).mover(xInicial + bordeX * 2, yInicial + bordeY * 4);

        pixeles.get(12).mover(xInicial + bordeX, yInicial + bordeY * 5);
        pixeles.get(13).mover(xInicial + mediaFicha, yInicial + bordeY * 5);
        pixeles.get(14).mover(xInicial + bordeX * 2, yInicial + bordeY * 5);
    }

}
