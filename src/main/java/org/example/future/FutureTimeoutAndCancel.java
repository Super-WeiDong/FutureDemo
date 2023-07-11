package org.example.future;

import java.util.concurrent.*;

public class FutureTimeoutAndCancel {
    public static void main(String[] args) {
        //thread pool with single thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(() -> {
            Thread.sleep(4000);
            return "Hello, Future!";
        });

        // If timeout is 2, throw timeout exception, print "Task is canceled", print "can not get res within 2 seconds"
        // If timeout is 5, print Hello, Future!"
        try {
            //throw timeout exception if exceeds 2 seconds
            String res = future.get(2, TimeUnit.SECONDS);
            System.out.println(res);
        } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e) {
            // boolean param specifies whether the running thread executing the task should be interrupted or not.
            boolean isCancelled = future.cancel(true);
            if(isCancelled){
                System.out.println("Task is canceled");
            }
            System.out.println("can not get res within 2 seconds");
        }

    }
}
