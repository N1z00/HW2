// Fiction class extending Book
public class Fiction extends Book {
    private String genre;
    
    // Constructor
    public Fiction(String title, String author, String isbn, String genre) {
        super(title, author, isbn);
        this.genre = genre;
    }
    
    // Getter method for genre
    public String getGenre() {
        return genre;
    }
    
    // Setter method for genre
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    // Override toString method
    @Override
    public String toString() {
        return super.toString() + ", Genre: " + genre;
    }
}