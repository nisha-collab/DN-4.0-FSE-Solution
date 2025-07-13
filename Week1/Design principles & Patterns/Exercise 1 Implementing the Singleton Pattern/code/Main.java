package Week1.DesignPatterns.SingletonPatternExample.code;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        System.out.println("Are both logger instances the same? " + (logger1 == logger2));
    }
}
