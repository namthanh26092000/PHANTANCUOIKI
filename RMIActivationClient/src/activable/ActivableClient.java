package activable;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ActivableClient {
	private static PaymentActivable stub = null;

	private ActivableClient() {}

	public static void main(String[] args) {
		
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}
				

		double payment, principal =  150000;
		double annualInterest = .06;
		int years = 15;
		try {
			Registry reg = LocateRegistry.getRegistry();
			stub = (PaymentActivable) reg.lookup("Mortgage");


		} catch (Exception e) {
			System.err.println("Client exception thrown: " + e.toString());
			e.printStackTrace();
		}
		if (args.length == 3) {
			try {
				principal = Double.parseDouble(args[0]);
				annualInterest = Double.parseDouble(args[1]);
				years = Integer.parseInt(args[2]);
			}
			catch (Exception e) {
				System.out.println("Wrong input " + e.getMessage() );
				System.exit(0);
			}
			print(principal, annualInterest, years);

		} else {
			System.out.println("Usage: java ActivableClient principal annualInterest years ");
			System.out.println("\nFor example: java ActivableClient 80000 .065 15 ");
			System.out.println("\nYou will get the output like the following: \n");
			print(principal, annualInterest, years);
			System.exit(0);
		}        

	}

	public static void print(double pr, double annRate, int years){
		double mpayment = 0;
		try {
			mpayment = stub.calculatePayment(pr, annRate, years);

		}catch(Exception e) {
			System.out.println("Remote method exception thrown: " + e.getMessage());
		}
		System.out.println("The principal is $" + (int)pr);
		System.out.println("The annual interest rate is " + annRate*100 +"%");
		System.out.println("The term is " + years + " years");
		System.out.println("Your monthly payment is $" + mpayment);
	}
}