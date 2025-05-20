package StackOverflow;

import java.util.ArrayList;
import java.util.List;

public class Answer implements Commentable,Votable{

    int id;
    String content;
    List<Comment> comments;
    Question question;
    boolean isAccepted;
    User author;

    Answer(User author,Question question ,String content)
    {
        this.id=1;
        this.content=content;
        this.question=question;
        this.comments=new ArrayList<>();
        this.author=author;
    }

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public void addVote(User user, VotyType voteType) {
        this.author.updateReputation(voteType.equals(VotyType.UPVOTE)?1:-1);
    }

    public void acceptedAnswer()
    {
        this.isAccepted=true;
    }
}
