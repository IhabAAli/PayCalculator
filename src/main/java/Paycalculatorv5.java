import java.util.Scanner;

public class Paycalculatorv5 {
	

	// Global Variables

	static String ename;
	static double totalhour = 0;
	static double hourlyrate = 0;
	static double grosspay;
	static double netPay = 0;

	public static void Welcometext() {
		// Welcome Text
		System.out.println("Welcome to Salary Calculator V5.0");
		System.out.println("Please Follow the Prompt .........");
	}

	public static void GetInput() {

		// Get Input From The User

		Scanner myscanner = GetOneScanner();

		System.out.println("");

		System.out.println("Enter Employee Name : ");
		ename = myscanner.nextLine();

//		int userInput=0;
//	try {
//		try {
//				String newInput = new String();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//		int String = 0;
//		boolean runL="true" != null; {
//		while (runL){
//		    Scanner scan=new Scanner(System.in);
//		    System.out.println("Enter valid Characters");
//		    if (scan.hasNextInt()){
//		       userInput=scan.nextInt();
//		       runL=false;
//		    }
//		    else {
//		        System.out.println("That is not a character, please try again.");
//		    }
//		}
//		System.out.println(userInput);
//
//	}
//		}
		//// check the value of total Hour is between 0 to 80
		int tryCount = 1;
		char isTheInputCorrect = 'N'; {

	
		do {
			try {
				System.out.println("\nEnter Employee Total Hour : ");
				totalhour = myscanner.nextDouble();
				if (totalhour >= 0 && totalhour <= 80) {
					isTheInputCorrect = 'Y';
				} else {
					System.out.println("Please Enter Total Hour Between 0 to 80!!! - You entered " + totalhour);
					isTheInputCorrect = 'N';
					tryCount++;
				}
			} catch (Exception e) {
				System.out.println("Please Enter Total Hour Between 0 to 80!!! - You entered something weird .... ");
				isTheInputCorrect = 'N';
				myscanner = new Scanner(System.in); // new Reference has been created here
				tryCount++;
			}

			// It will Check How many time user Tried to Give a Wrong Input
			if (tryCount > 5) {
				System.out.println("Please Run The Program Again And enter Correct Input Bye Bye Stopping .......  ");
				System.exit(0);
			}

		} while (isTheInputCorrect == 'N'); // False Loop End --True Loop COntine

		//// check the value of Hourly Rate is between 10 to 50
		tryCount = 1;
		do {
			try {
				System.out.println("Enter Employee Hourly Rate : ");
				hourlyrate = myscanner.nextDouble();
				if (hourlyrate >= 10 && hourlyrate <= 50) {
					isTheInputCorrect = 'Y';
				} else {
					System.out.println("Please Enter Hourly Rate Between 10 to 50!!! - You entered " + hourlyrate);
					isTheInputCorrect = 'N';
					tryCount++;
				}
			} catch (Exception e) {
				System.out.println("Please Enter Hourly Rate Between 10 to 50!!! - You entered something weird ");
				isTheInputCorrect = 'N';
				myscanner = GetOneScanner(); // new Reference has been created here
			}

			// Wrong Input Counter
			if (tryCount > 5) {
				System.out.println("Please try again .......  ");
				System.exit(0);
			}

		} while (isTheInputCorrect == 'N'); 
		}
	}

	public static void GrossPay() {

		// Process Gross Pay

		grosspay = totalhour * hourlyrate;
	}

	public static void NetPay() {

		// Process Net Pay

		if (grosspay < 1500) {
			netPay = grosspay - (grosspay * .10);
		} else if (grosspay >= 1500 && grosspay < 3000) {
			netPay = grosspay - (grosspay * .20);
		} else if (grosspay >= 3000 && grosspay < 4500) {
			netPay = grosspay - (grosspay * .30);
		} else if (grosspay >= 4500 && grosspay < 6000) {
			netPay = grosspay - (grosspay * .40);
		} else if (grosspay >= 6000) {
			netPay = grosspay - (grosspay * .45);
		}
	}

	public static void DisplayingOutPut() {

		// Displaying Output
		System.out.println("");
		System.out.println("Employe Name  : " + ename); // Concatenation
		System.out.println("Total Hour    : " + totalhour);
		System.out.println("Hourly Rate   : " + hourlyrate);
		System.out.println("Employee Type  : " + hourlyrate);
		System.out.println("===============================");
		System.out.println("Gross Pay is  : " + grosspay);
		System.out.println("Net Pay Pay is  : " + netPay);
	}

	
	public static Boolean DoYouWanttoContinue () {
		Scanner scn = GetOneScanner();
		String DOYouWanttoContinue;
		System.out.print("\n Do You Want To Continue?");
		DOYouWanttoContinue = scn.nextLine();
		DOYouWanttoContinue = DOYouWanttoContinue.toLowerCase();
		
		if (DOYouWanttoContinue.equals("no")) {
			
			return false;
		}else {
			return true;
		}
	}
	
	
	public static Scanner GetOneScanner ()  {
		
		return new Scanner(System.in);
	}
	public static void main(String[] args) {
		Welcometext();
		
		for (int i = 1; i <= 5; i++) {
			
	System.out.println("\n Proccessing employee.. " + i);
	GetInput();
	GrossPay();
	NetPay();
	DisplayingOutPut();
		
			
			if(!DoYouWanttoContinue()) break;
				
			}
			

		}
	
	}

