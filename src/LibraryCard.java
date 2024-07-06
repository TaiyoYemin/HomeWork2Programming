public class LibraryCard {
    final String identification;
    final int borrowLimit;

    public LibraryCard(String identification, int borrowLimit) {
        this.identification = identification;
        this.borrowLimit = borrowLimit;
    }

    public String getIdentification() {
        return this.identification;
    }
}
