//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library("Technion");
        library.addBook("Harry Potter and the Sorcerer's Stone", Genre.FANTASY, "J.K. Rowling", "British author, best known for the Harry Potter series.");
        library.addBook("Harry Potter", Genre.FANTASY, "J.K. Rowling", "British author, best known for the Harry Potter series.");
        library.addMember("Amir",1);

        library.printBooks();
    }
}
