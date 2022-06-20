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

        //If we allow only 3 threads to be in the ThreadPool that means that only 3 users will be
        //executing the message.The case is, if I make 5 runnable objects which in our case are Multithreading
        //objects and write some message which should be taken as a task and be executed. The first runnable(Maja) will take
        //first task, second(Stasa) that we added will take second, and the third(Ana) one will take third meessage.
        //The second we enter forth message it will not be executed by forth ruunable(Nikola) becouse in this case we
        //said that the pool has 3 threads and in that moment the the other runnables are available and one of them
        //will take that task and execute the message in the chet. So if we want to have 5 users(runnables) using the chat,
        //we also need to have 5 threads in the pool so the other two can execute the given input(message).


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
