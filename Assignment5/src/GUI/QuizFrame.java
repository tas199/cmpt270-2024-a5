/*
Name: Sojisirikul, Tanakan
NSID: tas199
Student Course: 11175553
Course: CMPT270-03
*/
package GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Quiz.QuizFileReader;
import Quiz.Quiz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import java.io.FileNotFoundException;

/**
 * This class work is based on CMPT270 Lab, CourseFrame.java
 */
public class QuizFrame extends JFrame
{
    /**
     * Quiz object
     */
    private Quiz quiz;

    /**
     * index integer
     */
    private int idx;

    /**
     * main panel of the GUI
     */
    private JPanel quizPanel;

    /**
     * sub panel that including question number, text, and choice buttons
     */
    private JPanel questionPanel;

    /**
     * label indicating the question number
     */
    private JLabel questionNumber;

    /**
     * label indicating the question description
     */
    private JLabel questionText;

    /**
     * answer choice buttons for the question
     */
    private JButton choiceButton1;
    private JButton choiceButton2;
    private JButton choiceButton3;
    private JButton choiceButton4;

    /**
     * label representing Quiz toString() that show mark for each question and total grade
     */
    private JLabel gradeQuiz;

    /**
     * GUI interactions for the quiz
     */
    public QuizFrame()
    {
        this.quiz = new Quiz();
        QuizFileReader reader = new QuizFileReader();
        String filepath;

        /* frame title and size */
        this.setTitle("Quiz - Avatar: The Last Airbender");
        this.setSize(500, 350);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        filepath = "Assignment5/input.txt";
        try {
            this.quiz = reader.readQuiz(filepath);

        } catch (FileNotFoundException e) {
            System.out.println("The file not found");
        }

        /* main panel setting */
        this.quizPanel = new JPanel();
        this.quizPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        this.questionNumber = new JLabel();
        this.questionText = new JLabel();
        this.choiceButton1 = new JButton();
        this.choiceButton2 = new JButton();
        this.choiceButton3 = new JButton();
        this.choiceButton4 = new JButton();
        this.gradeQuiz = new JLabel();

        choiceButton1.addActionListener(new ChoiceButtonListener(1));
        choiceButton2.addActionListener(new ChoiceButtonListener(2));
        choiceButton3.addActionListener(new ChoiceButtonListener(3));
        choiceButton4.addActionListener(new ChoiceButtonListener(4));

        /* sub panel that included question and choices */
        GridLayout layout = new GridLayout(7, 1);
        this.questionPanel = new JPanel(layout);

        this.questionPanel.add(this.questionNumber);
        this.questionPanel.add(this.questionText);
        this.questionPanel.add(this.choiceButton1);
        this.questionPanel.add(this.choiceButton2);
        this.questionPanel.add(this.choiceButton3);
        this.questionPanel.add(this.choiceButton4);

        /* adds both question panel and grade label to the main panel */
        this.quizPanel.add(questionPanel);
        this.quizPanel.add(gradeQuiz);

        this.setContentPane(this.quizPanel);
        this.setResizable(false);

        /* set text tool for each label and button */
        this.idx = 0;
        setDisplay(idx);

        /* set gradeQuiz label invisible as default */
        this.setVisible(true);
        this.gradeQuiz.setVisible(false);

    }

    /**
     * set the question labels and choice buttons to the current index
     * @param idx   the index of the question in quiz
     */
    private void setDisplay(int idx)
    {
        String question;
        String[] choice;

        question = this.quiz.getQuestion(idx).getQuestion();
        choice = this.quiz.getQuestion(idx).getChoice();

        this.questionNumber.setText("Question #" + (idx+1) + ":");
        this.questionText.setText(question);
        this.choiceButton1.setText(choice[0]);
        this.choiceButton2.setText(choice[1]);
        this.choiceButton3.setText(choice[2]);
        this.choiceButton4.setText(choice[3]);

    }


    private class ChoiceButtonListener implements ActionListener
    {
        /**
         * user's answer in integer form
         */
        private int userAnswer;

        /**
         * constructor, the argument that relating with each button setting
         * @param answer    user's answer in integer
         */
        public ChoiceButtonListener(int answer)
        {
            this.userAnswer = answer;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            quiz.addUserAnswer(this.userAnswer);
            idx++;
            if (idx < quiz.getQuizTotal())
            {
                setDisplay(idx);
            }
            else
            {
                /* if no more question, set only total grade to visible */
                questionPanel.setVisible(false);
                /* change console text to JLabel format */
                String quizStr = "<html>" + quiz.toString().replace("\n", "<br>") + "</html>";
                gradeQuiz.setText(quizStr);
                gradeQuiz.setVisible(true);

            }


        }
    }

}
