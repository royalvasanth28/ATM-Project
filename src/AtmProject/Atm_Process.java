package AtmProject;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class Atm_Process {
	static Map<Integer,Integer> map;
	public Atm_Process(Map<Integer,Integer> map, Map<Integer,Integer> map1) throws SQLException {
	    makeProcess(map,map1);
	}
	public void makeProcess(Map<Integer,Integer> map , Map<Integer,Integer> map1) throws SQLException{
	    int Addamount = 0;
	    int Takeamount = 0;
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Please select your bank user id:");
	    int id = sc.nextInt();
	    while(!map.containsKey(id)) {
	    	System.err.println("Enter Valid User Id");
	    	id = sc.nextInt();
	    }
	    System.out.println("Please Enter Your Pin:");
	    int password = sc.nextInt();
	    while(password != map.get(id)) {
	    	System.err.println("Enter correct PIN");
	    	password = sc.nextInt();
	    }
	    int balance = map1.get(id);
	         System.out.println("Welcome to SBI Atm...!!!");
	         int n =0;
	         while (n != 5) {
	              System.out.println("press 1 for balance");
	              System.out.println("press 2 for AddAmount");
	              System.out.println("press 3 for TakeAmount");
	              System.out.println("press 4 for Receipt");
	              System.out.println("press 5 for EXIT");

	               n = sc.nextInt();
	              switch (n) {
	                   case 1:
	                        System.out.println("You acc balance is :" + balance);
	                        break;

	                   case 2:
	                        System.out.println("Enter the balance to add...");
	                        Addamount = sc.nextInt();
	                        balance = balance + Addamount;
	                        AtmProject.changeBalance(id, balance);
	                        System.out.println("Amount added sucessfully");
	                        break;
	                   case 3:
	                        System.out.println("Enter the amount to Withdraw...");
	                        Takeamount = sc.nextInt();
	                        if (Takeamount > balance) {
	                             System.out.println("Insufficent balance");
	                             System.out.println("Enter the amount less than your balance");
	                        } else {
	                             balance = balance - Takeamount;
	                             AtmProject.changeBalance(id, balance);
	                             System.out.println("cash sucessfully Taken");
	                        }
	                        break;
	                   case 4:
	                        System.out.println("*****Welcome to SBI*******");
	                        System.out.println("your balance is : " + balance);
	                        System.out.println("Amount added : " + Addamount);
	                        System.out.println("Amount Withdrawn is : " + Takeamount);
	                        System.out.println("Thank you..!!! \n Come again");
	                        break;
	                   case 5:
	                        System.err.println("Thank you..!!!");
	                        break;
	                   default:
	                  	 System.out.println("Enter number between 1 to 5");
	              }
	              
	         }
	    sc.close();
	}
}
