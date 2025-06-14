// Factory class for creating library items
public class LibraryItemFactory {
    
    // Method to create different types of items using switch statement
    public static Borrowable createItem(String type, String title, String author, String isbn, String extra) {
        switch (type.toLowerCase()) {
            case "fiction":
                return new Fiction(title, author, isbn, extra);
            case "nonfiction":
                return new NonFiction(title, author, isbn, extra);
            case "magazine":
                return new Magazine(title, extra); // extra is issue number for magazine
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }
    
    // Overloaded method for Fiction with genre parameter
    public static Fiction createFiction(String title, String author, String isbn, String genre) {
        return new Fiction(title, author, isbn, genre);
    }
    
    // Overloaded method for NonFiction with subject parameter
    public static NonFiction createNonFiction(String title, String author, String isbn, String subject) {
        return new NonFiction(title, author, isbn, subject);
    }
    
    // Method to create Magazine
    public static Magazine createMagazine(String title, String issueNumber) {
        return new Magazine(title, issueNumber);
    }
}