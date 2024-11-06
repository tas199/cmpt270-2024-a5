/*
Name: Sojisirikul, Tanakan
NSID: tas199
Student Course: 11175553
Course: CMPT270-03
*/


package Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizMain
{
    private List<QuizQuestion> questionList;
    private List<UserAnswer> userAnswerList;
    private int questionIdx;
    private int score;

    public QuizMain()
    {
        this.questionList = new ArrayList<QuizQuestion>();
        this.userAnswerList = new ArrayList<UserAnswer>();
        this.questionIdx = 0;
        this.score = 0;


    }

    public void addQuestion(String question, String[] choices, int questionAnswer, int userAnswer)
    {
        this.questionList.add(new QuizQuestion(question, choices, questionAnswer));
        this.userAnswerList.add(new UserAnswer(userAnswer));
        this.questionIdx++;
    }

    public QuizQuestion getQuestion(int questionNumber)
    {
        // catching null
        return this.questionList.get(questionNumber);
    }

    public int getQuizAnswer(int questionNumber)
    {
        return this.questionList.get(questionNumber).getAnswer();

    }

    public int getUserAnswer(int questionNumber)
    {
        return this.userAnswerList.get(questionNumber).getAnswer();

    }

    public int getQuestionTotal()
    {
        return this.questionList.size();
    }

    /*
    public UserAnswer getUserAnswer(int questionNumber)
    {
        return this.userAnswerList.get(questionNumber);

    }

    public int getScore()
    {
        return this.score;

    }

    public int getQuestionTotal()
    {
        return this.questionList.size();
    }

    public int[] getUserAnswer()
    {
        return this

    }

    public String toString()
    {
        return "";
    }

    */
    public static void main(String[] args)
    {
        String[] choiceTest = {"1. Fire", "2. Water", "3. Earth", "4. Wind"};

        QuizMain test = new QuizMain();
        test.addQuestion("What is Azula element in the Avatar animation?", choiceTest, 1, 1);

        if (test.getQuestionTotal() != 1)
        {
            System.out.println("Error addQuestion(): incorrect number of size in QuizMain List after added a quiz");
        }

        if (test.getQuizAnswer(0) != 1)
        {
            System.out.println("Error getQuizAnswer(): incorrect return number");

        }

        if (test.getUserAnswer(0) != 1)
        {
            System.out.println("Error getUserAnswer(): incorrect return number");

        }



        //System.out.println(test.toString());


    }

}
