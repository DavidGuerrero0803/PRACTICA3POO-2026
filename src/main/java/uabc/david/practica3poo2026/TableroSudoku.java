package uabc.david.practica3poo2026;

public class TableroSudoku {
    private int[][] matriz;
    private boolean[][] esCasillaFija;

    public TableroSudoku() {
        matriz = new int[9][9];
        esCasillaFija = new boolean[9][9];
    }

    public int getValor(int fila, int columna) {
        return matriz[fila][columna];
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

        if (verificarFila(fila, columna, valor) &&
                verificarColumna(fila, columna, valor) &&
                verificarSubcuadricula(fila, columna, valor)) {
            return true;
        }

        return false;
    }

    private boolean verificarFila(int fila, int columna, int valor) {
        for (int j = 0; j < 9; j++) {
            if (j != columna && matriz[fila][j] == valor) {
                return false;
            }
        }

        return true;
    }

    private boolean verificarColumna(int fila, int columna, int valor) {
        for (int i = 0; i < 9; i++) {
            if (i != fila && matriz[i][columna] == valor) {
                return false;
            }
        }

        return true;
    }

    private boolean verificarSubcuadricula(int fila, int columna, int valor) {
        int filaInicial = (fila / 3) * 3;
        int columnaInicial = (columna / 3) * 3;

        for (int i = filaInicial; i < filaInicial + 3; i++) {
            for (int j = columnaInicial; j < columnaInicial + 3; j++) {
                if (i != fila && j != columna && matriz[i][j] == valor) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean asignarValor(int fila, int columna, int valor) {
        if (validarPosicion(fila, columna, valor)) {
            matriz[fila][columna] = valor;
            return true;
        }
        return false;
    }

    public boolean esFija(int fila, int columna) {
        return esCasillaFija[fila][columna];
    }

    public boolean seHaCompletadoTablero() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matriz[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

}
