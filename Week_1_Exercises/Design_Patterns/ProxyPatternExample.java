package Week_1_Exercises.Design_Patterns;

interface Image {
    void display();
}

class RealImage implements Image {
    String file;

    public RealImage(String file) {
        this.file = file;
        loadImageFromServer(file);
    }

    private void loadImageFromServer(String file) {
        System.out.println("Loading image from remote server...");
    }

    public void display() {
        System.out.println("Displaying image from file...");
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

class ImageViewerTest {
    public void test() {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("To display photo1.jpg:");
        image1.display();

        System.out.println("\nTo display photo1.jpg:");
        image1.display();

        System.out.println("\nTo display photo2.jpg:");
        image2.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        ImageViewerTest imageViewerTest = new ImageViewerTest();
        imageViewerTest.test();
    }
}