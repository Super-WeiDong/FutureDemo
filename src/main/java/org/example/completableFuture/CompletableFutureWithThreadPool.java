package org.example.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureWithThreadPool {
    public static void main(String[] args) {
        //fixed size thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // supplier
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(
                () -> 7, executorService
        );

        // functional interface -> run directly
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(
                () -> System.out.println("Hello"), executorService
        );

        // return 7
        try {
            Integer res = completableFuture1.get();
            System.out.println(res);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }
}
