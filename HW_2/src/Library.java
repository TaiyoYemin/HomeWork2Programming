public class Library {
    private String libraryName;
    private Book[] libraryBooks = new Book[20];
    private Member[] members = new Member[5];
    private int bookNumber = 0;

    public Library(String libraryName) {
        this.libraryName = libraryName;
    }

    private boolean addAuthor(String author_name){
        for(Book book: libraryBooks){
            if(book.bookAuthor() == author_name)
                return false;
        }
        return true;
    }

    public void addBook(String title, Genre bookGenre, String author, String biography) {
        if(bookNumber >= 20) {
            System.out.println("Library is full, cannot add more books.");
        }
        else {
            boolean add_author = addAuthor(author);

        }



    }

}
