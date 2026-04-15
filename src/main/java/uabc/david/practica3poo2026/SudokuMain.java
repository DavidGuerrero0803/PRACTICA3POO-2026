package uabc.david.practica3poo2026;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SudokuMain extends Application {
    private TableroSudoku logica = new TableroSudoku();

    @Override
    public void start(Stage primaryStage) {
        int[][] tablero = {
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

        logica.cargarTablero(tablero);

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

    public static void main(String[] args) {
        launch();
    }
}