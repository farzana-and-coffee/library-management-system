import java.util.ArrayList;

public class Librarian extends Person {
    private ArrayList<Book> books;

    public Librarian(String name, String id){
        super(name,id);
        this.books = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added:  " + book.getTitle());
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Book removed: " + book.getTitle());
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void displayAllBooks() {
        System.out.println(getName() +"'s Library Catalogue:");
        for (Book book : books) {
            book.displayInfo();
        }
    }

    public Book searchBook (String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
