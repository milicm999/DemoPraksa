package com.praksa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


public class JUnitTests {

    final int VALID_NUM_OF_DIGIT=13;
    @Test
    void test()
    {
        System.out.println("Test is running :D");
    }


    @Test()
    public void test_getFile(File file)
    {
        assertThrows(FileNotFoundExeption.class, () -> Employee.getFile(file));

    }
}
