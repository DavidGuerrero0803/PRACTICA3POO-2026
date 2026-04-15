package uabc.david.practica3poo2026;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class CasillaSudoku extends StackPane {
    private int fila;
    private int columna;

    private FichaNumero ficha;
    private TableroSudoku logica;
    private Rectangle borde;

    public CasillaSudoku(int fila, int columna, TableroSudoku logica) {
        this.fila = fila;
        this.columna = columna;
        this.logica = logica;
        this.setFocusTraversable(true);

        int valorInicial = logica.getValor(fila, columna);
        String colorInicial = logica.esFija(fila, columna) ? "black" : "blue";
        this.ficha = new FichaNumero(valorInicial, colorInicial);

        this.borde = new Rectangle(60, 60);
        this.borde.setFill(Color.TRANSPARENT);
        this.borde.setStroke(Color.web("#CCCCCC", 0.5));
        this.borde.setStrokeWidth(1);

        this.borde.setStrokeType(StrokeType.INSIDE);

        this.getChildren().addAll(ficha.getVista(), borde);

        if (valorInicial != 0) {
            ficha.dibujarFicha(valorInicial);
        }

        this.setOnMouseClicked(e -> {
            this.requestFocus();
            borde.setStroke(Color.ORANGE);
            borde.setStrokeWidth(3);
        });

        this.focusedProperty().addListener((obs,
                                            valorViejo, valorNuevo) -> {
            if (!valorNuevo) {
                borde.setStroke(Color.web("#CCCCCC", 0.5));
                borde.setStrokeWidth(1);
            }
        });

        this.setOnKeyPressed(e -> {
            String texto = e.getText();

            if (texto.matches("[1-9]")) {
                int valorTeclado = Integer.parseInt(texto);
                intercambiarValor(valorTeclado);
            } else if (e.getCode() == KeyCode.BACK_SPACE ||
                    e.getCode() == KeyCode.DELETE ||
                    texto.equals("0")) {

                borrarValorCasilla();
            }
        });
    }

    public void intercambiarValor(int nuevoValor) {
        if (logica.validarPosicion(fila, columna, nuevoValor)) {
            logica.asignarValor(fila, columna, nuevoValor);
            ficha.dibujarFicha(nuevoValor);
            borde.setStroke(Color.GREEN);
            borde.setStrokeWidth(3);

        } else {
            borde.setStroke(Color.RED);
            borde.setStrokeWidth(4);

            int valorReal = logica.getValor(fila, columna);
            ficha.dibujarFicha(valorReal);
        }
    }

    private void borrarValorCasilla() {
        if (logica.esFija(fila, columna)) {
            System.out.println("No se puede borrar una casilla fija");
            return;
        }

        logica.asignarValor(fila, columna, 0);

        ficha.dibujarFicha(0);

        borde.setStroke(Color.ORANGE);
        borde.setStrokeWidth(3);
    }
}
