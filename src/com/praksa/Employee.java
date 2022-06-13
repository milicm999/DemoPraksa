package com.praksa;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.*;
import java.util.logging.Level;


public class Employee {
    private String name;
    private String surname;
    private String jmbg;
    public File cv;
    final int VALID_NUM_OF_DIGIT=13;

    Log logr=new Log();


    public Employee() {

    }


    public void checkJMBG(String jmbgtest1) throws NumberOfDigitsException
    {
        if(jmbgtest1.length()!=VALID_NUM_OF_DIGIT)
            throw new NumberOfDigitsException("JMBG need to be 13 digit number! \n");
        else
            return;
    }
    public void isANumber(String jmbgtest) throws NotANumberException {
        if(jmbgtest.isEmpty())
            throw new NotANumberException("JMBG cannot be null value! \n");
        else
            return;
    }

    public void setJmbg()
    {
       while(true) {
            try
            {
                System.out.println("Enter your JMBG: ");
                Scanner scanner=new Scanner(System.in);
                String jmbg=scanner.nextLine();
                isANumber(jmbg);
                checkJMBG(jmbg);
                break;
            }
            catch (NotANumberException | NumberOfDigitsException e)
            {
                logr.logger.log(Level.INFO,"A problem occured: " + e);
                continue;
            }
       }
       this.jmbg=jmbg;
    }
    public static void getFile(File file) throws FileNotFoundExeption
    {
        if(file==null)
            throw new FileNotFoundExeption("Entered file does not exist!");
        else
            return;
    }

    public void getCVfile(Employee employee)
    {
        try {
            getFile(employee.cv);
        }
        catch (FileNotFoundExeption e)
        {
            logr.logger.log(Level.INFO,"A problem occured: " + e);
        }
    }
}
