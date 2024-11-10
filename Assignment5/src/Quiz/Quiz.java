/*
Name: Sojisirikul, Tanakan
NSID: tas199
Student Course: 11175553
Course: CMPT270-03
*/
package Quiz;

import java.util.ArrayList;

public class Quiz {
    /**
     * arraylist containing Question data type object
     */
    private ArrayList<Question> questionList;

    /**
     * arraylist containing user answers of each question
     */
    private ArrayList<Integer> userAnswerList;

    /**
     * initialization of arraylist question, and user answers
     */
    public Quiz()
    {
        this.questionList = new ArrayList<Question>();
        this.userAnswerList = new ArrayList<Integer>();

    }

    /**
     * adder Question type object into the array list
     * @param question      a question description
     * @param choices       answer choices for the question
     * @param answer        the answer integer of the question
     */
    public void addQuestion(String question, String[] choices, int answer)
    {
        this.questionList.add(new Question(question, choices, answer));

    }

    /**
     * getter question object by index
     * @param Idx   the index for the question list
     * @return  Question type object
     * @throws  IllegalStateException if index exceed number of list
     */
    public Question getQuestion(int Idx)
    {
        if (Idx > this.questionList.size()-1)
        {
            throw new IllegalStateException("index argument out of question bounds");
        }
        return this.questionList.get(Idx);

    }

    /**
     * adder user's answer into the array list
     * @param answer    user's answer for the question
     */
    public void addUserAnswer(int answer)
    {
        this.userAnswerList.add(answer);

    }

    /**
     * getter user's answer by index
     * @param Idx the index for the user's answer list
     * @return  the integer represent user's answer
     * @throws  IllegalStateException if Index exceed number of list
     */
    public int getUserAnswer(int Idx)
    {
        if (Idx > this.userAnswerList.size()-1)
        {
            throw new IllegalStateException("index argument out of user answer bounds");
        }
        return this.userAnswerList.get(Idx);

    }

    /**
     * getter of total number of question in the list
     * @return number of question in the quiz
     */
    public int getQuizTotal()
    {
        return this.questionList.size();

    }

    /**
     * number that user's answer matched with actual answer
     * @return  number of corrected answer
     * @throws  IllegalStateException of both index number not equal
     */
    public int getScore()
    {
        int userScore;
        userScore = 0;

        if (this.questionList.size() != this.userAnswerList.size())
        {
            throw new IllegalStateException("question count does not match with user answer count");

        }
        for (int i = 0; i < this.questionList.size(); i++)
        {
            if (getUserAnswer(i) == getQuestion(i).getAnswer())
            {
                userScore++;
            }
        }
        return userScore;
    }

    /**
     * indicates whether the user's answer is right or wrong
     * @param Idx   index for both question and user's answer lists
     * @return "Correct" if matching, "Wrong" otherwise
     */
    public String isCorrect(int Idx)
    {
        if (getUserAnswer(Idx) == getQuestion(Idx).getAnswer())
        {
            return "Correct";
        }
        return "Wrong";

    }

    /**
     * Summary user result in every question and grade
     * @return user result and grade in string
     */
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

    /* regression tests */
    public static void main(String[] args)
    {
        String qTest1 = "What is Azula nation Avatar animation?";
        String qTest2 = "What is Aang nation Avatar animation?";
        String[] choiceTest = {"1. Fire", "2. Water", "3. Earth", "4. Wind"};

        Quiz test = new Quiz();
        test.addQuestion(qTest1, choiceTest, 1);
        test.addUserAnswer(1);

        if (test.getQuizTotal() != 1)
        {
            System.out.println("Error addQuestion(): incorrect number of size in QuizMain List after added a quiz");
        }


        if (test.getUserAnswer(0) != 1)
        {
            System.out.println("Error getUserAnswer(): incorrect returned number");

        }

        if (test.isCorrect(0).equals("Wrong"))
        {
            System.out.println("Error isCorrect(): incorrect string result");
        }

        test.addQuestion(qTest2, choiceTest, 4);
        test.addUserAnswer(2);

        if(test.getQuizTotal() != 2)
        {
            System.out.println("Error getQuizTotal(): incorrect quiz total result");
        }

        if (test.getScore() != 1)
        {
            System.out.println("Error getScore(): incorrect score result");
        }

        //System.out.println(test);

        /* testing exceptions */

        test = new Quiz();
        test.addQuestion(qTest1, choiceTest, 1);
        test.addUserAnswer(1);

        try
        {
            test.getQuestion(1);
            System.out.println("Error getQuestion(): is not throwing exception for exceed index argument");
        }
        catch (IllegalStateException e)
        {}

        try
        {
            test.getUserAnswer(1);
            System.out.println("Error getUserAnswer(): is not throwing exception for exceed index argument");
        }
        catch (IllegalStateException e)
        {}

        test.addUserAnswer(1);
        try
        {
            test.getScore();
            System.out.println("Error getScore(): is not throwing exception for non-equal index");
        }
        catch (IllegalStateException e)
        {}

    }

}
