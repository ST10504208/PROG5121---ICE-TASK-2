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
    public boolean stand = false;
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
            return value + "-" + type;          //Converts to string
        }
    }

    public void buildDeck() {
        deck = new ArrayList<Card>();
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] types = {"C", "D", "H", "S"};

        for (int i = 0; i < types.length; i++) {                        //Builds the deck by looping through the values and giving it the 4 types of suits
            for (int j = 0; j < values.length; j++) {
                Card card = new Card(values[j], types[i]);               //Adds the format of "value-suit" to the card array list
                deck.add(card);
            }
        }

        System.out.println("BUILD DECK:");
        System.out.println(deck);

    }

    public void ShuffleDeck() {
        Random random = new Random();                   //Creates a random number for the shuffling
        for (int i = 0; i < deck.size(); i++) {
            int j = random.nextInt(deck.size());
            Card currCard = deck.get(i);
            Card randomCard = deck.get(j);
            deck.set(i, randomCard);
            deck.set(j, currCard);
            //Shuffles the deck by using the random number and swapping places
        }
        System.out.println("Shuffled Deck:");
        System.out.println(deck);
    }

    public void gameStart() {
        buildDeck();
        ShuffleDeck();
        System.out.println("Users hand: " + UsersHand());
        System.out.println("Dealers hand: " + DealersHand());
        System.out.println("First 2 nums for User: " + UsersHandNum());
        System.out.println("First 2 nums for Dealer: " + DealersHandNum());
    }

    public String UsersHand() {

        String usersHand1 = deck.get(0).toString();             //Gets the first card in the array and converts it to a string
        String usersHand2 = deck.get(1).toString();             //Gets the second card in the array and converts it to a string
        String usersHand = usersHand1 + " " + usersHand2;       //Combines them together with a space in the middle for string manipulation purposes
        return (usersHand);

    }

    public int UsersHandNum() {
        if (hit == false) {
            String usersHand = UsersHand();                             //Since hit is false this is the first users hand when the game starts
            int FirstNum = 0;                                           //declares the variables
            int SecondNum = 0;
            int spaceindex = usersHand.indexOf(" ");                    //finds the space we added to the string ealier in the UsersHand() method

            String First = usersHand.substring(0, spaceindex);
            First = First.substring(0, First.indexOf("-"));              //First number is from 0 - the space minus 2 because of the suit and -

            String Second = usersHand.substring(spaceindex + 1);        //Second number is from the space adding 1 because of the space itself
            Second = Second.substring(0, Second.indexOf("-"));          //Copy from that first character once again minus 2 because of the suit and -

            switch (First) {
                case "K":                                               //Switch case for if the "numbers" are a face card then the value of it is 10
                case "Q":
                case "J":
                    FirstNum = FirstNum + 10;
                    break;
                case "A":                                               //Switch case for if the "numbers" are an ace then the value of it is 11
                    FirstNum = FirstNum + 11;
                    break;
                default:
                    FirstNum = Integer.parseInt(First);

            }
            switch (Second) {                                          //Switch is the same as above but for the second number 
                case "K":
                case "Q":
                case "J":
                    SecondNum = SecondNum + 10;
                    break;
                case "A":
                    SecondNum = SecondNum + 11;
                    break;
                default:
                    SecondNum = Integer.parseInt(Second);

            }

            UserAmount = FirstNum + SecondNum;                              //Combines the 2 values into one number to calculate the total hand value

            return (UserAmount);
        } else {                                                            //If the user has hit then we go with this code
            String hitusershand = deck.get(indexnum).toString();
            int hyphenindex = hitusershand.indexOf("-");
            String usersnum = hitusershand.substring(0, hyphenindex);
            indexnum++;                                                     //Above is using the array and finding the value of the card once again

            switch (usersnum) {
                case "K":
                case "Q":
                case "J":
                    return (UserAmount = UserAmount + 10);
                case "A":
                    if (UserAmount + 11 < 21) {                             //If the card pulled is an ace and if adding 11 to the total means the user has above 21 then change the ace value to a 1
                        return UserAmount = UserAmount + 11;
                    } else {
                        return UserAmount = UserAmount + 1;
                    }

                default:
                    UserAmount = UserAmount + Integer.parseInt(usersnum);
                    return UserAmount;
            }

        }

    }

    public String DealersHand() {
        String dealersHand1 = deck.get(2).toString();
        String dealersHand2 = deck.get(3).toString();                       //Does the same as the UsersHand() method except for the dealer and is 2 indexes in the arary after the Users hand hence why the 3 and 4 in the deck.get
        String dealersHand = dealersHand1 + " " + dealersHand2;
        return dealersHand;
    }

    public int DealersHandNum() {
        if (stand == false) {
            String dealersHand = DealersHand();                         //Very similar to the UsersHandNum() method
            int FirstNum = 0;
            int SecondNum = 0;
            int spaceindex = dealersHand.indexOf(" ");

            String First = dealersHand.substring(0, spaceindex);
            First = First.substring(0, First.indexOf("-"));

            String Second = dealersHand.substring(spaceindex + 1);
            Second = Second.substring(0, Second.indexOf("-"));

            switch (First) {
                case "K":
                case "Q":
                case "J":
                    FirstNum = 10;
                    break;
                case "A":
                    FirstNum = 11;
                    break;
                default:
                    FirstNum = Integer.parseInt(First);

            }
            switch (Second) {
                case "K":
                case "Q":
                case "J":
                    SecondNum = 10;
                    break;
                case "A":
                    SecondNum = 11;
                    break;
                default:
                    SecondNum = Integer.parseInt(Second);

            }

            int DealerAmount = FirstNum + SecondNum;

            return DealerAmount;
        } else if (stand == true && DealerAmount >= 17) {
            if (UserAmount < DealerAmount) {
                System.out.println("You lose!" + '\n' + "The dealer had: " + DealerAmount);
                return DealerAmount;
            } else {
                System.out.println("You Win!" + '\n' + "The dealer had: " + DealerAmount);
                return (DealerAmount);
            }

        } else {

            while (DealerAmount < 17) {
                String hitdealershand = deck.get(indexnum).toString();

                int hyphenindex = hitdealershand.indexOf("-");
                String dealersnum = hitdealershand.substring(0, hyphenindex);
                indexnum++;

                                                                                                //Above is using the array and finding the value of the card once again
                switch (dealersnum) {
                    case "K":
                    case "Q":
                    case "J":
                        DealerAmount = DealerAmount + 10;
                        break;
                    case "A":
                        if (DealerAmount + 11 < 21) {                                           //If the card pulled is an ace and if adding 11 to the total means the Dealer has above 21 then change the ace value to a 1
                            DealerAmount = DealerAmount + 11;
                        } else {
                            DealerAmount = DealerAmount + 1;
                        }
                        break;
                    default:
                        DealerAmount = DealerAmount + Integer.parseInt(dealersnum);

                }
                if (DealerAmount > 21) {
                    System.out.println("Dealer bust! You win!" + '\n' + "Dealers amount: " + DealerAmount);
                    break;
                }
            }
            return DealerAmount;
        }

    }

}
