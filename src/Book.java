public class Book {
    final String bookName;
    final String bookIdentification;
    final genre genre;
    final Author author;
    private boolean isRented = false;

    public Book(String name, genre genre,Author author, String bookIdentification) {
        this.bookName = name;
        this.genre = genre;
        this.author = author;
        this.bookIdentification = bookIdentification;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isEqual(String bookName, genre bookGenre, String authorName, String bibliography){
        return (this.bookName.equals(bookName) &&
                this.genre.equals(bookGenre)&&
                (this.author.isEqual(authorName, bibliography)));
    }

    public boolean isRented(){
        return isRented;
    }

    public void printBook(){
        System.out.println("Title: "+this.bookName+", Genre: "+this.genre+", Author: "+this.author.authorName);
    }
}
