package qa.okay.domain.api.account;

import com.fasterxml.jackson.annotation.JsonAlias;
import qa.okay.domain.api.book.Book;

import java.util.ArrayList;
import java.util.Objects;

public class UserDetails {
    @JsonAlias({"userID"})
    private String userId;
    private String username;
    private ArrayList<Book> books;

    public UserDetails() { }

    public UserDetails(String userId, String username, ArrayList<Book> books) {
        this.userId = userId;
        this.username = username;
        this.books = books;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails that = (UserDetails) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(username, that.username) &&
                Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, books);
    }
}
