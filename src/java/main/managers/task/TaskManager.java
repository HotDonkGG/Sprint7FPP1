package java.main.managers.task;

import java.main.model.Epic;
import java.main.model.SubTask;
import java.main.model.Task;
import java.main.model.TaskStatus;

import java.util.List;

public interface TaskManager {

    List<Epic> getAllEpic();

    void clearEpic();

    Epic getEpicById(Integer id);

    Epic addEpic(Epic epic);

    void updateEpic(Epic epic);

    Epic removeEpicById(Integer id);

    List<SubTask> getAllSubTask();

    void clearSubtask();

    SubTask getSubTaskById(Integer id);

    SubTask addSubTask(SubTask subTask);

    SubTask removeSubTaskById(Integer id);

    SubTask updateSubTask(SubTask subTask);

    List<Task> getAllTask();

    void clearTask();

    Task getTaskById(Integer id);

    void updateStatusEpic(Epic epic, TaskStatus taskStatus);

    Task addTask(Task task);

    Task removeTaskById(Integer id);

    void updateTask(Task task);

    List<SubTask> getAllSubtaskByEpic(Epic epic);
}