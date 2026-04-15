package uabc.david.practica3poo2026;

public class TableroSudoku {
    private int[][] matriz;
    private boolean[][] esCasillaFija;

    public TableroSudoku() {
        matriz = new int[9][9];
        esCasillaFija = new boolean[9][9];
    }

    public void cargarTablero(int[][] tableroInicial) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matriz[i][j] = tableroInicial[i][j];

                if (tableroInicial[i][j] != 0) {
                    esCasillaFija[i][j] = true;
                } else {
                    esCasillaFija[i][j] = false;
                }
            }
        }
    }

    public boolean validarPosicion(int fila, int columna, int valor) {
        if (valor == 0) {
            return true;
        }

        if (valor < 1 || valor > 9) {
            return false;
        }

        if (esCasillaFija[fila][columna]) {
            return false;
        }

        return false;
    }

}
