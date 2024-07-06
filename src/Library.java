public class Library {
    private final String libraryName;
    private Book[] libraryBooks = new Book[20];
    private Member[] libraryMembers = new Member[5];
    private int bookNumber = 0;
    private int removedBookNumber = 0;
    private int memberNumber = 0;
    final int MAXBOOKNUMBER = 20;
    final int MAXMEMBERNUMBER = 5;

    public Library(String libraryName) {
        this.libraryName = libraryName;
    }

    public void addBook(String bookName, Genre bookGenre, String authorName, String bibliography) {
        Author author = checkAuthor(authorName, bibliography);
        int totalBooksNumber = this.bookNumber - this.removedBookNumber;
        if (totalBooksNumber < MAXBOOKNUMBER) {
            for (int i = 0; i < MAXBOOKNUMBER; i++) {
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
        for(int i = 0; i < 20; i++){
            if ( (this.libraryBooks[i] != null) && (this.libraryBooks[i].getAuthor().isEqual(tempAuthor)) ) {
                return this.libraryBooks[i].getAuthor();
            }
        }
        //in author does not exist we return the new author
        return tempAuthor;
    }

    public void removeBook(String bookName, Genre bookGenre, String authorName, String bibliography){
        //The functions check for existing books in the library.
        for(int i = 0; i < MAXBOOKNUMBER; i++){
            if ((this.libraryBooks[i]!=null)) {
                // If we find a book that isn't burrowed and matches the book we want to remove description we delete it.
                if((!(libraryBooks[i].isBorrowed()))&&libraryBooks[i].isEqual(bookName,bookGenre,authorName,bibliography)){
                    this.libraryBooks[i] = null;
                    this.removedBookNumber++;
                }
            }
        }
    }

    public void printBooks(){
        for(int i = 0; i < MAXBOOKNUMBER; i++){
            //looks for books that aren't burrowed in the library and prints them.
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
        if(memberNumber >= 5){
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
     * @param cardId
     * @return index in the members array. -1 if member not found.
     */
    private int memberNumberInArray(String card_id){
        for(int i = 0; i < MAXMEMBERNUMBER; i++){
            if(libraryMembers[i].getMemberCardIdentification() == card_id){
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes a member from the library.
     * If member doesn't exist prints no such member.
     * @param cardId
     */
    public void removeMember(String cardId){
        int index = memberNumberInArray(cardId);
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
     * @param cardId
     */
    public void printMember(String cardId){
        int index = memberNumberInArray(cardId);
        if(index == -1){
            System.out.println("No such member exists.");
        }
        else{
            System.out.println(libraryMembers[index].toString());
        }
    }
}
