public class Library {
    private final String libraryName;
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

    public Author checkAuthor(String author, String bibiliography) {
        Author tempAuthor = new Author(author, bibiliography);
        //create a function that look up if the author exists
        for(int i = 0; i < 20; i++){
            if ((this.libraryBooks[i].getAuthor() !=null) &&(this.libraryBooks[i].getAuthor().isEqual(tempAuthor))) {
                return this.libraryBooks[i].getAuthor();
            }
        }
        //in author does not exist we return the new author
        return tempAuthor;
    }




//        library.addBook("Harry Potter and the Sorcerer's Stone", Genre.FANTASY, "J.K. Rowling", "British author, best known for the Harry Potter series.");
}
