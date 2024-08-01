package Week_1_Exercises.Design_Patterns;

import java.util.*;

class Logger {

    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        return instance;
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        if (logger1 == logger2) {
            System.out.println("Logger1 and Logger2 are the same instance.");
        } else {
            System.out.println("Logger1 and Logger2 are different instances.");
        }
    }
}
