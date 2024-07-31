import java.util.*;
class coder
{//class
static int ar[]=new int[9];
static void Random()
{//Random
	int R,f;
	for(int i=0;i<8;i++)
	{//loop1
		do
		{//loop2
			f=0;
			double t=Math.random()*9;
			R=(int)t;

			for(int k=i;k>=0;k--)
			{//loop3
				if(R==ar[k]||R==0)
				{

					f=1;
					break;
				}
			}//loop3
			if(f==0)
			ar[i]=R;
		}while(f==1);
	}//loop1
	ar[8]=0;
	return;
}//random
static void puzzle()
{//puzzle
	int c=0;
	for(int j=0;j<=2;j++)
	{
	for(int i=0;i<=12;i++)
	{//loop4
		if(i%2!=0)
		System.out.print("_");
		else if(i%4==0)
		System.out.print("|");
		else
		{

			if(ar[c]==0)
			System.out.print(" ");
			else
			System.out.print(ar[c]);
			c++;

		}
	}//loop4
	System.out.println();
	}
	return;
}//puzzle
static void replace(int n)
{//replace
int c=0;
	for(int i=0;i<=8;i++)
	{
		if(ar[i]==0&&c==0)
		{
			ar[i]=n;
			c++;
		}
		else if(ar[i]==n&&c==0)
		{
			ar[i]=0;
			c++;
		}
	c=0;
	}
	return ;
}//replace
static boolean win()
{//win
    int min=8;
	for(int i=0;i<=6;i++)
	{
		if(ar[i+1]<ar[i])
		return false;
		else
		min=ar[i];
	}
	return true;
}//win
static boolean valid(int n)
{//win
	for(int i=0;i<=8;i++)
	{
	if(ar[i]==0)
	{
	switch(i)
	{//switch
		case 0:
		if(ar[i+1]==n||ar[i+3]==n)
		return true;

		case 1:
		if(ar[i+1]==n||ar[i-1]==n||ar[i+3]==n)
		return true;
		case 2:
		if(ar[i-1]==n||ar[i+3]==n)
		return true;
		case 3:
		if(ar[i+1]==n||ar[i-3]==n||ar[i+3]==n)
		return true;
		case 4:
		if(ar[i+1]==n||ar[i-1]==n||ar[i+3]==n||ar[i-3]==n)
		return true;
		case 5:
		if(ar[i-1]==n||ar[i+3]==n||ar[i-3]==n)
		return true;
		case 6:
		if(ar[i-1]==n||ar[i-3]==n)
		return true;
		case 7:
		if(ar[i+1]==n||ar[i-1]==n||ar[i-3]==n)
		return true;
	    case 8:
		if(ar[i-1]==n||ar[i-3]==n)
		return true;
	}//switch
}
}
return false;
}//valid
public static void main(String args[])
{//main
	Scanner sc=new Scanner(System.in);
	System.out.println("*BLOCK PUJJLE*");
	System.out.println();

	Random();
	for(;;)
	{
	puzzle();
	System.out.println();
	System.out.println("ENTER NUMBER");
    int n=sc.nextInt();
    if(valid(n))
    replace(n);
    else
    {
    System.out.println();
    System.out.println("INVALID INPUT");
	}
   if( win())
   {
	puzzle();
    break;
	}
	}
	System.out.println();
	System.out.print("WINNER");
}//main
}//class


