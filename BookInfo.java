import java.io.*;    
import java.awt.Desktop;

public class BookInfo {     //assignment 01
    String title, author, publisher;
    int year;

    BookInfo(String t, String a, String p, int y) {
        title = t;
        author = a;
        publisher = p;
        year = y;
    }

    void display() {
        System.out.println("\n---- Book Information ----");
        System.out.println("Title     : " + title);
        System.out.println("Author    : " + author);
        System.out.println("Publisher : " + publisher);
        System.out.println("Year      : " + year);
    }

    // write + read txt
    void saveAsText() {
        try {
            FileWriter writer = new FileWriter("Ebook.txt");
            writer.write("E-Book Content:\nTitle: " + title + "\nAuthor: " + author +
                         "\nPublisher: " + publisher + "\nYear: " + year);
            writer.close();
            System.out.println("Saved as Text File (Ebook.txt)");
        } catch (IOException e)
        { System.out.println("Error Writing TXT File");
    }
    }

    // PDF save hoga
    void saveAsPDF() {
        try {
            FileOutputStream pdf = new FileOutputStream("Ebook.pdf");
            pdf.write(("E-Book PDF Content\n" +
                       "Title: " + title + "\nAuthor: " + author +
                       "\nPublisher: " + publisher + "\nYear: " + year).getBytes());
            pdf.close();
            System.out.println("Saved as PDF File (Ebook.pdf)");
        } catch (IOException e) 
        { System.out.println("PDF Save Error"); 
    }
    }

void openInNotepad() {
    try {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File("Ebook.txt"));  // system default notepad open hoga
        System.out.println("File opened in Notepad");
    } catch (Exception e) {
        System.out.println("Unable to open file.");
    }
}
}
class EBookInfo extends BookInfo {
    String format;
    double sizeMB;

    EBookInfo(String t, String a, String p, int y, String f, double s) {
        super(t, a, p, y);
        format = f;
        sizeMB = s;
    }

    void displayEBook() {
        display();
        System.out.println("Format : " + format);
        System.out.println("Size   : " + sizeMB + "MB");
    }

}
class RunEBook {
    public static void main(String[] args) {

        EBookInfo eb = new EBookInfo("Java Basics", "Dua Enam", "National Publisher", 2025,"PDF", 4.5);

        eb.displayEBook();  
        eb.saveAsText();    
        eb.saveAsPDF();     
        eb.openInNotepad(); 
    }
}
