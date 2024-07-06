public class Author {
    String authorName;
    String bibliography;

    public Author(String name, String bibliography) {
        this.authorName = name;
        this.bibliography = bibliography;
    }

    public boolean isEqual(Author other) {
        return this.authorName.equals(other.authorName) && (this.bibliography.equals(other.bibliography));
    }

}
