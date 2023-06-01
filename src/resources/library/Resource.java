package resources.library;

public abstract class Resource implements Borrowable {
    private String title;
    private String author;
    private String catalogNumber;
    private String resourceType;
    private String genre;

    public Resource(String title, String author, String catalogNumber, String genre) {
        this.title = title;
        this.author = author;
        this.catalogNumber = catalogNumber;
        this.genre = genre;
    }

    public Resource(String title, String author, String catalogNumber) {
        this.title = title;
        this.author = author;
        this.catalogNumber = catalogNumber;
    }

    protected String getCatalogNumber() {
        return catalogNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getResourceType() {
        return resourceType;
    }

    protected void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    protected String borrowMessage() {
        return !canBorrowResource() ? "Resource cannot be borrowed" : "Check out resource with Librarian";
    }

    public void printResource() {
        String resource = """
                Catalog Number: %s
                Title: %s - Genre: %s
                Author: %s
                Resource Type: %s
                %s
                """;
        System.out.printf((resource) + "%n", catalogNumber, title, genre, author, resourceType, borrowMessage());
    }
}
