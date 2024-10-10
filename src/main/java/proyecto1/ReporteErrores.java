package proyecto1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReporteErrores {

    public void generarReporteErrores(List<Token> tokens) throws IOException {
        FileWriter archivo = new FileWriter("reporte_errores.html");
        archivo.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Reporte de Errores</title>\n</head>\n<body>\n");
        archivo.write("<h1>Reporte de Errores</h1>\n<table border='1'>\n<tr><th>Token</th><th>Lenguaje donde se encontró</th><th>Lenguaje sugerido</th><th>Fila</th><th>Columna</th></tr>\n");

        for (Token token : tokens) {
            archivo.write("<tr><td>" + token.getValor() + "</td><td>HTML</td><td>CSS</td><td>" + token.getFila() + "</td><td>" + token.getColumna() + "</td></tr>\n");
         
        }

        archivo.write("</table>\n</body>\n</html>");
        archivo.close();
    }
}

