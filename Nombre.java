import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Nombre {
    // Méthode pour ouvrir la fenêtre de conversion de nombres
    public static void openBinaryToDecimalConverter(JFrame parentWindow) {
        JDialog converterDialog = new JDialog(parentWindow, "Convertisseur Binaire → Décimal", true);
        converterDialog.setSize(400, 300);
        converterDialog.setLocationRelativeTo(parentWindow);

        JPanel userInput = new JPanel();
        userInput.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel UI = new JLabel("Veuillez entrer un nombre binaire :");
        JTextField enter = new JTextField();
        enter.setPreferredSize(new Dimension(100,50));
        userInput.add(UI);
        userInput.add(enter);
        userInput.setBorder(new EmptyBorder(10,0,10,0));
        converterDialog.add(userInput, BorderLayout.NORTH);

        JPanel inputResult = new JPanel();
        inputResult.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel res = new JLabel("Résultat décimal");
        JTextField outRes = new JTextField();
        outRes.setPreferredSize(new Dimension(100,50));
        inputResult.add(res);
        inputResult.add(outRes);
        inputResult.setBorder(new EmptyBorder(10,0,10,0));
        outRes.setEditable(false);
        converterDialog.add(inputResult, BorderLayout.SOUTH);


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton convertButton = new JButton("Convertir");
        panel.add(convertButton);
        converterDialog.add(panel, BorderLayout.CENTER);

        convertButton.addActionListener(e -> {
            try {
                String binaryString = enter.getText();
                int decimalResult = Integer.parseInt(binaryString, 2); // Conversion binaire → décimal
                outRes.setText(String.valueOf(decimalResult));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(converterDialog, "Veuillez entrer un nombre binaire valide !");
            }
        });

        
        converterDialog.setVisible(true);
    }
}
