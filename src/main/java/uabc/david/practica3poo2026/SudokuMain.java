package uabc.david.practica3poo2026;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class SudokuMain extends Application {
    private TableroSudoku logica = new TableroSudoku();

    @Override
    public void start(Stage primaryStage) {
        int[][] tableroSeleccionado = obtenerTableroAleatorio();

        logica.cargarTablero(tableroSeleccionado);

        Pane root = new Pane();
        root.setStyle("-fx-background-color: white;");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(0);
        grid.setHgap(0);

        for (int fila = 0; fila < 9; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                CasillaSudoku casilla = new CasillaSudoku(fila, columna, logica);

                String bordeSuperior = (fila % 3 == 0) ? "2px" : "0.5px";
                String bordeDerecho = ((columna + 1) % 3 == 0) ? "2px" : "0.5px";
                String bordeInferior = ((fila + 1) % 3 == 0) ? "2px" : "0.5px";
                String bordeIzquierdo = (columna % 3 == 0) ? "2px" : "0.5px";

                casilla.setStyle("-fx-border-color: #333333; " +
                        "-fx-border-width: " +
                        bordeSuperior + " " +
                        bordeDerecho + " " +
                        bordeInferior + " " +
                        bordeIzquierdo + ";");

                grid.add(casilla, columna, fila);
            }
        }

        root.getChildren().add(grid);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Sudoku");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private int[][] obtenerTableroAleatorio() {
        Random rmd = new Random();
        int opcion = rmd.nextInt(3);

        int[][] tableroFacil = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        int[][] tableroIntermedio = {
                {0, 0, 0, 2, 6, 0, 7, 0, 1},
                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                {8, 2, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                {7, 0, 3, 0, 1, 8, 0, 0, 0}
        };

        int[][] tableroDificil = {
                {1, 0, 0, 4, 8, 9, 0, 0, 6},
                {7, 3, 0, 0, 0, 0, 0, 4, 0},
                {0, 0, 0, 0, 0, 1, 2, 9, 5},
                {0, 0, 7, 1, 2, 0, 6, 0, 0},
                {5, 0, 0, 7, 0, 3, 0, 0, 8},
                {0, 0, 6, 0, 9, 5, 7, 0, 0},
                {9, 1, 4, 6, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 3, 7},
                {8, 0, 0, 5, 1, 2, 0, 0, 4}
        };

        switch (opcion) {
            case 0:
                return tableroFacil;
            case 1:
                return tableroIntermedio;
            case 2:
                return tableroDificil;
            default:
                return tableroFacil;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}