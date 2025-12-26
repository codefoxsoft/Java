   import java.io.*;
   import java.util.*;
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.FlowLayout;
   import java.net.*;
   import java.util.Random;

   //nick buchanan
   //pd4
   //finaly finished :D Friday, October 29, 2010
   public class dice2 extends JFrame implements ActionListener
   {

      private final int winheight =350;//declares the height of the window;
      private final int winlength = 500;//declares the length of the window;
	  public  boolean roll1 = false;
	  public  boolean roll2 = false;
	  public  boolean roll3 = false;
	  public  boolean win = false;
	  public  boolean  isdone = false;
      public Button button1;
      public TextArea output;
      public Button button2;
      public int die1 =0;
      public int die2 =0;
	  public JLabel dicepic1;
	  public JLabel dicepic2;
	  public Image dice1;
	  public Image dice2;
	  public Graphics2D g;
	  JLabel pic1;
	  JLabel pic2;
      public dice2()
      {
        super("Dice generator");
        setSize(winlength, winheight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        button1 = new Button("GENERATE!!!");
        button2 = new Button("New Game");
		add(button1);
        add(button2);
        pic1 = new JLabel("");
        pic2 = new JLabel("");
        output = new TextArea("");
      	add(output);
		add(pic1);
		add(pic2);
		button1.addActionListener(this);
	    button2.addActionListener(this);
	    button1.setActionCommand("gen");
	    button2.setActionCommand("new");
	    setVisible(true);
      }
      public void actionPerformed(ActionEvent e )
      {
		String d = e.getActionCommand();
		Random r = new Random();
		int dice1 = 0;
		int dice2= 0;
		dice1 = r.nextInt(6)+1;
		dice2 = r.nextInt(6)+1;
		System.out.println(dice1+" "+dice2);
		ImageIcon image;
		ImageIcon image2;
								  switch(dice1)
								  {
									  case 1:
									   image = new ImageIcon("die1.png");
									  pic1.setIcon(image);
									  break;
									  case 2:
									   image = new ImageIcon("die2.png");
									  pic1.setIcon(image);
									  break;
									  case 3:
									   image = new ImageIcon("die3.png");
									  pic1.setIcon(image);
									  break;
									  case 4:
									   image = new ImageIcon("die4.png");
									  pic1.setIcon(image);
									  break;
									  case 5:
									   image = new ImageIcon("die5.png");
									  pic1.setIcon(image);
									  break;
									  case 6:
									   image = new ImageIcon("die6.png");
									  pic1.setIcon(image);
									  break;
								}
								  switch(dice2)
								  {
									  case 1:
									   image2 = new ImageIcon("die1.png");
									  pic2.setIcon(image2);
									  break;
									  case 2:
									   image2 = new ImageIcon("die2.png");
									  pic2.setIcon(image2);
									  break;
									  case 3:
									   image2 = new ImageIcon("die3.png");
									  pic2.setIcon(image2);
									  break;
									  case 4:
									   image2 = new ImageIcon("die4.png");
									  pic2.setIcon(image2);
									  break;
									  case 5:
									   image2 = new ImageIcon("die5.png");
									  pic2.setIcon(image2);
									  break;
									  case 6:
									   image2 = new ImageIcon("die6.png");
									  pic2.setIcon(image2);
									  break;
								}
	if(d == "gen")
		{
			if(win!=true)
			{
			do
			{
				if(roll1==false)
				{

					if((dice1+dice2==7)||(dice1+dice2==11))
						{
							output.append("\nYOU WIN -" + dice1 +" " +dice2);
							win = true;
							roll1=true;
							isdone=true;
						}
						else{
							output.append("\nYOU HAVE 2 MORE TRYS TO MAKE 7 OR 11 -"+ dice1 +" " +dice2);
							roll1=true;
							win = false;
					}
						isdone=true;
				}
				else if(roll2==false)
				{
					if((dice1+dice2==7)||(dice1+dice2==11))
						{
							output.append("\nYOU WIN -"+ dice1 +" " +dice2);
							win = true;
							roll2=true;
							isdone=true;
						}
						else{
							output.append("\nYOU HAVE ONE MORE TO MAKE 7 OR 11 -"+ dice1 +" " +dice2);
							roll2=true;
							isdone=true;
							win = false;
						}
						isdone=true;
				}
				else if(roll3== false)
				{
					if((dice1+dice2==7)||(dice1+dice2==11))
						{
							output.append("\nYOU WIN -"+ dice1 +" " +dice2);
							win = true;
							roll3=true;
							isdone=true;
						}
						else{
							output.append("\nYou fail... sorry. -"+ dice1 +" " +dice2);
							roll3=true;
							isdone=true;

							win = false;
						}
						isdone=true;
				}
				else
				{
					output.append("\nNO more rolls left. hit new game :D");
					isdone=true;
			    }
			}while(isdone=false);
		}
		else
			{
				output.append("\nYou allready won!");
			}
		}else if(d == "new"){
			String ngLength = "NEW GAME STARTED";
				output.append("\n");
				for(int i =0; i<=ngLength.length(); i++){
				output.append("*");
				}
				output.append("\n\n\n\n\n\nNEW GAME STARTED\n");

				for (int i = 0; i<=ngLength.length();i++){
				output.append("*");
				}
				win=false;
				roll1=false;
				roll2=false;
				roll3=false;
				isdone=false;
				dice1 = 0;
			    dice2= 0;

		}
      }

      public static void main(String[] args)
      {
         new dice2();
      }
   }