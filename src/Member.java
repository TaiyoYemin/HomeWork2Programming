public class Member {
    final String memberName;
    final LibraryCard libraryCard;
    private int borrowedBooks = 0;
    private Book[] memberBooks;

    public Member(String memberName, LibraryCard libraryCard) {
        this.memberName = memberName;
        this.libraryCard = libraryCard;
        memberBooks = new Book[libraryCard.getBorrowLimit()];
    }

    public String getMemberCardIdentification() {
        return this.libraryCard.getIdentification();
    }

    public void addBorrowedBook(Book book) {
        if (borrowedBooks >= libraryCard.borrowLimit) {
            System.out.println("The member reached the limit.");
        } else {
            this.borrowedBooks++;
            // Adding the book to the array.
            for (int i = 0; i < memberBooks.length; i++) {
                if (memberBooks[i] == null) {
                    memberBooks[i] = book;
                    break;
                }
            }
        }
    }

    private int findBook(Book book) {
        for (int i = 0; i < memberBooks.length; i++) {
            if (memberBooks[i] == book) {
                return i;
            }
        }
        return -1;
    }

    public void removeBorrowedBook(Book book) {
        int book_index = findBook(book);
        if (book_index == -1) {
            System.out.println("Member cannot return the book.");
        } else {
            memberBooks[book_index] = null;
            borrowedBooks--;
        }
    }

    public void printMemberBooks() {
        System.out.println("Name: " + this.memberName + ", Checked-out books: ");
        for (int i = 0; i < memberBooks.length; i++) {
            if (memberBooks[i] != null) {
                memberBooks[i].printBook();
            }
        }
    }

}
