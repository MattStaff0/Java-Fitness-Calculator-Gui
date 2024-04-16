//  imports 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class CustomDialog extends JDialog {
    public CustomDialog(JFrame parent, String title, String message, String analysis) {
        super(parent, title, true);

        JLabel label = new JLabel("<html>" + message + "</html>");
        JLabel label2 =new JLabel(analysis);
        JButton closeButton = new JButton("Close");

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        int padding = 20;
        panel.setBorder(new EmptyBorder(padding, padding, padding, padding));
        
        panel.add(label);
        panel.add(label2);

        panel.add(Box.createVerticalStrut(25));

        panel.add(closeButton);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent); // Center on parent frame

        // Set a larger preferred size
        int width = 500; // Adjust as needed
        int height = 150; // Adjust as needed
        setPreferredSize(new Dimension(width, height));
        setSize(new Dimension(width, height));
    }
}
