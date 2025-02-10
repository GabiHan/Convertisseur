import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Compress {
    public static void CompressConverterDialog(JFrame parentWindow) {
        JDialog compressConverterDialog = new JDialog(parentWindow, "Convertisseur de taux de compression");
        compressConverterDialog.setSize(400, 200);
        compressConverterDialog.setLocationRelativeTo(parentWindow);
        compressConverterDialog.setLayout(new GridLayout(4, 2, 10, 10));

        // Création des composants
        JLabel labelInitialSize = new JLabel("Taille initiale (Ko) :");
        JTextField fieldInitialSize = new JTextField();
        
        JLabel labelCompressedSize = new JLabel("Taille compressée (Ko) :");
        JTextField fieldCompressedSize = new JTextField();
        
        JButton btnCalculate = new JButton("Calculer");
        JLabel labelResult = new JLabel("Taux de compression : ");

        // Action du bouton de calcul
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double initialSize = Double.parseDouble(fieldInitialSize.getText());
                    double compressedSize = Double.parseDouble(fieldCompressedSize.getText());
                    
                    if (initialSize > 0 && compressedSize > 0 && compressedSize <= initialSize) {
                        double compressionRate = (1 - (compressedSize / initialSize)) * 100;
                        labelResult.setText(String.format("Taux de compression : %.2f%%", compressionRate));
                    } else {
                        labelResult.setText("Valeurs incorrectes !");
                    }
                } catch (NumberFormatException ex) {
                    labelResult.setText("Entrée invalide !");
                }
            }
        });

        // Ajout des composants à la boîte de dialogue
        compressConverterDialog.add(labelInitialSize);
        compressConverterDialog.add(fieldInitialSize);
        compressConverterDialog.add(labelCompressedSize);
        compressConverterDialog.add(fieldCompressedSize);
        compressConverterDialog.add(new JLabel());  // Espacement
        compressConverterDialog.add(btnCalculate);
        compressConverterDialog.add(new JLabel());  // Espacement
        compressConverterDialog.add(labelResult);

        compressConverterDialog.setVisible(true);
    }
}
