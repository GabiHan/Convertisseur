import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Base {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Création de la fenêtre
            JFrame window = new JFrame("Convertisseur");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(800, 400);
            window.setLocationRelativeTo(null);
            window.setLayout(new BorderLayout());

            // Ajout d'un label d'introduction (centré)
            JPanel myIntro = new JPanel();
            myIntro.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centrer le texte
            JLabel intro = new JLabel("Bienvenue dans l'application de conversion !");  
            myIntro.add(intro);
            myIntro.setBorder(new EmptyBorder(10, 0, 10, 0)); // Espacement autour du panel
            window.add(myIntro, BorderLayout.NORTH); // Ajout au haut de la fenêtre

            // Ajout d'une question au centre, centrée aussi
            JPanel myQuest = new JPanel();
            myQuest.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centrer le texte
            JLabel quest = new JLabel("Veuillez choisir une option :");
            myQuest.add(quest);
            myQuest.setBorder(new EmptyBorder(20, 0, 20, 0)); // Espacement autour du panel
            window.add(myQuest, BorderLayout.WEST);

            /*JPanel imgPanel = new JPanel();
            imgPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centrer l'image
            ImageIcon imageIcon = new ImageIcon("1.png");  // Remplace par le chemin de ton image
            Image image = imageIcon.getImage().getScaledInstance(200, 400, Image.SCALE_SMOOTH); // Redimensionner l'image
            imageIcon = new ImageIcon(image); // Mettre à jour l'ImageIcon
            JLabel imageLabel = new JLabel(imageIcon);
            imgPanel.add(imageLabel);
            imgPanel.setBorder(new EmptyBorder(20, 0, 20, 0)); // Espacement autour du panel
            window.add(imgPanel, BorderLayout.EAST); 
            */
    

            // Ajout des boutons en "escaliers"
            JPanel groupButt = new JPanel();
            groupButt.setLayout(new GridBagLayout()); // Utilisation du GridBagLayout pour l'effet d'escalier
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;  // Colonne 0
            gbc.gridy = 0;  // Ligne 0

            // Définir un bouton avec une taille préférée
            JButton butt1 = new JButton("Convertisseur de nombres");
            butt1.setPreferredSize(new Dimension(300, 50)); // Redimensionner le bouton
            groupButt.add(butt1, gbc);

            // Espacement entre les boutons
            gbc.gridy = 2;  // Décalage d'une ligne pour créer l'effet d'escalier
            JButton butt2 = new JButton("Convertisseur de couleurs");
            butt2.setPreferredSize(new Dimension(300, 50)); // Redimensionner le bouton
            groupButt.add(butt2, gbc);

            gbc.gridy = 4;  // Décalage d'une autre ligne
            JButton butt3 = new JButton("Convertisseur du taux de compression");
            butt3.setPreferredSize(new Dimension(300, 50)); // Redimensionner le bouton
            groupButt.add(butt3, gbc);

            // Espacer les boutons avec "insets"
            gbc.insets = new Insets(10, 0, 10, 0); // Ajouter un espacement vertical entre les boutons

            groupButt.setBorder(new EmptyBorder(30, 0, 30, 0)); // Espacement autour du panel
            window.add(groupButt, BorderLayout.CENTER);

            // Ajout des actions sur les boutons

                        // Action pour le bouton Convertisseur de nombres
            butt1.addActionListener(e -> {
                // Ouvrir la fenêtre de conversion des nombres
                Nombre.openBinaryToDecimalConverter(window);
            });

            butt2.addActionListener(e -> {
                ColorConvertor.OpenColorConverter(window);
            });

            butt3.addActionListener(e -> {
                Compress.CompressConverterDialog(window);
            });
            



            window.setVisible(true);
        });
    }
}
