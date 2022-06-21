package com.praksa;

import java.io.File;
import java.util.logging.Level;


public class Employee {
    private String name;
    private String surname;


    private String jmbg;
    private File cv;
    final int VALID_NUM_OF_DIGIT=13;

    Log logr=new Log();


    public Employee() {

    }
    public String getJmbg() {
        return jmbg;
    }


    public void checkJMBG(String jmbgtest1) throws NumberOfDigitsException
    {
        if(jmbgtest1.length()!=VALID_NUM_OF_DIGIT)
            throw new NumberOfDigitsException("JMBG need to be 13 digit number! \n");
        else
            return;
    }
    public void isANumber(String jmbgtest) throws NotANumberException {
        if(jmbgtest==null)
            throw new NotANumberException("JMBG cannot be null value! \n");
        else
            return;
    }
    public void setJmbg(String jmbg1)
    {
        try
        {
            isANumber(jmbg1);
            checkJMBG(jmbg1);
        }
        catch (NotANumberException | NumberOfDigitsException e)
        {
            logr.logger.log(Level.INFO,"A problem occured: " + e);
        }
        this.jmbg=jmbg1;
    }
    public void checkFile(File file) throws FileNotFoundExeption
    {
        if(file==null)
            throw new FileNotFoundExeption("Entered file does not exist!");
        else
            return;
    }

    public File getCVfile()
    {
        try {
            checkFile(this.cv);
        }
        catch (FileNotFoundExeption e)
        {
            logr.logger.log(Level.INFO,"A problem occured: " + e);
        }
        return this.cv;
    }
    public void setCVfile(String pathname)
    {
        this.cv= new File(pathname);
    }
}
