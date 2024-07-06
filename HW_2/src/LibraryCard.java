public class LibraryCard {
    final String identification;
    final int borrowLimit;
    private Book[] books;

    public LibraryCard(String identification, int borrowLimit) {
        this.identification = identification;
        this.borrowLimit = borrowLimit;
    }
}
