package Week_1_Exercises.Design_Patterns;

public interface Document {
    void open();

    void close();

    void save();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document.");
    }

    public void close() {
        System.out.println("Closing Word document.");
    }

    public void save() {
        System.out.println("Saving Word document.");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document.");
    }

    public void close() {
        System.out.println("Closing PDF document.");
    }

    public void save() {
        System.out.println("Saving PDF document.");
    }
}

class ExcelDocument implements Document {

    public void open() {
        System.out.println("Opening Excel document.");
    }

    public void close() {
        System.out.println("Closing Excel document.");
    }

    public void save() {
        System.out.println("Saving Excel document.");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}
