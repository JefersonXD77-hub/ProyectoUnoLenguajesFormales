package proyecto1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReporteOptimizacion {

    public void generarReporteOptimizacion(List<Token> tokens, List<Token> eliminados) throws IOException {
    FileWriter archivo = new FileWriter("reporte_optimizacion.html");
    archivo.write("<!DOCTYPE html>\n<html>\n<head>\n<title>Reporte de Optimización</title>\n</head>\n<body>\n");
    archivo.write("<h1>Reporte de Optimización</h1>\n<table border='1'>\n<tr><th>Token</th><th>Tipo</th><th>Fila</th><th>Columna</th></tr>\n");

    for (Token token : eliminados) {
        archivo.write("<tr><td>" + token.getValor() + "</td><td>" + token.getTipo() + "</td><td>" + token.getFila() + "</td><td>" + token.getColumna() + "</td></tr>\n");
    }

    archivo.write("</table>\n</body>\n</html>");
    archivo.close();
}

}
