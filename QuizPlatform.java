import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);

            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());

            List<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == currentQuestion.getCorrectOptionIndex() + 1) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " +
                        (currentQuestion.getCorrectOptionIndex() + 1) + "\n");
            }
        }

        System.out.println("Quiz completed. Your score: " + score + "/" + questions.size());
    }
}

public class QuizPlatform {
    public static void main(String[] args) {
        
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                List.of("Berlin", "Paris", "Madrid", "Rome"), 1));
        questions.add(new Question("Which planet is known as the Red Planet?",
                List.of("Earth", "Mars", "Venus", "Jupiter"), 2));
        questions.add(new Question("What is the largest mammal?",
                List.of("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"), 2));

        Quiz quiz = new Quiz(questions);

        quiz.start();
    }
}
