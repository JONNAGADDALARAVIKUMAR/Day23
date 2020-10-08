package Day23;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Employee_wage_company {
	static int hrs=0,present=0,max=0,totalPay,type;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		
		System.out.print("\n\n\t\t\tWelcome to Employee Wage Computation programme\n\n\tEnter Employee Name : ");
		String name=scan.nextLine();
		
		System.out.print("\n\n\tChoose type of Employee\n\n\t\t1.Full Time\n\t\t2.Part Time\n\n\tEnter Choice : ");
		type = scan.nextInt();
		System.out.print("\n\n*********************************************************************************************");
		
		
			Tcs tcs = new Tcs();
			Wipro wipro = new Wipro();
			Infosys info = new Infosys();
			
			switch(type)
			{
			case 1:
				tcs.fullTime(name);
				wipro.fullTime(name);
				info.fullTime(name);
				break;
			case 2:
				tcs.partTime(name);
				wipro.partTime(name);
				info.partTime(name);
				break;
			default :
				System.out.println("Wrong choice in choosing job type");
				
			}

		}
		
		
		//System.out.println("***********************************************");
	}


class Tcs {
	int max=120,min=60,wagehour=45,workingDays=21;
	String name;
	
	Wage_calculation wage = new Wage_calculation(max,min,wagehour,workingDays);
	
	public void partTime(String name) {
		System.out.println("\n\n\n\t\tEMPLOYEE NAME : "+name+"\n\n\t\tCOMPANY NAME : TCS");
		wage.partTime();
	}
	public void fullTime(String name) {
		System.out.println("\n\n\n\t\tEMPLOYEE NAME : "+name+"\n\n\t\tCOMPANY NAME : TCS");

		wage.fullTime();		
	}
}
class Wipro {
	
	int max=140,min=70,wagehour=60,workingDays=22;
	String name;
	
	
	
	Wage_calculation wage = new Wage_calculation(max,min,wagehour,workingDays);
	
	public void partTime(String name) {
		
		System.out.println("\n\n\n\t\tEMPLOYEE NAME : "+name+"\n\n\t\tCOMPANY NAME : WIPRO");

		wage.partTime();		
	}
	public void fullTime(String name) {
		
		System.out.println("\n\n\n\t\tEMPLOYEE NAME : "+name+"\n\n\t\tCOMPANY NAME : WIPRO");
		wage.fullTime();		
	}

}
class Infosys {
	
	int max=130,min=65,wagehour=55,workingDays=23;
	String name;
	
	
	Wage_calculation wage = new Wage_calculation(max,min,wagehour,workingDays);
	public void fullTime(String name) {
		
		System.out.println("\n\n\n\t\tEMPLOYEE NAME : "+name+"\n\n\t\tCOMPAN NAME : INFOSYS");
		wage.fullTime();		
		
	}
	public void partTime(String name) {
		
		System.out.println("\n\n\n\t\tEMPLOYEE NAME : "+name+"\n\n\t\tCOMPANY NAME : INFOSYS");
		wage.partTime();		
	}

}

class Wage_calculation {
	
	int max,min,wagehour,hrs=0,present=0,workingDays,totalPay,size=0;
	ArrayList<String> data = new ArrayList<String>();
	
	public Wage_calculation(int max, int min, int wagehour, int workingDays) {
		
		this.max=max;
		this.min=min;
		this.wagehour=wagehour;
		this.workingDays=workingDays;
		
	}

	
	public void fullTime()
	{
	
		Random random = new Random();
		
		data.add("\n\n\t\tDay\tAttendence\tHours Worked\tDaily Wage\t    Total Wage");
		//System.out.println(data[size][0]);
		for(int i=1;i<=workingDays;i++)
		{
			int randValue = random.nextInt(9);
			if(randValue <= 4)
			{
				if(hrs<max)
				{
					present++;
					hrs+=8;
					//System.out.println("\t\t "+i+"\t    PR\t\t    "+hrs+"\t\t   "+(wagehour*8)+".00\t\t"+(hrs*wagehour));
					data.add("\t\t "+i+"\t    PR\t\t    "+hrs+"\t\t   "+(wagehour*8)+".00\t\t"+(hrs*wagehour));
					
					
				}
				else if(hrs>=max)
				{
					data.add("\t\t "+i+"\t    AB\t\t    "+hrs+"\t\t   0.00\t\t\t"+(hrs*wagehour));
				}
			}
			else
			{
				data.add("\t\t "+i+"\t    AB\t\t    "+hrs+"\t\t   0.00\t\t\t"+(hrs*wagehour));
			}
		
		}
		if(hrs>max)
		{
			totalPay=max*wagehour;
		}
		else
		{
			totalPay=hrs*wagehour;
		}
		for(String str : data)
		{
			System.out.println(str);
		}
		
		System.out.println("\t\t\t\t\t\t\t\t\t      --------\n\t\t\t\t\t\t\t\t\tTotal\t: "+totalPay+"\n\n\n\t\tNo. of Working days\t: "+workingDays+" \n\n\t\tNo. of days Worked\t: "+present+"\n\n\t\tNo. of Absents\t\t: "+(workingDays-present)+"\n\n\t\ttotal Working Hours\t: "+hrs+"\n\n\t\tMaximum Working Hours\t: "+max);
		System.out.println("\n\t\tTotal wage\t\t: "+totalPay+"\n\n...............................................................................................................");
		size++;
	}
	public void partTime()
	{
		Random random = new Random();

		data.add("\n\n\t\tDay\tAttendence\tHours Worked\tDaily Wage\t   Total Wage");
		for(int i=1;i<=workingDays;i++)
		{
			int randValue = random.nextInt(9);
			if(randValue <= 4)
			{
				if(hrs<min)
				{
					
					present++;
					hrs+=4;
					data.add("\t\t "+i+"\t    PR\t\t    "+hrs+"\t\t   "+(wagehour*4)+".00\t\t"+(hrs*wagehour));
				}
				else if(hrs >=min)
				{
					data.add("\t\t "+i+"\t    AB\t\t    "+hrs+"\t\t   0.00\t\t\t"+(hrs*wagehour));
				}
					
			}
			else
			{
				data.add("\t\t "+i+"\t    AB\t\t    "+hrs+"\t\t   0.00\t\t\t"+(hrs*wagehour));
			}
			size++;
		}
		
	
	if(hrs>min)
	{
		totalPay=min*wagehour;
	}
	else
	{
		totalPay=hrs*wagehour;
	}
	for(String str : data)
	{
		System.out.println(str);
	}
	
	System.out.println("\t\t\t\t\t\t\t\t\t      --------\n\t\t\t\t\t\t\t\t\tTotal\t: "+totalPay+"\n\n\n\t\tNo. of Working days\t: "+workingDays+" \n\n\t\tNo. of days Worked\t: "+present+"\n\n\t\tNo. of Absents\t\t: "+(workingDays-present)+"\n\n\t\ttotal Working Hours\t: "+hrs+"\n\n\t\tMaximum Working Hours\t: "+min);
	System.out.println("\n\t\tTotal wage\t\t: "+totalPay+"\n\n...............................................................................................................");
	size++;
	}
	
}

