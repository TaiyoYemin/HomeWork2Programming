public class Library {
    private final String libraryName;
    private Book[] libraryBooks = new Book[20];
    private Member[] libraryMembers = new Member[5];
    private int bookNumber = 0;
    private int removedBookNumber = 0;
    private int memberNumber = 0;
    final int MAX_BOOK_NUMBER = 20 , MAX_MEMBER_NUMBER = 5;

    public Library(String libraryName) {
        this.libraryName = libraryName;
    }

    public void addBook(String bookName, Genre bookGenre, String authorName, String bibliography) {
        Author author = checkAuthor(authorName, bibliography);
        int totalBooksNumber = this.bookNumber - this.removedBookNumber;
        if (totalBooksNumber < MAX_BOOK_NUMBER) {
            for (int i = 0; i < MAX_BOOK_NUMBER; i++) {
                if(libraryBooks[i] == null){
                    libraryBooks[i] = new Book(bookName, bookGenre, author, "BN" + Integer.toString(++this.bookNumber));
                    break;
                }
            }

        }
        else{
            System.out.println("Library is full, cannot add more books.");
        }

    }

    public Author checkAuthor(String author, String bibliography) {
        Author tempAuthor = new Author(author, bibliography);
        //create a function that look up if the author exists
        for(int i = 0; i < MAX_BOOK_NUMBER; i++){
            if ( (this.libraryBooks[i] != null) && (this.libraryBooks[i].getAuthor().isEqual(tempAuthor)) ) {
                return this.libraryBooks[i].getAuthor();
            }
        }
        //if author does not exist we return the new author
        return tempAuthor;
    }

    public void removeBook(String bookName, Genre bookGenre, String authorName, String bibliography){
        for(int i = 0; i < MAX_BOOK_NUMBER; i++){
            if ((this.libraryBooks[i]!=null)) {
                if((!(libraryBooks[i].isBorrowed()))&&libraryBooks[i].isEqual(bookName,bookGenre,authorName,bibliography)){
                    this.libraryBooks[i] = null;
                    this.removedBookNumber++;
                }
            }
        }
    }
    public void printBooks(){
        for(int i = 0; i < MAX_BOOK_NUMBER; i++){
            if((libraryBooks[i] != null)&&(!(libraryBooks[i].isBorrowed()))){
                libraryBooks[i].printBook();
            }
        }
    }





    /**
     * Adds a new member to the library.
     * If there are already 5 members, prints library full.
     *
     * @param memberName   The name of the member to be added.
     * @param borrowLimit  The borrowing limit for the member.
     */
    public void addMember(String memberName, int borrowLimit){
        if(memberNumber >= MAX_MEMBER_NUMBER){
            System.out.println("Library is full, cannot add more members.");
        }
        else{
            memberNumber += 1;
            String new_card_id = "LC" + memberNumber;
            LibraryCard new_card = new LibraryCard(new_card_id, borrowLimit);
            Member new_member = new Member(memberName, new_card);
            libraryMembers[memberNumber - 1] = new_member; // minus one because array starts with zero.
        }
    }

    /**
     * @param cardID
     * @return index in the members array. -1 if member not found.
     */
    private int memberNumberInArray(String cardID){
        for(int i = 0; i < MAX_MEMBER_NUMBER; i++){
            if(libraryMembers[i].getMemberCardIdentification() == cardID){
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes a member from the library.
     * If member doesn't exist prints no such member.
     * @param cardID
     */
    public void removeMember(String cardID){
        int index = memberNumberInArray(cardID);
        if(index == -1){
            System.out.println("No such member exists.");
        }
        else{
            libraryMembers[index] = null;
            memberNumber -= 1;
        }
    }

    /**
     * Prints member information.
     * If member doesn't exist prints no such member.
     * @param cardID
     */
    public void printMember(String cardID){
        int index = memberNumberInArray(cardID);
        if(index == -1){
            System.out.println("No such member exists.");
        }
        else{
            System.out.println(libraryMembers[index].toString());
        }
    }

    private int bookNumberInArray(String bookID){
        for(int i = 0; i < MAX_BOOK_NUMBER; i++){
            if(libraryBooks[i].getBookIdentification() == bookID){
                return i;
            }
        }
        return -1;
    }

    public void checkOutBook(String bookID, String cardID){
        int book_index = bookNumberInArray(bookID);
        int card_index = memberNumberInArray(cardID);
        if(book_index == -1){
            System.out.println("No such book exists.");
        }
        else if(card_index == -1){
            System.out.println("No such member exists.");
        }
    }
}
