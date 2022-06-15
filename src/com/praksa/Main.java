package com.praksa;

import com.praksa.Employee;

import java.util.logging.Logger;


public class Main {

    static final Logger logger= Logger.getLogger(Main.class.getName());
    public static void main(String[] args){



        Employee maja=new Employee();


        System.out.println("Hello");

        maja.setJmbg("123");
        maja.setJmbg("");

        maja.getCVfile();
    }


}
