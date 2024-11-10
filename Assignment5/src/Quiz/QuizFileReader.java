/*
Name: Sojisirikul, Tanakan
NSID: tas199
Student Course: 11175553
Course: CMPT270-03
*/
package Quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class work is followed CMPT270 Assignment4 AchievementFileReader.java
 */
public class QuizFileReader
{
    /**
     * the file path where question read from
     */
    private String filePath;

    /**
     * a file object at the location by filePath
     */
    private File myObj;

    /**
     * constructor, initialize filepath to empty string
     */
    public QuizFileReader()
    {
        this.filePath = "";
    }

    /**
     * reads question from a txt file at the argument filepath
     * @param filePathStr file path to txt file where questions stored
     * @return a newly created Quiz object with all questions stored
     * @throws FileNotFoundException if the file location does not exist
     */
    public Quiz readQuiz(String filePathStr) throws FileNotFoundException
    {
        Quiz questionAll = new Quiz();
        String question;
        String[] choice;
        int answer;

        question = "";
        choice = null;
        answer = 0;

        filePath = filePathStr;
        Scanner sc = null;
        try
        {
            myObj = new File(this.filePath);
            sc = new Scanner(myObj);

            while (sc.hasNextLine())
            {
                question = sc.nextLine().trim();

                if (sc.hasNextLine())
                {
                    String choiceS = sc.nextLine().trim();
                    choice = choiceS.split(",");
                    for (int i = 0; i < choice.length; i++)
                    {
                        choice[i] = choice[i].trim();

                    }

                }
                if (sc.hasNextLine())
                {
                    String answerStr = sc.nextLine().trim();
                    answer = Integer.parseInt(answerStr.trim());

                }
                questionAll.addQuestion(question, choice, answer);

            }

        }
        finally
        {
            if (sc != null)
            {
                sc.close();

            }
        }
        return questionAll;

    }

    public static void main(String[] args)
    {
        Quiz test = new Quiz();
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

        if (test.getQuizTotal() != 10)
        {
            System.out.println("Wrong size number of the array list.");
        }




        /*
        for (int i = 0; i < test.getQuizTotal(); i++)
        {
            testPrint += test.getQuestion(i) + "\n";
        }
        System.out.println(testPrint);

        */






    }




}