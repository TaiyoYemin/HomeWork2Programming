public class Author {
    final String authorName;
    final String bibliography;

    public Author(String name, String bibliography) {
        this.authorName = name;
        this.bibliography = bibliography;
    }

    public boolean isEqual(String authorName, String bibliography) {
        return this.authorName.equals(authorName) && (this.bibliography.equals(bibliography));
    }


}
