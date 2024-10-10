
package proyecto1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorHTML {

    public void generarHTML(List<Token> tokens) throws IOException {
        StringBuilder htmlContent = new StringBuilder();

        // Estructura inicial del HTML
        htmlContent.append("<!DOCTYPE html>\n")
                   .append("<html lang=\"en\">\n")
                   .append("<head>\n")
                   .append("<meta charset=\"UTF-8\">\n")
                   .append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n")
                   .append("<title>Documento Generado</title>\n");

        StringBuilder cssContent = new StringBuilder();
        StringBuilder jsContent = new StringBuilder();
        StringBuilder bodyContent = new StringBuilder();

        bodyContent.append("<body>\n");

        String currentSection = "html"; // Para controlar la sección actual (HTML, CSS, JS)

        // Procesar los tokens
        for (Token token : tokens) {
            switch (token.getTipo()) {
                case "Etiqueta":
                    // Añadir etiquetas solo si estamos en la sección HTML
                    if (currentSection.equals("html")) {
                        bodyContent.append("<").append(token.getValor()).append(">\n");
                    }
                    break;

                case "Etiqueta_Cierre":
                    if (currentSection.equals("html")) {
                        bodyContent.append("</").append(token.getValor()).append(">\n");
                    }
                    break;

                case "Texto":
                    if (currentSection.equals("html")) {
                        bodyContent.append(token.getValor()).append("\n");
                    }
                    break;

                case "CSS":
                    currentSection = "css"; // Cambiamos a la sección CSS
                    cssContent.append(token.getValor()).append("\n");
                    break;

                case "JS":
                    currentSection = "js"; // Cambiamos a la sección JS
                    jsContent.append(token.getValor()).append("\n");
                    break;

                default:
                    // Manejo de otros tipos de tokens si es necesario
                    break;
            }
        }

        // Cerrar las etiquetas HTML, CSS y JS
        bodyContent.append("</body>\n");
        htmlContent.append("<style>\n").append(cssContent.toString()).append("</style>\n");
        htmlContent.append("</head>\n");
        htmlContent.append(bodyContent.toString());
        htmlContent.append("<script>\n").append(jsContent.toString()).append("</script>\n");
        htmlContent.append("</html>");

        // Guardar el archivo generado
        try (FileWriter archivo = new FileWriter("salida.html")) {
            archivo.write(htmlContent.toString());
        }
    }
}
