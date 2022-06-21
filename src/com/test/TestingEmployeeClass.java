package com.test;
import com.praksa.Log;
import com.praksa.Employee;
import com.praksa.FileNotFoundExeption;
import com.praksa.NotANumberException;
import com.praksa.NumberOfDigitsException;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestingEmployeeClass {
    static int start=1;
    static int end=1;
    final int VALID_NUM_OF_DIGIT=13;
    static Log logr=new Log();

    @BeforeAll
    public static void init()
    {
        logr.logger.info("Tests are starting");
    }
    @AfterAll
    public static void shotdown()
    {
        logr.logger.info("done");
    }

    @BeforeEach
    public void beforeTest()
    {
        logr.logger.info("Test "+ start++ + " started" );
    }

    @AfterEach
    public void afterTest()
    {
        logr.logger.info("Test " + end++ +" finished.");
    }

    public NumberOfDigitsException exception;
    public NotANumberException exception1;

    public FileNotFoundExeption exception2;

    @Test
    public void testCheckJMBG()
    {
        try
        {
            Employee employee1=new Employee();
            employee1.checkJMBG("123");
        }
        catch (NumberOfDigitsException e)
        {
            assertEquals("JMBG need to be 13 digit number! \n",e.getMessage());
            logr.logger.log(Level.INFO,"Test checkJMBG() method passed",e.getMessage());
        }
    }
    @Test
    public void testIsANumber()
    {
        try
        {
            Employee employee=new Employee();
            employee.isANumber(null);
        }
        catch(NotANumberException e)
        {
            assertEquals("JMBG cannot be null value! \n",e.getMessage());
            logr.logger.log(Level.INFO,"Test isANumber() method passed",e.getMessage());
        }
    }
    @Test
    public void testSetJmbg()
    {
        Employee employee=new Employee();
        String actual="1234567891234";
        employee.setJmbg(actual);
        String expected= employee.getJmbg();
        assertEquals(expected,actual);
    }

    @Test
    public void testCheckFile()
    {
        try
        {
            Employee employee = new Employee();
            employee.checkFile(null);

            fail(); //if code does not throw any exceptions, it means that test failed.
        }
        catch(FileNotFoundExeption e)
        {
            assertEquals("Entered file does not exist!", e.getMessage());
        }
    }
    @Test
    public void testSetCvFile()
    {
        Employee employee=new Employee();
        employee.setCVfile("C:/Users/Public/Vezbe_1_RTSI.pdf");
        File expected=new File("C:/Users/Public/Vezbe_1_RTSI.pdf");
        File actual=employee.getCVfile();
        assertEquals(expected,actual);
    }
    @Test
    public void testLog()
    {
        try
        {
            Log logr = new Log();
            throw new IOException();
        }
        catch (IOException e)
        {
            assertEquals(null,e.getMessage());
        }
    }
    @Test
    public void testGetCVfile()
    {
        try
        {
            Employee employee= new Employee();
            employee.getCVfile();
        }
        catch (FileNotFoundExeption e)
        {
            assertEquals("Entered file does not exist!",e.getMessage());
        }
    }

    @Test
    public void TestNumberOfDigitsException()
    {
        String message="Test passed!";
        NumberOfDigitsException n=new NumberOfDigitsException(message);
        assertEquals("Test passed!",n.getMessage());
    }

    @Test
    public void TestNotANumberException()
    {
        String message="Test passed!";
        NotANumberException n=new NotANumberException(message);
        assertEquals(message,n.getMessage());
    }
    @Test
    public void TestFileNotFoundExeption()
    {
        String message="Test passed!";
        FileNotFoundExeption f=new FileNotFoundExeption(message);
        assertEquals(message,f.getMessage());
    }




}
