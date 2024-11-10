package Quiz;

public class UserAnswer
{
    private int answer;

    public UserAnswer(int userInput)
    {
    this.answer = userInput;

    }

    public int getAnswer()
    {
        return answer;

    }

    public String toString()
    {
        String userAnswerString;

        userAnswerString = "";
        userAnswerString += "User answer: " + this.answer + "\n";

        return userAnswerString;

    }

    public static void main(String[] args)
    {
        UserAnswer test = new UserAnswer(3);

        if (test.getAnswer() != 3)
        {
            System.out.println("Error: answer attribute not match with the input argument");
        }

        //System.out.println(test);
    }


}
