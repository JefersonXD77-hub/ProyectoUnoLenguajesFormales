
package proyecto1;

public class AnalizadorCSS extends Analizador {

    @Override
    public void analizar(String codigo, int fila, int column) {
        String[] lineas = codigo.split("\n");

        for (int i = 0; i < lineas.length; i++) {
            String linea = lineas[i].trim();
            int columna = 1;

          
            if (linea.startsWith(".")) {
                agregarToken(new Token("Selector_Clase", linea.split("\\s")[0], i + 1, columna));
            } else if (linea.startsWith("#")) {
                agregarToken(new Token("Selector_Id", linea.split("\\s")[0], i + 1, columna));
            } else if (esSelectorEtiqueta(linea)) {
                agregarToken(new Token("Selector_Etiqueta", linea.split("\\s")[0], i + 1, columna));
            }else if (esReglasCSS(linea)) {
                agregarToken(new Token("Selector_Etiqueta", linea.split("\\s")[0], i + 1, columna));
            } else if (otrosCSS(linea)) {
                agregarToken(new Token("Selector_Etiqueta", linea.split("\\s")[0], i + 1, columna));
            }

           
            String[] combinadores = {">", "+", "~", " "}; 
            for (String combinador : combinadores) {
                if (linea.contains(combinador)) {
                    agregarToken(new Token("Combinador", combinador, i + 1, columna));
                }
            }

        
            String[] partes = linea.split(":");
            if (partes.length == 2) {
                String propiedad = partes[0].trim();
                agregarToken(new Token("Propiedad_CSS", propiedad, i + 1, columna));
                columna += propiedad.length() + 1;
            }
        }
    }

    private boolean esSelectorEtiqueta(String linea) {
        String[] etiquetas = {"body", "header", "main", "nav", "aside", "div", "ul", "ol", "li", "a", "h1", "h2", "h3", "h4", "h5", "h6", "p", "span", "label", "textarea", "button", "section", "article", "footer"};
        for (String etiqueta : etiquetas) {
            if (linea.startsWith(etiqueta)) {
                return true;
            }
        }
        return false;
    }
    
     private boolean esReglasCSS(String regla) {
        String[] reglas = {"color", "background-color", "font-size", "margin", "padding", "border", "display", "width", "height", "position","static", "relative", "absolute", "sticky","fixed","top","bottom","left","right","z-index","justify.content", "aling.items","border-radius","auto","float","list-style","text-aling","box-shadow"};
        for (String reg : reglas) {
            if (regla.equals(reg)) {
                return true;
            }
        }
        return false;
    }
    private boolean otrosCSS(String otros) {
        String[] otros2 = {"px","%","rem","em","vw","vh",":hover",":active",":not()",":nth-child()","odd","even","::before", "::after", ":", ";", ",", "(", ")","a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (String otro : otros2) {
            if (otros.equals(otro)) {
                return true;
            }
        }
        return false;
    }
}

