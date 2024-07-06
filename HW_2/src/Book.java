public class Book {
    private String title;
    private Author author;
    private Genre genre;
    final String identifier;

    public Book(String title, Author author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.identifier = generateID();
    }

    public String bookAuthor(){
        return author.getName();
    }

    private String generateID() {
        return "";
    }

    public void printBook(){
        System.out.println("Title: "+this.title+", Genre: "+this.genre+", Author: "+this.author.getName());
    }
}
