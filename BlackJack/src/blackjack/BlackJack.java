
package blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BlackJack {


public static JFrame windowConfig(){
            
    JFrame display = new JFrame();                          // JFrame Object 
    JPanel gamePanel = new JPanel();                        // Creates gamePanel Object that will fit in the JFrame
    
    display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes it so the application stops running when closed
    display.setResizable(false);                            // Makes it so that the Window cannot be resized
    display.setTitle("Blackjack");                          // Creates the Title of the window
    display.setSize(900, 675);                              // Size of Window
    
    display.setLocationRelativeTo(null);                    // Makes it so the application opens in the middle of the screen
    gamePanel.setLayout(new BorderLayout());                // Set the Game Panel to fit the JFrame
    gamePanel.setBackground(new Color(53, 101, 57));        // Set the background color to dark green
    display.add(gamePanel);                                 // Adds the Game Panel to the JFrame
    
    
    return display;
}

public static void buttonConfig(JFrame display){
    JButton hitButton = new JButton("Hit!");               // Creates button objects
    JButton stayButton = new JButton("Stay");   
    JPanel buttonPanel = new JPanel();                     // Creates JPanel for the Buttons 
 
    hitButton.setFocusable(true);                          // Allows the button to interact with input
    hitButton.addActionListener(null);                     // Creates output after button is pressed
    buttonPanel.add(hitButton);
    stayButton.setFocusable(true);
    stayButton.addActionListener(null);
    buttonPanel.add(stayButton);
    
    display.add(buttonPanel , BorderLayout.SOUTH);
}

    public static void main(String[] args) {
        JFrame display = windowConfig();
        buttonConfig(display);
        display.setVisible(true);                          // Visualizes the window (Makes it visable) 
        
        
        
   // Create two buttons Hit and Stand
   
   // Connect the Array data to the card data and graphics
   
   // Add shuffle feature for the deck of cards
   



    }
    
}
