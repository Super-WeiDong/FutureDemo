package org.example.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureChaining {
    public static void main(String[] args) {
        // If it is Void, don't need to use a variable to hold Future, it will run

        // supplier + thenApply((A)->{B}) + thenAccept((A)->{}) + thenRun(()->{})
        CompletableFuture.supplyAsync(()-> 7)
        .thenApply((num)->num+1)
        .thenAccept((num)-> System.out.println(num))
        .thenRun(()->{
            System.out.println("End of the chaining");
        });

        System.out.println("----------------------------------------------");

        // we can chain after runAsync
        // but if we chain thenRun or thenAccept we get null from previous operation
        CompletableFuture.runAsync(() -> System.out.println("Hello"))
                .thenRun(() -> System.out.println("Chaining"))
                .thenAccept((v)-> {System.out.println(v);});
    }
}
