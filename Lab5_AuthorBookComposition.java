/**
 * Lab 5: Author and Book - Composition (Has-A Relationship)
 * PT821 - Object-Oriented Programming
 * State University of Zanzibar (SUZA)
 *
 * LEARNING OBJECTIVES:
 * - Understand composition ("has-a") vs inheritance ("is-a")
 * - Create classes that contain objects of other classes
 * - Access composed object properties through delegation
 * - Compare when to use composition vs inheritance
 *
 * KEY CONCEPT:
 * A Book HAS-A Author (composition)     -- NOT "A Book IS-A Author" (inheritance)
 * A Book is COMPOSED OF an Author        -- The Author is a PART of the Book
 *
 * INSTRUCTIONS:
 * Complete the following exercises step by step.
 * Follow the TODO comments and implement the required functionality.
 */

// ============================================================
// PART A: The Author Class
// ============================================================

/*
 * TODO 1: Create a class called "Author" with:
 *
 * Private instance variables:
 *   - name (String)
 *   - email (String)
 *   - gender (char, 'm' or 'f')
 *
 * Constructor:
 *   - Author(String name, String email, char gender)
 *
 * Public methods:
 *   - getName(), getEmail(), setEmail(String email), getGender()
 *   - toString() - returns "Author[name=?, email=?, gender=?]"
 *
 * NOTE: No setters for name and gender (they are fixed once set)
 */

// Write your Author class here:
class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public String toString() {
        return "Author[name=" + name +
                ", email=" + email +
                ", gender=" + gender + "]";
    }
}

// ============================================================
// PART B: The Book Class (composes Author)
// ============================================================

/*
 * TODO 2: Create a class called "Book" with:
 *
 * Private instance variables:
 *   - name (String)
 *   - author (Author) <-- This is COMPOSITION! Book "has-a" Author
 *   - price (double)
 *   - qty (int, quantity in stock)
 *
 * Constructors:
 *   - Book(String name, Author author, double price)
 *     Sets qty to 0
 *   - Book(String name, Author author, double price, int qty)
 *
 * Public methods:
 *   - getName(), getAuthor() - returns the Author object
 *   - getPrice(), setPrice(double price)
 *   - getQty(), setQty(int qty)
 *
 *   Methods that DELEGATE to the composed Author object:
 *   - getAuthorName() - returns author.getName()
 *   - getAuthorEmail() - returns author.getEmail()
 *   - getAuthorGender() - returns author.getGender()
 *
 *   - toString() - returns
 *     "Book[name=?, Author[name=?, email=?, gender=?], price=?, qty=?]"
 *     Hint: Use author.toString() inside Book's toString()
 */

// Write your Book class here:
class Book {
    private String name;
    private Author author;   // Composition (has-a)
    private double price;
    private int qty;

    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = 0;
    }

    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    // Delegation methods
    public String getAuthorName() {
        return author.getName();
    }

    public String getAuthorEmail() {
        return author.getEmail();
    }

    public char getAuthorGender() {
        return author.getGender();
    }

    @Override
    public String toString() {
        return "Book[name=" + name +
                ", " + author.toString() +
                ", price=" + price +
                ", qty=" + qty + "]";
    }
}

// ============================================================
// PART C: Test Driver
// ============================================================

public class Lab5_AuthorBookComposition {
    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("  Lab 5: Author and Book (Composition)");
        System.out.println("=============================================\n");

        // ----- Section 1: Author Objects -----
        System.out.println("--- Section 1: Creating Authors ---");

        // TODO 3: Create Author objects
        // Author author1 = new Author("Ali Sultan", "ali.sultan@suza.ac.tz", 'm');
        // Author author2 = new Author("Mwanaisha Bakari", "mwanaisha.b@suza.ac.tz", 'f');
        // Author author3 = new Author("Hamad Khamis", "hamad.k@gmail.com", 'm');
        //
        // System.out.println(author1);
        // System.out.println(author2);
        // System.out.println(author3);
        Author author1 = new Author("Ali Sultan", "ali.sultan@suza.ac.tz", 'm');
        Author author2 = new Author("Mwanaisha Bakari", "mwanaisha.b@suza.ac.tz", 'f');
        Author author3 = new Author("Hamad Khamis", "hamad.k@gmail.com", 'm');

        System.out.println(author1);
        System.out.println(author2);
        System.out.println(author3);
        // ----- Section 2: Book Objects (Composition) -----
        System.out.println("\n--- Section 2: Creating Books ---");

        // TODO 4: Create Book objects - note how Book CONTAINS an Author
        // Book book1 = new Book("Introduction to Java", author1, 35000, 50);
        // Book book2 = new Book("Data Structures in Java", author2, 42000, 30);
        //
        // System.out.println(book1);
        // System.out.println(book2);
        Book book1 = new Book("Introduction to Java", author1, 35000, 50);
        Book book2 = new Book("Data Structures in Java", author2, 42000, 30);

        System.out.println(book1);
        System.out.println(book2);
        // ----- Section 3: Accessing Composed Object -----
        System.out.println("\n--- Section 3: Accessing Through Composition ---");

        // TODO 5: Access author details through the book
        // System.out.println("Book: " + book1.getName());
        // System.out.println("Author name: " + book1.getAuthorName());     // Delegated
        // System.out.println("Author email: " + book1.getAuthorEmail());   // Delegated
        //
        // // You can also get the Author object directly
        // Author bookAuthor = book1.getAuthor();
        // System.out.println("Author object: " + bookAuthor);
         System.out.println("Book: " + book1.getName());
        System.out.println("Author name: " + book1.getAuthorName());
        System.out.println("Author email: " + book1.getAuthorEmail());

