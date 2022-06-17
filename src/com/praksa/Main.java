package com.praksa;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
import com.threads.Multithreading;



public class Main {

    static final Logger logger= Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws InterruptedException {


//        Employee maja=new Employee();
//        System.out.println("Hello");
//        maja.setJmbg("123");
//        maja.setJmbg("");
//        maja.getCVfile();
        ArrayList<Multithreading> array=new ArrayList<>();
        boolean runningOut=true;
        Scanner scanner=new Scanner(System.in);
        System.out.println("How many users will be in chat?");
        int numOfUsers=scanner.nextInt();
        System.out.println("What are the names of users in this group?");
        for(int i=0;i<numOfUsers;i++)
        {
            scanner.nextLine();
            System.out.println("Dodaj: ");
            String name=scanner.nextLine();
            System.out.println("dodajem "+name);
            Multithreading user=new Multithreading(i,name);
            array.add(user);
        }
        System.out.println(array.size());
        System.out.println("Chatroom \n");

        for(int i=0;i<numOfUsers;i++)
        {
            System.out.println(array.get(i).getNameOf() + ": I am in.");
        }

        for(int i=0;i<numOfUsers;i++)
        {
            array.get(i).start();
        }
        for (int i=0;i<numOfUsers;i++)
        {
            array.get(i).join();
        }


//        while(runningOut)
//        {
//            System.out.println("Send with?");
//            String username=scanner.nextLine();
//            for(int i=0;i<numOfUsers;i++)
//            {
//                if(array.get(i).getNameOf()==username) {
//                    array.get(i).start();
//
//                    if (array.get(i).getRunning()==false)
//                        runningOut=false;
//                }
//
//            }
//        }

//        for(int i=0;i<numOfUsers;i++)
//        {
//            array.get(i).start();
//        }
//        for(int i=0;i<numOfUsers;i++)
//        {
//            array.get(i).join(2000);
//        }













//        int current=0;
//        System.out.println("Who are you? \n");
//        String name=scanner.nextLine();
//        for(int k=0;k<numOfUsers;k++)
//        {
//            if(array[k].getName()==name)
//            {
//                array[k].start();
//                while(runningOut)
//                {
//                    for(int j=0;j<numOfUsers;j++)
//                    {
//                        if (array[k].getOther() == array[j].getOther() && array[k].getIndex()!=array[j].getIndex())
//                        {
//                            current=j;
//                            array[j].start();
//                            if(array[j].getRunning()==false)
//                                runningOut=false;
//                        }
//                    }
//                    k=current;
//
//
//                }
//            }
//
//        }







    }



}
