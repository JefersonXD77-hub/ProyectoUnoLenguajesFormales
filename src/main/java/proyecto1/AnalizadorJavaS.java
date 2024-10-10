
package proyecto1;

public class AnalizadorJavaS extends Analizador {

    @Override
    public void analizar(String codigo, int fila, int columna) {
        String[] lineas = codigo.split("\n");

        for (int i = 0; i < lineas.length; i++) {
            String linea = lineas[i].trim();
            String[] palabras = linea.split("\\s+");
            for (String palabra : palabras) {
                if (esPalabraReservada(palabra)) {
                    agregarToken(new Token("Palabra_Reservada", palabra, i + 1, columna));
                } else if (esOperador(palabra)) {
                    agregarToken(new Token("Operador", palabra, i + 1, columna));
                } else if (esIdentificador(palabra)) {
                    agregarToken(new Token("Identificador", palabra, i + 1, columna));
                } else if (esTipoDeDato(palabra)) {
                    agregarToken(new Token("Tipo_De_Dato", palabra, i + 1, columna));
                } else if (esComentario(palabra)) {
                    agregarToken(new Token("Comentario", palabra, i + 1, columna));
                }

                // Actualiza la columna para el siguiente token
                columna += palabra.length() + 1; 
            }
        }
    }

    private boolean esPalabraReservada(String palabra) {
        String[] reservadas = {
            "function", "const", "let", "document", "event", 
            "alert", "for", "while", "if", "else", 
            "return", "console.log", "null"
        };
        for (String reservada : reservadas) {
            if (palabra.equals(reservada)) {
                return true;
            }
        }
        return false;
    }

    private boolean esOperador(String palabra) {
        String[] operadores = {
            "+", "-", "*", "/", "==", "&&", "||", 
            ">", "<", ">=", "<=", "!="
        };
        for (String operador : operadores) {
            if (palabra.equals(operador)) {
                return true;
            }
        }
        return false;
    }

    private boolean esIdentificador(String palabra) {
        return palabra.matches("[a-zA-Z]([a-zA-Z]|[0-9]|[_])*");
    }

    private boolean esTipoDeDato(String palabra) {
        return palabra.matches("[0-9]+|[0-9]+\\.[0-9]+|\"[^\"]*\"|'[^']*'|`[^`]*`|true|false");
    }

    private boolean esComentario(String palabra) {
        return palabra.startsWith("//");
    }
}
