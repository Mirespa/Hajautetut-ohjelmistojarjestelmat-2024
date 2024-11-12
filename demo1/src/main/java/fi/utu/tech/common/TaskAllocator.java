package fi.utu.tech.common;

import java.util.ArrayList;
import java.util.List;

/**
 * You need to modify this file
 */


public class TaskAllocator {

    /**
     * Allocator that creates list of two (2) GradingTask objects with each having half of the given submissions
     * @param submissions The submissions to be allocated
     * @return The two GradingTask objects in a list, each having half of the submissions
     */
    public static List<GradingTask> sloppyAllocator(List<Submission> submissions) {
        List<GradingTask> tasks = new ArrayList<>();
        
        List<Submission> firstHalf = submissions.subList(0, submissions.size() / 2);
        List<Submission> secondtHalf = submissions.subList(submissions.size() / 2, submissions.size());
        
        tasks.add(new GradingTask(firstHalf));
        tasks.add(new GradingTask(secondtHalf));
        
        return tasks;
    }


    
    /**
     * Allocate List of ungraded submissions to tasks
     * @param submissions List of submissions to be graded
     * @param taskCount Amount of tasks to be generated out of the given submissions
     * @return List of GradingTasks allocated with some amount of submissions (depends on the implementation)
     */
    public static List<GradingTask> allocate(List<Submission> submissions, int taskCount) {
        List<GradingTask> tasks = new ArrayList<>();

        //Luodaan gradingTask oliot
        for (int i = 0; i < taskCount; i++) {
            tasks.add(new GradingTask(new ArrayList<>()));
        }

        //Jaetaan palautukset olioille
        for (int i = 0; i < submissions.size(); i++) {
            tasks.get(i % taskCount).getUngradedSubmissions().add(submissions.get(i));
        }

        return tasks;
    }
}
