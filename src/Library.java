public class Library {
    private String libraryName;
    private Book[] libraryBooks = new Book[20];
    private Member[] members = new Member[5];
    private int bookNumber = 0;

    public Library(String libraryName) {
        this.libraryName = libraryName;
    }

    public void addBook(String bookName, genre bookGenre, String authorName, String bibliography) {
        Author author = checkAuthor(authorName, bibliography);
        if (this.bookNumber < 20) {
            libraryBooks[bookNumber] = new Book(bookName, bookGenre, author, "BN" + Integer.toString(++this.bookNumber));
        }
        else{
            System.out.println("Library is full, cannot add more books.");
        }

    }

    public static Author checkAuthor(String author, String bibiliography) {
        return new Author(author, bibiliography);
        //create a function that look up if the author exists
        //in case he does we return the author in case he is not we create a new author and return
    }


//        library.addBook("Harry Potter and the Sorcerer's Stone", Genre.FANTASY, "J.K. Rowling", "British author, best known for the Harry Potter series.");
}
