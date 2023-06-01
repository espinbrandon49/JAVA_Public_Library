import resources.library.Book;
import resources.library.Periodical;
import resources.library.Reference;
import resources.library.Resource;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    static ArrayList<Resource> requestedResources = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello, my name is HAL, your friendly Revature Librarian");

        String resourceMenu = """
                Which library resource can I assist you with locating?
                (1) Book
                (2) Periodical
                (3) Reference
                (4) Finished""";

        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println(resourceMenu);
                int resource = scanner.nextInt();

                if (resource == 1) {
                    System.out.println("What is the title");
                    String title = scanner.nextLine();
                    scanner.nextLine();

                    System.out.println("Who is the author");
                    String author = scanner.nextLine();

                    System.out.println("What is the genre");
                    String genre = scanner.nextLine();

                    Book book = new Book(title, author, createCatalogNumber(), genre);
                    requestedResources.add(book);
                }

                if (resource == 2) {
                    System.out.println("What is the title");
                    String title = scanner.nextLine();
                    scanner.nextLine();

                    System.out.println("Who is the author");
                    String author = scanner.nextLine();

                    System.out.println("What is the genre");
                    String genre = scanner.nextLine();

                    Periodical periodical = new Periodical(title, author, createCatalogNumber(), genre);
                    requestedResources.add(periodical);
                }
                if (resource == 3) {
                    System.out.println("What is the title");
                    String title = scanner.nextLine();
                    scanner.nextLine();

                    System.out.println("Who is the author");
                    String author = scanner.nextLine();

                    String subjectResources = """
                            What is the subject?
                            (a) Scientific
                            (b) Legal
                            (c) Medical
                            (d) Arts
                            (e) Other
                            """;
                    System.out.println(subjectResources);
                    String subjectChoice = scanner.nextLine();

                    String subject = switch (subjectChoice) {
                        case "a" -> "Scientific";
                        case "b" -> "Legal";
                        case "c" -> "Medical";
                        case "d" -> "Arts";
                        default -> "Other";
                    };
                    Reference reference = new Reference(title, author, createCatalogNumber(), subject);
                    requestedResources.add(reference);
                }
                if (resource == 4) {
                    printListOfResourcesToLocate();
                    scanner.close();
                    break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }
    }

    protected static String createCatalogNumber() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }

    public static void printListOfResourcesToLocate() {
        for (Resource e : requestedResources) {
            e.printResource();
        }
    }
}
