package main.DAO;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import main.ui.SignupFrame;

public class hello extends JFrame {
    private JButton saveButton;

    public static void main(String[] args) {
        // Create an instance of MyFrame
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new hello();
            }
        });
    }

    public hello() {
        setTitle("Save Frame as Image");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create save button
        saveButton = new JButton("Save as Image");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2d = image.createGraphics();
                    getContentPane().paint(g2d);
                    g2d.dispose();

                    /*// Get the size of the frame
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    Rectangle screenRectangle = new Rectangle(screenSize);
                    
                    // Capture the frame as an image
                    Robot robot = new Robot();
                    BufferedImage image = robot.createScreenCapture(screenRectangle);*/
                    
                    // Choose the file to save the image
                    JFileChooser fileChooser = new JFileChooser();
                    int option = fileChooser.showSaveDialog(hello.this);
                    if (option == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        
                        // Save the image to the selected file
                        ImageIO.write(image, "png", selectedFile);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        // Add the save button to the frame
        add(saveButton, BorderLayout.CENTER);
        
        setVisible(true);
    }
}

