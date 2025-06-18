package Week1.DesignPatterns.FactoryMethodPatternExample.code;

public class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}
