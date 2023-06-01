package resources.library;

import java.util.Objects;

public class Reference extends Resource {

    private String subject;

    public Reference(String title, String author, String catalogNumber, String subject) {
        super(title, author, catalogNumber);
        this.setResourceType("Reference");
        this.subject = subject;
    }

    @Override
    public void printResource() {
        String resource = """
                Catalog Number: %s
                Title: %s - Subject: %s
                Author: %s
                Resource Type: %s
                %s
                """;
        System.out.printf((resource) + "%n", this.getCatalogNumber(), this.getTitle(), this.subject, this.getAuthor(), this.getResourceType(), borrowMessage());
    }

    @Override
    public boolean canBorrowResource() {
        return !Objects.equals(this.subject, "Legal") && !Objects.equals(this.subject, "Medical");
    }
}
