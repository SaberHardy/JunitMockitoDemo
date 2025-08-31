package modules;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private String genre;

    private int publishYear;
    private int totalCopies;
    private int availableCopies;

    public Book() {
    }

    public Book(int id, String isbn, String title, String author, String genre, int publishYear, int totalCopies, int availableCopies) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishYear = publishYear;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public String getIsbn() {return isbn;}

    public String getTitle() {return title;}

    public String getAuthor() {return author;}

    public String getGenre() {return genre;}

    public int getPublishYear() {return publishYear;}

    public int getTotalCopies() {return totalCopies;}

    public int getAvailableCopies() {return availableCopies;}

    public void setIsbn(String isbn) {this.isbn = isbn;}

    public void setTitle(String title) {this.title = title;}

    public void setAuthor(String author) {this.author = author;}

    public void setGenre(String genre) {this.genre = genre;}

    public void setPublishYear(int publishYear) {this.publishYear = publishYear;}

    public void setTotalCopies(int totalCopies) {this.totalCopies = totalCopies;}

    public void setAvailableCopies(int availableCopies) {this.availableCopies = availableCopies;}

    public boolean isAvailable() { return availableCopies > 0;}

    public void borrowCopy() { if (availableCopies > 0) availableCopies --; }

    public void returnCopy() { if (availableCopies < totalCopies) availableCopies ++; }
}
