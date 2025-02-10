import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorConvertor {
    public static void OpenColorConverter(JFrame parentWindow) {
        JDialog colorConverterDialog = new JDialog(parentWindow, "Convertisseur de couleurs");
        colorConverterDialog.setSize(400, 300);
        colorConverterDialog.setLocationRelativeTo(parentWindow);
        colorConverterDialog.setLayout(new GridLayout(4, 2, 10, 10));

        // Champs pour HEX et RGB
        JTextField hexField = new JTextField("#000000");
        JTextField rgbField = new JTextField("0,0,0");

        // Aperçu de la couleur
        JPanel colorPreview = new JPanel();
        colorPreview.setBackground(java.awt.Color.BLACK);
        colorPreview.setPreferredSize(new Dimension(50, 50));

        // Mise à jour de la couleur
        ActionListener updateColor = e -> {
            try {
                if (e.getSource() == hexField) {
                    java.awt.Color color = java.awt.Color.decode(hexField.getText());
                    rgbField.setText(color.getRed() + "," + color.getGreen() + "," + color.getBlue());
                    colorPreview.setBackground(color);
                } else if (e.getSource() == rgbField) {
                    String[] parts = rgbField.getText().split(",");
                    int r = Integer.parseInt(parts[0]);
                    int g = Integer.parseInt(parts[1]);
                    int b = Integer.parseInt(parts[2]);
                    java.awt.Color color = new java.awt.Color(r, g, b);
                    hexField.setText(String.format("#%02X%02X%02X", r, g, b));
                    colorPreview.setBackground(color);
                }
            } catch (Exception ex) {
                // Ignorer l'erreur si les valeurs ne sont pas valides
            }
        };

        hexField.addActionListener(updateColor);
        rgbField.addActionListener(updateColor);

        // Ajout des composants
        colorConverterDialog.add(new JLabel("HEX :"));
        colorConverterDialog.add(hexField);
        colorConverterDialog.add(new JLabel("RGB :"));
        colorConverterDialog.add(rgbField);
        colorConverterDialog.add(new JLabel("Aperçu :"));
        colorConverterDialog.add(colorPreview);

        colorConverterDialog.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        OpenColorConverter(frame);
    }
}
