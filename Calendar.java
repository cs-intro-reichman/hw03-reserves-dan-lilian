public class Calendar {
    static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     
	static int nDaysInMonth = 31; 
	
	public static void main(String args[]) {
		int chosenYear = Integer.parseInt(args[0]);
		int numberOfSundays=0;
	 	while (year<chosenYear) {	
	 		advance();
	 		}
        while (year<=chosenYear) {
            if (dayOfWeek==1)
            {
               System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday"); 	
            }else
            {
                 System.out.println(dayOfMonth + "/" + month + "/" + year);
            }	
               
            advance();
            }
        
     }
	
	 private static void advance() {
		if (dayOfMonth<nDaysInMonth(month, year))
		{
			dayOfMonth++;
		}else {
			if (month<12)
			{
				month++;
			}else
			{
				year++;
				month =1;
			}
			dayOfMonth=1;
		}
		if (dayOfWeek<7)
		{
			dayOfWeek++;
		}else{
			dayOfWeek=1;
		}
	 } 
		 

	private static boolean isLeapYear(int year) {
	    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			return true;
		} else return false;
	}
	 
	
	private static int nDaysInMonth(int month, int year) {
		if ( month== 4||month== 6||month== 9||month== 11)
		{
			return 30;
		} else if (month==2 && isLeapYear(year)== true)
		{
			return 29;
		} else if (month==2 && isLeapYear(year)==false)
		{
			return 28;
		}else {
			return 31;
		}

	}

}
