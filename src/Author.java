public class Author {
    final String authorName;
    final String bibliography;

    public Author(String name, String bibliography) {
        this.authorName = name;
        this.bibliography = bibliography;
    }

    /**
     * This method checks whether 2 books are the same by comparing their author name and parameter.
     *
     * @param authorName The author name to compare
     * @param bibliography The author bibliography
     * @return if the author is the same
     */
    public boolean isEqual(String authorName, String bibliography) {
        return (this.authorName.equals(authorName) && (this.bibliography.equals(bibliography)));
    }


}
