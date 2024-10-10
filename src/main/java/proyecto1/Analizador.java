
package proyecto1;

import java.util.ArrayList;
import java.util.List;

public abstract class Analizador {
    protected List<Token> tokens = new ArrayList<>();

    public abstract void analizar(String codigo, int fila, int columna);

    public List<Token> getTokens() {
        return tokens;
    }

    public void agregarToken(Token token) {
        tokens.add(token);
    }
}

