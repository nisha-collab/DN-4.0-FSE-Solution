package Week1.DesignPatterns.FactoryMethodPatternExample;

public class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}
