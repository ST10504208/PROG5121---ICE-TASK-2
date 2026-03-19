package blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;

public class BlackJack implements ActionListener {

    ArrayList<Card> deck;

    BlackJack() {
        gameStart();
    }

    public static JFrame windowConfig() {

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

    public void buttonConfig(JFrame display) {
        JButton hitButton = new JButton("Hit!");               // Creates button objects
        JButton stayButton = new JButton("Stay");
        JPanel buttonPanel = new JPanel();                     // Creates JPanel for the Buttons 

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
            System.out.println("Hit");

        } else if (command.equals("stand")) {
            System.out.println("Stand");
        }

    }

    public static void main(String[] args) {
        JFrame display = windowConfig();
        BlackJack game = new BlackJack();
        game.buttonConfig(display);
        display.setVisible(true);

        // Visualizes the window (Makes it visable) 
        // Create two buttons Hit and Stand
        // Connect the Array data to the card data and graphics
        // Add shuffle feature for the deck of cards
    }

    public class Card {

        String value;
        String type;

        Card(String value, String type) {
            this.value = value;
            this.type = type;
        }

        public String toString() {
            return value + "-" + type;
        }
    }

    public void buildDeck() {
        deck = new ArrayList<Card>();
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] types = {"C", "D", "H", "S"};

        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Card card = new Card(values[j], types[i]);
                deck.add(card);
            }
        }

        System.out.println("BUILD DECK:");
        System.out.println(deck);

    }

    public void ShuffleDeck() {
        Card ChoseCard = deck.get(randomNum());
        System.out.println(ChoseCard);
    }

    public int randomNum() {
        int min = 0;
        int max = 13;
        Random random = new Random();
        int intShuffledDeck = random.nextInt((max - min) + 1) + min;
        return (intShuffledDeck);
    }

    public void gameStart() {
        buildDeck();
        ShuffleDeck();

    }

}
