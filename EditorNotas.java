import javax.swing.*;
import java.awt.event.*;

// Importaciones necesarias para detectar cambios en el texto
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class EditorNotas extends JFrame implements ActionListener {
 private JTextArea areaNota;
 private JScrollPane scroll;
 private JTextField tfBuscar;
 private JButton btnContar, btnBuscar, btnLimpiar;
 private JLabel lblEstado;
 private JButton btnMayusculas;

 public EditorNotas() {
 setLayout(null);
 setTitle("Editor de Notas");
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 areaNota = new JTextArea();
 areaNota.setLineWrap(true);
 areaNota.setWrapStyleWord(true);

 // Se agrega un DocumentListener al área de texto
 // Esto permite detectar cuando el usuario escribe o borra texto
 areaNota.getDocument().addDocumentListener(new DocumentListener() {

    // Se ejecuta cuando se inserta texto
    public void insertUpdate(DocumentEvent e) {
        actualizarContador();
    }

    // Se ejecuta cuando se elimina texto
    public void removeUpdate(DocumentEvent e) {
        actualizarContador();
    }

    // Se ejecuta cuando hay cambios en el formato (no siempre se usa)
    public void changedUpdate(DocumentEvent e) {
        actualizarContador();
    }
 });

 scroll = new JScrollPane(areaNota);
 scroll.setBounds(10, 10, 560, 280);
 add(scroll);

 tfBuscar = new JTextField();
 tfBuscar.setBounds(10, 310, 200, 30);
 add(tfBuscar);

 btnBuscar = new JButton("Buscar");
 btnBuscar.setBounds(220, 310, 100, 30);
 btnBuscar.addActionListener(this);
 add(btnBuscar);

 btnContar = new JButton("Contar palabras");
 btnContar.setBounds(330, 310, 140, 30);
 btnContar.addActionListener(this);
 add(btnContar);

 btnLimpiar = new JButton("Limpiar");
 btnLimpiar.setBounds(480, 310, 90, 30);
 btnLimpiar.addActionListener(this);
 add(btnLimpiar);

 lblEstado = new JLabel("Listo.");
 lblEstado.setBounds(10, 360, 560, 25);
 add(lblEstado);

 btnMayusculas = new JButton("Mayusculas");
 btnMayusculas.setBounds(440, 350, 130, 30);
 btnMayusculas.addActionListener(this);
 add(btnMayusculas);
 }

 // Método creado para actualizar el contador de caracteres
 private void actualizarContador() {
    // Se obtiene la cantidad de caracteres del texto
    int caracteres = areaNota.getText().length();

    // Se muestra el total en la etiqueta de estado
    lblEstado.setText("Caracteres: " + caracteres);
 }

 @Override
 public void actionPerformed(ActionEvent e) {

 if (e.getSource() == btnMayusculas) {
    String texto = areaNota.getText();
    areaNota.setText(texto.toUpperCase());
    lblEstado.setText("Texto convertido a mayusculas.");
 }

 String texto = areaNota.getText();

 if (e.getSource() == btnContar) {
 if (texto.trim().isEmpty()) {
 lblEstado.setText("El area esta vacia.");
 } else {
 String[] palabras = texto.trim().split("\\s+");
 lblEstado.setText("Total de palabras: " + palabras.length);
 }
 }

 if (e.getSource() == btnBuscar) {
 String termino = tfBuscar.getText().trim();
 if (termino.isEmpty()) {
 lblEstado.setText("Escribe algo en el campo de busqueda.");
 return;
 }
 if (texto.contains(termino)) {
 lblEstado.setText("Encontrado: '" + termino + "' en el texto.");
 } else {
 lblEstado.setText("No se encontro: '" + termino + "'");
 }
 }

 if (e.getSource() == btnLimpiar) {
 areaNota.setText("");
 tfBuscar.setText("");
 lblEstado.setText("Listo.");
 }
 }

 public static void main(String[] args) {
 EditorNotas editor = new EditorNotas();
 editor.setBounds(150, 100, 600, 430);
 editor.setVisible(true);
 }
}