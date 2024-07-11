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

    /**
     * Converts the genre enum to its corresponding string representation.
     *
     * @return a string representing the genre of the current object.
     *         or "Unknown genre" if the genre is not recognized.
     */
    private String genreToString(){
        switch (this.genre){
            case DRAMA: return "Drama";
            case FANTASY: return "Fantasy";
            case HISTORY_FICTION: return "History Fiction";
            case SCIENCE_FICTION: return "Science Fiction";
            default:
                return "Unknown genre";
        }
    }
    public void printBook() {
        System.out.println("Title: " + this.bookName + ", Genre: " + genreToString() + ", Author: " + this.author.authorName+".");
    }
}
