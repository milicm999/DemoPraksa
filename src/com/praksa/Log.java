package com.praksa;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class Log {

    public static final Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Log()
    {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        ConsoleHandler ch=new ConsoleHandler();
        ch.setLevel(Level.ALL);
        logger.addHandler(ch);


        try {
            FileHandler fh = new FileHandler("myLogger.log");
            fh.setLevel(Level.INFO);
            logger.addHandler(fh);

        }
        catch(IOException e)
        {
            logger.log(Level.SEVERE,"File logger not working",e);
        }


    }


}
