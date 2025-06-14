import java.util.*;

// Library class implementing Singleton Pattern
public class Library {
    // Static instance for Singleton Pattern
    private static Library instance = null;
    
    // Collections to store library items
    private List<Borrowable> items;
    
    // Private constructor for Singleton Pattern
    private Library() {
        items = new ArrayList<>();
    }
    
    // Method to get single instance of Library (Singleton Pattern)
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }
    
    // Method to add book or magazine to collection
    public void addBook(Borrowable item) {
        items.add(item);
        System.out.println("Item added to library successfully!");
    }
    
    // Overloaded method to add book with different parameters
    public void addBook(String title, String author, String isbn) {
        Book book = new Book(title, author, isbn);
        items.add(book);
        System.out.println("Book added to library successfully!");
    }
    
    // Method to remove book from collection
    public void removeBook(String identifier) {
        for (int i = 0; i < items.size(); i++) {
            Borrowable item = items.get(i);
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.getIsbn().equals(identifier) || book.getTitle().equals(identifier)) {
                    items.remove(i);
                    System.out.println("Book removed successfully!");
                    return;
                }
            } else if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                if (magazine.getTitle().equals(identifier)) {
                    items.remove(i);
                    System.out.println("Magazine removed successfully!");
                    return;
                }
            }
        }
        System.out.println("Item not found!");
    }
    
    // Method to search books by title
    public void searchBook(String title) {
        boolean found = false;
        System.out.println("Search results:");
        for (Borrowable item : items) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    System.out.println(book);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No books found with that title!");
        }
    }
    
    // Overloaded method to search by title and author
    public void searchBook(String title, String author) {
        boolean found = false;
        System.out.println("Search results:");
        for (Borrowable item : items) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.getTitle().toLowerCase().contains(title.toLowerCase()) &&
                    book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                    System.out.println(book);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No books found with that title and author!");
        }
    }
    
    // Method to borrow book
    public void borrowBook(String identifier) {
        for (Borrowable item : items) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.getIsbn().equals(identifier) || book.getTitle().equals(identifier)) {
                    item.borrowItem();
                    return;
                }
            } else if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                if (magazine.getTitle().equals(identifier)) {
                    item.borrowItem();
                    return;
                }
            }
        }
        System.out.println("Item not found!");
    }
    
    // Method to return book
    public void returnBook(String identifier) {
        for (Borrowable item : items) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.getIsbn().equals(identifier) || book.getTitle().equals(identifier)) {
                    item.returnItem();
                    return;
                }
            } else if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                if (magazine.getTitle().equals(identifier)) {
                    item.returnItem();
                    return;
                }
            }
        }
        System.out.println("Item not found!");
    }
    
    // Method to find available items
    public void findAvailableItems() {
        System.out.println("Available items in library:");
        boolean hasAvailable = false;
        for (Borrowable item : items) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.isAvailable()) {
                    System.out.println(book);
                    hasAvailable = true;
                }
            } else if (item instanceof Magazine) {
                Magazine magazine = (Magazine) item;
                if (magazine.isAvailable()) {
                    System.out.println(magazine);
                    hasAvailable = true;
                }
            }
        }
        if (!hasAvailable) {
            System.out.println("No items available for borrowing!");
        }
    }
    
    // Method to display all items
    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the library!");
            return;
        }
        
        System.out.println("All items in library:");
        for (Borrowable item : items) {
            System.out.println(item);
        }
    }
}