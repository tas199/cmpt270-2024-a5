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


public class QuizFrame extends JFrame {
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
    private int i;

    public QuizFrame() {
        this.reader = new QuizFileReader();
        this.quizDisplay = new ArrayList<>();
        this.scoreCollect = new QuizMain();
        String filepath;
        String question;
        String[] choice;
        int answer;
        this.i = 0;
        String finalScore;

        quizPanel = new JPanel();

        this.setTitle("Quiz - Avatar: The Last Airbender");
        this.setSize(500, 350);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        filepath = "Assignment5/src/input.txt";
        try {
            quizDisplay = reader.readQuiz(filepath);

        } catch (FileNotFoundException e) {
            System.out.println("The file not found");
        }

        GridLayout layout = new GridLayout(8, 2);
        this.quizPanel.setSize(500, 700);
        layout.setHgap(10);
        this.quizPanel.setLayout(layout);
        this.quizPanel.setBorder(new EmptyBorder(20, 20, 20, 20));


        question = quizDisplay.get(i).getQuestion();
        choice = quizDisplay.get(i).getChoice();
        answer = quizDisplay.get(i).getAnswer();
        finalScore = scoreCollect.toString();


        this.questionNumber = new JLabel();
        this.questionText = new JLabel();
        this.choiceButton1 = new JButton();
        this.choiceButton2 = new JButton();
        this.choiceButton3 = new JButton();
        this.choiceButton4 = new JButton();
        this.gradeQuiz = new JLabel();

        choiceButton1.addActionListener(new ChoiceBottonListener(1));
        choiceButton2.addActionListener(new ChoiceBottonListener(2));
        choiceButton3.addActionListener(new ChoiceBottonListener(3));
        choiceButton4.addActionListener(new ChoiceBottonListener(4));




        this.quizPanel.add(this.questionNumber);
        this.quizPanel.add(this.questionText);
        this.quizPanel.add(this.choiceButton1);
        this.quizPanel.add(this.choiceButton2);
        this.quizPanel.add(this.choiceButton3);
        this.quizPanel.add(this.choiceButton4);
        this.quizPanel.add(this.gradeQuiz);





        this.setContentPane(this.quizPanel);


        this.setResizable(false);
        if(!quizDisplay.isEmpty()) {
            QuizQuestion q = quizDisplay.get(i);
            updateDisplay(q);
        }


        this.setVisible(true);




    }

    private void updateDisplay(QuizQuestion q)
    {
        String question;
        String[] choice;
        int answer;
        question = this.quizDisplay.get(i).getQuestion();
        choice = quizDisplay.get(i).getChoice();
        answer = quizDisplay.get(i).getAnswer();

        this.questionNumber.setText("Question #" + (this.i+1) + ":");
        this.questionText.setText(question);
        this.choiceButton1.setText(choice[0]);
        this.choiceButton2.setText(choice[1]);
        this.choiceButton3.setText(choice[2]);
        this.choiceButton4.setText(choice[3]);

        gradeQuiz.setText("");

    }



    private class ChoiceBottonListener implements ActionListener
    {
        private final int choiceIdx;

        public ChoiceBottonListener(int idx)
        {
            this.choiceIdx = idx;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String question;
            String[] choice;
            int answer;
            question = quizDisplay.get(i).getQuestion();
            choice = quizDisplay.get(i).getChoice();
            answer = quizDisplay.get(i).getAnswer();
            scoreCollect.addQuestion(question, choice, answer, choiceIdx);
            i++;
            if (i < quizDisplay.size())
            {
                updateDisplay(quizDisplay.get(i));

            }
            else
            {
                float finalScorePercent = (float) scoreCollect.getScore() / scoreCollect.getQuizTotal();
                gradeQuiz.setText("Total Score "+ scoreCollect.getScore() + "/" + scoreCollect.getQuizTotal() +
                        " (" + finalScorePercent + "%)");
            }


        }
    }

    public static void main(String[] args)
    {
        QuizFrame frame = new QuizFrame();

    }


}
/*
        this.choiceButton1.addActionListener(this.scoreCollect.addQuestion(question, choice, answer, 1));
        this.choiceButton2.addActionListener(this.scoreCollect.addQuestion(question, choice, answer, 2));
        this.choiceButton3.addActionListener(this.scoreCollect.addQuestion(question, choice, answer, 3));
        this.choiceButton4.addActionListener(this.scoreCollect.addQuestion(question, choice, answer, 4));
*/