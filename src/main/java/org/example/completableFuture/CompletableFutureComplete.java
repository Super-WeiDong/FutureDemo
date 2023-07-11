package org.example.completableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureComplete {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
                () -> {
                    try{
                        Thread.sleep(3000);
                    }catch(Exception e){}
                    return "Task completed";
                }
        );

        // Once task is completed, result can't be override
        // If TIMEOUT is 5000 -> "Task completed"
        // If TIMEOUT is 2000 -> "Task Manually Completed"
        try{
            Thread.sleep(5000);
        }catch(Exception e){}

        // complete the async task and give it a result
        completableFuture.complete("Task Manually Completed");

        System.out.println(completableFuture.join());

    }

}
