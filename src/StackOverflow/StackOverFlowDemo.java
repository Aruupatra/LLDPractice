package StackOverflow;

import java.util.Arrays;

public class StackOverFlowDemo {

    public static void main(String[] args)
    {
        StackOverFlow stackOverFlow=new StackOverFlow();
         User arun=stackOverFlow.createUser("Arun","Arun@gmail.com");

         Question question=stackOverFlow.askQuestion(arun,"What is java","need a explanation why we use Java over Python", Arrays.asList("Java","Pyhton"));

         User kabi=stackOverFlow.createUser("Kabi","Kabi@gmail.com");
         Answer answer=stackOverFlow.putAnswer(kabi,question,"Java is user Friendly that Python");

         stackOverFlow.vote(arun,answer,VotyType.UPVOTE);
         stackOverFlow.acceptAnswer(answer);

         System.out.println(kabi.reputation);

    }
}
