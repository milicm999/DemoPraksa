package com.threads;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Multithreading extends Thread{

    private int index;

    private String name;
    private String chat;
    private static boolean runningIn = true;
    public String getNameOf() {
        return name;
    }

    public Multithreading(int index, String name)
    {
        this.index=index;
        this.name=name;
    }

    public int getIndex()
    {
        return this.index;
    }

    public boolean getRunning()
    {
        if(runningIn==false)
        {
            return false;
        }
        else {
            return true;
        }
    }


   public void message()
   {
       synchronized (this)
       {
           while (runningIn) {
               Scanner scanner = new Scanner(System.in);
               String chat = scanner.nextLine();
               this.chat = chat;
               if (chat == "f")
                   runningIn = false;
               else {
                   System.out.println(name + " said: " + chat);
                   System.out.println("Finished.");
                   this.notifyAll();
               }
           }
       }


   }


    @Override
    public synchronized void run()
    {
        Scanner scanner = new Scanner(System.in);
        message();
        System.out.println(name+ " in message method");
        synchronized (this)
        {
            while(runningIn)
            {
                System.out.println("Waithing to finish");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Other thread finished");
        }



    }
}
