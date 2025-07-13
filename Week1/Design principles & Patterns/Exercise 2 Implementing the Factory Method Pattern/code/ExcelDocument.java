package Week1.DesignPatterns.FactoryMethodPatternExample.code;

public class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel document...");
    }
}
