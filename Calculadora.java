import javax.swing.*;
import java.awt.event.*;

public class Calculadora extends JFrame implements ActionListener {
    private JLabel lblNum1, lblNum2, lblOp, lblResultado;
    // Etiqueta para mostrar la operación completa
    private JLabel lblOperacion;
    private JTextField tfNum1, tfNum2;
    private JComboBox<String> cmbOperacion;
    private JButton btnCalcular;

    public Calculadora() {
        setLayout(null);
        setTitle("Calculadora Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblNum1 = new JLabel("Numero 1:");
        lblNum1.setBounds(20, 20, 100, 25);
        add(lblNum1);

        tfNum1 = new JTextField();
        tfNum1.setBounds(130, 20, 120, 25);
        add(tfNum1);

        lblNum2 = new JLabel("Numero 2:");
        lblNum2.setBounds(20, 60, 100, 25);
        add(lblNum2);

        tfNum2 = new JTextField();
        tfNum2.setBounds(130, 60, 120, 25);
        add(tfNum2);

        lblOp = new JLabel("Operacion:");
        lblOp.setBounds(20, 100, 100, 25);
        add(lblOp);

        // Se agregó la opción de Potencia al ComboBox
        String[] ops = { "Suma (+)", "Resta (-)", "Multiplicacion (*)",
                         "Division (/)", "Potencia (^)" };

        cmbOperacion = new JComboBox<>(ops);
        cmbOperacion.setBounds(130, 100, 180, 25);
        add(cmbOperacion);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(130, 145, 120, 35);
        btnCalcular.addActionListener(this);
        add(btnCalcular);

        lblResultado = new JLabel("Resultado: ---");
        lblResultado.setBounds(20, 200, 320, 30);
        add(lblResultado);

        // Se crea la etiqueta para mostrar la operación completa
        lblOperacion = new JLabel("Operacion: ---");
        lblOperacion.setBounds(20, 230, 320, 25);
        add(lblOperacion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(tfNum1.getText().trim());
            double n2 = Double.parseDouble(tfNum2.getText().trim());

            int opIndex = cmbOperacion.getSelectedIndex();
            double resultado = 0;

            switch (opIndex) {
                case 0: resultado = n1 + n2; break;
                case 1: resultado = n1 - n2; break;
                case 2: resultado = n1 * n2; break;

                case 3:
                    if (n2 == 0) {
                        lblResultado.setText("Error: Division por cero");
                        return;
                    }
                    resultado = n1 / n2;
                    break;

                // Se calcula la potencia usando Math.pow
                case 4:
                    resultado = Math.pow(n1, n2);
                    break;
            }

            lblResultado.setText(String.format("Resultado: %.2f", resultado));

            // Se obtiene el símbolo de la operación seleccionada
            String simbolo = "";
            switch (opIndex) {
                case 0: simbolo = "+"; break;
                case 1: simbolo = "-"; break;
                case 2: simbolo = "*"; break;
                case 3: simbolo = "/"; break;
                case 4: simbolo = "^"; break;
            }

            // Se muestra la operación completa en la etiqueta
            lblOperacion.setText(n1 + " " + simbolo + " " + n2 + " = " + resultado);

        } catch (NumberFormatException ex) {
            lblResultado.setText("Error: ingresa valores numericos validos");
        }
    }

    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        c.setBounds(250, 200, 380, 300);
        c.setVisible(true);
    }
}