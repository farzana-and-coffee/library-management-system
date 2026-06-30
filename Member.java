import java.util.ArrayList;

public class Member extends Person {
    private ArrayList<Book> borrowedBooks;

    public Member(String name , String id){
        super(name,id);
        this.borrowedBooks = new ArrayList<>();
    }

    public ArrayList<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    public void borrowBook (Book book) {
        borrowedBooks.add(book);
        book.setBorrowed(true);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
        book.setBorrowed(false);
    }

    public void displayBorrowedBooks(){
        System.out.println(getName() + "'s borrowed books: ");
        if (borrowedBooks.isEmpty()) {
            System.out.println ("No books borrowed.");
        } else{
            for(Book book : borrowedBooks){
                book.displayInfo();
            }
        }
    }
}
