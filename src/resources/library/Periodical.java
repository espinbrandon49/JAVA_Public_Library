package resources.library;

public class Periodical extends Resource {

    public Periodical(String title, String author, String catalogNumber, String genre) {
        super(title, author, catalogNumber, genre);
        this.setResourceType("Periodical");
    }

    @Override
    public boolean canBorrowResource() {
        return false;
    }
}
