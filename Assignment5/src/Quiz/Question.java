/*
Name: Sojisirikul, Tanakan
NSID: tas199
Student Course: 11175553
Course: CMPT270-03
*/

package Quiz;

public class Question
{
    /**
     * a question description
     */
    private String question;

    /**
     * answer choices of the question
     */
    private String[] choices;

    /**
     * the answer in the question
     */
    private int answer;

    /**
     * class construction that included complete form question
     * @param question      a question information
     * @param choices       answer choices for the question
     * @param answer        the answer number of the question
     */
    public Question(String question, String[] choices, int answer)
    {
        this.question = question;
        this.choices = choices;
        this.answer = answer;

    }

    /**
     * getter of question description
     * @return question description in string
     */
    public String getQuestion()
    {
        return question;
    }


    /**
     * getter of answer choices information
     * @return the string array of choices
     */
    public String[] getChoice()
    {
        return choices;

    }

    /**
     * number of answer choices
     * @return the choices length in integer
     */
    public int getChoiceSize()
    {
        return choices.length;
    }

    /**
     * getter of the answer choice of the question in number
     * @return the number of the answer in integer
     */
    public int getAnswer()
    {
        return answer;

    }

    /**
     * complete form of question without showing answer.
     * @return  question and its choices in string
     */
    @Override
    public String toString()
    {
        String quizQuestionString;

        quizQuestionString = "";
        quizQuestionString += this.getQuestion() + "\n";
        for (int i = 0; i < this.getChoiceSize(); i++)
        {
            quizQuestionString += "\t" + this.getChoice()[i] + "\n";
        }
        //quizQuestionString += "Answer:" + this.answer + "\n";
        return quizQuestionString;

    }

    public static void main(String[] args)
    {
        String[] choiceTest = {"AAAAA", "BBBBB", "CCCCC", "DDDDD"};

        Question test = new Question("QUESTION", choiceTest, 1);

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
            System.out.println("Error: answer  attribute not match with the input argument");
        }

        //System.out.println(test.toString());


    }
}
