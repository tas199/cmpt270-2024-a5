package GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
//import javax.swing.border.Border.*;


import GradeQuiz.QuizQuestion;
import GradeQuiz.QuizFileReader;
import GradeQuiz.QuizMain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;


public class QuizFrame extends JFrame
{
    QuizFileReader reader;
    List<QuizQuestion> quizDisplay;
    QuizMain scoreCollect = new QuizMain();

    private JPanel quizPanel;

    private JLabel questionNumber;
    private JLabel questionText;

    private JButton choiceButton1;
    private JButton choiceButton2;
    private JButton choiceButton3;
    private JButton choiceButton4;

    private JLabel gradeQuiz;

    public QuizFrame()
    {
        this.reader = new QuizFileReader();
        this.quizDisplay = new ArrayList<>();
        this.scoreCollect = new QuizMain();
        String filepath;
        String question;
        String[] choice;
        int answer;
        int i;

        quizPanel = new JPanel();

        this.setTitle("Quiz - Avatar: The Last Airbender");
        this.setSize(500, 350);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        filepath = "Assignment5/src/input.txt";
        try
        {
            quizDisplay = reader.readQuiz(filepath);

        } catch (FileNotFoundException e)
        {
            System.out.println("The file not found");
        }

        i = 0;
        question = quizDisplay.get(i).getQuestion();
        choice = quizDisplay.get(i).getChoice();
        answer = quizDisplay.get(i).getAnswer();

        GridLayout layout = new GridLayout(8, 2);
        this.quizPanel.setSize(500, 700);
        layout.setHgap(10);
        this.quizPanel.setLayout(layout);


        this.questionNumber = new JLabel("Question #" + (i+1) + ":");
        this.questionText = new JLabel(question);
        this.choiceButton1 = new JButton(choice[0]);
        this.choiceButton2 = new JButton(choice[1]);
        this.choiceButton3 = new JButton(choice[2]);
        this.choiceButton4 = new JButton(choice[3]);
        this.gradeQuiz = new JLabel(this.scoreCollect.toString());

        //this.choiceButton1.addActionListener(this.scoreCollect.addQuestion(question, choice, answer, 1));
        //this.choiceButton2.addActionListener(this.scoreCollect.addQuestion(question, choice, answer, 2));
        //this.choiceButton3.addActionListener(this.scoreCollect.addQuestion(question, choice, answer, 3));
        //this.choiceButton4.addActionListener(this.scoreCollect.addQuestion(question, choice, answer, 4));




        this.quizPanel.add(this.questionNumber);
        this.quizPanel.add(this.questionText);
        this.quizPanel.add(this.choiceButton1);
        this.quizPanel.add(this.choiceButton2);
        this.quizPanel.add(this.choiceButton3);
        this.quizPanel.add(this.choiceButton4);

        this.quizPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setContentPane(this.quizPanel);




        this.setResizable(false);
        this.setVisible(true);

        }

        public static void main(String[] args)
        {
            QuizFrame fram = new QuizFrame();

        }

}
