package StackOverflow;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;

public class Question implements Commentable,Votable{

    int id;
    String title;
    String content;
    List<Answer> answers;
    List<Comment> comments;
    List<Vote> votes;
    User author;
    List<Tag> tags;

    Question(User author,String title,String content,List<String> tags)
    {
        id=1;
        this.title=title;
        this.content=content;
        answers=new ArrayList<>();
        comments=new ArrayList<>();
        this.author=author;
        this.tags=new ArrayList<>();
        this.votes=new ArrayList<>();
        for(String tagname:tags)
        {
         this.tags.add(new Tag(tagname));
        }

    }

    public void addAnswer(Answer answer)
    {
        this.answers.add(answer);
    }

    @Override
    public void addComment(StackOverflow.Comment comment) {

    }

    @Override
    public void addVote(User user, VotyType voteType) {

        this.author.updateReputation(voteType.equals(VotyType.UPVOTE)?1:-1);
    }
}
