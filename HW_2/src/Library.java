public class Library {
    private Book[] books = new Book[20];
    private Member[] members = new Member[5];
    private String lib_name;

    public Library(String lib_name) {
        this.lib_name = lib_name;
    }

    private boolean addAuthor(String author_name){
        for(Book book: books){
            if(book.bookAuthor() == author_name)
                return false;
        }
        return true;
    }

    public void addBook(String title, Genre genre, String author, String biography) {
        boolean add_author = addAuthor(author);

        Book new_book = new Book(title, new Author(author,biography) ,genre);

    }

}
