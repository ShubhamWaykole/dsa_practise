import java.util.concurrent.*;

// Class 1
// Helper Class implementing runnable interface Callable
class Task implements Runnable {
    // Member variable of this class
    private String message;

    // Constructor of this class
    public Task(String message)
    {
        // This keyword refers to current instance itself
        this.message = message;
    }

    // Method of this Class
    public void run()
    {
        try {
            Thread.sleep(1000);
            System.out.println("EEEEEEEEEEEEEEEEEE");
            //  return "Hiiii " + message + "!";
        }
        catch(Exception e){}
    }
}
// Class 2
// Main Class
// ExecutorExample
public class ExecutorExample {

    // Main driver method
    public static void main(String[] args)
    {

        // Creating an object of above class
        // in the main() method
        Task task = new Task("GeeksForGeeks");

        // Creating object of ExecutorService class and
        // Future object Class
        ExecutorService executorService
                = Executors.newFixedThreadPool(4);
        System.out.println("Submission time " + System.currentTimeMillis());
        CompletableFuture result = CompletableFuture.runAsync(task, executorService);
      //  CompletableFuture<String> comFut = CompletableFuture.supplyAsync(() -> executorService.submit(task));

        // Try block to check for exceptions
        try {
           // System.out.println(result.get());
            System.out.println("Before calling complete " + System.currentTimeMillis());
            result.complete("Completed");
            System.out.println("written after get");
            System.out.println("After calling complete " + System.currentTimeMillis());
        }

        // Catch block to handle the exception
        catch (Exception e) {

            // Display message only
            System.out.println(
                    "Error occurred while executing the submitted task");

            // Print the line number where exception occurred
            e.printStackTrace();}

        // Cleaning resource and shutting down JVM by
        // saving JVM state using shutdown() method
        executorService.shutdown();
    }
}