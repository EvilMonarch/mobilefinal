package th.ac.kmitl.a59070016.Post_Comment;

public class CommentStore {
    int postId , id;
    String name,email, body;

    public CommentStore(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }
}