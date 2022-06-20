package com.threads;

import java.util.ArrayList;
import java.util.Scanner;

public class Multithreading implements Runnable{

    private int index;
    private static int threadIndex=0;
    private static int countIndex=0;
    private int numOfUsers;
    private String name;
    private String chat;
    private ArrayList<String> names;
    private static boolean runningIn = true;
    public String getNameOf() {
        return name;
    }

    public Multithreading(int numOfUsrers)
    {
        this.numOfUsers=numOfUsrers;
        names=new ArrayList<>(numOfUsrers);
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

    public void setName(String name)
    {
        names.add(countIndex,name);
        countIndex++;
    }

    public int getThreadIndex()
    {
        return (threadIndex++)%3;

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
                   System.out.println(names.get(getThreadIndex()) + " said: " + chat);
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
