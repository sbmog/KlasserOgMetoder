package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Team {
    private String name;
    private String room;

    ArrayList<Student> studentList = new ArrayList<>();

    //    Konstrukteren, hvor navn og rum skal defineres ved oprettelse af objekt
    public Team(String name, String room) {
        this.name = name;
        this.room = room;
    }

//    metode, der printer teamets samlede antal korrekte svar
    public void printAmountOfCorrectAnswersOnTeam() {
        int[] correctAnswers = new int[10]; //tomt array
//        for loop, der løber student listen igennem
        for (Student student : studentList) {
//            for loop, der løber igennem om den studerende, vi tjekker, har svaret korrekt
            for (int index = 0; index < correctAnswers.length; index++) {
//                if sætning, der sammenligner, om man har svaret rigtigt i betingelsen
                if (student.getCorrectAnswersInTheMultipleChoice()[index]==student.getMultipleChoice()[index]){
                    correctAnswers[index]++; //tæller, så frem betingelsen er opfyldt
                }
            }
        }
//        print selve arrayet
        System.out.println(Arrays.toString(correctAnswers));
    }

    //    array, der returnere de studerendes navn,gennemsnitskarekter og rigtige svar
    public String[] printTheInformationAboutTheStudents() {
        String[] theStudentsInformation = new String[studentList.size()]; //opret tomt array
//        forloop til at tildele hver element i arrayet en værdi
        for (int index = 0; index < studentList.size(); index++) {
            String name = studentList.get(index).getName();
            double averageGrade = studentList.get(index).averageGrade();
            studentList.get(index).getMultipleChoice();
            int correctAnswers = studentList.get(index).correctAnswers(studentList.get(index).getCorrectAnswersInTheMultipleChoice());
//            gem variablerne ovenover i selve arrayelementet. formatteres ved String.format, så opstillingen bliver pæn
            theStudentsInformation[index] = String.format("%-10s %-20.2f %-15d", name, averageGrade, correctAnswers);
        }
//        print overskrift til kolonnerne med formatteringen.
        System.out.printf("%-10s %-20s %-15s%n", "Navn", "Gennemsnitskarekter", "Rigtige svar");
//        foreach loop, der laver en printet sætning pr. studerende
        for (String studentInfo : theStudentsInformation) {
            System.out.printf("%s%n", studentInfo);
        }
        return theStudentsInformation;
    }

    //    array over korrekte svar på multiplechoice testen fra Student klassen
    public String[] teamsCorrectAnswers() {
        String[] correctAnswersList = new String[studentList.size()]; //opret tomt array
//        forloop, til at tildele hver element i array en værdi
        for (int index = 0; index < studentList.size(); index++) {
            studentList.get(index).getMultipleChoice(); //den studerendes individuelle svar
//            svaret sammenlignes nu med facit og gemmes i en variabel
            int correctAnswers = studentList.get(index).correctAnswers(studentList.get(index).getCorrectAnswersInTheMultipleChoice());
//            String arrayet får nu tildelt en sætning for elementet.
            correctAnswersList[index] = studentList.get(index).getName() + " har " + correctAnswers + " korrekte svar";
        }
        return correctAnswersList;
    }

    //    lav et array over de studerende, som har et karektergennemsnit, der er højere end teamets samlede karektergennemsnit
    public Student[] highScoreStudents(double minAverage) {
        ArrayList<Student> highScoreStudents = new ArrayList<>(); //tom arraylist
//        forloop, til at tildele hver element i array en værdi
        for (Student student : studentList) {
//            if sætning, der sammenliger karektergennemsnit
            if (student.averageGrade() >= averageGradeOfTheTeam()) {
                highScoreStudents.add(student); //tilføjes, hvis betingelse er opfyldt
            }
        }
//        Arraylisten laves nu om til et array
        Student[] listOfHighScoreStudents = new Student[highScoreStudents.size()];
        highScoreStudents.toArray(listOfHighScoreStudents);
        return listOfHighScoreStudents;
    }

    //    metode, der giver gennemsnitskarekteren for hele teamet
    public double averageGradeOfTheTeam() {
        double sumOfTheStudentsAverageGrades = 0;
//        foreach loop, der tjekker alle de studerende på studenlist
        for (Student student : studentList) {
//            læg de studerendes karektergennemsnit sammen
            sumOfTheStudentsAverageGrades += student.averageGrade();
        }
//        udregn gennemsnittet i returværdien
        return sumOfTheStudentsAverageGrades / studentList.size();
    }

    //    tilføj en studerende til team
    public void addStudent(Student student) {
        studentList.add(student);
    }

    //    fjern en studerende fra team
    public void removeStudent(Student name) {
        studentList.remove(name);
    }

    //    lav et array over aktive studerende
    public Student[] returnArrayOfActiveStudents() {
        ArrayList<Student> activeStudent = new ArrayList<>(); //tom Arraylist
//        foreach loop, der tjekker om de studerende er aktive
        for (Student student : studentList) {
            if (student.isActive()) {
//                hvis betingelsen bliver opfyldt, tilføj til listen
                activeStudent.add(student);
            }
        }
//        Arraylisten laves til et array
        Student[] listOfActiveStudents = new Student[activeStudent.size()];
        activeStudent.toArray(listOfActiveStudents);
        return listOfActiveStudents;
    }


    //    Aktuelle get og set metoder
    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
}
