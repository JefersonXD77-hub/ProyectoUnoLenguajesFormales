package proyecto1;

import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 * @author Jeferson_Manuel_Aguilar_Panjoj////Carné:_202130718
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        LectorDelTextArea();

    }

    private Analizador analizadorActual;
    private List<Token> tokens = new ArrayList<>();
    private List<Token> tokensOptimizados = new ArrayList<>(); 
    private List<Token> tokensErrores = new ArrayList<>();
    private List<Token> tokensEliminados = new ArrayList<>();
    private String lenguajeActual;
    
    private void LectorDelTextArea() {
        jTextArea1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                analizarTexto(jTextArea1.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                analizarTexto(jTextArea1.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
    }

   private void analizarTexto(String texto) {
    tokens.clear();
    tokensOptimizados.clear();
    tokensErrores.clear();
    String[] lineas = texto.split("\n");

    for (int i = 0; i < lineas.length; i++) {
        String linea = lineas[i].trim();
        if (linea.startsWith(">>[html]")) {
            analizadorActual = new AnalizadorHTML();
            lenguajeActual = "HTML";
        } else if (linea.startsWith(">>[css]")) {
            analizadorActual = new AnalizadorCSS();
            lenguajeActual = "CSS";
        } else if (linea.startsWith(">>[js]")) {
            analizadorActual = new AnalizadorJavaS();
            lenguajeActual = "JavaScript";
        } else if (analizadorActual != null) {
            analizadorActual.analizar(linea, i + 1, 1);
            tokens.addAll(analizadorActual.getTokens());
        }
    }

    // Generar HTML solo si no hay errores
    if (tokensErrores.isEmpty()) {
        try {
            GeneradorHTML generadorHTML = new GeneradorHTML();
            generadorHTML.generarHTML(tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("Errores léxicos encontrados.");
    }
}



   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        reporteToken = new javax.swing.JButton();
        reporteOptimizacion = new javax.swing.JButton();
        reporteError = new javax.swing.JButton();
        GeneradorHTMLBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(0,0);
        setResizable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        reporteToken.setText("Reporte de Tokens");
        reporteToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteTokenActionPerformed(evt);
            }
        });

        reporteOptimizacion.setText("Reporte de Optimización");
        reporteOptimizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteOptimizacionActionPerformed(evt);
            }
        });

        reporteError.setText("Reporte de Error");
        reporteError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteErrorActionPerformed(evt);
            }
        });

        GeneradorHTMLBoton.setText("Generar HTML");
        GeneradorHTMLBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneradorHTMLBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reporteToken, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reporteOptimizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reporteError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GeneradorHTMLBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reporteToken, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(reporteOptimizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(reporteError, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GeneradorHTMLBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reporteTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteTokenActionPerformed
    String[] columnNames = {"Lenguaje", "Tipo", "Valor", "Fila", "Columna"};
    Object[][] data = new Object[tokens.size()][5];

    for (int i = 0; i < tokens.size(); i++) {
        Token token = tokens.get(i);
        data[i][0] = lenguajeActual; 
        data[i][1] = token.getTipo();
        data[i][2] = token.getValor();
        data[i][3] = token.getFila();
        data[i][4] = token.getColumna();
    }

    JTable table = new JTable(data, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    JFrame frame = new JFrame("Reporte de Tokens");
    frame.add(scrollPane);
    frame.setSize(600, 400);
    frame.setVisible(true);   
       
    }//GEN-LAST:event_reporteTokenActionPerformed

    private void generarHTML() {
        String inputText = jTextArea1.getText();
        StringBuilder htmlContent = new StringBuilder();

        // Comenzar estructura HTML
        htmlContent.append("<!DOCTYPE html>\n<html>\n<head>\n")
                   .append("<style>\n")
                   .append("body { font-size: 16px; }\n")
                   .append("</style>\n</head>\n<body>\n");

        // Procesar el texto del JTextArea
        String[] lines = inputText.split("\n");
        String currentSection = "";

        for (String line : lines) {
            if (line.startsWith(">>[html]")) {
                currentSection = "html";
                htmlContent.append("<div>\n<Lenguaje HTML>\n");
            } else if (line.startsWith(">>[css]")) {
                currentSection = "css";
                htmlContent.append("<style>\n/* Lenguaje CSS */\n");
            } else if (line.startsWith(">>[js]")) {
                currentSection = "js";
                htmlContent.append("<script>\n// Lenguaje JS\n");
            } else {
                if (currentSection.equals("html")) {
                    htmlContent.append(line).append("\n");
                } else if (currentSection.equals("css")) {
                    htmlContent.append(line).append("\n");
                } else if (currentSection.equals("js")) {
                    htmlContent.append(line).append("\n");
                }
            }
        }

        if (currentSection.equals("html")) {
            htmlContent.append("</div>\n");
        } else if (currentSection.equals("css")) {
            htmlContent.append("</style>\n");
        } else if (currentSection.equals("js")) {
            htmlContent.append("</script>\n");
        }

        htmlContent.append("</body>\n</html>");

        JPanel htmlPanel = new JPanel();
        JTextArea htmlOutput = new JTextArea(htmlContent.toString());
        htmlOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(htmlOutput);
        htmlPanel.setLayout(new BorderLayout());
        htmlPanel.add(scrollPane, BorderLayout.CENTER);

        JFrame outputFrame = new JFrame("HTML Generado");
        outputFrame.setSize(600, 400);
        outputFrame.add(htmlPanel);
        outputFrame.setVisible(true);

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.html"))) {
            writer.write(htmlContent.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    
    private void reporteOptimizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteOptimizacionActionPerformed
        String[] columnNames = {"Token", "Tipo", "Fila", "Columna"};
    Object[][] data = new Object[tokensOptimizados.size()][4];

    for (int i = 0; i < tokensOptimizados.size(); i++) {
        Token token = tokensOptimizados.get(i);
        data[i][0] = token.getValor();
        data[i][1] = token.getTipo();
        data[i][2] = token.getFila();
        data[i][3] = token.getColumna();
    }

    JTable table = new JTable(data, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    JFrame frame = new JFrame("Reporte de Optimización");
    frame.add(scrollPane);
    frame.setSize(600, 400);
    frame.setVisible(true);
    }//GEN-LAST:event_reporteOptimizacionActionPerformed

    private void reporteErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteErrorActionPerformed
        String[] columnNames = {"Token", "Lenguaje", "Sugerido", "Fila", "Columna"};
    Object[][] data = new Object[tokensErrores.size()][5];

    for (int i = 0; i < tokensErrores.size(); i++) {
        Token token = tokensErrores.get(i);
        data[i][0] = token.getValor();
        data[i][1] = "HTML"; 
        data[i][2] = "CSS"; 
        data[i][3] = token.getFila();
        data[i][4] = token.getColumna();
    }

    JTable table = new JTable(data, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    JFrame frame = new JFrame("Reporte de Errores");
    frame.add(scrollPane);
    frame.setSize(600, 400);
    frame.setVisible(true);
    }//GEN-LAST:event_reporteErrorActionPerformed

    private void GeneradorHTMLBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneradorHTMLBotonActionPerformed
        generarHTML(); 
    }//GEN-LAST:event_GeneradorHTMLBotonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GeneradorHTMLBoton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton reporteError;
    private javax.swing.JButton reporteOptimizacion;
    private javax.swing.JButton reporteToken;
    // End of variables declaration//GEN-END:variables
}
