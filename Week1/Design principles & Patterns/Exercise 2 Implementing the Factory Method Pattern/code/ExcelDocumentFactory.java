package Week1.DesignPatterns.FactoryMethodPatternExample.code;

public class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}
