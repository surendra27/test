import java.lang.*;
import java.awt.*;

class Firstwin extends Frame
{
    Button b1;
public Firstwin()	
	{
           b1 = new Button("hello");
           this.add(b1);
	}
    
}

class General
{
   public static void main(String args[])
   {
        Firstwin win = new Firstwin();
          win.setVisible(true);
   }
}