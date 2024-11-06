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

    public void addQuestion(String question, String[] choices, int quiznAnswer, int userAnswer)
    {
        this.questionList.add(new QuizQuestion(question, choices, quiznAnswer));
        this.userAnswerList.add(new UserAnswer(userAnswer));
        this.questionIdx++;
        if (quiznAnswer == userAnswer)
        {
            this.score++;
        }
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

    public int getQuizTotal()
    {
        return this.questionList.size();

    }

    public boolean isCorrect(int questionNumber)
    {
        return this.getQuizAnswer(questionNumber) == this.getUserAnswer(questionNumber);
    }

    public int getScore()
    {
        return this.score;

    }

    public String toString()
    {
        String quizString;

        quizString = "";

        for (int i = 0; i < this.getQuizTotal(); i++)
        {
            quizString += "Question " + (i+1) + ": " + this.isCorrect(i) + "\n";
        }
        quizString += "Score: " + this.getScore() + "/" + this.getQuizTotal() + "\n";

        return quizString;
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
        test.addQuestion("What is Azula nation Avatar animation?",
                choiceTest, 1, 1);

        if (test.getQuizTotal() != 1)
        {
            System.out.println("Error addQuestion(): incorrect number of size in QuizMain List after added a quiz");
        }

        if (test.getQuizAnswer(0) != 1)
        {
            System.out.println("Error getQuizAnswer(): incorrect returned number");

        }

        if (test.getUserAnswer(0) != 1)
        {
            System.out.println("Error getUserAnswer(): incorrect returned number");

        }

        if (!test.isCorrect(0))
        {
            System.out.println("Error isCorrect(): incorrect boolean result");
        }

        test.addQuestion("What is Aang nation Avatar animation?",
                choiceTest, 4, 1);

        if (test.getScore() != 1)
        {
            System.out.println("Error getScore(): incorrect score result");
        }



        System.out.println(test.toString());


    }

}
