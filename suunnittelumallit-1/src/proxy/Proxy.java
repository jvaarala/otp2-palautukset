package proxy;

import java.util.ArrayList;
import java.util.List;

interface Image {
    public void displayImage();
    public void showData();
}

// On System A
class RealImage implements Image {
    private final String filename;

    /**
     * Constructor
     * @param filename
     */
    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    /**
     * Loads the image from the disk
     */
    private void loadImageFromDisk() {
        System.out.println("Loading   " + filename);
    }

    /**
     * Displays the image
     */
    public void displayImage() {
        System.out.println("Displaying " + filename);
    }

    @Override
    public void showData() {
        System.out.println("Showing data  " + filename);
    }
}

// On System B
class ProxyImage implements Image {
    private final String filename;
    private RealImage image;

    /**
     * Constructor
     * @param filename
     */
    public ProxyImage(String filename) {
        this.filename = filename;
    }

    /**
     * Displays the image
     */
    public void displayImage() {
        if (image == null) {
            image = new RealImage(filename);
        }
        image.displayImage();
    }

    @Override
    public void showData() {
        if (image == null) {
            image = new RealImage(filename);
        }
        image.showData();
    }
}

class Proxy {
    /**
     * Test method
     */
    public static void main(final String[] arguments) {
        ArrayList<Image> imageList = new ArrayList<>();


        imageList.add(new ProxyImage("HiRes_10MB_Photo1"));
        imageList.add(new ProxyImage("HiRes_10MB_Photo2"));
        imageList.add(new ProxyImage("HiRes_10MB_Photo3"));
        imageList.add(new ProxyImage("HiRes_10MB_Photo4"));

        for (Image image : imageList) {
            image.showData();
            image.showData();
        }

//        Image image1 = new ProxyImage("HiRes_10MB_Photo1");
//        Image image2 = new ProxyImage("HiRes_10MB_Photo2");
//
//        image1.displayImage(); // loading necessary
//        image1.displayImage(); // loading unnecessary
//        image2.displayImage(); // loading necessary
//        image2.displayImage(); // loading unnecessary
//        image1.displayImage(); // loading unnecessary
    }
}

