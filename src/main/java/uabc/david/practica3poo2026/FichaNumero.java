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
        recalcularMedidas();

        fondoDeLaFicha = new Square();
        fondoDeLaFicha.changeColor("white");
        vista.getChildren().add(fondoDeLaFicha.getRectangulo());

        for (int i = 0; i < 15; i++) {
            Square pixel = new Square();
            pixel.changeColor(color);
            pixeles.add(pixel);
            vista.getChildren().add(pixel.getRectangulo());
        }

        ordenarLaFicha();
        mostrar();
    }

    public Group getVista() {
        return vista;
    }

    public void mostrar() {
        dibujarFicha(this.valor);
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

    public void dibujarFicha(int valor) {
        this.valor = valor;
        ocultarPixeles();
        if (valor == 0) {
            return;
        }

        switch(valor) {
            case 1:
                mostrarUno();
                break;
            case 2:
                mostrarDos();
                break;
            case 3:
                mostrarTres();
                break;
            case 4:
                mostrarCuatro();
                break;
            case 5:
                mostrarCinco();
                break;
            case 6:
                mostrarSeis();
                break;
            case 7:
                mostrarSiete();
                break;
            case 8:
                mostrarOcho();
                break;
            case 9:
                mostrarNueve();
                break;
            default:
                ocultarPixeles();
        }
    }

    private void mostrarUno() {
        pixeles.get(1).makeVisible();
        pixeles.get(3).makeVisible();
        pixeles.get(4).makeVisible();
        pixeles.get(7).makeVisible();
        pixeles.get(10).makeVisible();
        pixeles.get(12).makeVisible();
        pixeles.get(13).makeVisible();
        pixeles.get(14).makeVisible();
    }

    private void mostrarDos() {
        pixeles.get(0).makeVisible();
        pixeles.get(1).makeVisible();
        pixeles.get(2).makeVisible();
        pixeles.get(5).makeVisible();
        pixeles.get(6).makeVisible();
        pixeles.get(7).makeVisible();
        pixeles.get(8).makeVisible();
        pixeles.get(9).makeVisible();
        pixeles.get(12).makeVisible();
        pixeles.get(13).makeVisible();
        pixeles.get(14).makeVisible();
    }

    private void mostrarTres() {
        pixeles.get(0).makeVisible();
        pixeles.get(1).makeVisible();
        pixeles.get(2).makeVisible();
        pixeles.get(5).makeVisible();
        pixeles.get(6).makeVisible();
        pixeles.get(7).makeVisible();
        pixeles.get(8).makeVisible();
        pixeles.get(11).makeVisible();
        pixeles.get(12).makeVisible();
        pixeles.get(13).makeVisible();
        pixeles.get(14).makeVisible();
    }

    private void mostrarCuatro() {
        pixeles.get(0).makeVisible();
        pixeles.get(2).makeVisible();
        pixeles.get(3).makeVisible();
        pixeles.get(5).makeVisible();
        pixeles.get(6).makeVisible();
        pixeles.get(8).makeVisible();
        pixeles.get(9).makeVisible();
        pixeles.get(10).makeVisible();
        pixeles.get(11).makeVisible();
        pixeles.get(14).makeVisible();
    }

    private void mostrarCinco() {
        pixeles.get(0).makeVisible();
        pixeles.get(1).makeVisible();
        pixeles.get(2).makeVisible();
        pixeles.get(3).makeVisible();
        pixeles.get(6).makeVisible();
        pixeles.get(7).makeVisible();
        pixeles.get(8).makeVisible();
        pixeles.get(11).makeVisible();
        pixeles.get(12).makeVisible();
        pixeles.get(13).makeVisible();
        pixeles.get(14).makeVisible();
    }

    private void mostrarSeis() {
        pixeles.get(0).makeVisible();
        pixeles.get(1).makeVisible();
        pixeles.get(2).makeVisible();
        pixeles.get(3).makeVisible();
        pixeles.get(6).makeVisible();
        pixeles.get(7).makeVisible();
        pixeles.get(8).makeVisible();
        pixeles.get(9).makeVisible();
        pixeles.get(11).makeVisible();
        pixeles.get(12).makeVisible();
        pixeles.get(13).makeVisible();
        pixeles.get(14).makeVisible();
    }

    private void mostrarSiete() {
        pixeles.get(0).makeVisible();
        pixeles.get(1).makeVisible();
        pixeles.get(2).makeVisible();
        pixeles.get(3).makeVisible();
        pixeles.get(5).makeVisible();
        pixeles.get(8).makeVisible();
        pixeles.get(11).makeVisible();
        pixeles.get(14).makeVisible();
    }

    private void mostrarOcho() {
        pixeles.get(0).makeVisible();
        pixeles.get(1).makeVisible();
        pixeles.get(2).makeVisible();
        pixeles.get(3).makeVisible();
        pixeles.get(5).makeVisible();
        pixeles.get(6).makeVisible();
        pixeles.get(7).makeVisible();
        pixeles.get(8).makeVisible();
        pixeles.get(9).makeVisible();
        pixeles.get(11).makeVisible();
        pixeles.get(12).makeVisible();
        pixeles.get(13).makeVisible();
        pixeles.get(14).makeVisible();
    }

    private void mostrarNueve() {
        pixeles.get(0).makeVisible();
        pixeles.get(1).makeVisible();
        pixeles.get(2).makeVisible();
        pixeles.get(3).makeVisible();
        pixeles.get(5).makeVisible();
        pixeles.get(6).makeVisible();
        pixeles.get(7).makeVisible();
        pixeles.get(8).makeVisible();
        pixeles.get(11).makeVisible();
        pixeles.get(12).makeVisible();
        pixeles.get(13).makeVisible();
        pixeles.get(14).makeVisible();
    }

    public void ocultarPixeles() {
        fondoDeLaFicha.makeVisible();
        for (Square pixel : pixeles) {
            pixel.makeInvisible();
        }
    }

}
