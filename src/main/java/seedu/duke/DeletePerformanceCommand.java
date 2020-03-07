package seedu.duke;

import java.util.List;

public class DeletePerformanceCommand extends Command {
    public DeletePerformanceCommand() {
    }

    /**
     * Delete the performance that was input by the user.
     *
     * @param performance The performance to be deleted
     *                    from the performance list.
     */
    public static List<Performance> execute(List<Performance> performances, Performance performance) {
        System.out.println(performances);
        for (Performance p: performances) {
            if (p != null &&
                    performance.getAssignment().equals(p.getAssignment()) &&
                    performance.getModule().equals(p.getModule()) &&
                    performance.getStudent().equals(p.getStudent())) {
                performances.remove(p);
                System.out.println("deleted successfully");
                return performances;
            }
        }
        System.out.println("delete fail");
        return performances;
    }
}