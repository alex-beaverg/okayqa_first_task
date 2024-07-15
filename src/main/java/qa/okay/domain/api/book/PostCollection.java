package qa.okay.domain.api.book;

import java.util.ArrayList;

public class PostCollection {
    public String userId;
    public ArrayList<CollectionOfIsbn> collectionOfIsbns;

    public PostCollection() { }

    public PostCollection(String userId, ArrayList<CollectionOfIsbn> collectionOfIsbns) {
        this.userId = userId;
        this.collectionOfIsbns = collectionOfIsbns;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<CollectionOfIsbn> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(ArrayList<CollectionOfIsbn> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
