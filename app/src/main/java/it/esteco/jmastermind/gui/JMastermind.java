/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.esteco.jmastermind.gui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class JMastermind {

    private final JFrame frame;

    public static void main(String[] args) {
        ImageIcon smallHoleIcon = new ImageIcon(ClassLoader.getSystemResource("it/esteco/jmastermind/hole16.png"));
        ImageIcon largeHoleIcon = new ImageIcon(ClassLoader.getSystemResource("it/esteco/jmastermind/hole24.png"));
        ImageIcon gripperIcon = new ImageIcon(ClassLoader.getSystemResource("it/esteco/jmastermind/gripper.png"));
        SwingUtilities.invokeLater(() -> new JMastermind(smallHoleIcon, largeHoleIcon, gripperIcon).show());
    }

    public JMastermind(Icon smallHoleIcon, Icon largeHoleIcon, Icon gripperIcon) {
        frame = new JFrame("JMastermind");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        contentPane.setBackground(new Color(164, 116, 73));

        JLabel title = new JLabel("JMastermind");
        title.setFont(title.getFont().deriveFont(Font.ITALIC).deriveFont(24.0f));
        title.setOpaque(true);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(title, BorderLayout.NORTH);

        JPanel decodingBoard = new JPanel(new GridLayout(0, 1));
        decodingBoard.setOpaque(false);
        decodingBoard.add(new ShieldableRow(gripperIcon).getRow());
        for (int i = 0; i < 10; i++) {
            decodingBoard.add(new Row(smallHoleIcon, largeHoleIcon).getRow());
        }
        contentPane.add(decodingBoard, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(new JButton("Check"));
        buttonPanel.add(new JButton("Quit"));
        buttonPanel.add(new JButton("Help"));
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        frame.setContentPane(contentPane);
    }

    private void show() {
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
