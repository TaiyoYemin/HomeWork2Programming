//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library("Technion");
        library.addBook("Potter", Genre.FANTASY, "J.K. Rowling", "British author, best known for the Harry Potter series.");
        library.addBook("Harry Potter and the Sorcerer's Stone", Genre.FANTASY, "J.K. Rowling", "British author, best known for the Harry Potter series.");
        library.addBook("Harry Potter", Genre.FANTASY, "J.K. Rowlin", "British author, best known for the Harry Potter series.");
        library.addMember("Amir", 3);


        //library.printBooks();
        library.checkOutBook("BN1", "LC1");
        //library.checkOutBook("BN1","LC1" );
        //System.out.println();
        //library.printBooks();
        //library.printMember("LC1");
        //System.out.println();
        library.returnBook("BN1", "LC2");
        //library.printBooks();
        //library.printMember("LC1");
        //library.printMember("LC2");
    }
}
