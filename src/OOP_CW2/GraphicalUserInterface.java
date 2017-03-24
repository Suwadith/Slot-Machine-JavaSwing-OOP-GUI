/**
 * Created by Suwadith on 12/9/2016.
 */

package OOP_CW2;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class GraphicalUserInterface extends JFrame {

    //Declaration of the variables
    private JButton spinBtn, addCoinBtn, betOneBtn, betMaxBtn, resetBtn, statisticsBtn;
    private static JLabel title, creditArea, betArea, creditAreaTitle, betAreaTitle;
    public static JLabel reel1, reel2, reel3;
    private Container contentPane;
    private SlotMachine slotMachine;
    private static int index, wins, losses, noOfGames;
    private int profit, loss;
    private static double statValue, average;
    public static boolean flag = true, reelClickable = true;
    private ArrayList<ArrayList<Symbol>> reelImages;

    //Declaration of the Constructor
    public GraphicalUserInterface(SlotMachine slotMachine) {
        this.slotMachine = slotMachine;
        contentPane = getContentPane();
        contentPane.add(titlePanel(), BorderLayout.NORTH);
        contentPane.add(mainPanel(), BorderLayout.CENTER);

        startup();
    }

    //Setting up the public Getters
    public static int getWins() {
        return wins;
    }

    public static int getLosses() {
        return losses;
    }

    public static double getAverage() {
        return average;
    }

    //Setting up Different types of JPanels so we can include them inside a ContentPane
    private JComponent titlePanel() {
        loadFont();
        JPanel titlePanel = new JPanel();
        title = new JLabel();
        title.setText("Slot Machine GUI");
        title.setFont(new Font("New Athletic M54", Font.PLAIN, 30));
        title.setForeground(Color.cyan);
        titlePanel.add(title);
        titlePanel.setBackground(Color.BLACK);
        return titlePanel;
    }

    private JComponent mainPanel() {
        loadFont();
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 20, 40);

        creditAreaTitle = new JLabel();
        creditAreaTitle.setText("Credit Area");
        creditAreaTitle.setFont(new Font("New Athletic M54", Font.PLAIN, 30));
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(creditAreaTitle, constraints);


        creditArea = new JLabel();
        if(slotMachine.getRemCredit()<10){
            creditArea.setText(" 0" + slotMachine.getRemCredit() + " ");
        } else {
            creditArea.setText(" " + slotMachine.getRemCredit() + " ");
        }
        creditArea.setFont(new Font("New Athletic M54", Font.PLAIN, 50));
        creditArea.setForeground(Color.red);
        creditArea.setBackground(Color.black);
        creditArea.setBorder(BorderFactory.createLineBorder(Color.RED));
        creditArea.getPreferredSize().setSize(20,20);
        creditArea.setOpaque(true);
        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(creditArea, constraints);

        betAreaTitle = new JLabel();
        betAreaTitle.setText("Bet Area");
        betAreaTitle.setFont(new Font("New Athletic M54", Font.PLAIN, 30));
        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(betAreaTitle, constraints);

        betArea = new JLabel();
        if(slotMachine.getCurrentBet()<10){
            betArea.setText(" 0" + slotMachine.getCurrentBet() + " ");
        } else {
            betArea.setText(" " + slotMachine.getCurrentBet() + " ");
        }
        betArea.setFont(new Font("New Athletic M54", Font.PLAIN, 50));
        betArea.setForeground(Color.red);
        betArea.setBackground(Color.black);
        betArea.setBorder(BorderFactory.createLineBorder(Color.RED));
        betArea.getPreferredSize().setSize(20,20);
        betArea.setOpaque(true);
        constraints.gridx = 0;
        constraints.gridy = 3;
        mainPanel.add(betArea, constraints);

        reel1 = new JLabel();
        constraints.gridx = 1;
        constraints.gridy = 0;
         constraints.gridheight = 7;
        constraints.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(reel1, constraints);

        reel2 = new JLabel();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 7;
        constraints.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(reel2, constraints);

        reel3 = new JLabel();
        constraints.gridx = 3;
        constraints.gridy =0;
        constraints.gridheight = 7;
        constraints.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(reel3, constraints);

        constraints.gridheight = 1;
        spinBtn = new JButton("Spin");
        spinBtn.setBackground(new Color(33, 202, 157));
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spinBtn, constraints);

        constraints.gridwidth = 1;
        addCoinBtn = new JButton("Add Coin");
        addCoinBtn.setBackground(new Color(57, 228, 119));
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(addCoinBtn, constraints);

        betOneBtn = new JButton("Bet One");
        betOneBtn.setBackground(new Color(57, 228, 119));
        constraints.gridx = 4;
        constraints.gridy = 1;
        mainPanel.add(betOneBtn, constraints);

        betMaxBtn = new JButton("Bet Max");
        betMaxBtn.setBackground(new Color(57, 228, 119));
        constraints.gridx = 4;
        constraints.gridy = 2;
        mainPanel.add(betMaxBtn, constraints);

        resetBtn = new JButton("Reset");
        resetBtn.setBackground(new Color(57, 228, 119));
        constraints.gridx = 4;
        constraints.gridy = 3;
        mainPanel.add(resetBtn, constraints);

        statisticsBtn = new JButton("Statistics");
        statisticsBtn.setBackground(new Color(242, 187, 35));
        constraints.gridx = 4;
        constraints.gridy = 4;
        mainPanel.add(statisticsBtn, constraints);

        reel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                flag = false;
                spinButtonVisibility();
                turnOnOtherButtonVisibility();
                calculateResult();
            }
        });

        reel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                flag = false;
                spinButtonVisibility();
                turnOnOtherButtonVisibility();
                calculateResult();
            }
        });

        reel3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                flag = false;
                spinButtonVisibility();
                turnOnOtherButtonVisibility();
                calculateResult();
            }
        });

        addCoinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCoinBtnPressed();
            }
        });

        betOneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                betOneBtnPressed();
            }
        });

        betMaxBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                betMaxBtnPressed();
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slotMachine.setRemCredit(10);
                noOfGames=0;
                wins=0;
                loss=0;
                resetBtnPressed();
            }
        });

        spinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spinButtonVisibility();
                turnOffOtherButtonVisibility();
                spinBtnPressed();
                reelClickable = true;
            }
        });

        statisticsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatsGUI stats = new StatsGUI();
                stats.setTitle("Statistics");
                stats.setSize(610, 507);
                stats.setMinimumSize(new Dimension(610, 507));
                stats.setVisible(true);
            }
        });

        return mainPanel;
    }

    //Loading the preview of the three Reels
    private void startup() {

        reelImages = new ArrayList<ArrayList<Symbol>>();
        for (int x = 0; x < 3; x++) {
            reelImages.add(slotMachine.getReel(x));
        }
        reel1.setIcon(reelImages.get(0).get(index).getImage());
        reel2.setIcon(reelImages.get(1).get(index).getImage());
        reel3.setIcon(reelImages.get(2).get(index).getImage());

        spinButtonVisibility();
        reelClickable = false;
    }

    //Method to update current credit and bet amounts
    private void updateLabels() {
        if(slotMachine.getRemCredit()<10){
            creditArea.setText(" 0" + slotMachine.getRemCredit() + " ");
        } else {
            creditArea.setText(" " + slotMachine.getRemCredit() + " ");
        }
        if(slotMachine.getCurrentBet()<10){
            betArea.setText(" 0" + slotMachine.getCurrentBet() + " ");
        } else {
            betArea.setText(" " + slotMachine.getCurrentBet() + " ");
        }
    }

    //Methods to be invoked in each and every button click event
    private void addCoinBtnPressed() {
        slotMachine.addCoin();
        updateLabels();
    }

    private void betOneBtnPressed() {
        try {
            slotMachine.betOne();
            updateLabels();
            spinButtonVisibility();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Not Enough Credits Available!!!!");
        }
    }

    private void betMaxBtnPressed() {
        try {
            slotMachine.betMax();
            updateLabels();
            spinButtonVisibility();
            betMaxBtn.setEnabled(false);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Not Enough Credits Available!!!!");
        }
    }

    private void resetBtnPressed() {
        slotMachine.setRemCredit(slotMachine.getRemCredit() + slotMachine.getCurrentBet());
        slotMachine.setCurrentBet(0);
        updateLabels();
        spinButtonVisibility();
    }

    private void spinBtnPressed() {
        spinBtn.setEnabled(false);
        new ThreadController().threadSpinMethod();
        flag = true;
    }

    //Makes sure that spin button won't be visible when the bet amount is any lesser than 1
    private void spinButtonVisibility() {
        if (slotMachine.getCurrentBet() == 0) {
            spinBtn.setEnabled(false);
        } else {
            spinBtn.setEnabled(true);
        }
    }

    private void turnOffOtherButtonVisibility() {
        addCoinBtn.setEnabled(false);
        betOneBtn.setEnabled(false);
        betMaxBtn.setEnabled(false);
        resetBtn.setEnabled(false);
        statisticsBtn.setEnabled(false);
    }

    private void turnOnOtherButtonVisibility() {
        addCoinBtn.setEnabled(true);
        betOneBtn.setEnabled(true);
        betMaxBtn.setEnabled(true);
        resetBtn.setEnabled(true);
        statisticsBtn.setEnabled(true);
    }

    //Calculating Final Result (No of games, wins, losses)
    private void calculateResult() {
        if(reelClickable) {
            if (reel1.getIcon().toString() == reel2.getIcon().toString()
                    && reel2.getIcon().toString() == reel3.getIcon().toString()
                    && reel1.getIcon().toString() == reel3.getIcon().toString()) {
                profit=ThreadController.reelImages.get(0).get(ThreadController.getIndex()).getValue() * slotMachine.getCurrentBet();
                slotMachine.setRemCredit(slotMachine.getRemCredit()
                        + ThreadController.reelImages.get(0).get(ThreadController.getIndex()).getValue() * slotMachine.getCurrentBet());
                JOptionPane.showMessageDialog(null, "You've Earned: "
                        + ThreadController.reelImages.get(0).get(ThreadController.getIndex()).getValue() * slotMachine.getCurrentBet()
                        + " Credits");

                slotMachine.setCurrentBet(0);
                spinButtonVisibility();
                updateLabels();
                noOfGames++;
                wins++;
            } else if (reel1.getIcon().toString() == reel2.getIcon().toString()
                    || reel2.getIcon().toString() == reel3.getIcon().toString()
                    || reel1.getIcon().toString() == reel3.getIcon().toString()) {
                JOptionPane.showMessageDialog(null, "You've Earned a Free Spin!!!!!");

            } else {
                JOptionPane.showMessageDialog(null, "You've Lost!!!!!");
                loss=slotMachine.getCurrentBet();
                slotMachine.setCurrentBet(0);
                spinButtonVisibility();
                updateLabels();
                losses++;
                noOfGames++;
            }

        }
        statValue+=profit-loss;
        average=statValue/noOfGames;
        if(noOfGames==0){
            average=0;
        }
        profit=0;
        loss=0;
        reelClickable = false;
    }

    //Loading custom Font
    private void loadFont(){
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/OOP_CW2/New Athletic M54.ttf")));
        } catch (IOException |FontFormatException e) {
            JOptionPane.showMessageDialog(null, "Unable to load font");
        }
    }

    //Main method
    public static void main(String[] args) {
        SlotMachine slotMachine = new SlotMachine();
        GraphicalUserInterface gui = new GraphicalUserInterface(slotMachine);
        gui.setTitle("Slot Machine GUI");
        gui.setSize(924, 561);
        gui.setMinimumSize(new Dimension(924, 561));
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
        gui.setResizable(true);
        gui.setVisible(true);
    }

}


