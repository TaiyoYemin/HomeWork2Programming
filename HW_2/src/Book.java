public class Book {
    private String title;
    private Author author;
    private Genre genre;
    final String bookIdentification;

    public Book(String title, Author author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookIdentification = bookIdentification;

    }

    public String bookAuthor(){
        return author.getName();
    }

    public void printBook(){
        System.out.println("Title: "+this.title+", Genre: "+this.genre+", Author: "+this.author.getName());
    }
}
