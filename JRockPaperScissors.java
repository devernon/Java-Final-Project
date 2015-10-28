// David Vernon
// CIS263AA - Java Programming: Level II - Class# 21446
// MEID: DAV2098654

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JRockPaperScissors extends JApplet implements ActionListener
{
   String myName = "David Vernon";
   String myCourse = "CIS263AA - Java Programming: Level II";
   String mySection = "Class# 21446";
   String myMEID = "MEID: DAV2098654";
   JLabel lblTitle = new JLabel("Rock, Paper, Scissors");
   JLabel lblChoose = new JLabel("Choose one button");
   JPanel pnlButtons = new JPanel();
   JButton btnRock = new JButton("Rock");
   JButton btnPaper = new JButton("Paper");
   JButton btnScissors = new JButton("Scissors");
   JPanel pnlResults = new JPanel();
   JLabel lblResults1 = new JLabel("----- Results -----");
   JLabel lblResults2 = new JLabel(" ");
   JLabel lblResults3 = new JLabel(" ");
   JLabel lblResults4 = new JLabel(" ");
   JLabel lblResults5 = new JLabel(" ");
   Font font1 = new Font("Arial", Font.BOLD, 20);
   Font font2 = new Font("Arial", Font.BOLD, 16);
   Font font3 = new Font("Arial", Font.BOLD, 12);
   Font fontInfo = new Font("Times New Roman", Font.PLAIN, 14);
   int youWon = 0;
   int compWon = 0;
   int tie = 0;
   Container con = getContentPane();
   
   public void paint(Graphics gr)
   {
      super.paint(gr);
      Dimension appletSize = this.getSize();
      gr.setFont(fontInfo);
      int startLeft = appletSize.width - 250;
      int startTop = appletSize.height - 52;
      gr.drawString(myName, startLeft, startTop);
      startTop += 16;
      gr.drawString(myCourse, startLeft, startTop);
      startTop += 16;
      gr.drawString(mySection, startLeft, startTop);
      startTop += 16;
      gr.drawString(myMEID, startLeft, startTop);
   }
   
   public void init()
   {
      lblTitle.setFont(font1);
      lblChoose.setFont(font2);
      lblResults1.setFont(font2);
      lblResults2.setFont(font3);
      con.setLayout(new FlowLayout());
      lblTitle.setHorizontalAlignment(JLabel.CENTER);
      add(lblTitle);
      pnlButtons.setLayout(new FlowLayout());
      pnlButtons.add(lblChoose);
      pnlButtons.add(btnRock);
      pnlButtons.add(btnPaper);
      pnlButtons.add(btnScissors);
      add(pnlButtons);
      lblResults1.setHorizontalAlignment(JLabel.CENTER);
      pnlResults.setLayout(new BoxLayout(pnlResults, BoxLayout.PAGE_AXIS));
      pnlResults.add(lblResults1);
      pnlResults.add(lblResults2);
      pnlResults.add(lblResults3);
      pnlResults.add(lblResults4);
      pnlResults.add(lblResults5);
      add(pnlResults);
      btnRock.addActionListener(this);
      btnPaper.addActionListener(this);
      btnScissors.addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent e)
   {
      Object source = e.getSource();
      Random rand = new Random();
      int computerResult = rand.nextInt(3);
      if (source == btnRock)
      {
         if (computerResult == 0)
         {
            lblResults2.setText("You picked rock --- Computer picked rock");
            lblResults3.setText(" ");
            lblResults4.setText("Winner: Tie");
            tie++;
         }
         else if (computerResult == 1)
         {
            lblResults2.setText("You picked rock --- Computer picked paper");
            lblResults3.setText("Paper covers rock");
            lblResults4.setText("Winner: Computer");
            compWon++;
         }
         else
         {
            lblResults2.setText("You picked rock --- Computer picked scissors");
            lblResults3.setText("Rock breaks scissors");
            lblResults4.setText("Winner: You");
            youWon++;
         }
      }
      else if (source == btnPaper)
      {
         if (computerResult == 0)
         {
            lblResults2.setText("You picked paper --- Computer picked rock");
            lblResults3.setText("Paper covers rock");
            lblResults4.setText("Winner: You");
            youWon++;
         }
         else if (computerResult == 1)
         {
            lblResults2.setText("You picked paper --- Computer picked paper");
            lblResults3.setText(" ");
            lblResults4.setText("Winner: Tie");
            tie++;
         }
         else
         {
            lblResults2.setText("You picked paper --- Computer picked scissors");
            lblResults3.setText("Scissors cut Paper");
            lblResults4.setText("Winner: Computer");
            compWon++;
         }
      }
      else
      {
         if (computerResult == 0)
         {
            lblResults2.setText("You picked scissors --- Computer picked rock");
            lblResults3.setText("Rock breaks scissors");
            lblResults4.setText("Winner: Computer");
            compWon++;
         }
         else if (computerResult == 1)
         {
            lblResults2.setText("You picked scissors --- Computer picked paper");
            lblResults3.setText("Scissors cut paper");
            lblResults4.setText("Winner: You");
            youWon++;
         }
         else
         {
            lblResults2.setText("You picked scissors --- Computer picked scissors");
            lblResults3.setText(" ");
            lblResults4.setText("Winner: Tie");
            tie++;
         }
      }
      lblResults5.setText("You: " + youWon + " -- Computer: " + compWon + " -- Ties: " + tie);
      validate();
   }
}