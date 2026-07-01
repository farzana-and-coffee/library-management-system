import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book>allBooks = new ArrayList<>();
        ArrayList<Librarian> librarians = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();

        librarians.add(new Librarian("Farzana", "L001"));
        librarians.add(new Librarian("David", "L002"));
        librarians.add(new Librarian("Emma", "L003"));
        librarians.add(new Librarian("Jungkook", "L004"));

        boolean running = true;

        while(running) {
            System.out.println("\n======= LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Login as Libarian");
            System.out.println("2. Login as Member");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice ==1){
                System.out.print("Enter your librarian ID: ");
                String libId = scanner.nextLine();

                Librarian librarian = null;
                for (Librarian lib : librarians) {
                    if (lib.getId().equals(libId)) {
                        librarian = lib;
                        break;

                    }
                }

                if ( librarian != null) {
                    System.out.println("Welcome, " + librarian.getName() + " ! ");

                    boolean libRunning = true;
                    while (libRunning) {
                        System.out.println("\n======= LIBRARIAN MENU ========");
                        System.out.println("1. Add Book");
                        System.out.println("2. Remove Book");
                        System.out.println("3. View All Books");
                        System.out.println("4. Search Book ");
                        System.out.println("5. View All Member");
                        System.out.println("6. Add Member");
                        System.out.println("0. Exit");

                        System.out.print("Enter your choice: ");
                        int libChoice = scanner.nextInt();

                        if ( libChoice == 1) {
                            System.out.print("Enter book title: ");
                            String title = scanner.nextLine();
                            System.out.print("Enter author: ");
                            String author = scanner.nextLine();
                            System.out.print("Enter ISBN: ");
                            String isbn = scanner.nextLine();

                            Book newBook = new Book(title, author, isbn);
                            librarian.addBook(newBook);
                            allBooks.add(newBook);

                        } else if (libChoice == 2) {
                            System.out.print("Enter book title to remove: ");
                            String title = scanner.nextLine();
                            Book found = librarian.searchBook(title);
                            if (found != null) {
                                librarian.removeBook(found);
                                allBooks.remove(found);
                            } else {
                                System.out.println("Book not found!");
                            }
                        } else if (libChoice == 3) {
                            librarian.displayAllBooks();

                        } else if (libChoice ==4 ) {
                            System.out.print("Enter book title to search: ");
                            String title = scanner.nextLine();
                            Book found = librarian.searchBook(title);
                            if (found != null) {
                                found.displayInfo();
                            } else {
                                System.out.println("Book not found!");
                            }
                        } else if (libChoice == 5) {
                            if (members.isEmpty()) {
                                System.out.println("No members registered yet.");
                            } else {
                                for (Member m : members) {
                                    System.out.println("Member: " + m.getName() + " (ID: " + m.getId() + ")");
                                    m.displayBorrowedBooks();
                                }
                            }
                        } else if (libChoice == 6){
                            System.out.print("Enter Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter ID: ");
                            String id = scanner.nextLine();

                            Member newMember = new Member (name, id);

                        }else if (libChoice == 0) {
                            libRunning = false;
                            System.out.println("Logged out !");

                        } else {
                            System.out.println("Invalid Choice!");
                        }
                    }
                } else {
                    System.out.println("Invalid Librarian ID ! \n Access Denied. \n Returning to main menu.");
                }


            } else if (choice ==2) {

            } else if (choice ==0) {
                running = false;
                System.out.println("Goodbye !!");
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }

        scanner.close();
    }
}
