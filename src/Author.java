public class Author {
    final String authorName;
    final String bibliography;

    public Author(String name, String bibliography) {
        this.authorName = name;
        this.bibliography = bibliography;
    }

    public boolean isEqual(Author other) {
        return this.authorName.equals(other.authorName) && (this.bibliography.equals(other.bibliography));
    }

}
