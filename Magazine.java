// Magazine class implementing Borrowable interface
public class Magazine implements Borrowable {
    private String title;
    private String issueNumber;
    private boolean isAvailable;
    
    // Constructor
    public Magazine(String title, String issueNumber) {
        this.title = title;
        this.issueNumber = issueNumber;
        this.isAvailable = true;
    }
    
    // Getter methods
    public String getTitle() {
        return title;
    }
    
    public String getIssueNumber() {
        return issueNumber;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Setter methods
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }
    
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    // Implementation of Borrowable interface
    @Override
    public void borrowItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Magazine '" + title + "' has been borrowed.");
        } else {
            System.out.println("Magazine '" + title + "' is not available.");
        }
    }
    
    @Override
    public void returnItem() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Magazine '" + title + "' has been returned.");
        } else {
            System.out.println("Magazine '" + title + "' was not borrowed.");
        }
    }
    
    // toString method
    @Override
    public String toString() {
        return "Magazine - Title: " + title + ", Issue: " + issueNumber + 
               ", Available: " + (isAvailable ? "Yes" : "No");
    }
}