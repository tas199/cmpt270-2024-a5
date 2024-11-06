package GradeQuiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizFileReader
{
    private String filePath;
    private File myObj;

    public QuizFileReader()
    {
        this.filePath = "";
    }

    public List<QuizQuestion> readQuiz(String filepath) throws FileNotFoundException
    {
        List<QuizQuestion> questionAll = new ArrayList<>();
        String question;
        String[] choice;
        int answer;

        question = "";
        choice = null;



        filePath = filepath;
        Scanner sc = null;
        try
        {
            myObj = new File(this.filePath);
            sc = new Scanner(myObj);

            while (sc.hasNextLine())
            {
                question = sc.nextLine().trim();

                if (sc.hasNextLine()) {
                    String choiceStr = sc.nextLine().trim();
                    choice = choiceStr.split(",");
                    for (int i = 0; i < choice.length; i++) {
                        choice[i] = choice[i].trim();
                    }
                }

                answer = 0;
                if (sc.hasNextLine()) {
                    String answerStr = sc.nextLine().trim();
                    answer = Integer.parseInt(answerStr.trim());
                }
                questionAll.add(new QuizQuestion(question, choice, answer));

            }

        }
        finally
        {
            if (sc != null)
                sc.close();
        }
        return questionAll;

    }

    public static void main(String[] args) {
        List<QuizQuestion> test = new ArrayList<>();
        QuizFileReader reader = new QuizFileReader();
        String testPrint = "";

        String filepath = "Assignment5/src/input.txt";

        try
        {
            test = reader.readQuiz(filepath);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }


        for (int i = 0; i < test.size(); i++)
        {
            testPrint += test.get(i).toString() + "\n";
        }
        System.out.println(testPrint);


    }




}