package Quiz;

public class QuizQuestion {

    private String question;
    private String[] choices;
    private int answer;

    public QuizQuestion(String question, String[] choices, int answer)
    {
        this.question = question;
        this.choices = choices;
        this.answer = answer;

    }

    public String getQuestion()
    {
        return question;
    }

    public String[] getChoice()
    {
        return choices;

    }

    public int getAnswer()
    {
        return answer;

    }

    @Override
    public String toString()
    {
        String quizQuestionString;

        quizQuestionString = "";
        quizQuestionString += "\n" + this.question + "\n";
        for (int i = 0; i < choices.length; i++)
        {
            quizQuestionString += choices[i] + "\n";
        }
        quizQuestionString += "Answer:" + this.answer + "\n";
        return quizQuestionString;

    }

    public static void main(String[] args)
    {
        String[] choiceTest = {"AAAAA", "BBBBB", "CCCCC", "DDDDD"};

        QuizQuestion test = new QuizQuestion("QUESTION", choiceTest, 1);

        if (test.getQuestion().equals("AAAAA"))
        {
            System.out.println("Error: question attribute not match with the input argument");
        }

        if (!test.getChoice().equals(choiceTest))
        {
            System.out.println("Error: choice attribute not match with the input argument");
        }

        if (test.getAnswer() != 1)
        {
            System.out.println("Error: answer attribute not match with the input argument");
        }

        System.out.println(test.toString());


    }
}
