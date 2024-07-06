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
            bookIDs[borrowedBooks] = bookID;
        }
    }


    public String toString(){
        return "Name: " + this.memberName + ", Checked-out books: " + this.borrowedBooks;
    }

}
