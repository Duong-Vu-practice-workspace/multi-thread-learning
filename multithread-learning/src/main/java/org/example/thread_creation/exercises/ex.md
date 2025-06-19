# Thread Creation - MultiExecutor
## Instructions
In this exercise, we are going to implement a  MultiExecutor .

The client of this class will create a list of Runnable tasks and provide that list into MultiExecutor's constructor.

When the client runs the  executeAll(),  the MultiExecutor,  will execute all the given tasks.

To take full advantage of our multicore CPU, we would like the MultiExecutor to execute all the tasks in parallel by passing each task to a different thread.



Please implement the MultiExecutor below

### Test(s)
#### Test 1
```java
import org.junit.Test;
import org.junit.Assert;
import com.udemy.ucp.*;
import java.util.List;
import java.util.Arrays;

public class Evaluate {
IOHelper helper = new IOHelper();

    @Test
    public void testExercise() throws InterruptedException{
        helper.resetStdOut(); // clean stdout
        
        String string1 = "Cutting carrots";
        String string2 = "Cooking eggs";
        String string3 = "Washing dishes";
        
        Runnable task1 = () -> System.out.println(string1);
        Runnable task2 = () -> System.out.println(string2);
        Runnable task3 = () -> System.out.println(string3);
        
        List tasks = Arrays.asList(task1, task2, task3);
        
        MultiExecutor multiExecutor = new MultiExecutor(tasks);
        
        multiExecutor.executeAll();
        
        Thread.sleep(1000);
        
        String output = helper.getOutput();
        
        Assert.assertTrue("The task "+ string1 +" is not executed", output.contains(string1));
        Assert.assertTrue("The task "+ string2 +" is not executed", output.contains(string2));
        Assert.assertTrue("The task "+ string3 +" is not executed", output.contains(string3));
    }
}
```
