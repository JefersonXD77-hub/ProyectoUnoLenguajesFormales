package proyecto1; 

import java.util.HashMap;
import java.util.Map;

public class AnalizadorHTML extends Analizador {

    private Map<String, String> traducciones;

    public AnalizadorHTML() {
        // Mapeo de traducción de etiquetas
        traducciones = new HashMap<>();
        traducciones.put("principal", "main");
        traducciones.put("encabezado", "header");
        traducciones.put("navegacion", "nav");
        traducciones.put("apartado", "aside");
        traducciones.put("listaordenada", "ul");
        traducciones.put("listadesordenada", "ol");
        traducciones.put("itemlista", "li");
        traducciones.put("anclaje", "a");
        traducciones.put("contenedor", "div");
        traducciones.put("seccion", "section");
        traducciones.put("articulo", "article");
        traducciones.put("titulo1", "h1");
        traducciones.put("titulo2", "h2");
        traducciones.put("titulo3", "h3");
        traducciones.put("titulo4", "h4");
        traducciones.put("titulo5", "h5");
        traducciones.put("titulo6", "h6");
        traducciones.put("parrafo", "p");
        traducciones.put("span", "span");
        traducciones.put("entrada", "input");
        traducciones.put("formulario", "form");
        traducciones.put("label", "label");
        traducciones.put("area", "textarea");
        traducciones.put("boton", "button");
        traducciones.put("piepagina", "footer");
        // Añadir más traducciones según sea necesario...
    }

    @Override
    public void analizar(String codigo, int fila, int columna) {
        String[] lineas = codigo.split("\n");
        boolean dentroEtiqueta = false; // Controlar si estamos dentro de una etiqueta

        for (int i = 0; i < lineas.length; i++) {
            String linea = lineas[i].trim();

            for (int j = 0; j < linea.length(); j++) {
                if (linea.charAt(j) == '<') {
                    int cierreEtiqueta = linea.indexOf('>', j);
                    if (cierreEtiqueta != -1) {
                        String etiqueta = linea.substring(j + 1, cierreEtiqueta).trim();
                        boolean esCierre = etiqueta.endsWith("/");

                        // Remover el slash final si es un cierre de etiqueta
                        if (esCierre) {
                            etiqueta = etiqueta.substring(0, etiqueta.length() - 1);
                        }

                        // Verificar si la etiqueta es una traducción
                        if (traducciones.containsKey(etiqueta)) {
                            etiqueta = traducciones.get(etiqueta);
                        }

                        // Generar el token con la etiqueta traducida
                        agregarToken(new Token("Etiqueta", esCierre ? etiqueta + "/" : etiqueta, fila, j + 1));
                        j = cierreEtiqueta; // Saltar al final de la etiqueta
                        dentroEtiqueta = true; // Indica que estamos dentro de una etiqueta
                    }
                } else if (linea.charAt(j) == '>') {
                    dentroEtiqueta = false; // Salimos de la etiqueta
                }

                // Si estamos fuera de una etiqueta, puede haber texto válido
                if (!dentroEtiqueta && linea.charAt(j) != '<' && linea.charAt(j) != '>') {
                    String texto = extraerTexto(linea, j);
                    if (!texto.isEmpty()) {
                        agregarToken(new Token("Texto", texto, fila, j + 1));
                        j += texto.length() - 1; // Saltar el texto procesado
                    }
                }
            }

            // Dividir la línea para verificar las palabras reservadas
            String[] palabras = linea.split(" ");
            for (String palabra : palabras) {
                if (esPalabraReservada(palabra)) {
                    agregarToken(new Token("Palabra_Reservada", palabra, fila, linea.indexOf(palabra) + 1));
                }
            }
        }
    }

    /**
     * Método para extraer una cadena de texto entre caracteres.
     * Solo es válido si no está dentro de una etiqueta.
     */
    private String extraerTexto(String linea, int inicio) {
        StringBuilder texto = new StringBuilder();
        for (int i = inicio; i < linea.length(); i++) {
            char c = linea.charAt(i);
            if (c == '<' || c == '>') {
                break; // Detener si encontramos otra etiqueta
            }
            texto.append(c);
        }
        return texto.toString().trim();
    }

    private boolean esPalabraReservada(String palabra) {
        String[] reservadas = {"class", "id", "style", "type", "name", "href", "onClick", "placeholder", "required"};
        for (String reservada : reservadas) {
            if (palabra.contains(reservada)) {
                return true;
            }
        }
        return false;
    }
}