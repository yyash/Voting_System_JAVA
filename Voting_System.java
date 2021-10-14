import java.util.*;
import java.io.*;
import java.lang.*;

class makingVoterID
{
	int age;
	String name,locality;
	char gender;
   public void read()
    {	
        Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t\t\t\t\t WELCOME NEW VOTER");
        System.out.println("Enter name of the voter : ");
        name = sc.next();
		System.out.println("Enter locality of the voter :\n1.Southern\n2.Central\n3.Western ");
        locality = sc.next();      
	System.out.println("Enter gender of the voter : ");
		gender = sc.next().charAt(0);        
	System.out.println("Enter age of the voter : ");
		age = sc.nextInt();
        
    }
}
class Main extends makingVoterID
{ 
    Scanner sc = new Scanner(System.in);
    public static void main(String args[])
    {
	int counter[] = new int[4];
	int n,i;
        counter[0] = 0;
	counter[1] = 0;
        counter[2] = 0;
	counter[3] = 0;
        makingVoterID id[] = new makingVoterID[1000];
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,00);
        cal.set(Calendar.MINUTE,11);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        n=1;
		int j,flag=0;
		
        	for(i=0;i<n;i++)
        	{
			boolean time = Calendar.getInstance().after(cal);
			if(time)
			{
				System.out.println("The voting lines are CLOSED now."); 
				break;
                   
			}
			else
			{
		
     	   	    		id[i] = new makingVoterID();
				id[i].read();
				if(id[i].age<18)
				{
					System.out.println("UNDERAGE");
					i--;
					continue;
				
				
				}
			
			
				for(j=0;j<i;j++)
				{
					if(id[i].age==id[j].age&&id[i].name.equalsIgnoreCase(id[j].name)&&id[i].locality.equalsIgnoreCase(id[j].locality))
					{
						System.out.println("Sorry, you have already voted.");
						flag = 1;
					    	break;
					}
				}
				if(flag==1)
				{	
					i--;
					continue;
            			}
	
          		
			
			            
				System.out.println("\t\t\t\t\t\t-----MUMBAI ELECTION-----");
        			System.out.println("\t\t\t\t\t\tThe parties contesting are : ");
       				System.out.println("\t\t\t\t\t\t1. Topper's Society (Party Number- 111)");
        			System.out.println("\t\t\t\t\t\t2. Backbenchers' Asscoiation (Party Number-786)");
        			System.out.println("\t\t\t\t\t\t3. Defaulter's Janta Party (Party Number- 365)");
        			System.out.println("\t\t\t\t\t\t4. Aam Vidyarthi Party (Party Number- 123)");
				counter = count(counter);
				n++;
			}
		 	
     } 
	makingVoterID copy[] = new makingVoterID[i];
	System.arraycopy(id,0,copy,0,i);		
	display(counter,copy);
}              
    
    static int[] count(int counter[])
    {
  
    Scanner sc = new Scanner(System.in);
        System.out.println("Enter a valid party number : ");
        int pn = sc.nextInt();
    
        switch(pn)
        {
            case 111 : counter[0]++; 
			break;
			
			
            case 786 : counter[1]++; 
			break; 
			
            case 365 : counter[2]++; 
			break;
			
            case 123 : counter[3]++;
			break; 
			
            default  : System.out.println("Invalid Party Number.");
					counter = count(counter);        
        }
		 return counter;
	}   
    
	

	
	static void display(int counter[],makingVoterID copy[])
	{			
			int total=0;
			total=counter[0]+counter[1]+counter[2]+counter[3];
			System.out.println("Total number of VOTES are : "+total);
			float tsperc = counter[0]/(float)total *100;
			float bbperc = counter[1]/(float)total *100;
			float djpperc = counter[2]/(float)total *100;
			float avpperc = counter[3]/(float)total *100;
			System.out.println("\t\tPARTY\t\t\t\tVOTES\t\t\t\tPERCENTAGE\n");
			System.out.println("\t\tTopper Society\t\t\t"+counter[0]+"\t\t\t\t"+tsperc);
			System.out.println("\t\tBackbenchers Association\t"+counter[1]+"\t\t\t\t"+bbperc);
			System.out.println("\t\tDefaulter Janta Party\t\t"+counter[2]+"\t\t\t\t"+djpperc);
			System.out.println("\t\tAam Vidyarthi Party\t\t"+counter[3]+"\t\t\t\t"+avpperc);
			System.out.println("\n\n\n\n\n\n\n\t\t\t\t\t\tSTATS OF THE VOTING");
			int large = counter[0];
			int i,j,w=0,c=0,s=0,male=0,female=0;
			for(i=0;i<4;i++)
			{
				if(counter[i]>large)
					large=counter[i];
			}
			
			if(counter[0]==large&&counter[0]!=counter[1]&&counter[0]!=counter[2]&&counter[0]!=counter[3])
				System.out.println("\t\tTOPPER'S SOCIETY IS THE WINNER!");
			else if(counter[1]==large&&counter[1]!=counter[0]&&counter[1]!=counter[2]&&counter[1]!=counter[3])
				System.out.println("\t\tBACKBENCHER'S ASSOCIATION IS THE WINNER!");
			else if(counter[2]==large&&counter[2]!=counter[1]&&counter[2]!=counter[0]&&counter[2]!=counter[3])
				System.out.println("\t\tDEFAULTER JANTA PARTY IS THE WINNER!");
			else if(counter[3]==large&&counter[3]!=counter[0]&&counter[3]!=counter[1]&&counter[3]!=counter[2])
				System.out.println("\t\tAAM VIDYARTHI PARTY IS THE WINNER!");
			else
				{
					for(i=0;i<4;i++)
					{
						for(j=3;j>i;j--)
						{
							if(counter[i]==large && counter[j]==large && counter[i]!=0)
							{	if(i==0&&j==1)
								System.out.println("It's a Tie between Topper Society and Backbenchers Association\n");
								if(i==0&&j==2)
								System.out.println("It's a Tie between Topper Society and Defaulter Janta Party\n");
								if(i==0&&j==3)
								System.out.println("It's a Tie between Topper Society and Aam Vidyarthi Party\n");
								if(i==1&&j==2)
								System.out.println("It's a Tie between Backbenchers Association and Defaulter Janta Party\n");	
								if(i==1&&j==3)
								System.out.println("It's a Tie between Backbenchers Association and Aam Vidyarthi Party\n");
								if(i==2&&j==3)
								System.out.println("It's a Tie between Defaulter Janta Party and Aam Vidyarthi Party\n");
								
							}
						}
					}
				}
			
			for(i=0;i<copy.length;i++)
			{
				if(copy[i].locality.equalsIgnoreCase("western"))
					w++;
				if(copy[i].locality.equalsIgnoreCase("central"))
					c++;
				if(copy[i].locality.equalsIgnoreCase("southern"))
					s++;
				if(copy[i].gender=='m'||copy[i].gender=='M')
					male++;
				if(copy[i].gender=='f'||copy[i].gender=='F')
					female++;
				
			}
			//int total1=0;
			//total1 = w+c+s;
			float wperc = w/(float)total*100;
			float cperc = c/(float)total*100;
			float sperc = s/(float)total*100;
			float mperc = male/(float)total*100;
			float fperc = female/(float)total*100;
			System.out.println("\t\tAREA\t\t\tVOTE PERCENTAGE");
			System.out.println("\t\tSOUTHERN\t\t"+sperc);
			System.out.println("\t\tCENTRAL\t\t\t"+cperc);
			System.out.println("\t\tWESTERN\t\t\t"+wperc);
			System.out.println("\n\n\n");
			System.out.println("\t\tGENDER\t\t\tVOTE PERCENTAGE");
			System.out.println("\t\tFEMALES\t\t\t"+fperc);
			System.out.println("\t\tMALES\t\t\t"+mperc);
			
			
			
			
	}
}   
