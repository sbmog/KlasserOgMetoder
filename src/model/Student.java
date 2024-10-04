package model;

public class Student {
    private String name;
    private boolean active;
    private int[] grades;

    private char[] multipleChoice = new char[10];
    private char[] choices = {'A', 'B', 'C', 'D'};
    private char[] correctAnswersInTheMultipleChoice = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};

    //    konstrukteren, hvor navn, aktivitet og karekter skal defineres ved oprettelse af objekt
    public Student(String name, boolean active, int[] grades) {
        this.name = name;
        this.active = active;
        this.grades = grades;
    }

    //    metode, der giver antal korrekte svar i multiplechoice
    public int correctAnswers(char[] correct) {
        int correctAnswers = 0;
//        for loop, der sammenligner svaret med det korrekte facit
        for (int index = 0; index < multipleChoice.length; index++) {
            if (multipleChoice[index] == correct[index]) {
//                tælleren går 1 op, ved rigtigt svar
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    //    vilkårligt generet svar til multiple choice
    public char[] getMultipleChoice() {
        for (int index = 0; index < multipleChoice.length; index++) {
            multipleChoice[index] = choices[(int) (Math.random() * 4)];
        }
        return multipleChoice;
    }

    //    definere hvordan et objekt af Student klassen vil blive vist i konsolen
    public String toString() {
        return name;
    }

    //    metode, der giver den højste karekter
    public int highestGrade() {
        int max = grades[0];
//        foreach loop, der sammenligner karektererne
        for (int grade : grades) {
            if (grade > max) {
//                hvis betingelsen er opfyldt, vil max blive sat til det element i arrayet der tjekkes
                max = grade;
            }
        }
        return max;
    }

    //    metode, der udregner gennemsnitskarekter
    public double averageGrade() {
        double sum = 0;
//        foreach loop, til at ligge karekterene sammen
        for (int grade : grades) {
            sum += grade;
        }
//        i returværdien udregnes selve gennemsnittet
        return sum / grades.length;
    }

    //    aktuelle get og set metoder
    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public char[] getCorrectAnswersInTheMultipleChoice() {
        return correctAnswersInTheMultipleChoice;
    }


}
