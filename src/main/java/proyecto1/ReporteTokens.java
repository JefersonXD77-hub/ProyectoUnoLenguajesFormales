package proyecto1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReporteTokens {

    
    
    
    public void generarReporteTokens(List<Token> tokens, String lenguaje) throws IOException {
        FileWriter archivo = new FileWriter("reporte_tokens.html");
        archivo.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Reporte de Tokens</title>\n</head>\n<body>\n");
        archivo.write("<h1>Reporte de Tokens</h1>\n<table border='1'>\n<tr><th>Lenguaje</th><th>Tipo</th><th>Valor</th><th>Fila</th><th>Columna</th></tr>\n");

        for (Token token : tokens) {
            archivo.write("<tr><td>" + lenguaje + "</td><td>" + token.getTipo() + "</td><td>" + token.getValor() + "</td><td>" + token.getFila() + "</td><td>" + token.getColumna() + "</td></tr>\n");
        }

        archivo.write("</table>\n</body>\n</html>");
        archivo.close();
    }

    
    
}
