package com.test;
import com.praksa.Log;
import com.praksa.Employee;
import com.praksa.FileNotFoundExeption;
import com.praksa.NotANumberException;
import com.praksa.NumberOfDigitsException;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;




public class JUnitTests {
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
    public void testCheckJMBG() throws NumberOfDigitsException
    {
        Employee employee1=mock(Employee.class);
        exception=new NumberOfDigitsException("JMBG need to be 13 digit number! \n");
        doThrow(exception).when(employee1).checkJMBG("123");
        logr.logger.log(Level.ALL,exception.getMessage());
    }
    @Test
    public void testIsANumber() throws NotANumberException
    {
        Employee employee1=mock(Employee.class);
        exception1=new NotANumberException("JMBG cannot be null value! \n");
        doThrow(exception1).when(employee1).isANumber("");
        logr.logger.log(Level.ALL,exception1.getMessage());
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
    public void testgetFile()
    {
        try
        {
            Employee employee = new Employee();
            employee.getFile(null);

            fail(); //if code does not throw any exceptions, it means that test failed.
        }
        catch(FileNotFoundExeption e)
        {
            assertEquals("Entered file does not exist!", e.getMessage());
        }
    }
    @Test
    public void testGetCvFile()
    {
        Employee employee=new Employee();
        employee.cv=new File("C:/Users/milicm/maja faks/vestacka inteligencija/matlab-vezbe/Vezbe_1_RTSI.pdf");
        File expected=employee.cv;
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




}
