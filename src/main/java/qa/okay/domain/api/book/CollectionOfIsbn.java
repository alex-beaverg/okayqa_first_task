package qa.okay.domain.api.book;

public class CollectionOfIsbn {
    private String isbn;

    public CollectionOfIsbn() { }

    public CollectionOfIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
