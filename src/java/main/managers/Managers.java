package java.main.managers;

import java.main.managers.history.InMemoryHistoryManager;
import java.main.managers.task.FileBackedTasksManager;
import java.main.managers.history.HistoryManager;

public class Managers {

    public static HistoryManager getHistoryManager(){
        return  new InMemoryHistoryManager();
    }
    public static FileBackedTasksManager getFileBackendManager(){
        return new FileBackedTasksManager();
    }
}
