import java.lang.*;
import java.io.*;
class hw1{

	public static void main(String args[]){

		pattern p = new pattern();
		int pattern,limit=0;

		try{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		
		while(true){
		System.out.println("which pattern do u want to execute(1/2/exit):");
		pattern = Integer.parseInt(br.readLine());

		if(pattern==1||pattern==2){
		System.out.println("enter the limit for the pattern:");
		limit = Integer.parseInt(br.readLine());
		}

		if(pattern==1){
			p.pattern1(limit);
		}
		else if(pattern == 2){
			p.pattern2(limit);
		}
		else{System.exit(0);}
		}
		}catch(Exception e){}
	}
}
	
class pattern{
	
	public static void pattern1(int n){
		for(int i=1;i<=n;i++){
			int j = i;
			for(int k=1;k<=n-j;k++){
				System.out.print("  ");
			}
			int k = 1;
			while(k<=j){
				System.out.print(k+" ");
				k++;
			}
			int p=k-2;
			while(p>=1){
		
				System.out.print(p+" ");
				p--;		
			}
			System.out.println();
		}
	}

	public static void pattern2(int n){
		for(int i =1;i<=n;i++){
			int j = i;
			for(int k =1;k<=n-j;k++){
				System.out.print("  ");
			}
	
			for(int k =j;k>=1;k--){
				System.out.print(i+"   ");
			}
		System.out.println();
		}
	}
}
			