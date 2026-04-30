import javax.swing.*;
import java.awt.event.*;

public class Cotizador extends JFrame implements ActionListener {

 private JLabel lblPlan, lblExtras, lblTotal;
 private JRadioButton rBasico, rProfesional, rEmpresarial;
 private ButtonGroup bgPlanes;

 private JCheckBox chkSoporte, chkBackup, chkSeguridad;

 private JButton btnCotizar, btnLimpiar;

 public Cotizador() {
  setLayout(null);
  setTitle("Cotizador de Servicios");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  lblPlan = new JLabel("Selecciona tu plan:");
  lblPlan.setBounds(20, 15, 200, 25);
  add(lblPlan);

  bgPlanes = new ButtonGroup();

  rBasico = new JRadioButton("Basico $199/mes");
  rProfesional = new JRadioButton("Profesional $399/mes");
  rEmpresarial = new JRadioButton("Empresarial $799/mes");

  rBasico.setBounds(20, 45, 250, 25);
  rProfesional.setBounds(20, 75, 250, 25);
  rEmpresarial.setBounds(20, 105, 250, 25);

  rBasico.setSelected(true);

  bgPlanes.add(rBasico);
  bgPlanes.add(rProfesional);
  bgPlanes.add(rEmpresarial);

  add(rBasico); add(rProfesional); add(rEmpresarial);

  lblExtras = new JLabel("Servicios adicionales:");
  lblExtras.setBounds(20, 145, 220, 25);
  add(lblExtras);

  chkSoporte = new JCheckBox("Soporte 24/7 +$99");
  chkBackup = new JCheckBox("Backup diario +$49");
  chkSeguridad = new JCheckBox("Seguridad Plus +$79");

  chkSoporte.setBounds(20, 175, 250, 25);
  chkBackup.setBounds(20, 205, 250, 25);
  chkSeguridad.setBounds(20, 235, 250, 25);

  add(chkSoporte); add(chkBackup); add(chkSeguridad);

  btnCotizar = new JButton("Ver cotizacion");
  btnCotizar.setBounds(20, 280, 160, 35);
  btnCotizar.addActionListener(this);
  add(btnCotizar);

  btnLimpiar = new JButton("Limpiar seleccion");
  btnLimpiar.setBounds(190, 280, 140, 35);
  btnLimpiar.addActionListener(this);
  add(btnLimpiar);

  lblTotal = new JLabel("Total mensual: $0.00");
  lblTotal.setBounds(20, 330, 300, 30);
  add(lblTotal);
 }

 @Override
 public void actionPerformed(ActionEvent e) {

  int total = 0;
  String resumen = "Resumen de cotizacion:\n\n";

  if (e.getSource() == btnLimpiar) {
   rBasico.setSelected(true);
   chkSoporte.setSelected(false);
   chkBackup.setSelected(false);
   chkSeguridad.setSelected(false);
   lblTotal.setText("Total mensual: $0.00");
   return;
  }

  if (rBasico.isSelected()) {
   total += 199;
   resumen += "Basico: $199\n";
  } else if (rProfesional.isSelected()) {
   total += 399;
   resumen += "Profesional: $399\n";
  } else if (rEmpresarial.isSelected()) {
   total += 799;
   resumen += "Empresarial: $799\n";
  }

  if (chkSoporte.isSelected()) {
   total += 99;
   resumen += "Soporte 24/7: $99\n";
  }

  if (chkBackup.isSelected()) {
   total += 49;
   resumen += "Backup diario: $49\n";
  }

  if (chkSeguridad.isSelected()) {
   total += 79;
   resumen += "Seguridad Plus: $79\n";
  }

  resumen += "\nTotal: $" + total + " MXN";

  lblTotal.setText(String.format("Total mensual: $%,d MXN", total));

  // Muestra el resumen detallado
  JOptionPane.showMessageDialog(this, resumen);
 }

 public static void main(String[] args) {
  Cotizador cot = new Cotizador();
  cot.setBounds(200, 150, 360, 420);
  cot.setVisible(true);
 }
}