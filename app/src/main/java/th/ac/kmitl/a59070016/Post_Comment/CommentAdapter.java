package th.ac.kmitl.a59070016.Post_Comment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import th.ac.kmitl.a59070016.R;

public class CommentAdapter extends ArrayAdapter<CommentStore> {
    private Context context;
    private List<CommentStore> comments;
    public CommentAdapter(@NonNull Context context, int resource, List<CommentStore> comments) {
        super(context, resource, comments);
        this.comments = comments;
        this.context = context;
    }


    @Nullable
    @Override
    public CommentStore getItem(int position) {
        return comments.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View commentItem = LayoutInflater.from(context).inflate(
                R.layout.fragment_adcomment,
                parent,
                false
        );

        TextView commentId = (TextView) commentItem.findViewById(R.id.comment_post_id);
        TextView commentTitle = (TextView) commentItem.findViewById(R.id.comment_id);
        TextView commentBody = (TextView) commentItem.findViewById(R.id.comment_body);
        TextView commentEmail = (TextView) commentItem.findViewById(R.id.comment_email);
        TextView commentName = (TextView) commentItem.findViewById(R.id.comment_name);
        commentId.setText(comments.get(position).postId+"");
        commentTitle.setText(comments.get(position).id+"");
        commentBody.setText(comments.get(position).body);
        commentEmail.setText(comments.get(position).email);
        commentName.setText(comments.get(position).name);


        return commentItem;
    }
}
