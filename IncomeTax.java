// ADEL AKHMED 
// 105760170
// OCTOBER 2, 2020



import java.util.Scanner;

public class IncomeTax {

	public static void main(String[] args) {
		
		Tax t1 = new Tax();
		boolean tf = true;
		do {
		System.out.println("Welcome!");
		System.out.println("Press 1 to calculate tax ");
		System.out.println("Press 2 to view tax tables");
		System.out.println("Press 0 to exit!");
		Scanner input = new Scanner(System.in);
		int ch = input.nextInt();
		switch(ch) {
		case 1 : t1.set();
		t1.getTax();
		break;
		case 2 : 
			t1.print();
		break;
		case 0: 
			tf = false;
			break;
		}
		}while(tf == true);
	}

}
class Tax{
	int fillingStatus;
	final static int SINGLE_FILER = 0;
	final static int MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER= 1;
	final static int  MARRIED_SEPARATELY = 2;
	final static int HEAD_OF_HOUSEHOLD = 3;
	final static int[][] brackets = {{0,27050,27051,65550,65551,136750,136751,297350},
	{0,45200,45201,109250,109251,166500,166501,297350}, 
	{0,22600,22601,54625,54626,83250,83251,148675}, 
	{0,36250,36251,93650,93651,151650,151651,297350}};
	final static int[][] brackets2 = {{0,8350,8351,33950,82250,82251,171550,1715551,372950},
			{0,16700,16701,67900,67901,137050,137051,208850,208851,372950},
			{0,8350,8351,33950,33951,68525,68526,104425,104426,186475},
			{0,11950,11951,45500,45501,1117}
			
			
	};
	double[] rates = {0.15,0.275,0.305,0.355,0.391};
	double[] rates2 = {0.10, 0.15,0.25,0.28,0.33,0.35};
	double taxableIncome;
	
	Tax(){
		
	}
	public void set() {
		Scanner input = new Scanner(System.in);
		
		boolean tf = true;
		int status; 
		System.out.print("Enter the filing status: ");
		do {
	
		 status = input.nextInt();
		
		if (!( status == 1 || status == 0 || status == 2 || status == 3)) {
			tf = false; 
			System.out.print("Invalid Entry! Enter the filling status: ");
			
			
		}else {
			tf = true;
		}
		
		
		}while (tf == false);
		
		System.out.println();
		System.out.print("Enter the Taxable Income: ");
		
		double income  = input.nextDouble();
		
		
		fillingStatus = status;
		taxableIncome = income;
		System.out.println();
	
	}
	public void getTax() {
		double total =0;
		if (taxableIncome > brackets[fillingStatus][brackets[fillingStatus].length -1]  ) {
			total = taxableIncome * rates[rates.length];
		}
			else {
		int tracker = 0;
		for (int i = 0,j = 1; j < brackets[fillingStatus].length; i++, j++) {
			if (taxableIncome >= brackets[fillingStatus][i] && taxableIncome <= brackets[fillingStatus][j]) {
				 total = taxableIncome * rates[tracker];	
				break;
			}
			i++;
			j++;
			tracker++;
			
		}
		
	}
		System.out.println("Tax is: $" + total);
}
	
	Tax(int status, double[] brackets, double[] rates, double income){
		
	}
	public void print() {
		System.out.println("Enter the amount from: $");
		Scanner input = new Scanner(System.in);
		double[] range = new double[2];
		for (int i = 0 ; i < 2; i++) {
			range[i] = input.nextDouble();
		}
		System.out.println("2001 tax tables for taxable income from $" + range[0] + " to $" + range[1]);
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		System.out.println("Taxable     Single     Married Joint     Married     Head of");
		System.out.println("Income                 or Qualifying     Seperate    a house");
		System.out.println("                       Widow(er)");
		System.out.println("--------------------------------------------------------------");
		double temp = range[0];
		double x1 = range[1]- range[0];
		int x2 = (int)(x1 / 1000);
		x2++;
		double[][] arrayRates = new double[4][x2];
		
		int tracker = 0;
		int x =0;
		int z =0;
		do {
			
			temp = range[0];
			z =0;
			do {
			tracker = 0;
		for (int i = 0, j = 1; i < brackets[fillingStatus].length && temp <= range[1]; i++, j++) {
			
			if (temp >= brackets[x][i] && temp <= brackets[x][j] && z < (x2) ) {
				temp+=1000;
				arrayRates[x][z] = rates[tracker]; 
				z++;
				break;
				
			}
			else if(temp >= brackets[x][i] && temp >= brackets[x][j] && z < (x2)) {
				temp+=1000;
				arrayRates[x][z] = rates[3]; 
				z++;
				break;
			}
		
	
			i++;
			j++;
			tracker++;
			}
		
		}while(z < x2);
		x++;
		}while(x < brackets.length);
		
	temp = range[0];
	int a =0;
	int b = 0;
	int c =0;
	int d =0;
	do {
		
		System.out.println(Math.round(temp) + "      " + Math.round((temp * arrayRates[0][a]) * 100) /100 + "      " + Math.round((temp * arrayRates[1][b]) * 100)  / 100 + "      " + Math.round((temp * arrayRates[2][c]) * 100) / 100 + "      " + Math.round((temp * arrayRates[3][d]) * 100) /100 );
		a++;
		b++;
		c++;
		d++;
		temp+=1000;
		
			
	}while(a < x2);
	System.out.println();
	
	
	
	x= 0;
	////////////////////////////////////////////////////////////////////////////////////////////////
	System.out.println("2009 tax tables for taxable income from $" + range[0] + " to $" + range[1]);
	System.out.println();
	System.out.println("--------------------------------------------------------------");
	System.out.println("Taxable     Single     Married Joint     Married     Head of");
	System.out.println("Income                 or Qualifying     Seperate    a house");
	System.out.println("                       Widow(er)");
	System.out.println("--------------------------------------------------------------");
	
	double[][] arrayRates2 = new double[4][x2];
			x =0;
	do {
		
		temp = range[0];
		z =0;
		do {
		tracker = 0;
	for (int i = 0, j = 1; i < brackets2[fillingStatus].length && temp <= range[1]; i++, j++) {
		if (temp >= brackets2[x][i] && temp <= brackets2[x][j] && z < (x2) ) {
			temp+=1000;
			arrayRates2[x][z] = rates2[tracker]; 
			z++;
			break;
			
		}
		else if(temp >= brackets2[x][i] && temp >= brackets2[x][j] && z < (x2)) {
			temp+=1000;
			arrayRates2[x][z] = rates2[4]; 
			z++;
			break;
		}
		

		i++;
		j++;
		tracker++;
		
	}
	}while(z < x2);
	x++;
	}while(x < brackets2.length);
	

	
temp = range[0];
a =0;
 b = 0;
 c =0;
 d =0;
do {
	
	System.out.println(Math.round(temp) + "      " + Math.round((temp * arrayRates2[0][a]) * 100) /100 + "      " + Math.round((temp * arrayRates2[1][b]) * 100)  / 100 + "      " + Math.round((temp * arrayRates2[2][c]) * 100) / 100 + "      " + Math.round((temp * arrayRates2[3][d]) * 100) /100 );
	a++;
	b++;
	c++;
	d++;
	temp+=1000;
	
		
}while(a < x2);
System.out.println();
	
	
	
	
	}
}









