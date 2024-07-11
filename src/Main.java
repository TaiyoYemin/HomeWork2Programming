public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Test 1 starts");
            test1();
            System.out.println("Test 1 done");
            System.out.println("--------------------------------------------");
        } catch (Exception e) {
            System.out.println("exception " + e);
        }

        try {
            System.out.println("Test 2 starts");
            test2();
            System.out.println("Test 2 done");
            System.out.println("--------------------------------------------");
        } catch (Exception e) {
            System.out.println("exception " + e);
        }
        try {
            System.out.println("Test 3 starts");
            test3();
            System.out.println("Test 3 done");
            System.out.println("--------------------------------------------");
        } catch (Exception e) {
            System.out.println("exception " + e);
        }
        try {
            System.out.println("Test 4 starts");
            test4();
            System.out.println("Test 4 done");
            System.out.println("--------------------------------------------");
        } catch (Exception e) {
            System.out.println("exception " + e);
        }
    }
    public static void test1() {
        Library library = new Library("Technion Library");
        library.addBook("Harry Potter and the Sorcerer's Stone", Genre.FANTASY, "J.K. Rowling", "British author, best known for the Harry Potter series.");
        library.printBooks();
        library.addBook("Harry Potter and the Sorcerer's Stone", Genre.SCIENCE_FICTION, "J.K. Rowling", "British author, best known for the Harry Potter series.");
        library.addBook("Harry Potter and the Sorcerer's Stone", Genre.FANTASY, "J.K. Rowling", "American author! Best known for copying British writer J.K. Rowling's identity.");
        System.out.println("second print:");
        library.printBooks();

        System.out.println(library.getAuthor("BN0") == library.getAuthor("BN1"));
        System.out.println(library.getAuthor("BN0") == library.getAuthor("BN2"));
    }

    public static void test2() {
        Library library = new Library("Technion Library");
        library.removeBook("Book 1", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 1", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.removeBook("Book 1", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 2", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 3", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 4", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 5", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 6", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 7", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 8", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 9", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 10", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 11", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 12", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 13", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 14", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 15", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 16", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 17", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 18", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 19", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 20", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 1", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.printBooks();

        System.out.println(library.getAuthor("BN0"));

        library.addBook("Book 21", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.printBooks();
    }

    public static void test3() {
        Library library = new Library("Technion Library");
        library.addBook("How To write exercises for students", Genre.DRAMA, "Gal Zur", "A TA at the Technion known (possibly notoriously) for his exercises in the Software Engineering course.");
        library.addBook("How to successfully answer exercises", Genre.FANTASY, "Gal Zur", "A student at the Technion. For complete biography find him at the DDS faculty.");
        library.addBook("Book 3", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 4", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 5", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 6", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 7", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 8", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 9", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 10", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 11", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 12", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 13", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 14", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 15", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 16", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 17", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 18", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 19", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 20", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 1", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.printBooks();

        library.addMember("Israel Israeli", 3);
        library.addMember("Israel Israeli 2", 3);
        library.addMember("Israel Israeli 3", 3);
        library.addMember("Israel Israeli 4", 3);
        library.addMember("Israel Israeli 5", 3);
        library.addMember("Israel Israeli 6", 3);

        library.checkOutBook("BN0", "LC0");
        library.checkOutBook("BN1", "LC0");

        library.printMember("LC0");
    }

    public static void test4() {
        Library library = new Library("Technion Library");
        library.printBooks();

        library.addBook("How To write exercises for students", Genre.DRAMA, "Gal Zur", "A TA at the Technion known (possibly notoriously) for his exercises in the Software Engineering course.");
        library.addBook("How to successfully answer exercises", Genre.FANTASY, "Gal Zur", "A student at the Technion. For complete biography find him at the DDS faculty.");
        library.addBook("Book 3", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");
        library.addBook("Book 4", Genre.DRAMA, "John Doe", "Just a generic guy in a generic U.S. state.");

        library.printBooks();

        library.addMember("Israel Israeli", 2);
        library.addMember("Israel Israeli 2", 3);
        library.addMember("Israel Israeli 3", 3);
        library.addMember("Israel Israeli 4", 3);
        library.addMember("Israel Israeli 5", 3);

        library.checkOutBook("BN0", "LC0");
        library.checkOutBook("BN1", "LC0");
        library.checkOutBook("BN2", "LC0");
        library.checkOutBook("BN0", "LC0");

        library.printMember("LC0");
        System.out.println("library:");
        library.printBooks();

        library.removeMember("LC0");
        library.checkOutBook("BN9", "LC7");
        library.printMember("LC0");
    }
}
