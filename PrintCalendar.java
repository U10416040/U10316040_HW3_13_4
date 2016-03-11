//U10416040 ªL¦ö¼á

import java.util.*;

public class PrintCalendar {
	static GregorianCalendar Gcalendar;
	
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		Gcalendar = new GregorianCalendar();//create GregorianCalendar object 
		Date date = new Date();//create Date object
		System.out.println(date.toString());
		
		Gcalendar.setTime(date);//set the current date to GregorianCalendar object
		
		Gcalendar.set(Calendar.DAY_OF_MONTH, 1);//set the first day  of the month
		
		System.out.print("Enter full year(e.g., 2012):");
		int year=input.nextInt();
		
		System.out.print("Enter month as a number 1 and 12:");
		int month=input.nextInt();
		
		printMonth(year, month);
	}
	
	public static void printMonth(int year, int month){
		printMonthTitle(year, month);
		
		printMonthBody(year, month);
	}
	
	public static void printMonthTitle(int year, int month){
		System.out.println("        " + getMonthName(month) + " " + year);
		System.out.println("-----------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}
	
	public static String getMonthName(int month){
		String monthName="";
		switch(month){
			case 1:monthName="Janurary";
			break;
			case 2:monthName="February";
			break;
			case 3:monthName="March";
			break;
			case 4:monthName="April";
			break;
			case 5:monthName="May";
			break;
			case 6:monthName="June";
			break;
			case 7:monthName="July";
			break;
			case 8:monthName="August";
			break;
			case 9:monthName="September";
			break;
			case 10:monthName="October";
			break;
			case 11:monthName="November";
			break;
			case 12:monthName="December";
			break;
		}
		
		return monthName;
	}
	
	public static void printMonthBody(int year, int month){
		int startDay=getStartDay(year, month);
		int numberOfDaysInMonth=getNumberOfDaysInMonth(year, month);
		
		int i;
		for(i=0;i<startDay;i++){
			System.out.print("    ");
		}
		
		for(i=1;i<=numberOfDaysInMonth;i++){
			System.out.printf("%4d", i);
			
			if((i+startDay)%7==0){
				System.out.println();
			}
		}	
		System.out.println();
	}
	
	public static int getStartDay(int year, int month){		
		int D_week = Gcalendar.get(Calendar.DAY_OF_WEEK);//get the day of week
		return D_week-1;//calendar day is one day more than original day
	}
	
	public static int getNumberOfDaysInMonth(int year, int month){
		int total=0;
		
		//to calculate total days of the month, original month is one more than calendar month
		while (Gcalendar.get(Calendar.MONTH) == month-1) {
			total++;
			Gcalendar.add(Calendar.DAY_OF_MONTH, 1);//add one day
		}

		return total;
	}	
}
