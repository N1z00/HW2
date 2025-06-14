import java.util.*;

// Main Library Management System class
public class LibraryManagementSystem {
    private Library library;
    private Scanner scanner;
    
    // Constructor
    public LibraryManagementSystem() {
        // Get singleton instance of Library
        library = Library.getInstance();
        scanner = new Scanner(System.in);
    }
    
    // Main method to run the system
    public void run() {
        System.out.println("=== Welcome to Library Management System ===");
        
        while (true) {
            try {
                displayMenu();
                int choice = getChoice();
                
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        removeItem();
                        break;
                    case 3:
                        searchItems();
                        break;
                    case 4:
                        borrowItem();
                        break;
                    case 5:
                        returnItem();
                        break;
                    case 6:
                        library.findAvailableItems();
                        break;
                    case 7:
                        library.displayAllItems();
                        break;
                    case 8:
                        System.out.println("Thank you for using Library Management System!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            System.out.println(); // Add spacing
        }
    }
    
    // Method to display menu
    private void displayMenu() {
        System.out.println("=== Library Management System ===");
        System.out.println("1. Add Item (Book/Magazine)");
        System.out.println("2. Remove Item");
        System.out.println("3. Search Items");
        System.out.println("4. Borrow Item");
        System.out.println("5. Return Item");
        System.out.println("6. View Available Items");
        System.out.println("7. View All Items");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }
    
    // Method to get user choice with exception handling
    private int getChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            throw new InputMismatchException("Invalid input");
        } finally {
            scanner.nextLine(); // Clear buffer
        }
    }
    
    // Method to add item using Factory Pattern
    private void addItem() {
        try {
            System.out.println("Select item type:");
            System.out.println("1. Fiction Book");
            System.out.println("2. Non-Fiction Book");
            System.out.println("3. Magazine");
            System.out.print("Enter choice: ");
            
            int type = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            switch (type) {
                case 1:
                    addFictionBook();
                    break;
                case 2:
                    addNonFictionBook();
                    break;
                case 3:
                    addMagazine();
                    break;
                default:
                    System.out.println("Invalid item type!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input!");
            scanner.nextLine();
        }
    }
    
    // Method to add fiction book using Factory
    private void addFictionBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        
        // Use Factory Pattern to create Fiction book
        Fiction fiction = LibraryItemFactory.createFiction(title, author, isbn, genre);
        library.addBook(fiction);
    }
    
    // Method to add non-fiction book using Factory
    private void addNonFictionBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();
        
        // Use Factory Pattern to create NonFiction book
        NonFiction nonFiction = LibraryItemFactory.createNonFiction(title, author, isbn, subject);
        library.addBook(nonFiction);
    }
    
    // Method to add magazine using Factory
    private void addMagazine() {
        System.out.print("Enter magazine title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter issue number: ");
        String issueNumber = scanner.nextLine();
        
        // Use Factory Pattern to create Magazine
        Magazine magazine = LibraryItemFactory.createMagazine(title, issueNumber);
        library.addBook(magazine);
    }
    
    // Method to remove item
    private void removeItem() {
        System.out.print("Enter title or ISBN of item to remove: ");
        String identifier = scanner.nextLine();
        library.removeBook(identifier);
    }
    
    // Method to search items with method overloading
    private void searchItems() {
        System.out.println("Search options:");
        System.out.println("1. Search by title only");
        System.out.println("2. Search by title and author");
        System.out.print("Enter choice: ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            switch (choice) {
                case 1:
                    System.out.print("Enter title to search: ");
                    String title = scanner.nextLine();
                    library.searchBook(title);
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    System.out.print("Enter author to search: ");
                    String author = scanner.nextLine();
                    library.searchBook(searchTitle, author);
                    break;
                default:
                    System.out.println("Invalid search option!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input!");
            scanner.nextLine();
        }
    }
    
    // Method to borrow item
    private void borrowItem() {
        System.out.print("Enter title or ISBN of item to borrow: ");
        String identifier = scanner.nextLine();
        library.borrowBook(identifier);
    }
    
    // Method to return item
    private void returnItem() {
        System.out.print("Enter title or ISBN of item to return: ");
        String identifier = scanner.nextLine();
        library.returnBook(identifier);
    }
    
    // Main method
    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        system.run();
    }
}