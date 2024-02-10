public class LoanCalc {
	
	static double epsilon = 0.001;  
	static int iterationCounter;
	
	public static void main(String[] args) {		
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon)
	{  
		iterationCounter=0;
		double payment = (loan/n);
	    double remainingLoan=1;
	    while (remainingLoan>epsilon)
	    {
	     	payment +=epsilon;
		    iterationCounter++;
		    remainingLoan= endBalance(loan , rate, n, payment);
	    } 
	    return payment;	
    }
    
    /**
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of theloan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
    	iterationCounter=0;
		double L= loan/n;
		double H= 2*(loan/n);
		double payment= (L+H)/2;
		while (H-L > epsilon)
		{
			iterationCounter++;
			if (endBalance(loan, rate, n, payment)*endBalance(loan, rate, n, L)>0)
			{
				L=payment;
				payment= (L+H)/2;
			} else {
				H=payment;
				payment=(H+L)/2;
			}
		}
		return payment;
    }
	

	private static double endBalance(double loan, double rate, int n, double payment) {
		double last = loan;
		for ( int i = 1 ; i<=n ;i++ )
		{
			last= (last-payment)*(1+(rate/100)); 
		}
    	return last;
	}
}