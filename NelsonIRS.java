import java.util.Scanner;	// Needed for the Scanner class

/************************************************************************
*																		*
*																		*
*	This program intended to compute the tax owed.						*
*																		*
************************************************************************/

public class NelsonIRS
{
	public static void main(String[] args)
	{
		
		//Create a Scanner object to read input.
		Scanner keyboard = new Scanner (System.in);
		
		//Declare variables.
		double input;
		double income = 0;
		double deductions = 0;
		double taxableIncome = 0;
		double tax = 0;
		char taxGroup = ' ';
		
		
		System.out.print("Enter the next amount  : ");
			
		input = keyboard.nextDouble();
		
		//Prompt the user for income and deductions until 0 is entered.
		while (input != 0)
		{
			
			if (input > 0)
				{
				income += input;
				}
				
			
			if (input < 0)
				{
				deductions -= input;
				}
				
		System.out.print("Enter the next amount  : ");
			
		input = keyboard.nextDouble();
		}
		
		//Call the method computeTaxableIncome.
		taxableIncome = computeTaxableIncome(income, deductions);
		
		//Call the method computeTaxGroup.
		taxGroup = computeTaxGroup(taxableIncome);
		
		//Call the method computeTax.
		tax = computeTax(taxGroup, taxableIncome);
		
		//Call the method displayOutput.
		displayOutput(income, deductions, taxableIncome, taxGroup, tax);
		
	}

			//Create a method called computeTaxableIncome in order to compute the taxable income.
			public static double computeTaxableIncome (double income, double deductions)
			{
				double taxableIncome = 0;
				
			if (income >= deductions)
				{
				 taxableIncome = income - deductions;
				}
			else
				{
				taxableIncome = 0;
				}
				return taxableIncome;
			}
			
			
				//Create a method called computeTaxGroup in order to compute the tax group.
				public static char computeTaxGroup (double taxableIncome)
				{
				char taxGroup;	
					
				if (taxableIncome >= 500000)
					{
					taxGroup = 'V';
					}
						else if (taxableIncome >= 200000)
						{
						taxGroup = 'Q';
						}
							else if (taxableIncome >= 100000)
							{
							taxGroup = 'M';
							}
								else if (taxableIncome >= 50000)
								{
								taxGroup = 'A';
								}
									else if (taxableIncome >= 20000)
									{
									taxGroup = 'R';
									}
										else
										{
										taxGroup = 'P';
										}
										return taxGroup;
				}					
					//Create a method called computeTax in order to compute the tax.
					public static double computeTax (char taxGroup, double taxableIncome)
					{
						double tax = 0;
						
						switch (taxGroup)
						{	
								case 'V':
								case 'Q':
										tax = taxableIncome * 0.25;
										break;
										
								case 'M':
										tax = taxableIncome * 0.1;
										break;
								
								case 'A':
								case 'R':
										tax = taxableIncome * 0.03;
										break;
										
								case 'P':
										tax = 0.0;
										break;
								default:
									System.out.println("Error!");
						}
						return tax;
					}
				
					
						//Create a method called displayOutput in order to display the output.
						public static void displayOutput (double income, double deductions, double taxableIncome, char taxGroup, double tax)
						{
						System.out.println();
						System.out.println("Income\t\t\t= $" + income);
						System.out.println("Deductions\t\t= $" + deductions);
						System.out.println("Taxable income\t\t= $" + taxableIncome);
						System.out.println("Tax group\t\t= " + taxGroup);
						System.out.println("Tax owed\t\t= $" + tax);
						}
						
}







