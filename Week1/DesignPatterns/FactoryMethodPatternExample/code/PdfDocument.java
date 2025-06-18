package Week1.DesignPatterns.FactoryMethodPatternExample.code;

public class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document...");
    }
}
