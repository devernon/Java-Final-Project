// David Vernon
// CIS263AA - Java Programming: Level II - Class# 21446
// MEID: DAV2098654

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JCatchTheMouse extends JFrame implements ActionListener
{
   final static int FRAME_WIDTH = 400;
   final static int FRAME_HEIGHT = 300;
   static JFrame myFrame;
   JLabel lblInstructions = new JLabel("Hit the button with the 'X' ten times.");
   JPanel gamePane = new JPanel();
   JButton[] myButtons = new JButton[48];
   int xPlacement = 0;
   int myScore = 0;
   int myClicks = 0;
   
   public JCatchTheMouse()
   {
      setTitle("Catch The Mouse");
      Container con = getContentPane();
      con.setLayout(new BorderLayout());
      con.add(lblInstructions, BorderLayout.NORTH);
      gamePane.setLayout(new GridLayout(8,6));
      for (int x = 0; x < myButtons.length; x++)
      {
         myButtons[x] = new JButton();
         gamePane.add(myButtons[x]);
         myButtons[x].addActionListener(this);
      }
      Random rand = new Random();
      xPlacement = rand.nextInt(48);
      myButtons[xPlacement].setText("X");
      con.add(gamePane, BorderLayout.SOUTH);
   }
   
   public void actionPerformed(ActionEvent e)
   {
      Object source = e.getSource();
      myClicks++;
      if (source == myButtons[xPlacement])
      {
         myScore++;
         if (myScore == 10)
         {
            JOptionPane.showMessageDialog(null, "David Vernon\nCIS263AA - Java Programming: Level II - Class# 21446\nMEID: DAV2098654", "You Win, " + myScore + " out of " + myClicks + " clicks", JOptionPane.PLAIN_MESSAGE);
            myScore = 0;
            myClicks = 0;
         }
         else
         {
            myButtons[xPlacement].setText("");
            Random rand = new Random();
            xPlacement = rand.nextInt(48);
            myButtons[xPlacement].setText("X");
         }
      }

   }
   
   public static void main(String[] args)
   {
      myFrame = new JCatchTheMouse();
      myFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.setVisible(true);
   }
}