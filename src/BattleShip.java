import java.util.Scanner;

public class Battleboard
{
	static int[][] board=new int[10][10];
	static int[] ships=new int[15];
	public static void main(String[] args)
	{	
		
		// Initialization;
		 for(int row=0 ; row < 10 ; row++ )
	            for(int column=0 ; column < 10 ; column++ )
	                board[row][column]=1;
		 
		 for(int r=0 ; r < 15 ; r++ )
			 {ships[r]=0;}
	
		 
		 printBoard();
		 int n = 1;
		 while (n<6)
		 {
			System.out.println("Deploy Your "+n+" Ship");
		 	int s1;
			int s2;
			String s3;
			Scanner in = new Scanner(System.in);
			System.out.println("Write the row:");
			s1 = in.nextInt();
			in = new Scanner(System.in);
			System.out.println("Write the cloumn:");
			s2= in.nextInt();
			in = new Scanner(System.in);			
			System.out.println("Choose From; BigShip,MediumShip and SmallShip:");
			s3 = in.nextLine();
			
			boolean a=addShip(s3, s1, s2);
			
			if (a==true)
			{
				System.out.println("Ship Deployed");
				System.out.println("");
				printBoard();
				n=n+1;
			}
			else 
			{
				System.out.println("Ship not Deployed \n");
			}
		 }
		
			int n1=0;
			System.out.println("You have ten turns, please hit five bombs a turn.");
			for (int h=0;h<10;h++)
			{
				int h1=0;
				System.out.println("Try Number :"+(h+1) );
				while (h1<5)
				{  
					System.out.println("Bomb Number :"+(h1+1) );
					int s4;
					int s5;
					Scanner in = new Scanner(System.in);
					System.out.println("Enter the row:");
					s4 = in.nextInt();
					in = new Scanner(System.in);
					System.out.println("Enter the cloumn:");
					s5= in.nextInt();
					shoot(s4,s5);
					printBoard();
					
					if (board[s4][s5]==1||board[s4][s5]==2)
						h++;
						
					if (board[s4][s5]==3||board[s4][s5]==4)
						{
							ships[n1]=0;
							n1=n1+1; 
						}
					
					if (n1==15)
						break;
							
				}
			}
			
			boolean d= isLost();
			if (d==true)
				System.out.println("You Won");
			else
				System.out.println("You Lost");
	}

	public static void printBoard() { 
		 System.out.println("\t1 \t2 \t3 \t4 \t5\t6\t7\t8\t9\t10");
	        System.out.println();
	        int a=65;
	        
	        for(int row=0 ; row < 10 ; row++ ){
	            System.out.print(((char)a)+"");
	            for(int column=0 ; column < 10 ; column++ ){
	                if(board[row][column]==1||board[row][column]==2){
	                    System.out.print("\t"+ "_|");
	                }else if(board[row][column]==4){
	                    System.out.print("\t"+"0");
	                }else if(board[row][column]==3){
	                    System.out.print("\t"+"X");
	                }
	                
	            }
	            a=a+1;
	            System.out.println();
	        } 
	 } 
	 static int k=0;
	 static int k1=0;
	 static int k2=0;
	 
	public static boolean addShip(String x, int xcor, int ycor) {
	 
		int j=0;
		
		try {
			
			
			if (x.equals("BigShip") && k==0)
			{
			for (int s=xcor-1;s<xcor+4;s++)
			{
				if (board[s][ycor]==1)
					{
						board[s][ycor]=2;
						j=j+1;
						k=1;
					}
				else 
					{
						k=0;
						break;					
					}
			}
		}
			if (x.equals("MediumShip") && k1!=2)
				k1=k1+1;
			{
			for (int s=xcor-1;s<xcor+2;s++)
			{
				if (board[s][ycor]==1)
					{
						board[s][ycor]=2;
						j=j+1;
					}
				else 
					{
						k1=k1-1;
						break;
					}
			}
		}
			if (x.equals("SmallShip") && k2!=2)
			{
				k2=k2+1;
			for (int s=xcor-1;s<xcor+1;s++)
			{
				if (board[s][ycor]==1)
					{
						board[s][ycor]=2;
						j=j+1;
					}
				else 
					{
						k2=k2-1;
						break;
					}
				}
			}
			if (j==5||j==3||j==2)
				return true;
			else
				return false;
		
		
		}catch (Exception e)
				{
					return false;
				}
					
		}


	public static void shoot(int xcor, int ycor)
	
	{ 
	 
		if (board[xcor][ycor]==2)
			{board[xcor][ycor]=3;}
		else if (board[xcor][ycor]==1)
			{board[xcor][ycor]=4;}
	 
	 } 
	 
	public static boolean isLost() {
		int j=0;
		for (int n=0;n<15;n++)
			{
			if (ships[n]==0)
				j=j+15;
			else
				break;
			}
		
		if (j==15)
			return true;
		else
			return false;
	 
	 }
}

