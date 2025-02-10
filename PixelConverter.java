import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PixelConverter {

    public static void showConverter(JFrame parentWindow) {
        // Création de la boîte de dialogue
        JDialog sizeDialog = new JDialog(parentWindow, "Convertisseur Pixel → REM & %", true);
        sizeDialog.setSize(350, 200);
        sizeDialog.setLocationRelativeTo(parentWindow);
        sizeDialog.setLayout(new GridLayout(4, 2, 10, 10));

        // Labels et champs de saisie
        JLabel labelPx = new JLabel("Pixels (px) :");
        JTextField inputPx = new JTextField();
        JLabel labelRem = new JLabel("REM :");
        JTextField outputRem = new JTextField();
        JLabel labelPercent = new JLabel("Pourcentage (%) :");
        JTextField outputPercent = new JTextField();

        // Désactiver la modification des champs de sortie
        outputRem.setEditable(false);
        outputPercent.setEditable(false);

        // Bouton de conversion
        JButton convertButton = new JButton("Convertir");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double px = Double.parseDouble(inputPx.getText());
                    double rem = px / 16; // Conversion en REM (1rem = 16px par défaut)
                    double percent = (px / 16) * 100; // Conversion en %

                    outputRem.setText(String.format("%.2f", rem));
                    outputPercent.setText(String.format("%.2f%%", percent));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(sizeDialog, "Veuillez entrer une valeur numérique valide !");
                }
            }
        });

        // Ajout des composants
        sizeDialog.add(labelPx);
        sizeDialog.add(inputPx);
        sizeDialog.add(labelRem);
        sizeDialog.add(outputRem);
        sizeDialog.add(labelPercent);
        sizeDialog.add(outputPercent);
        sizeDialog.add(convertButton);

        sizeDialog.setVisible(true);
    }

    public static void main(String[] args) {
        // Fenêtre principale
        JFrame frame = new JFrame("Test");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Affichage du convertisseur
        showConverter(frame);
    }
}
