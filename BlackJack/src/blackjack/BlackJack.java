
package blackjack;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BlackJack {


public static JFrame windowConfig(){
            
    JFrame display = new JFrame();                          // JFrame Object 
    
    display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes it so the application stops running when closed
    display.setResizable(false);                            // Makes it so that the Window cannot be resized
    display.setTitle("Blackjack");                          // Creates the Title of the window
    display.setSize(900, 675);                              // Size of Window
    display.setLocationRelativeTo(null);                    // Makes it so the application opens in the middle of the screen
    
    return display;
}

public static void buttonConfig(JFrame display){
    JButton hitButton = new JButton("Hit!");
    hitButton.addActionListener(null);
    display.add(hitButton);
    
    JButton standButton = new JButton("Stand");
    hitButton.addActionListener(null);
    display.add(standButton);
}

    public static void main(String[] args) {
        JFrame display = windowConfig();
        buttonConfig(display);
        buttonConfig(display);
        display.setVisible(true);                             // Visualizes the window (Makes it visable) 
        
        
        
   // Create two buttons Hit and Stand
   
   // Connect the Array data to the card data and graphics
   
   // Add shuffle feature for the deck of cards
   



    }
    
}
