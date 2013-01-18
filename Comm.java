import java.lang.*;

class Box
{
  private int count;
  private boolean produced;
  Box()
  {
      count=0;
      produced=false;
  }
  synchronized public void put()
  {
      if(produced)
      {
          try {
              //wait();
              wait(500);
          } catch (Exception e) {

          }
      }
      count++;
      System.out.println("Produced : " + count);
      produced=true;
      notify();
      //notifyAll();
  }
  synchronized public void get()
  {
      if(!produced)
      {
          try {
              wait();
          } catch (Exception e) {

          }
      }
      count--;
      System.out.println("Consumed : " + count);
      produced=false;
      notify();
  }
}

class Producer extends Thread
{
    Box box;
    volatile boolean running;
    Producer(Box b)
    {
        box=b;
        running=false;
    }
    public void startThread()
    {
        running=true;
        start();
    }
    public void terminateThread()
    {
        running=false;
    }
    public void run()
    {
        while(running)
        {
            box.put();
            try {
                Thread.sleep(70);
            } catch (Exception e) {

            }
        }
    }
}

class Consumer extends Thread
{
    Box box;
    volatile boolean running;
    Consumer(Box b)
    {
        box=b;
        running=false;
    }
    public void startThread()
    {
        running=true;
        start();
    }
    public void terminateThread()
    {
        running=false;
    }
    public void run()
    {
        while(running)
        {
            box.get();
            try {
                Thread.sleep(120);
            } catch (Exception e) {

            }
        }
    }
}

public class Comm
{
    public static void main(String args[])
    {
        Box box=new Box();
        Producer producer=new Producer(box);
        Consumer consumer=new Consumer(box);
        producer.startThread();
        consumer.startThread();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        producer.terminateThread();
        consumer.terminateThread();
    }
}