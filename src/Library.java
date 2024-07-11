/**
 * HomeWork2
 *
 * @author Amir Cohen -322989807 and Taiyo Yemin -213836299
 * @version 06/07/2024
 */

public class Library {
    private final String libraryName;
    final int MAX_BOOK_NUMBER = 20, MAX_MEMBER_NUMBER = 5;
    private Book[] libraryBooks = new Book[MAX_BOOK_NUMBER];
    private Member[] libraryMembers = new Member[MAX_MEMBER_NUMBER];
    private int bookNumber = 0;
    private int removedBookNumber = 0;
    private int memberNumber = 0;
    private int removedMemberNumber = 0;


    /**
     * Constructs the library
     *
     * @param libraryName
     */
    public Library(String libraryName) {
        this.libraryName = libraryName;
    }

    /**
     * Add a book to a library
     *
     * @param bookName     The book name
     * @param bookGenre    The book genre
     * @param authorName   The author's name
     * @param bibliography The author's bibliography
     */
    public void addBook(String bookName, Genre bookGenre, String authorName, String bibliography) {
        Author author = checkAuthor(authorName, bibliography); //Checks if author exists on any other books.
        if (this.bookNumber < MAX_BOOK_NUMBER) {
            //Looks for a place to put the book in the library
            for (int i = 0; i < MAX_BOOK_NUMBER; i++) {
                if (libraryBooks[i] == null) {
                    libraryBooks[i] = new Book(bookName, bookGenre, author, "BN" + Integer.toString((++this.bookNumber) + this.removedBookNumber));
                    break;
                }
            }

        } else {
            System.out.println("Library is full, cannot add more books.");
        }

    }

    /**
     * Return the author of the specified book Identification
     *
     * @param bookID The wanted author book identification
     * @return
     */
    public Author getAuthor(String bookID) {
        for (int i = 0; i < MAX_BOOK_NUMBER; i++) {
            if (libraryBooks[i] != null) {// looks through the the library for the wanted book ID
                libraryBooks[i].bookIdentification.equals(bookID) ;
                return libraryBooks[i].author;
            }
        }
        return null;
    }

    /**
     * A private function that looks up if the same author exist in any of the books in the library.
     *
     * @param author       The author name we're looking for.
     * @param bibliography the bibliography of the author we're looking for.
     * @return The author in existing book or a new author.
     */
    private Author checkAuthor(String author, String bibliography) {
        //create a function that look up if the author exists
        for (int i = 0; i < MAX_BOOK_NUMBER; i++) {
            if ((this.libraryBooks[i] != null) && (this.libraryBooks[i].getAuthor().isEqual(author, bibliography))) {
                return this.libraryBooks[i].getAuthor();
            }
        }
        //if author does not exist we return the new author
        return new Author(author, bibliography);
    }

    /**
     * Remove all books that has the described book name, genre and author from the library.
     *
     * @param bookName
     * @param bookGenre
     * @param authorName
     * @param bibliography
     */
    public void removeBook(String bookName, Genre bookGenre, String authorName, String bibliography) {
        for (int i = 0; i < MAX_BOOK_NUMBER; i++) {
            if ((this.libraryBooks[i] != null)) {
                if ((!(libraryBooks[i].isBorrowed())) && libraryBooks[i].isEqual(bookName, bookGenre, authorName, bibliography)) {
                    this.libraryBooks[i] = null;
                    this.bookNumber--;
                    this.removedBookNumber++;
                }
            }
        }
    }

    /**
     * Prints all the books in the library.
     */
    public void printBooks() {
        for (int i = 0; i < MAX_BOOK_NUMBER; i++) {
            if ((libraryBooks[i] != null) && (!(libraryBooks[i].isBorrowed()))) {
                libraryBooks[i].printBook();
            }
        }
    }



    /**
     * Adds a new member to the library.
     * If there are already 5 members, prints library full.
     *
     * @param memberName  The name of the member to be added.
     * @param borrowLimit The borrowing limit for the member.
     */
    public void addMember(String memberName, int borrowLimit) {
        if (memberNumber >= MAX_MEMBER_NUMBER) {
            System.out.println("Library is full, cannot add more members.");
        } else {
            memberNumber++;
            String new_card_id = "LC" + Integer.toString(memberNumber + removedMemberNumber);
            LibraryCard new_card = new LibraryCard(new_card_id, borrowLimit);
            Member new_member = new Member(memberName, new_card);
            libraryMembers[memberNumber - 1] = new_member; // minus one because array starts with zero.
        }
    }

    /**
     * returns the index in the libraryMember array by cardID.
     *
     * @param cardID
     * @return int index in the array. -1 if not found.
     */
    private int memberNumberInArray(String cardID) {
        for (int i = 0; i < MAX_MEMBER_NUMBER; i++) {
            if (!(libraryMembers[i] == null) && libraryMembers[i].getMemberCardIdentification().equals(cardID)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes a member from the library.
     * If member doesn't exist prints no such member.
     *
     * @param cardID
     */
    public void removeMember(String cardID) {
        int index = memberNumberInArray(cardID);
        if (index == -1) {
            System.out.println("No such member exists.");
        } else {
            libraryMembers[index] = null;
            memberNumber--;
            removedMemberNumber++;
        }
    }

    /**
     * Prints member information.
     * If member doesn't exist prints no such member.
     *
     * @param cardID
     */
    public void printMember(String cardID) {
        int index = memberNumberInArray(cardID);
        if (index == -1) {
            System.out.println("No such member exists.");
        } else {
            libraryMembers[index].printMemberBooks();
        }
    }

    /**
     * returns the index in the libraryBook array by bookID.
     *
     * @param bookID
     * @return int index in the array. -1 if not found.
     */
    private int bookNumberInArray(String bookID) {
        for (int i = 0; i < MAX_BOOK_NUMBER; i++) {
            if (libraryBooks[i] != null && libraryBooks[i].getBookIdentification().equals(bookID)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * This method is for a member who wants to borrow a book.
     * The method checks whether the member is valid and the book is valid before borrowing a book.
     *
     * @param bookID
     * @param cardID
     */
    public void checkOutBook(String bookID, String cardID) {
        int book_index = bookNumberInArray(bookID);
        int card_index = memberNumberInArray(cardID);
        if (book_index == -1) {
            System.out.println("No such book exists.");
        } else if (card_index == -1) {
            System.out.println("No such member exists.");
        } else if (libraryBooks[book_index].isBorrowed()) {
            System.out.println("The book is already checked-out.");
        } else {
            //If the member reaches the limit the func will print reached limit and won't add the book.
            libraryMembers[card_index].addBorrowedBook(libraryBooks[book_index]);
            libraryBooks[book_index].borrowBook();
        }
    }

    /**
     * This method is for a member who wants to return a book he borrowed.
     * The method checks whether the member is valid and can return the book.
     *
     * @param bookID
     * @param cardID
     */
    public void returnBook(String bookID, String cardID) {
        int book_index = bookNumberInArray(bookID);
        int card_index = memberNumberInArray(cardID);
        if (card_index == -1) {
            System.out.println("No such member exists.");
        } else {
            //If member don't have this book print cannot return.
            libraryMembers[card_index].removeBorrowedBook(libraryBooks[book_index]);
            libraryBooks[card_index].returnBook();
        }
    }
}
