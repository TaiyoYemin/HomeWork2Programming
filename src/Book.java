public class Book {
    final String bookName;
    final String bookIdentification;
    final Genre genre;
    final Author author;
    private boolean isBorrowed = false;

    public Book(String name, Genre genre, Author author, String bookIdentification) {
        this.bookName = name;
        this.genre = genre;
        this.author = author;
        this.bookIdentification = bookIdentification;
    }

    public Author getAuthor() {
        return author;
    }

    public String getBookIdentification() {
        return bookIdentification;
    }

    /**
     * This method checks whether 2 books are the same by name,genre,author.
     *
     * @param bookName
     * @param bookGenre
     * @param authorName
     * @param bibliography
     * @return true if the books are the same, false otherwise.
     */
    public boolean isEqual(String bookName, Genre bookGenre, String authorName, String bibliography) {
        return (this.bookName.equals(bookName) &&
                this.genre.equals(bookGenre) &&
                (this.author.isEqual(authorName, bibliography)));
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        this.isBorrowed = true;
    }

    public void returnBook() {
        this.isBorrowed = false;
    }

    public void printBook() {
        System.out.println("Title: " + this.bookName + ", Genre: " + this.genre + ", Author: " + this.author.authorName);
    }
}
