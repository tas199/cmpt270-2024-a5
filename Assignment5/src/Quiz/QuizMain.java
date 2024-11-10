/*
Name: Sojisirikul, Tanakan
NSID: tas199
Student Course: 11175553
Course: CMPT270-03
*/


package GradeQuiz;

import java.util.ArrayList;
import java.util.List;

public class QuizMain
{
    private List<QuizQuestion> questionList;
    private List<UserAnswer> userAnswerList;
    private int score;

    public QuizMain()
    {
        this.questionList = new ArrayList<QuizQuestion>();
        this.userAnswerList = new ArrayList<UserAnswer>();
        this.score = 0;


    }

    public void addQuestion(String question, String[] choices, int quiznAnswer, int userAnswer)
    {
        this.questionList.add(new QuizQuestion(question, choices, quiznAnswer));
        this.userAnswerList.add(new UserAnswer(userAnswer));
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

    public String isCorrect(int questionNumber)
    {
        if (getQuizAnswer(questionNumber) == getUserAnswer(questionNumber))
        {
            return "Correct";
        }
        return "Wrong";

    }

    public int getScore()
    {
        return this.score;

    }

    @Override
    public String toString()
    {
        String quizString;
        float result;
        result = (float) getScore() / getQuizTotal() * 100;

        quizString = "";

        for (int i = 0; i < getQuizTotal(); i++)
        {
            quizString += "Question " + (i+1) + ": " + isCorrect(i) + "\n";
        }
        quizString += "Score: " + getScore() + "/" + getQuizTotal()
        + " (" + result + "%)" + "\n";

        return quizString;
    }


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

        if (test.isCorrect(0).equals("Wrong"))
        {
            System.out.println("Error isCorrect(): incorrect boolean result");
        }

        test.addQuestion("What is Aang nation Avatar animation?",
                choiceTest, 4, 1);

        if (test.getScore() != 1)
        {
            System.out.println("Error getScore(): incorrect score result");
        }

        //System.out.println(test.toString());


    }

}
