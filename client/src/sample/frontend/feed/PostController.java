package sample.frontend.feed;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import sample.backend.application.post.Post;
import sample.frontend.post.comment.CommentController;
import sample.frontend.post.comment.CommentMain;

import java.io.IOException;


public class PostController
{
    @FXML
    public Label date;
    @FXML
    public ImageView profileImage;
    @FXML
    private ImageView postImage;

    @FXML
    private Label owner;

    @FXML
    private Label likes;

    @FXML
    private Label comments;

    private Post post;


    public void setData(Post post) throws IOException
    {
        this.post = post;

        postImage.setImage(post.getImage());
        owner.setText(post.getOwner());
        likes.setText(post.getLikesQuantity().toString());
        comments.setText(post.getCommentsQuantity().toString());
        String dateTimeToShow = post.getDateTime().getYear() + " " +
                post.getDateTime().getMonth() + " " +
                post.getDateTime().getDayOfMonth() + " " +
                post.getDateTime().getHour() + ":" +
                post.getDateTime().getMinute() + "min";
        date.setText(dateTimeToShow);
    }

    public void likeBTN()
    {

    }

    public void commentBTN() throws Exception
    {
        CommentController.setPostID(post.getPostID());
        CommentController.setCaption(post.getCaption());
        CommentMain commentRunner = new CommentMain();
        commentRunner.setUp("comment.fxml");
    }
}
