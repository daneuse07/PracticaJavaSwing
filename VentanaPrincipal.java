import javax.swing.*;
public class VentanaPrincipal extends JFrame {
 public VentanaPrincipal() {
 setLayout(null);
 setTitle("Mi Primera Aplicacion Swing");
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 }
 public static void main(String[] args) {
 VentanaPrincipal ventana = new VentanaPrincipal();
 // Centrar en pantalla:
 int screenW =
java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
 int screenH =
java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
 ventana.setBounds((screenW - 800) / 2, (screenH - 600) / 2, 800, 600);
 ventana.setVisible(true);
 }
}