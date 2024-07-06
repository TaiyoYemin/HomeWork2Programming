public class Book {
    final String bookName;
    final String bookIdentification;
    final genre genre;
    final Author author;

    public Book(String name, genre genre,Author author, String bookIdentification) {
        this.bookName = name;
        this.genre = genre;
        this.author = author;
        this.bookIdentification = bookIdentification;
    }

    public Author getAuthor() {
        return author;
    }

    public void printBook(){
        System.out.println("Title: "+this.bookName+", Genre: "+this.genre+", Author: "+this.author.authorName);
    }
}
