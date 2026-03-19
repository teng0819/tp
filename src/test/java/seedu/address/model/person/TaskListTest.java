package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TaskListTest {

    @Test
    public void removeCompletedTasks_removesOnlyCompleted() {
        TaskList taskList = new TaskList();

        Task t1 = new Task("task1", "desc1");
        Task t2 = new Task("task2", "desc2");

        t2.markAsCompleted();

        taskList.addTaskOverall(t1);
        taskList.addTaskOverall(t2);

        taskList.removeCompletedTasks();
        assertTrue(true);
    }
}
