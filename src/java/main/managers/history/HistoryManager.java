package java.main.managers.history;

import java.main.model.Task;

import java.util.List;

public interface HistoryManager {

    List<Task> getHistory();

    void addHistory(Task task);

    void remove(int id);
}