package Week_1_Exercises.DSA;

import java.util.*;

class Book {
    int bookId;
    String title, author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagementSystem {

    Book[] library;

    LibraryManagementSystem(int capacity) {
        library = new Book[capacity];
    }

    LibraryManagementSystem() {
        library = new Book[1000];
    }

    // implementing binary search
    static Book binarySearch(Book[] library, Book targetBook) {
        int left = 0;
        int right = library.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = library[mid];

            if (midBook == targetBook) {
                return midBook;
            } else if (midBook == targetBook) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // implementing linear Search
    static Book linearSearch(Book[] library, Book targetBook) {
        for (Book book : library) {
            if (book == targetBook) {
                return book;
            }
        }
        System.out.println("The Product does not exsists.");
        return null;
    }

    public static void main(String[] args) {
        /*
         * Create some books to be in the library and search for them using the linear
         * search or binary search provided. Sort the array before attempting to o
         * binary search
         */
    }

}

/*
 * Analysis:
 * 
 * time complexity of linear search: O(N)
 * time complexity of binary search: O(log(N))
 * 
 * if the data set is too large and sorted and the time to search for the
 * element is restricted to very limited time, then binary search is more
 * efficient. if the list is not sorted then linear search is more convinient
 */