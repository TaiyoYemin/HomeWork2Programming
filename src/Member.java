public class Member {
    final String memberName;
    final LibraryCard libraryCard;
    private int borrowedBooks = 0;
    private String [] bookIDs;

    public Member(String memberName, LibraryCard libraryCard) {
        this.memberName = memberName;
        this.libraryCard = libraryCard;
        bookIDs = new String[libraryCard.getBorrowLimit()];
    }

    public String getMemberCardIdentification(){
        return this.libraryCard.getIdentification();
    }

    public void addBorrowedBook(String bookID) {
        if(borrowedBooks >= libraryCard.borrowLimit){
            System.out.println("The member reached the limit.");
        }
        else {
            this.borrowedBooks++;
            // Adding the book to the array.
            for(int i = 0; i < bookIDs.length; i++){
                if(bookIDs[i] == null){
                    bookIDs[i] = bookID;
                }
            }
        }
    }

    private int findBookByID(String bookID) {
        for(int i = 0; i < bookIDs.length; i++){
            if(bookID.equals(bookIDs[i])){
                return i;
            }
        }
        return -1;
    }

    public void removeBorrowedBook(String bookID) {
        int book_index = findBookByID(bookID);
        if(book_index == -1){
            System.out.println("Member cannot return the book.");
        }
        else{
            bookIDs[book_index] = null;
            borrowedBooks--;
        }
    }

    public String toString(){
        return "Name: " + this.memberName + ", Checked-out books: " + this.borrowedBooks;
    }

}
