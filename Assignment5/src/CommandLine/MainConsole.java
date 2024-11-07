
package CommandLine;

import GradeQuiz.QuizQuestion;
import GradeQuiz.QuizFileReader;
import GradeQuiz.QuizMain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainConsole
{
    public static void main(String[] args)
    {
        QuizFileReader reader = new QuizFileReader();
        List<QuizQuestion> quizDisplay = new ArrayList<>();
        QuizMain scoreCollect = new QuizMain();
        Scanner sc = new Scanner(System.in);
        String filepath;
        int i;
        int userAnswer;
        String question;
        String[] choice;
        int answer;

        filepath = "Assignment5/src/input.txt";
        try
        {
            quizDisplay = reader.readQuiz(filepath);

        } catch (FileNotFoundException e)
        {
            System.out.println("The file not found");
        }

        i = 0;
        while (i < quizDisplay.size())
        {
            System.out.println("\nQuestion #" + (i+1));
            System.out.print(quizDisplay.get(i));
            System.out.print("Enter your answer (1-4): ");

            userAnswer = sc.nextInt();

            question = quizDisplay.get(i).getQuestion();
            choice = quizDisplay.get(i).getChoice();
            answer = quizDisplay.get(i).getAnswer();

            scoreCollect.addQuestion(question, choice, answer, userAnswer);
            i++;

        }
        System.out.println(scoreCollect);

    }
}
