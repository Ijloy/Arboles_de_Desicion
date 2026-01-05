import javax.swing.*;

public class Ventana {

    private JPanel Principal;
    private JTextField txtPrestamo;
    private JTextField txtIngreso;
    private JCheckBox cbHistorial;
    private JCheckBox cbDeudas;
    private JButton btnConfirmar;
    private JTextArea textArea1;

    public Ventana() {
        btnConfirmar.addActionListener(e -> evaluar());
    }

    private void evaluar() {
        try {
            double ingreso = Double.parseDouble(txtIngreso.getText());
            double monto = Double.parseDouble(txtPrestamo.getText());

            boolean historial = cbHistorial.isSelected();
            boolean deudas = cbDeudas.isSelected();

            String resultado = ArbolDecision.evaluarPrestamo(
                    ingreso, monto, deudas, historial
            );

            textArea1.setText(resultado);

        } catch (NumberFormatException ex) {
            textArea1.setText("ERROR: Ingrese valores numéricos válidos.");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Árbol de Decisión - Préstamos");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
