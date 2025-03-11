class Question {
  String prompt;
  String answer;
  String response;

  Question(String prompt, String answer);

  void ask();

  boolean isCorrect();

  public String toString();
}

class Quiz {
  List<Question> questions;

  void addQuestion(String prompt, String answer);

  void runQuiz();
}
