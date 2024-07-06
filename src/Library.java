public class Library {
    private final String libraryName;
    private Book[] libraryBooks = new Book[20];
    private Member[] members = new Member[5];
    private int bookNumber = 0;
    private int removedBookNumber = 0;
    private int memberNumber = 0;
    final int MAXBOOKNUMBER = 20;

    public Library(String libraryName) {
        this.libraryName = libraryName;
    }

    public void addBook(String bookName, genre bookGenre, String authorName, String bibliography) {
        Author author = checkAuthor(authorName, bibliography);
        int totalBooksNumber = this.bookNumber - this.removedBookNumber;
        if (totalBooksNumber < MAXBOOKNUMBER) {
            for (int i = 0; i < MAXBOOKNUMBER; i++) {
                if (libraryBooks[i] == null) {
                    libraryBooks[i] = new Book(bookName, bookGenre, author, "BN" + Integer.toString(++this.bookNumber));
                    break;
                }
            }

        } else {
            System.out.println("Library is full, cannot add more books.");
        }

    }

    public Author checkAuthor(String author, String bibliography) {
        Author tempAuthor = new Author(author, bibliography);
        //create a function that look up if the author exists
        for (int i = 0; i < 20; i++) {
            if ((this.libraryBooks[i] != null) && (this.libraryBooks[i].getAuthor().isEqual(tempAuthor))) {
                return this.libraryBooks[i].getAuthor();
            }
        }
        //in author does not exist we return the new author
        return tempAuthor;
    }

    public void removeBook(String bookName, genre bookGenre, String authorName, String bibliography) {
        for (int i = 0; i < MAXBOOKNUMBER; i++) {
            if ((this.libraryBooks[i] != null)) {
                if ((!(libraryBooks[i].isRented())) && libraryBooks[i].isEqual(bookName, bookGenre, authorName, bibliography)) {
                    this.libraryBooks[i] = null;
                    this.removedBookNumber++;
                }
            }
        }
    }

    public void printBooks() {
        for (int i = 0; i < MAXBOOKNUMBER; i++) {
            if ((libraryBooks[i] != null) && (!(libraryBooks[i].isRented()))) {
                libraryBooks[i].printBook();
            }
        }
    }


//        library.addBook("Harry Potter and the Sorcerer's Stone", Genre.FANTASY, "J.K. Rowling", "British author, best known for the Harry Potter series.");
}
