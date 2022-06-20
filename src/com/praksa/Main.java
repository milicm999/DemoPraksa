package com.praksa;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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




        ExecutorService executorService= Executors.newFixedThreadPool(3);

        ArrayList<Runnable> array = new ArrayList<>();
        boolean runningOut = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many users will be in chat?");
        int numOfUsers = scanner.nextInt();
        Multithreading userSingleton = Multithreading.getMultithreading(numOfUsers);
        System.out.println("What are the names of users in this group?");
        for (int i = 0; i < numOfUsers; i++) {
            scanner.nextLine();
            System.out.println("Dodaj: ");
            String name = scanner.nextLine();
            userSingleton.setName(name);
            System.out.println("dodajem " + name);
            Thread thread=new Thread(userSingleton);
            array.add(thread);
            System.out.println(name + ": I am in.");
        }
        System.out.println("Chatroom \n");


        for (int i = 0; i < numOfUsers; i++) {
            executorService.execute(array.get(i));
        }


    }

}
