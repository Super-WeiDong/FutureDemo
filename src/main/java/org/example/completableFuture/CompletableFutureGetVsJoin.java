package org.example.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureGetVsJoin {
    public static void main(String[] args) {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(
                () -> 7
        );

        //get
        try {
            Integer res = completableFuture.get();
            System.out.println(res);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }

        // join, no need to perform error handling
        // we can get result twice from a single completableFuture
        Integer res = completableFuture.join();
        System.out.println(res);
    }
}
