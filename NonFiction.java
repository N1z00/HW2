// NonFiction class extending Book
public class NonFiction extends Book {
    private String subject;
    
    // Constructor
    public NonFiction(String title, String author, String isbn, String subject) {
        super(title, author, isbn);
        this.subject = subject;
    }
    
    // Getter method for subject
    public String getSubject() {
        return subject;
    }
    
    // Setter method for subject
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    // Override toString method
    @Override
    public String toString() {
        return super.toString() + ", Subject: " + subject;
    }
}