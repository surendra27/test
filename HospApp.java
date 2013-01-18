import  java.lang.*;
import java.io.*;

class Doctor
{
  private String name;
  private String spez;
  private int noofdays;
  private int daynos[];
  private int patcount[][];
  public void getData()
  throws IOException
  {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter name : ");
    name=br.readLine();
    System.out.print("Enter spez : ");
    spez=br.readLine();
    System.out.print("Enter number of days : ");
    noofdays=Integer.parseInt(br.readLine());
    daynos=new int[noofdays];
    patcount=new int[2][noofdays];
    for(int i=0;i<noofdays;i++)
    {
      System.out.print("Enter day number for day " + (i+1) + " : " );
      daynos[i]=Integer.parseInt(br.readLine());
      System.out.print("Enter patient count in Session 1 : ");
      patcount[0][i]=Integer.parseInt(br.readLine());
      System.out.print("Enter patient count in Session 2 : ");
      patcount[1][i]=Integer.parseInt(br.readLine());
    }
  }

  public void printData(int sn)
  {
      System.out.print("\n" + sn + "\t" + name + "\t" + spez);
      for(int i=0;i<2;i++)
      {
        System.out.print("\n\t\t\tS" + (i+1) + "\t");
        int k=0;
        for(int j=1;j<=6;j++)
        {
          if(k<noofdays && j==daynos[k])
          {
            System.out.print(patcount[i][k] + "  ");
            k++;
          }
          else
           System.out.print("--  ");
        }
      }
  }
}

class OutDoor
{
   public static void main(String args[])
   throws IOException
   {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int n;
     System.out.print("Enter number of Doctors : ");
     n=Integer.parseInt(br.readLine());
     Doctor darr[]=new Doctor[n];
     for(int i=0;i<n;i++)
      darr[i]=new Doctor();
     for(int i=0;i<n;i++)
     {
       System.out.println("\nEnter Details of Doctor " + (i+1) + " : ");
       darr[i].getData();
     }
     System.out.println("\n\n\nWeekly Report...");
     System.out.println("\nSN\tNAME\tSPEZ\tSs\tMn  Tu  Wd  Th  Fr  Sa");
     for(int i=0;i<n;i++)
      darr[i].printData(i+1);
   }
}
















