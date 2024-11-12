package fi.utu.tech.assignment4;

import java.util.ArrayList;
import java.util.List;

// Käytetään tehtässä 1 muokattua GradingTask-oliota
import fi.utu.tech.common.GradingTask;
// Allokointifunktiot implementoidaan TaskAllocator-luokassa
import fi.utu.tech.common.TaskAllocator;

import fi.utu.tech.common.Submission;
import fi.utu.tech.common.SubmissionGenerator;
import fi.utu.tech.common.SubmissionGenerator.Strategy;


public class App4 {
    public static void main( String[] args )
    {
        // Otetaan funktion aloitusaika talteen suoritusajan laskemista varten
        long startTime = System.currentTimeMillis();

        // Generoidaan kasa esimerkkitehtäväpalautuksia
        List<Submission> ungradedSubmissions = SubmissionGenerator.generateSubmissions(21, 200, Strategy.STATIC);

        // Tulostetaan tiedot esimerkkipalautuksista ennen arviointia
        for (var ug : ungradedSubmissions) {
            System.out.println(ug);
        }
        
        //Allokoidaan palautukset
        List<GradingTask> gradingTasks = TaskAllocator.sloppyAllocator(ungradedSubmissions);

        //Lista säikeistä
        List<Thread> gradingThreads = new ArrayList<>();

        //Käynistetään säikeet
        for (GradingTask gradingTask : gradingTasks) {
            Thread gradingThread = new Thread(gradingTask);
            gradingThreads.add(gradingThread);
            gradingThread.start();
        }

        //Odotetaan, että kaikki säikeet ovat valmiita
        for (Thread gradingThread : gradingThreads) {
            try {
                gradingThread.join();
            } catch (InterruptedException e) {
                System.err.println("error");
            }
        }

        // Tulostetaan arvioidut palautukset
        System.out.println("------------ CUT HERE ------------");
        for (GradingTask gradingTask : gradingTasks) {
            for (var gs : gradingTask.getGradedSubmissions()) {
                System.out.println(gs);
            }
        }

        // Lasketaan funktion suoritusaika
        System.out.printf("Total time for grading: %d ms%n", System.currentTimeMillis()-startTime);
    }
}
