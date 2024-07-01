public class Book {
    String bookName;
    String bookIdentification;
    genre genre;
    Author author;

    public Book(String name, genre genre,Author author, String bookIdentification) {
        this.bookName = name;
        this.genre = genre;
        this.author = author;
        this.bookIdentification = bookIdentification;
    }

    public void printBook(){
        System.out.println("Title: "+this.bookName+", Genre: "+this.genre+", Author: "+this.author.authorName);
    }
}
