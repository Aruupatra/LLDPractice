package StackOverflow;

import java.util.HashMap;
import java.util.List;

public class StackOverFlow {

    HashMap<Integer , User> userMap=new HashMap<>();
    HashMap<Integer , Question> questionMap=new HashMap<>();
    HashMap<Integer , Answer> answerMap=new HashMap<>();


    public User createUser(String name, String email)
    {
        User user=new User(name,email);
        userMap.put(user.id, user);
        return user;
    }
    public Question askQuestion(User user,String title,String content , List<String> tags)
    {
        Question question = user.askQuestion(title,content,tags);
        questionMap.put(question.id, question);
        return question;
    }
    public Answer putAnswer(User user,Question question,String content)
    {
        Answer answer=user.addAnswer(question,content);
        answerMap.put(answer.id, answer);
        return  answer;
    }
    public void vote(User user,Votable votable,VotyType voteType)
    {
        votable.addVote(user,voteType);
    }
    public Comment addCommentsQuestion(User user,Commentable commentable ,String content)
    {
      Comment comment=user.addComment(commentable , content);
      return comment;
    }

    public void acceptAnswer(Answer answer)
    {
        answer.acceptedAnswer();
    }
}
