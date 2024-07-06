public class Library {
    private final String libraryName;
    private Book[] libraryBooks = new Book[20];
    private Member[] members = new Member[5];
    private int bookNumber = 0;
    private int removedBookNumber = 0;
    private int memberNumber = 0;
    final int MAXBOOKNUMBER = 20;

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
        for(int i = 0; i < MAXBOOKNUMBER; i++){
            if ((this.libraryBooks[i]!=null)) {
                if((!(libraryBooks[i].isBorrowed()))&&libraryBooks[i].isEqual(bookName,bookGenre,authorName,bibliography)){
                    this.libraryBooks[i] = null;
                    this.removedBookNumber++;
                }
            }
        }
    }
    public void printBooks(){
        for(int i = 0; i < MAXBOOKNUMBER; i++){
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
    public void addMember(String member_name, int borrow_limit){
        if(memberNumber >= 5){
            System.out.println("Library is full, cannot add more members.");
        }
        else{
            memberNumber += 1;
            String new_card_id = "LC" + memberNumber;
            LibraryCard new_card = new LibraryCard(new_card_id, borrow_limit);
            Member new_member = new Member(member_name, new_card);
            members[memberNumber - 1] = new_member; // minus one because array starts with zero.
        }
    }

    /**
     * @param card_id
     * @return index in the members array. -1 if member not found.
     */
    private int memberNumberInArray(String card_id){
        for(Member m: members){
            if(m.getMemberCardIdentification() == card_id){
                return memberNumber - 1;
            }
        }
        return -1;
    }

    /**
     * Removes a member from the library.
     * If member doesn't exist prints no such member.
     * @param card_id
     */
    public void removeMember(String card_id){
        int index = memberNumberInArray(card_id);
        if(index == -1){
            System.out.println("No such member exists.");
        }
        else{
            members[index] = null;
            memberNumber -= 1;
        }
    }

    /**
     * Prints member information.
     * If member doesn't exist prints no such member.
     * @param card_id
     */
    public void printMember(String card_id){
        int index = memberNumberInArray(card_id);
        if(index == -1){
            System.out.println("No such member exists.");
        }
        else{
            System.out.println(members[index].toString());
        }
    }
}
