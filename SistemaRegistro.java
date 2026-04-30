package ejercicio8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SistemaRegistro extends JFrame implements ActionListener {

    // Campos de texto
    private JTextField tfNombre, tfMatricula, tfPromedio;

    // ComboBox
    private JComboBox<String> cmbCarrera;

    // RadioButtons
    private JRadioButton rMatutino, rVespertino, rNocturno;
    private ButtonGroup bgTurno;

    // CheckBox
    private JCheckBox chkBiblioteca, chkDeportes, chkCafeteria;

    private JButton btnRegistrar;

    // Área de registros
    private JTextArea areaRegistros;

    // Menú
    private JMenuBar menuBar;
    private JMenu menuArchivo;
    private JMenuItem miNuevo, miLimpiar, miExportar, miSalir;

    public SistemaRegistro() {
        setLayout(null);
        setTitle("Sistema de Registro de Estudiantes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(220, 235, 250));

        // ===== CAMPOS =====
        add(new JLabel("Nombre:")).setBounds(40, 40, 100, 25);
        tfNombre = new JTextField();
        tfNombre.setBounds(140, 40, 220, 25);
        add(tfNombre);

        add(new JLabel("Matricula:")).setBounds(40, 80, 100, 25);
        tfMatricula = new JTextField();
        tfMatricula.setBounds(140, 80, 220, 25);
        add(tfMatricula);

        add(new JLabel("Promedio:")).setBounds(40, 120, 100, 25);
        tfPromedio = new JTextField();
        tfPromedio.setBounds(140, 120, 220, 25);
        add(tfPromedio);

        // ===== COMBOBOX =====
        add(new JLabel("Carrera:")).setBounds(40, 160, 100, 25);
        String[] carreras = {"Sistemas","Industrial","Mecatronica","Electronica","Administracion"};
        cmbCarrera = new JComboBox<>(carreras);
        cmbCarrera.setBounds(140, 160, 220, 25);
        add(cmbCarrera);

        // ===== RADIOBUTTONS =====
        add(new JLabel("Turno:")).setBounds(40, 200, 100, 25);

        rMatutino = new JRadioButton("Matutino");
        rVespertino = new JRadioButton("Vespertino");
        rNocturno = new JRadioButton("Nocturno");

        rMatutino.setOpaque(false);
        rVespertino.setOpaque(false);
        rNocturno.setOpaque(false);

        rMatutino.setBounds(140, 200, 100, 25);
        rVespertino.setBounds(240, 200, 110, 25);
        rNocturno.setBounds(350, 200, 100, 25);

        bgTurno = new ButtonGroup();
        bgTurno.add(rMatutino);
        bgTurno.add(rVespertino);
        bgTurno.add(rNocturno);

        add(rMatutino); 
        add(rVespertino); 
        add(rNocturno);

        // ===== CHECKBOX =====
        add(new JLabel("Servicios:")).setBounds(40, 240, 100, 25);

        chkBiblioteca = new JCheckBox("Biblioteca");
        chkDeportes = new JCheckBox("Deportes");
        chkCafeteria = new JCheckBox("Cafeteria");

        chkBiblioteca.setOpaque(false);
        chkDeportes.setOpaque(false);
        chkCafeteria.setOpaque(false);

        chkBiblioteca.setBounds(140, 240, 100, 25);
        chkDeportes.setBounds(240, 240, 100, 25);
        chkCafeteria.setBounds(340, 240, 100, 25);

        add(chkBiblioteca); 
        add(chkDeportes); 
        add(chkCafeteria);

        // ===== BOTÓN =====
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(170, 280, 140, 40);

        btnRegistrar.setBackground(new Color(70, 130, 200)); 
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);

        btnRegistrar.addActionListener(this);
        add(btnRegistrar);

        // ===== TEXTAREA =====
        areaRegistros = new JTextArea();
        areaRegistros.setBackground(new Color(245, 250, 255));
        areaRegistros.setBorder(BorderFactory.createLineBorder(new Color(150, 180, 220)));

        JScrollPane scroll = new JScrollPane(areaRegistros);
        scroll.setBounds(40, 340, 420, 150);
        add(scroll);

        // ===== MENÚ =====
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuArchivo = new JMenu("Archivo");
        menuBar.add(menuArchivo);

        miNuevo = new JMenuItem("Nuevo registro");
        miLimpiar = new JMenuItem("Limpiar lista");
        miExportar = new JMenuItem("Exportar");
        miSalir = new JMenuItem("Salir");

        miNuevo.addActionListener(this);
        miLimpiar.addActionListener(this);
        miExportar.addActionListener(this);
        miSalir.addActionListener(this);

        menuArchivo.add(miNuevo);
        menuArchivo.add(miLimpiar);
        menuArchivo.addSeparator();
        menuArchivo.add(miExportar);
        menuArchivo.addSeparator();
        menuArchivo.add(miSalir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();

        // ===== REGISTRAR =====
        if (src == btnRegistrar) {

            String nombre = tfNombre.getText().trim();
            String matricula = tfMatricula.getText().trim();
            String promedioStr = tfPromedio.getText().trim();

            if (nombre.isEmpty() || matricula.isEmpty() || promedioStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Completa todos los campos");
                return;
            }

            double promedio;
            try {
                promedio = Double.parseDouble(promedioStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Promedio invalido");
                return;
            }

            if (!rMatutino.isSelected() && !rVespertino.isSelected() && !rNocturno.isSelected()) {
                JOptionPane.showMessageDialog(this, "Selecciona un turno");
                return;
            }

            String turno = "";
            if (rMatutino.isSelected()) turno = "Matutino";
            else if (rVespertino.isSelected()) turno = "Vespertino";
            else if (rNocturno.isSelected()) turno = "Nocturno";

            String servicios = "";
            if (chkBiblioteca.isSelected()) servicios += "Biblioteca ";
            if (chkDeportes.isSelected()) servicios += "Deportes ";
            if (chkCafeteria.isSelected()) servicios += "Cafeteria ";

            String registro = "Nombre: " + nombre +
                    " | Matricula: " + matricula +
                    " | Promedio: " + promedio +
                    " | Carrera: " + cmbCarrera.getSelectedItem() +
                    " | Turno: " + turno +
                    " | Servicios: " + servicios + "\n";

            areaRegistros.append(registro);
        }

        // ===== MENÚ =====
        else if (src == miNuevo) {
            tfNombre.setText("");
            tfMatricula.setText("");
            tfPromedio.setText("");
            bgTurno.clearSelection();
            chkBiblioteca.setSelected(false);
            chkDeportes.setSelected(false);
            chkCafeteria.setSelected(false);
        }

        else if (src == miLimpiar) {
            areaRegistros.setText("");
        }

        // 🔥 EXPORTAR (solo mensaje)
        else if (src == miExportar) {
            JOptionPane.showMessageDialog(this, "Función de exportar ejecutada");
        }

        else if (src == miSalir) {
            int op = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas salir?");
            if (op == JOptionPane.YES_OPTION) System.exit(0);
        }
    }

    public static void main(String[] args) {
        SistemaRegistro s = new SistemaRegistro();
        s.setBounds(200, 100, 520, 560);
        s.setVisible(true);
    }
}