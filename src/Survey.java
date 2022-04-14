import java.util.ArrayList;
import java.util.Scanner;

public class Survey {
    public static void main(String[] args) {

        /**
         COMPLETE THIS CLASS AFTER ALL OTHER CLASSES ARE COMPLETED
         */

        /*
        Write a program that will get information from 3 participants and
        -Print information for each participant
        -Print how many participants were male
        -Print how many participants were female
        -Print the age of the youngest person
        -Print the age of the eldest person
         */


        //Global variables or objects needed
        Scanner userInput = new Scanner(System.in);
        ArrayList<Participant> participants = new ArrayList<>();
        int youngest = Integer.MAX_VALUE;
        int eldest = 0;




        do {

            System.out.println(SurveyQuestions.askToJoin);
            String join = userInput.next();

            if(join.toUpperCase().startsWith("Y")){

                //ask your questions to get name, age, and gender

                Participant.addParticipants();

                System.out.println(SurveyQuestions.askName);
                String name = userInput.next();

                System.out.println(SurveyQuestions.askAge);
                int age = userInput.nextInt();

                System.out.println(SurveyQuestions.askGender);
                String gender = userInput.next();

                Participant participant = new Participant(name, age, gender);
                participants.add(participant);




                if(gender.toUpperCase().startsWith("M")) Participant.addMaleParticipants();
                else Participant.addFemaleParticipants();


            }



        }while(Participant.totalNumberOfParticipants < 3);


        for (Participant element : participants) {
            System.out.println(element);
            if(element.age > eldest) eldest = element.age;
            if(element.age < youngest) youngest = element.age;

        }

        System.out.println("The total number of male participants = " + Participant.totalNumberOfMaleParticipants);
        System.out.println("The total number of female participants = " + Participant.totalNumberOfFemaleParticipants);


        System.out.println("The youngest age of the participants = " + youngest);
        System.out.println("The oldest age of the participants = " + eldest);




    }
}
