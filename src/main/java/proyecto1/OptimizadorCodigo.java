
package proyecto1;
import java.util.List;

public class OptimizadorCodigo {
    
    public String optimizarCodigo(String codigo) {
        StringBuilder codigoOptimizado = new StringBuilder();
        String[] lineas = codigo.split("\n");
        
        for (String linea : lineas) {
            if (linea.contains("//")) {
                linea = linea.substring(0, linea.indexOf("//"));
            }
            if (!linea.trim().isEmpty()) {
                codigoOptimizado.append(linea).append("\n");
            }
        }
        
        return codigoOptimizado.toString();
    }

    public void generarReporteOptimizacion(String codigoOriginal, String codigoOptimizado) {
     
        String[] lineasOriginal = codigoOriginal.split("\n");
        String[] lineasOptimizadas = codigoOptimizado.split("\n");

        System.out.println("Reporte de Optimización:");
        for (int i = 0; i < lineasOriginal.length; i++) {
            if (i >= lineasOptimizadas.length || !lineasOriginal[i].equals(lineasOptimizadas[i])) {
                System.out.println("Línea eliminada: " + lineasOriginal[i]);
            }
        }
    }
}
