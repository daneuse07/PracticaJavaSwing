import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppConMenu extends JFrame implements ActionListener {

 private JMenuBar menuBar;
 private JMenu menuVista, menuTamano, menuAyuda;

 // Submenú dentro de Vista
 private JMenu menuHerramientas;

 private JMenuItem miRojo, miAzul, miVerde, miBlancoFondo;
 private JMenuItem mi800, mi1024, miMaximizar, miSalir, miAcerca;

 // Opciones de herramientas
 private JMenuItem miLimpiar, miColorRandom, miCambiarTexto;

 private JLabel lblInfo;

 public AppConMenu() {
  setLayout(null);
  setTitle("Aplicacion con Menu");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  menuBar = new JMenuBar();
  setJMenuBar(menuBar);

  // ===== MENU VISTA =====
  menuVista = new JMenu("Vista");
  menuBar.add(menuVista);

  miRojo = new JMenuItem("Fondo Rojo");
  miAzul = new JMenuItem("Fondo Azul");
  miVerde = new JMenuItem("Fondo Verde");
  miBlancoFondo = new JMenuItem("Restaurar fondo");

  // Atajos de teclado
  miRojo.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
  miAzul.setAccelerator(KeyStroke.getKeyStroke("ctrl A"));
  miVerde.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));
  miBlancoFondo.setAccelerator(KeyStroke.getKeyStroke("ctrl B"));

  miRojo.addActionListener(this);
  miAzul.addActionListener(this);
  miVerde.addActionListener(this);
  miBlancoFondo.addActionListener(this);

  menuVista.add(miRojo);
  menuVista.add(miAzul);
  menuVista.add(miVerde);
  menuVista.addSeparator();
  menuVista.add(miBlancoFondo);

  // ===== SUBMENU HERRAMIENTAS =====
  menuHerramientas = new JMenu("Herramientas");

  miLimpiar = new JMenuItem("Limpiar pantalla");
  miColorRandom = new JMenuItem("Color aleatorio");
  miCambiarTexto = new JMenuItem("Cambiar texto");

  miLimpiar.addActionListener(this);
  miColorRandom.addActionListener(this);
  miCambiarTexto.addActionListener(this);

  menuHerramientas.add(miLimpiar);
  menuHerramientas.add(miColorRandom);
  menuHerramientas.add(miCambiarTexto);

  menuVista.addSeparator();
  menuVista.add(menuHerramientas);

  // ===== MENU VENTANA =====
  menuTamano = new JMenu("Ventana");
  menuBar.add(menuTamano);

  mi800 = new JMenuItem("800 x 600");
  mi1024 = new JMenuItem("1024 x 768");

  // Opción para maximizar la ventana
  miMaximizar = new JMenuItem("Maximizar");

  miSalir = new JMenuItem("Salir");

  // Atajos
  miSalir.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));

  mi800.addActionListener(this);
  mi1024.addActionListener(this);
  miMaximizar.addActionListener(this);
  miSalir.addActionListener(this);

  menuTamano.add(mi800);
  menuTamano.add(mi1024);
  menuTamano.add(miMaximizar);
  menuTamano.addSeparator();
  menuTamano.add(miSalir);

  // ===== MENU AYUDA =====
  menuAyuda = new JMenu("Ayuda");
  menuBar.add(menuAyuda);

  miAcerca = new JMenuItem("Acerca de...");
  miAcerca.addActionListener(this);
  menuAyuda.add(miAcerca);

  // Contenido
  lblInfo = new JLabel("Usa el menu para interactuar");
  lblInfo.setBounds(20, 20, 400, 30);
  add(lblInfo);
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  Object src = e.getSource();
  Container fondo = getContentPane();

  // Cambiar colores
  if (src == miRojo) fondo.setBackground(new Color(220, 80, 80));
  else if (src == miAzul) fondo.setBackground(new Color(70, 130, 200));
  else if (src == miVerde) fondo.setBackground(new Color(80, 200, 120));
  else if (src == miBlancoFondo) fondo.setBackground(null);

  // Cambiar tamaño
  else if (src == mi800) setSize(800, 600);
  else if (src == mi1024) setSize(1024, 768);

  // Maximizar ventana
  else if (src == miMaximizar)
   setExtendedState(JFrame.MAXIMIZED_BOTH);

  // Confirmación antes de salir
  else if (src == miSalir) {
   int opcion = JOptionPane.showConfirmDialog(
    this,
    "¿Seguro que deseas salir?",
    "Confirmar salida",
    JOptionPane.YES_NO_OPTION
   );

   if (opcion == JOptionPane.YES_OPTION) {
    System.exit(0);
   }
  }

  // ===== HERRAMIENTAS =====

  // Limpia texto y fondo
  else if (src == miLimpiar) {
   lblInfo.setText("");
   fondo.setBackground(null);
  }

  // Aplica un color aleatorio
  else if (src == miColorRandom) {
   Color color = new Color(
    (int)(Math.random()*256),
    (int)(Math.random()*256),
    (int)(Math.random()*256)
   );
   fondo.setBackground(color);
  }

  // Permite cambiar el texto con un input
  else if (src == miCambiarTexto) {
   String nuevo = JOptionPane.showInputDialog("Escribe nuevo texto:");
   if (nuevo != null) {
    lblInfo.setText(nuevo);
   }
  }

  // Información
  else if (src == miAcerca) {
   JOptionPane.showMessageDialog(this,
    "Practica de Menus con Swing\nVersion 1.0",
    "Acerca de", JOptionPane.INFORMATION_MESSAGE);
  }
 }

 public static void main(String[] args) {
  AppConMenu app = new AppConMenu();
  app.setBounds(150, 100, 600, 400);
  app.setVisible(true);
 }
}