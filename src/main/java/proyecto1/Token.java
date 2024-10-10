
package proyecto1;

public class Token {
    private String tipo;
    private String valor;
    private int fila;
    private int columna;

    public Token(String tipo, String valor, int fila, int columna) {
        this.tipo = tipo;
        this.valor = valor;
        this.fila = fila;
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public String toString() {
        return "Token{" + "tipo=" + tipo + ", valor=" + valor + ", fila=" + fila + ", columna=" + columna + '}';
    }
}
