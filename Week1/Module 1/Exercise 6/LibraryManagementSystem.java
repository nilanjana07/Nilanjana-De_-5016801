public class LibraryManagementSystem {

    // Define the Book class
    public static class Book {
        private int bookId;
        private String title;
        private String author;

        // Constructor
        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        // Getters
        public int getBookId() { return bookId; }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }

        @Override
        public String toString() {
            return "BookID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    // Define the LibraryManager class
    public static class LibraryManager {
        private Book[] books;
        private int size;

        // Constructor
        public LibraryManager(int capacity) {
            books = new Book[capacity];
            size = 0;
        }

        // Add a book to the library
        public void addBook(Book book) {
            if (size < books.length) {
                books[size++] = book;
            } else {
                System.out.println("Library is full!");
            }
        }

        // Linear search for a book by title
        public Book linearSearchByTitle(String title) {
            for (int i = 0; i < size; i++) {
                if (books[i].getTitle().equalsIgnoreCase(title)) {
                    return books[i];
                }
            }
            return null; // Book not found
        }

        // Binary search for a book by title (requires sorted array)
        public Book binarySearchByTitle(String title) {
            int left = 0;
            int right = size - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int comparison = books[mid].getTitle().compareToIgnoreCase(title);
                if (comparison == 0) {
                    return books[mid];
                } else if (comparison < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null; // Book not found
        }

        // Sort the books array by title (for binary search)
        public void sortBooksByTitle() {
            for (int i = 1; i < size; i++) {
                Book key = books[i];
                int j = i - 1;
                while (j >= 0 && books[j].getTitle().compareToIgnoreCase(key.getTitle()) > 0) {
                    books[j + 1] = books[j];
                    j--;
                }
                books[j + 1] = key;
            }
        }
    }

    // Main method to demonstrate the Library Management System
    public static void main(String[] args) {
        // Create a LibraryManager instance
        LibraryManager manager = new LibraryManager(10);

        // Add books to the library
        manager.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        manager.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        manager.addBook(new Book(3, "1984", "George Orwell"));
        manager.addBook(new Book(4, "The Catcher in the Rye", "J.D. Salinger"));

        // Sort books by title for binary search
        manager.sortBooksByTitle();

        // Search for a book by title using linear search
        System.out.println("Linear Search for '1984':");
        Book book = manager.linearSearchByTitle("1984");
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }

        // Search for a book by title using binary search
        System.out.println("\nBinary Search for '1984':");
        book = manager.binarySearchByTitle("1984");
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }
}

