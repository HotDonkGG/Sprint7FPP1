package java.main.tests;

import java.main.managers.task.InMemoryTaskManager;
import org.junit.jupiter.api.BeforeEach;

public class InMemoryTaskManagerTest extends TaskManagerTest{

    @BeforeEach
    public void init(){
        manager = new  InMemoryTaskManager();
    }
}

