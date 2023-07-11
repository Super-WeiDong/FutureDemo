package org.example.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureBasic {
    public static void main(String[] args) {
        // supplier
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(
                ()-> 7
        );

        // functional interface -> run directly
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(
                () -> System.out.println("Hello")
        );

        // return 7
        try{
            Integer res = completableFuture1.get();
            System.out.println(res);
        }catch(InterruptedException | ExecutionException e){
            System.out.println(e.getMessage());
        }
    }
}
