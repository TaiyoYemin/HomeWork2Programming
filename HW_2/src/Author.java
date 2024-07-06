public class Author {
    private String author_name;
    private String biography;

    public Author(String name, String biography) {
        this.author_name = name;
        this.biography = biography;
    }
    public String getName(){
        return this.author_name;
    }
    public String authorBiography(){
        return this.biography;
    }
}
