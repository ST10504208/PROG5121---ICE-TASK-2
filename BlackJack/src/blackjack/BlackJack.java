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
    public int indexnum = 4;
    public boolean hit = false;
    public int UserAmount = 0;
    public int DealerAmount = 0;

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
            //  System.out.println("Hit");
            hit = true;
            UsersHandNum();
        } else if (command.equals("stand")) {
            //  System.out.println("Stand");
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
        Random random = new Random();
        for (int i = 0; i < deck.size(); i++) {
            int j = random.nextInt(deck.size());
            Card currCard = deck.get(i);
            Card randomCard = deck.get(j);
            deck.set(i, randomCard);
            deck.set(j, currCard);

        }
        System.out.println("Shuffled Deck:");
        System.out.println(deck);
    }

    public void gameStart() {
        buildDeck();
        ShuffleDeck();
        System.out.println("Users hand: " + UsersHand());
        System.out.println("Dealers hand: " + DealersHand());
        System.out.println("First 2 nums: " + UsersHandNum());
    }

    public String UsersHand() {

        String usersHand1 = deck.get(0).toString();
        String usersHand2 = deck.get(1).toString();
        String usersHand = usersHand1 + " " + usersHand2;
        return (usersHand);

    }

    public String UsersHandNum() {
        if (hit == false) {
            String usersHand = UsersHand();

            int spaceindex = usersHand.indexOf(" ");

            String First = usersHand.substring(0, spaceindex - 2);

            String Second = usersHand.substring(spaceindex + 1);
            Second = Second.substring(0, Second.length() - 2);

            return (First + " " + Second);
        } else {
            String hitusershand = deck.get(indexnum).toString();
            int hyphenindex = hitusershand.indexOf("-");
            String usersnum = hitusershand.substring(0, hyphenindex);
            indexnum++;
            return usersnum;
        }

    }

    public String DealersHand() {
        String dealersHand1 = deck.get(2).toString();
        String dealersHand2 = deck.get(3).toString();
        String dealersHand = dealersHand1 + " " + dealersHand2;
        return dealersHand;
    }


}