        Author bookAuthor = book1.getAuthor();
        System.out.println("Author object: " + bookAuthor);
        
        System.out.println("\n--- Section 4: Shared Author References ---");
        Book book3 = new Book("Advanced Java Programming", author1, 55000, 20);

        System.out.println("Book 1 author: " + book1.getAuthorName());
        System.out.println("Book 3 author: " + book3.getAuthorName());
        System.out.println("Same author? " + (book1.getAuthor() == book3.getAuthor()));

        author1.setEmail("ali.sultan.new@suza.ac.tz");

        System.out.println("\nAfter changing author1's email:");
        System.out.println("Book 1 author email: " + book1.getAuthorEmail());
        System.out.println("Book 3 author email: " + book3.getAuthorEmail());
        // TODO 6: Same author can write multiple books
        // Book book3 = new Book("Advanced Java Programming", author1, 55000, 20);
        // System.out.println("Book 1 author: " + book1.getAuthorName());
        // System.out.println("Book 3 author: " + book3.getAuthorName());
        // System.out.println("Same author? " + (book1.getAuthor() == book3.getAuthor()));
        //
        // // What happens when we change the shared author's email?
        // author1.setEmail("ali.sultan.new@suza.ac.tz");
        // System.out.println("\nAfter changing author1's email:");
        // System.out.println("Book 1 author email: " + book1.getAuthorEmail());
        // System.out.println("Book 3 author email: " + book3.getAuthorEmail());
        // System.out.println("Both changed! Because they share the same Author object.");

        // ----- Section 5: Anonymous Author -----
        System.out.println("\n--- Section 5: Creating Book with Anonymous Author ---");

        // TODO 7: Create a Book with an anonymous Author (inline construction)
        // Book book4 = new Book(
        //     "Python for Beginners",
        //     new Author("Salma Haji", "salma.h@suza.ac.tz", 'f'),
        //     28000,
        //     100
        // );
        // System.out.println(book4);
        // System.out.println("Author: " + book4.getAuthorName());
        Book book4 = new Book(
                "Python for Beginners",
                new Author("Salma Haji", "salma.h@suza.ac.tz", 'f'),
                28000,
                100
        );

        System.out.println(book4);
        System.out.println("Author: " + book4.getAuthorName());
        // ----- Section 6: Book Inventory -----
        System.out.println("\n--- Section 6: Book Inventory ---");

        // TODO 8: Manage a collection of books
        // Book[] inventory = {book1, book2, book3, book4};
        //
        // System.out.println("SUZA Bookshop Inventory:");
        // System.out.println(String.format("%-30s %-25s %10s %5s",
        //     "Title", "Author", "Price(TZS)", "Qty"));
        // System.out.println("-".repeat(75));
        //
        // double totalValue = 0;
        // for (Book book : inventory) {
        //     System.out.println(String.format("%-30s %-25s %,10.0f %5d",
        //         book.getName(), book.getAuthorName(),
        //         book.getPrice(), book.getQty()));
        //     totalValue += book.getPrice() * book.getQty();
        // }
        // System.out.println("-".repeat(75));
        // System.out.println(String.format("Total inventory value: TZS %,.0f", totalValue));
         Book[] inventory = {book1, book2, book3, book4};

        System.out.println("SUZA Bookshop Inventory:");
        System.out.println(String.format("%-30s %-25s %10s %5s",
                "Title", "Author", "Price(TZS)", "Qty"));
        System.out.println("-".repeat(75));

        double totalValue = 0;

        for (Book book : inventory) {
            System.out.println(String.format("%-30s %-25s %,10.0f %5d",
                    book.getName(),
                    book.getAuthorName(),
                    book.getPrice(),
                    book.getQty()));

            totalValue += book.getPrice() * book.getQty();
        }

        System.out.println("-".repeat(75));
        System.out.println(String.format("Total inventory value: TZS %,.0f", totalValue));
        System.out.println("\n=============================================");
        System.out.println("  End of Lab 5");
        System.out.println("=============================================");
    }
}

/*
 * QUESTIONS TO ANSWER:
 * 1. What is the difference between composition (has-a) and inheritance (is-a)?
 Inheritance (is-a): One class is a specialized version of another.
    Example: Square IS-A Rectangle.
 Composition (has-a): One class contains another as a part of it.
    Example: Book HAS-A Author
 * 2. Why is it better for Book to HAVE an Author rather than EXTEND Author?
A book is not a type of author. That relationship would be logically incorrect.
If Book extended Author:
    A book would inherit name, email, gender.
    That would mean a Book "is an Author", which makes no sense.
    Composition correctly represents real-world modeling:
        A book is written by an author.
The author is part of the book’s data
 * 3. In Section 4, why does changing author1's email affect both books?
 *    How could you prevent this? (Hint: think about deep copy vs shallow copy)
 * Because both books store a reference to the same Author object.

    This is called a shallow copy (shared reference).

    To prevent this:

    Use a deep copy in the constructor:

        this.author = new Author(
            author.getName(),
            author.getEmail(),
            author.getGender()
        );


    That way each book has its own separate Author object.
 * 4. Can an Author exist without a Book? Can a Book exist without an Author?
 *    What does this tell you about the strength of the composition relationship?
        An Author can exist without a Book. ✔

        A Book should not exist without an Author (in this design). ✔

    This shows:

        The relationship is composition,

        But it is not a strong composition (like engine inside a car),

        Because Author is independent of Book.
*/
