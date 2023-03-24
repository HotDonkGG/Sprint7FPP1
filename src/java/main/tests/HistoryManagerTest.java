package java.main.tests;

import java.main.managers.Managers;
import java.main.model.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.main.managers.history.HistoryManager;
import java.main.model.Task;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public abstract class HistoryManagerTest<T extends HistoryManager> {

    private final List<Task> emptyList = new ArrayList<>();
    private HistoryManager manager;

    @BeforeEach
    public void loadInitialConditions() {

        manager = Managers.getHistoryManager();

    }

    @Test
    public void addTasksToHistoryTest() {

        var task1 = new Task(1, "Task1", TaskStatus.NEW,
                "Task1", Instant.EPOCH, 0);
        var task2 = new Task(2, "Task2", TaskStatus.NEW,
                "Task2", Instant.EPOCH, 0);
        var task3 = new Task(3, "Task3", TaskStatus.NEW,
                "Task3", Instant.EPOCH, 0);

        manager.addHistory(task1);
        manager.addHistory(task2);
        manager.addHistory(task3);

        assertEquals(List.of(task1, task2, task3), manager.getHistory());

    }


    @Test
    public void removeTask() {

        var task1 = new Task(1, "Task1", TaskStatus.NEW,
                "Task1", Instant.EPOCH, 0);
        var task2 = new Task(2, "Task2", TaskStatus.NEW,
                "Task2", Instant.EPOCH, 0);
        var task3 = new Task(3, "Task3", TaskStatus.NEW,
                "Task3", Instant.EPOCH, 0);

        manager.addHistory(task1);
        manager.addHistory(task2);
        manager.addHistory(task3);

        manager.remove(task2.getId());

        assertEquals(List.of(task1, task3), manager.getHistory());

    }

    @Test
    public void noDuplicatesTest() {

        var task1 = new Task(1, "Task1", TaskStatus.NEW,
                "Task1", Instant.EPOCH, 0);
        var task2 = new Task(2, "Task2", TaskStatus.NEW,
                "Task2", Instant.EPOCH, 0);
        var task3 = new Task(3, "Task3", TaskStatus.NEW,
                "Task3", Instant.EPOCH, 0);

        manager.addHistory(task1);
        manager.addHistory(task2);
        manager.addHistory(task3);
        manager.addHistory(task1);
        manager.addHistory(task2);
        manager.addHistory(task3);
        manager.addHistory(task2);
        manager.addHistory(task3);

        assertEquals(List.of(task1, task2, task3), manager.getHistory());

    }

    @Test
    public void noTaskRemoveIfIncorrectIDTest() {

        var task1 = new Task(1, "Task1", TaskStatus.NEW,
                "Task1", Instant.EPOCH, 0);
        var task2 = new Task(2, "Task2", TaskStatus.NEW,
                "Task2", Instant.EPOCH, 0);
        var task3 = new Task(3, "Task3", TaskStatus.NEW,
                "Task3", Instant.EPOCH, 0);

        manager.addHistory(task1);
        manager.addHistory(task2);
        manager.addHistory(task3);

        manager.remove(42);
        manager.remove(17);
        manager.remove(9);

        assertEquals(List.of(task1, task2, task3), manager.getHistory());

    }
}
