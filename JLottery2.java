// David Vernon
// CIS263AA - Java Programming: Level II - Class# 21446
// MEID: DAV2098654

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JLottery2 extends JFrame implements ActionListener
{
   final static int FRAME_WIDTH = 300;
   final static int FRAME_HEIGHT = 400;
   static JFrame myFrame;
   JLabel lblChoose = new JLabel("Check six numbers and submit for results");
   JLabel lblWinning1 = new JLabel("The Winning Numbers are:");
   JLabel lblWinning2 = new JLabel(" - - - - - ");
   JLabel lblPrize1 = new JLabel("Your Prize Amount:");
   JLabel lblPrize2 = new JLabel(" ");
   JPanel pnlCheckBoxes = new JPanel();
   JPanel pnlResults = new JPanel();
   JMenuBar menuBar = new JMenuBar();
   JMenu mnuFile = new JMenu("File");
   JMenuItem mniAbout = new JMenuItem("About");
   JCheckBox[] chkNumbers = new JCheckBox[31];
   int[] winningNumbers = { -1, -1, -1, -1, -1, -1 };
   JButton btnSubmit = new JButton("Submit");
   
   public JLottery2()
   {
      setTitle("Lottery Game");
      setJMenuBar(menuBar);
      menuBar.add(mnuFile);
      mnuFile.add(mniAbout);
      generateNumbers();
      lblWinning2.setText( winningNumbers[0] + " - " + winningNumbers[1] + " - " + winningNumbers[2] + " - " + winningNumbers[3] + " - " + winningNumbers[4] + " - " + winningNumbers[5] );
      Container con = getContentPane();
      con.setLayout(new BorderLayout());
      pnlCheckBoxes.setPreferredSize(new Dimension(FRAME_WIDTH, (FRAME_HEIGHT/3)));
      pnlCheckBoxes.setLayout(new FlowLayout());
      for (int x = 0; x < 31; x++)
      {
         chkNumbers[x] = new JCheckBox(Integer.toString(x));
         pnlCheckBoxes.add(chkNumbers[x]);
      }
      pnlResults.setLayout(new GridLayout(0, 1));
      pnlResults.add(btnSubmit);
      pnlResults.add(lblWinning1);
      lblWinning1.setVisible(false);
      pnlResults.add(lblWinning2);
      lblWinning2.setVisible(false);
      pnlResults.add(lblPrize1);
      lblPrize1.setVisible(false);
      pnlResults.add(lblPrize2);
      lblPrize2.setVisible(false);
      con.add(lblChoose, BorderLayout.NORTH);
      con.add(pnlCheckBoxes, BorderLayout.CENTER);
      con.add(pnlResults, BorderLayout.SOUTH);
      mniAbout.addActionListener(this);
      btnSubmit.addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent e)
   {
      Object source = e.getSource();
      if(source == btnSubmit)
      {
         if(btnSubmit.getText().equals("Submit"))
         {
            int chkCount = 0;
            int matches = 0;
            for (int x = 0; x < 31; x++)
               if (chkNumbers[x].isSelected())
               {
                  chkCount++;
                  for (int y = 0; y < 6; y++)
                     if (winningNumbers[y] == x)
                        matches++;
               }
            if (chkCount != 6)
               JOptionPane.showMessageDialog(null, "6 numbers must be selected, you have " + chkCount + " selected");
            else
            {
               lblWinning1.setVisible(true);
               lblWinning2.setVisible(true);
               lblPrize1.setVisible(true);
               if (matches == 6)
                  lblPrize2.setText("You have 6 matches. You won $ 1,000,000.00");
               else if (matches == 5)
                  lblPrize2.setText("You have 5 matches. You won $ 50,000.00");
               else if (matches == 4)
                  lblPrize2.setText("You have 4 matches. You won $ 10,000.00");
               else if (matches == 3)
                  lblPrize2.setText("You have 3 matches. You won $ 100.00");
               else
                  lblPrize2.setText("You have " + matches + " matches. You are not a winner.");
               lblPrize2.setVisible(true);
               btnSubmit.setText("Reset");
            }
         }
         else
         {
            for (int x = 0; x < 31; x++)
               chkNumbers[x].setSelected(false);
            lblWinning1.setVisible(false);
            lblWinning2.setVisible(false);
            lblPrize1.setVisible(false);
            lblPrize2.setVisible(false);
            generateNumbers();
            lblWinning2.setText( winningNumbers[0] + " - " + winningNumbers[1] + " - " + winningNumbers[2] + " - " + winningNumbers[3] + " - " + winningNumbers[4] + " - " + winningNumbers[5] );
            btnSubmit.setText("Submit");
         }
      }
      else
      {
         JOptionPane.showMessageDialog(null, "David Vernon\nCIS263AA - Java Programming: Level II - Class# 21446\nMEID: DAV2098654", "About Lottery Game", JOptionPane.PLAIN_MESSAGE);
      }
   }
   
   public void generateNumbers()
   {
      Random rand = new Random();
      for (int x = 0; x < 6; x++)
      {
         winningNumbers[x] = rand.nextInt(31);
         for (int y = 0; y < x; y++)
            if(winningNumbers[x] == winningNumbers[y])
            {
               winningNumbers[x] = rand.nextInt(31);
               y = -1;
            }
       }
   }
   public static void main(String[] args)
   {
      myFrame = new JLottery2();
      myFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.setVisible(true);
   }
}