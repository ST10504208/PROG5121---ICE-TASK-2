
package blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
<<<<<<< Updated upstream
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
=======
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
>>>>>>> Stashed changes

public class BlackJack {

<<<<<<< Updated upstream
=======
    ArrayList<Card> deck;
    public int indexnum = 4;
    public boolean hit = false;
    public boolean stand = false;
    public int UserAmount = 0;
    public int DealerAmount = 0;
    
    
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
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
   

=======
    public static JFrame windowConfig() {

        JFrame display = new JFrame();                          // JFrame Object 
        JPanel gamePanel = new JPanel();
        // Creates gamePanel Object that will fit in the JFrame

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

    public void buttonConfig(JFrame display,String dealersHand, String playerHand, int UsersHandNum, int DealersHandNum) {
        
                
        int cardWidth = 110;
        int cardHeight = 154;
                
        
        JButton hitButton = new JButton("Hit!");               // Creates button objects
        JButton stayButton = new JButton("Stay");
        JPanel buttonPanel = new JPanel() {
                  @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            try {
                //draw hidden card
                Image hiddenCardImg = new ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();
                if (!stayButton.isEnabled()) {
                    hiddenCardImg = new ImageIcon(getClass().getResource(hiddenCard.getImagePath())).getImage();
                }
                g.drawImage(hiddenCardImg, 20, 20, cardWidth, cardHeight, null);

                //draw dealer's hand
                for (int i = 0; i < dealersHand.size(); i++) {
                    Card card = dealersHand.get(i);
                    Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                    g.drawImage(cardImg, cardWidth + 25 + (cardWidth + 5)*i, 20, cardWidth, cardHeight, null);
                }

                //draw player's hand
                for (int i = 0; i < playerHand.size(); i++) {
                    Card card = playerHand.get(i);
                    Image cardImg = new ImageIcon(getClass().getResource(card.getImagePath())).getImage();
                    g.drawImage(cardImg, 20 + (cardWidth + 5)*i, 320, cardWidth, cardHeight, null);
                }

                if (!stayButton.isEnabled()) {
                    DealersHandNum = reduceDealerAce();
                    UsersHandNum = reducePlayerAce();
                    System.out.println("STAY: ");
                    System.out.println(DealersHandNum);
                    System.out.println(UsersHandNum);

                    String message = "";
                    if (UsersHandNum > 21) {
                        message = "You Lose!";
                    }
                    else if (DealersHandNum > 21) {
                        message = "You Win!";
                    }
                    //both you and dealer <= 21
                    else if (UsersHandNum == DealersHandNum) {
                        message = "Tie!";
                    }
                    else if (UsersHandNum > DealersHandNum) {
                        message = "You Win!";
                    }
                    else if (UsersHandNum < DealersHandNum) {
                        message = "You Lose!";
                    }

                    g.setFont(new Font("Arial", Font.PLAIN, 30));
                    g.setColor(Color.white);
                    g.drawString(message, 220, 250);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            
            
            
            
        };
        // Creates JPanel for the Buttons 

        hitButton.setFocusable(true);
        hitButton.setActionCommand("hit");                      // Allows the button to interact with input
        hitButton.addActionListener(this);                     // Creates output after button is pressed
        buttonPanel.add(hitButton);

        stayButton.setFocusable(true);
        stayButton.setActionCommand("stand");
        stayButton.addActionListener(this);
        buttonPanel.add(stayButton);

        display.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("hit")) {
            hit = true;
            UsersHandNum();
            System.out.println("Users Amount: " + UserAmount);

        } else if (command.equals("stand")) {
            hit = false;
            stand = true;
            DealersHandNum();

        }

    }

    public static void main(String[] args) {
        JFrame display = windowConfig();
        BlackJack game = new BlackJack();
        game.buttonConfig(display);
        display.setVisible(true);
    }
>>>>>>> Stashed changes


    }
    
}
