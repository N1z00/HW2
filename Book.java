// Base Book class implementing Borrowable interface
public class Book implements Borrowable {
    // Private attributes for encapsulation
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    
    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }
    
    // Getter methods
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Setter methods
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    // Implementation of Borrowable interface
    @Override
    public void borrowItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book '" + title + "' has been borrowed.");
        } else {
            System.out.println("Book '" + title + "' is not available.");
        }
    }
    
    @Override
    public void returnItem() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book '" + title + "' has been returned.");
        } else {
            System.out.println("Book '" + title + "' was not borrowed.");
        }
    }
    
    // toString method
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + 
               ", Available: " + (isAvailable ? "Yes" : "No");
    }
}