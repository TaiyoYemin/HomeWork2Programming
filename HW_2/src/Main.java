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
    }
    public static void test1() {
        Library library = new Library("Technion Library");
        library.addBook("Harry Potter and the Sorcerer's Stone", Genre.FANTASY, "J.K. Rowling", "British author, best known for the Harry Potter series.");
        library.printBooks();
    }
}
