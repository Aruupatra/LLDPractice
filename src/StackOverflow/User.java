package StackOverflow;

import java.util.ArrayList;
import java.util.List;

public class User {

    int id;
    String name;
    String email;
    int reputation;
    List<Question> questions;
    List<Answer> answers;
    List<Comment> comments;

    private static final int QUESTION_REPUTATION=5;
    private static final int ANSWER_REPUTATION=10;
    private static final int COMMENT_REPUTATION=2;

    User(String name,String email)
    {
        this.id=1;
        this.name=name;
        this.email=email;
        this.reputation=0;
        this.questions=new ArrayList<>();
        this.answers=new ArrayList<>();
        this.comments=new ArrayList<>();
    }

    public void updateReputation(int reputation)
    {
        this.reputation=this.reputation+reputation;
    }

    public Question askQuestion(String title,String content,List<String> tags)
    {
        Question question=new Question(this,title,content,tags);
        this.questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }
    public Answer addAnswer(Question question,String content)
    {
        Answer answer=new Answer(this,question,content);
        this.answers.add(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }
    public Comment addComment(Commentable commentable , String content)
    {
        Comment comment=new Comment(content);
        this.comments.add(comment);
        commentable.addComment(comment);
        updateReputation(COMMENT_REPUTATION);
        return comment;
    }
}
