public class Member {
    final String memberName;
    final LibraryCard libraryCard;
    private int borrowed_books = 0;

    public Member(String memberName, LibraryCard libraryCard) {
        this.memberName = memberName;
        this.libraryCard = libraryCard;
    }

    public String getMemberCardIdentification(){
        return this.libraryCard.getIdentification();
    }

    public String toString(){
        return "Name: " + this.memberName + ", Checked-out books: " + this.borrowed_books;
    }

}
