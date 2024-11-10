package CommandLine;

import Quiz.QuizFileReader;
import Quiz.Quiz;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainConsole
{
    public static void main(String[] args)
    {
        QuizFileReader reader = new QuizFileReader();
        Quiz quiz = new Quiz();
        Scanner sc = new Scanner(System.in);
        String filepath;
        int idx;
        int userAnswer;

        filepath = "Assignment5/src/input.txt";
        try
        {
            quiz = reader.readQuiz(filepath);

        } catch (FileNotFoundException e)
        {
            System.out.println("The file not found");
        }

        idx = 0;
        while (idx < quiz.getQuizTotal())
        {
            System.out.println("\nQuestion " + (idx+1) + ":");
            System.out.print(quiz.getQuestion(idx));
            System.out.print("Enter your answer (1-4): ");

            userAnswer = sc.nextInt();
            quiz.addUserAnswer(userAnswer);
            idx++;

        }
        System.out.println("\n" + quiz);

    }
}
