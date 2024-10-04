package test;

import model.Student;
import model.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App3a {
//    Arrayliste som en feltvariabel
//    Feltvariabler, så de kan bruges i hele klassen
    public static ArrayList<Team> teams = new ArrayList<>();
    public static Scanner input = new Scanner(System.in); //scanner til hele klassen
    public static int index = 0;

    public static void main(String[] args) {

        System.out.println("Vil du oprette et team? (ja/nej)");
        String answers = input.next();
//        While loop, der kører så længe betingelsen (At svaret ikke er "nej") er opfyldt
        while (!answers.equals("nej")) {
//            kald på metoden createTeam, for at oprette et team
            createTeam();
//            kald på metoden createStudent, for at oprette de studerende til teamet
            createStudent();

//            print de aktive studerende ved at kalde på team klassen og metoden returnArrayOfActiveStudents derfra
            System.out.println("De aktive studerende er: " + Arrays.toString(teams.get(index).returnArrayOfActiveStudents()));

//            Svares der ja herunder vil while loopet kører igen. Ellers vil vi fortsætte ud
            System.out.println("Vil du oprette et team? (ja/nej");
            answers = input.next();

//            tælleren index går 1 op, for at vores indeks i Arraylisten bliver opdateret til det næste element i listen
            index++;
        }
//        kald på printTheTeamInformation, for at printe informationerne om teamets studerende
        printTheTeamInformation();
    }


//    metode, til at oprette et team
    public static void createTeam() {
        System.out.println("Hvad skal teamet hedde?");
        String teamName = input.next();

        System.out.println("Hvilket lokale skal teamet være i?");
        String roomName = input.next();

//        selve Team objektet bliver oprettet
        teams.add(new Team(teamName, roomName));
    }

//    metode, til at oprette de studerende
    public static void createStudent() {
        System.out.println("Hvor mange studerende skal der oprettes i teamet?");
        int numberOfStudentsOnTheTeam = input.nextInt();

//        forloop pr. studerende, som bliver defineret udfra lænlgden angivet før
        for (int studentsIndex = 0; studentsIndex < numberOfStudentsOnTheTeam; studentsIndex++) {
            System.out.println("Navn på den studernede:");
            String studentName = input.next();

            System.out.println("Er den studerende aktiv?(ja/nej)");
            boolean activeStudent = true;
            if (input.next().equals("nej")) {
                activeStudent = false;
            }

            System.out.println("Hvor mange karekter har den studerende fået?");
            int numberOfGradesGiven = input.nextInt();

//            der oprettes et tomt array til at kunne definere den studerendes karekter
            int[] gradesOfStudent = new int[numberOfGradesGiven];

            System.out.println("Den studerendes karekter, adskilt med mellemrum:");
//            forloop, til at definere arrayets elementer
            for (int gradesIndex = 0; gradesIndex < numberOfGradesGiven; gradesIndex++) {
                gradesOfStudent[gradesIndex] = input.nextInt();
            }

//            Selve Student objektet bliver oprettet
            Student student = new Student(studentName, activeStudent, gradesOfStudent);
//            Den studerende bliver tilføjet til teamet
            teams.get(index).addStudent(student);
        }
    }

//    metode, der printer teamets informationer til konsollen
    public static void printTheTeamInformation() {
//        foreach loop, der løber alle teams igennem i Arraylisten
        for (Team team : teams) {
//            kald på getName metoden i Team klassen
            System.out.println("Alle de studerende på: " + team.getName());
//            kals på printTheInformationAboutTheStudents metoden i Team klassen
            team.printTheInformationAboutTheStudents();
        }
    }
}
