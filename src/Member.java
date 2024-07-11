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

    /**
     * This method is used in the library class when a member wants to borrow a book.
     * It checks first whether the member can borrow more books.
     *
     * @param book
     * @return true if the user can borrow a book.
     */
    public boolean addBorrowedBook(Book book) {
        if (borrowedBooks >= libraryCard.borrowLimit) {
            return false;
        } else {
            // Adding the book to the array.
            for (int i = 0; i < memberBooks.length; i++) {
                if (memberBooks[i] == null) {
                    memberBooks[i] = book;
                    this.borrowedBooks++;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method gives back the index of a book if it's there.
     * It is used to check if the member actually borrowed the book.
     *
     * @param book
     * @return int index in the book array. -1 if not found.
     */
    private int findBook(Book book) {
        for (int i = 0; i < memberBooks.length; i++) {
            if (memberBooks[i] == book) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method removes a borrowed book when the member returns it.
     * It first checks whether the member actually has this book.
     *
     * @param book
     */
    public void removeBorrowedBook(Book book) {
        int book_index = findBook(book);
        if (book_index == -1) {
            System.out.println("Member cannot return the book.");
        } else {
            memberBooks[book_index] = null;
            this.borrowedBooks--;
        }
    }

    public void printMemberBooks() {
        System.out.println("Name: " + this.memberName + ", Checked-out books:");
        for (int i = 0; i < memberBooks.length; i++) {
            if (memberBooks[i] != null) {
                memberBooks[i].printBook();
            }
        }
    }
}
