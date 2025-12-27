
//Nicholas Larkin Buchanan
//2010-09-15
//pd 8
import javax.swing.*;

public class BankHelper {
	public String name;
	public double balence;

	public BankHelper(String nm, double bl) {
		System.out.println("DEBUG: Creating new BankHelper object for " + nm);
		name = nm;
		balence = bl;
	}

	public void deposit(double dp)

	{
		System.out.println("DEBUG: deposit method called with amount: " + dp);
		balence = balence + dp;
	}

	public void withdraw(double wd) {
		System.out.println("DEBUG: withdraw method called with amount: " + wd);
		balence = balence - wd;
	}

	public void printnewbalence() {
		System.out.println("DEBUG: printnewbalence method called");
		System.out.println("The " + name + " account balence is " + balence);

	}

	public void displaybalgui1() {
		System.out.println("DEBUG: displaybalgui1 (JOptionPane) called");
		JOptionPane.showMessageDialog(null, "Your balance is:(after deposite) " + balence, "BALENCE",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public void displaybalgui2() {
		System.out.println("DEBUG: displaybalgui2 (JOptionPane) called");
		JOptionPane.showMessageDialog(null, "Your balance is:(after withdraw) " + balence, "BALENCE",
				JOptionPane.INFORMATION_MESSAGE);

	}
}

// Usage: specific object defining a bank account. Do not run directly.
// Helpers: Used by BankMainApp.java