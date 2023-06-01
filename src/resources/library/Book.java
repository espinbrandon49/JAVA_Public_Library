package resources.library;

public class Book extends Resource {

    public Book(String title, String author, String catalogNumber, String genre) {
        super(title, author, catalogNumber, genre);
        this.setResourceType("Book");
    }

    @Override
    public boolean canBorrowResource() {
        return true;
    }
}
