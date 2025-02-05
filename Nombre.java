import javax.swing.*;
import java.awt.*;

public class Nombre {
    // Méthode pour ouvrir la fenêtre de conversion de nombres
    public static void openBinaryToDecimalConverter(JFrame parentWindow) {
        JDialog converterDialog = new JDialog(parentWindow, "Convertisseur Binaire → Décimal", true);
        converterDialog.setSize(400, 300);
        converterDialog.setLocationRelativeTo(parentWindow);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel label1 = new JLabel("Entrez un nombre binaire :");
        JTextField inputField = new JTextField();
        JLabel resultLabel = new JLabel("Résultat (Décimal) :");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        JButton convertButton = new JButton("Convertir");

        panel.add(label1);
        panel.add(inputField);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(new JLabel());
        panel.add(convertButton);

        convertButton.addActionListener(e -> {
            try {
                String binaryString = inputField.getText();
                int decimalResult = Integer.parseInt(binaryString, 2); // Conversion binaire → décimal
                resultField.setText(String.valueOf(decimalResult));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(converterDialog, "Veuillez entrer un nombre binaire valide !");
            }
        });

        converterDialog.add(panel);
        converterDialog.setVisible(true);
    }

    // Méthode pour ouvrir la fenêtre de conversion Décimal → Binaire
    public static void openDecimalToBinaryConverter(JFrame parentWindow) {
        JDialog converterDialog = new JDialog(parentWindow, "Convertisseur Décimal → Binaire", true);
        converterDialog.setSize(400, 300);
        converterDialog.setLocationRelativeTo(parentWindow);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel label1 = new JLabel("Entrez un nombre décimal :");
        JTextField inputField = new JTextField();
        JLabel resultLabel = new JLabel("Résultat (Binaire) :");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        JButton convertButton = new JButton("Convertir");

        panel.add(label1);
        panel.add(inputField);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(new JLabel());
        panel.add(convertButton);

        convertButton.addActionListener(e -> {
            try {
                int decimalValue = Integer.parseInt(inputField.getText());
                String binaryResult = Integer.toBinaryString(decimalValue); // Conversion décimal → binaire
                resultField.setText(binaryResult);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(converterDialog, "Veuillez entrer un nombre décimal valide !");
            }
        });

        converterDialog.add(panel);
        converterDialog.setVisible(true);
    }
}
