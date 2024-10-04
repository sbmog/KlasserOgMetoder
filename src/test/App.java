package test;

import model.Student;
import model.Team;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {
//        Opret 2 objekter af klassen Team
        Team team1 = new Team("programmering 1", "SH-A1.28");
        Team team2 = new Team("systemudvikling 1", "SH-A1.28");

//        Opret 6 objekter af klassen Student
        Student student1 = new Student("Sidse", true, new int[]{12, 12, 12});
        Student student2 = new Student("Victor", true, new int[]{12, 12, 10});
        Student student3 = new Student("Sammi", true, new int[]{12, 10, 12});
        Student student4 = new Student("Sara", true, new int[]{10, 10, 12});
        Student student5 = new Student("Maja", true, new int[]{12, 10, 10});
        Student student6 = new Student("Karl", true, new int[]{02, 00, 4});

//        tilføj Student objekterne til Arraylisten i Team objekterne
        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);

        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);

//        Udskriv Arraylisten: studentList til de gældende team
        System.out.println(team1.getName() + " har følgende som studerende: " + team1.getStudentList());
        System.out.println(team2.getName() + " har følgende som studerende: " + team2.getStudentList());

//        Fjern et Student objekt fra Arraylisten i Team Objekt
        team2.removeStudent(student6);

//        Udskriv team2 listen efter fjernelsen
        System.out.println("Efter fjernelsen af " + student6.getName() + " har " + team2.getName() + " følgende som studerende: " + team2.getStudentList());

//        Den fjernede tilføjes igen, for at der er min. 3 Student objekter pr. Team objekt
        team2.addStudent(student6);
        System.out.println(student6.getName() + " er igen tilføjet til " + team2.getName() + ", og derfor har " + team2.getName() + " følgende som studerende: " + team2.getStudentList());

//        Udskriv array med aktive studerende på team metoden
        System.out.println(Arrays.toString(team2.returnArrayOfActiveStudents()));
        System.out.println(); //linjeskift for overblik i konsolen


//        "Højeste karekter" metoden i Student klassen bliver testet og udskrevet i konsolen
        System.out.println(student6.getName() + " højeste karakter er: " + student6.highestGrade());
//        "Karektergennemsnittet for den enkelte studerene" metoden i Student klassen bliver testet og udskrevet i konsolen
        System.out.println(student6.getName() + "s gennemsnitlige karakter er: " + student6.averageGrade());
//        "Karektergennemsnittet for alle studerende på et team(Niveau)" metoden i Team klassen bliver testet og udskrevet i konsolen
        System.out.println(team1.getName() + "s gennemsnitlige karekter for hele teamet er: " + team1.averageGradeOfTheTeam());

//        Udskriv array fra metoden, der angiver de studerende, som har et personligt karektergennemsnit, der er højere en karektergennemsnittet for hele teamet
        System.out.println(Arrays.toString(team1.highScoreStudents(team1.averageGradeOfTheTeam())));
        System.out.println();//linjeskift for overblik i konsolen


//        "Svar på multiple choice" metoden i Student klassen, der giver et array, bliver testet og udskrevet i konsolen
        System.out.println(Arrays.toString(student2.getMultipleChoice()));
//        "Tjek om den studerendes svar er korrekt" metoden i Student klassen bliver testet og udskrevet i konsolen
        System.out.println((student2.correctAnswers(student2.getCorrectAnswersInTheMultipleChoice())));

//        "Tjek om alle de studerende på teamet har svaret korrekt" metoden i Student klassen bliver testet og udskrevet i konsolen
        System.out.println(Arrays.toString(team1.teamsCorrectAnswers()));
        System.out.println(Arrays.toString(team2.teamsCorrectAnswers()));

//        kald på metoden, der printer informationen om de studernede
       team1.printTheInformationAboutTheStudents();

//       Kald metoden der printer antal correcte svar for teamet samlet
       team1.printAmountOfCorrectAnswersOnTeam();
    }
}
