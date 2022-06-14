package com.test;
import com.praksa.Log;
import com.praksa.Employee;
import com.praksa.FileNotFoundExeption;
import com.praksa.NotANumberException;
import com.praksa.NumberOfDigitsException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import java.util.List;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;


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




    @Test()
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
            //logr.logger.log(Level.INFO,"Testing getFile() method");
        }


    }
    @Test
    public void testCheckJmbg()
    {
        try
        {
            Employee employee = new Employee();
            employee.checkJMBG("123");

            fail();
        }
        catch (NumberOfDigitsException e)
        {
            assertEquals("JMBG need to be 13 digit number! \n", e.getMessage());
            //logr.logger.log(Level.INFO,"Testing checkJmbg() method");

        }
    }



    @Test
    public void testIsANumber()
    {
        assertThrows(NotANumberException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Employee employee= new Employee();
                employee.isANumber("");
                //logr.logger.log(Level.INFO,"Testing isAnNumber() method");

            }

        });
    }
}
