import java.util.*;

class Main {
  public static void main(String[] args) {
    var quiz = new Quiz();

    quiz.addQuestion("alabama", "montgomery");
    quiz.addQuestion("alaska", "juneau");
    quiz.addQuestion("arizona", "phoenix");
    quiz.addQuestion("arkansas", "little rock");
    quiz.addQuestion("california", "sacramento");
    quiz.addQuestion("colorado", "denver");
    quiz.addQuestion("connecticut", "hartford");
    quiz.addQuestion("delaware", "dover");
    quiz.addQuestion("florida", "tallahassee");
    quiz.addQuestion("georgia", "atlanta");

    quiz.runQuiz();
  }
}

class Question {
  // Keep track of the question and answer text, as
  // well as the response from the user

  String prompt;
  String answer;
  String response;

  // Share one scanner instance between all Questions
  static Scanner scanner = new Scanner(System.in);

  Question(String prompt, String answer) {
    this.prompt = prompt;
    this.answer = answer;
  }

  void ask() {
    // Display the question text, get and store the user response
    System.out.println(prompt);

    // Prompt the user to enter a response and return
    // the resulting string
    System.out.print("> ");
    response = scanner.nextLine();
  }

  boolean isCorrect() {
    // Check if the response is correct
    return response.equals(answer);
  }

  public String toString() {
    // Display the question text, the user response,
    // the status (Correct or Incorrect), and the answer if
    // the response is incorrect

    var status = isCorrect() ? "CORRECT" : "INCORRECT";
    var result = "";

    result += "Question: " + prompt + "\n";
    result += "Response: " + response + "\n";
    result += "Answer:   " + answer + "\n";
    result += "Status:   " + status + "\n";

    return result;
  }
}

// Quiz keep track of a list of questions and handles
// handles asking the questions sequentially

class Quiz {
  List<Question> questions = new ArrayList<>();

  void addQuestion(String prompt, String answer) {
    // Add a new question to the quiz for
    // the given question and answer pair
    questions.add(new Question(prompt, answer));
  }

  void runQuiz() {
    // Have the user respond to each question, then
    // print out the results for each question and
    // calculate the number of correct responses

    var score = 0;
    var total = questions.size();

    for (var question : questions) {
      // Ask each question and update the score

      question.ask();
      score += question.isCorrect() ? 1 : 0;

      // Clear the console
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }

    for (var question : questions) {
      // Show the results for each question and submission

      System.out.println(question);
    }

    System.out.println("Score: " + score + " of " + total);
  }
}
