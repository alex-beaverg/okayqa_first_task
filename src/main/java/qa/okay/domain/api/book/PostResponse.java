package qa.okay.domain.api.book;

import java.util.ArrayList;

public class PostResponse {
    private ArrayList<CollectionOfIsbn> books;

    public PostResponse() { }

    public PostResponse(ArrayList<CollectionOfIsbn> books) {
        this.books = books;
    }

    public ArrayList<CollectionOfIsbn> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<CollectionOfIsbn> books) {
        this.books = books;
    }
}
