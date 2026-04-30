import javax.swing.*;
public class Formulario extends JFrame { 
private JLabel label1,label2, label3;
public Formulario() { 
setLayout(null);
label1=new JLabel("Rojo"); 
label1.setBounds (10, 20, 100, 30);
add (label1);
label2=new JLabel ("Verde");
label2.setBounds (10,60, 100,30);
add (label2);
label3=new JLabel("Azul");
label3.setBounds (10, 100, 100, 30);
add(label3);
}
public static void main(String[] ar) {
Formulario formulariol=new Formulario();
formulariol.setBounds (0,0,300,200);
formulariol.setVisible(true);
}
}