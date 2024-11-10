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


import Quiz.Question;
import Quiz.QuizFileReader;
import Quiz.Quiz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import java.io.FileNotFoundException;


public class QuizFrame extends JFrame
{
    private Quiz quiz;
    private int idx;
    private JPanel quizPanel;

    private JLabel questionNumber;
    private JLabel questionText;

    private JButton choiceButton1;
    private JButton choiceButton2;
    private JButton choiceButton3;
    private JButton choiceButton4;

    private JLabel gradeQuiz;

    public QuizFrame() {
        QuizFileReader reader = new QuizFileReader();
        this.quiz = new Quiz();
        String filepath;

        this.setTitle("Quiz - Avatar: The Last Airbender");
        this.setSize(500, 350);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        filepath = "Assignment5/src/input.txt";
        try {
            this.quiz = reader.readQuiz(filepath);

        } catch (FileNotFoundException e) {
            System.out.println("The file not found");
        }

        this.quizPanel = new JPanel();
        this.quizPanel.setSize(500, 700);
        GridLayout layout = new GridLayout(7,1);
        layout.setHgap(10);
        this.quizPanel.setLayout(layout);
        this.quizPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        this.questionNumber = new JLabel();
        this.questionText = new JLabel();
        this.choiceButton1 = new JButton();
        this.choiceButton2 = new JButton();
        this.choiceButton3 = new JButton();
        this.choiceButton4 = new JButton();

        this.gradeQuiz = new JLabel();
        this.gradeQuiz.setVisible(false);

        choiceButton1.addActionListener(new ChoiceButtonListener(1));
        choiceButton2.addActionListener(new ChoiceButtonListener(2));
        choiceButton3.addActionListener(new ChoiceButtonListener(3));
        choiceButton4.addActionListener(new ChoiceButtonListener(4));




        this.quizPanel.add(this.questionNumber);
        this.quizPanel.add(this.questionText);
        this.quizPanel.add(this.choiceButton1);
        this.quizPanel.add(this.choiceButton2);
        this.quizPanel.add(this.choiceButton3);
        this.quizPanel.add(this.choiceButton4);
        this.quizPanel.add(this.gradeQuiz);

        this.setContentPane(this.quizPanel);
        this.setResizable(false);

        this.idx = 0;
        Question q = this.quiz.getQuestion(this.idx);
        quizDisplay(q);



        this.setVisible(true);




    }

    private void quizDisplay(Question q)
    {
        String question;
        String[] choice;
        int answer;
        question = q.getQuestion();
        choice = q.getChoice();

        this.questionNumber.setText("Question #" + (this.idx+1) + ":");
        this.questionText.setText(question);
        this.choiceButton1.setText(choice[0]);
        this.choiceButton2.setText(choice[1]);
        this.choiceButton3.setText(choice[2]);
        this.choiceButton4.setText(choice[3]);

        gradeQuiz.setVisible(false);

    }



    private class ChoiceButtonListener implements ActionListener
    {
        private final int userAnswer;

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
                quizDisplay(quiz.getQuestion(idx));
            }
            else
            {
                questionNumber.setVisible(false);
                questionText.setVisible(false);
                choiceButton1.setVisible(false);
                choiceButton2.setVisible(false);
                choiceButton3.setVisible(false);
                choiceButton4.setVisible(false);

                String quizStr = "<html>" + quiz.toString().replace("\n", "<br>") + "</html>";
                gradeQuiz.setText(quizStr);
                gradeQuiz.setVisible(true);




            }


        }
    }

    public static void main(String[] args)
    {
        QuizFrame frame = new QuizFrame();

    }


}
