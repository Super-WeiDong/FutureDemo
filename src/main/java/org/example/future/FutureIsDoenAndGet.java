package org.example.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class FutureIsDoenAndGet {
    public static void main(String[] args) {
        //thread pool with single thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        //Cannot directly create a Future object without using an ExecutorService
        Future<String> future = executor.submit(()->{
            Thread.sleep(3000);
            return "Hello, Future!";
        });

        // if main thread don't sleep -> "can't get result from Future"
        // if main thread sleep more than 3000 -> "Hello, Future!"
        try {
            Thread.sleep(4000);
        }catch(InterruptedException e){
            System.out.println("Slepping is interrupted");
        }

        if(future.isDone()){
            try{
                String res = future.get();
                System.out.println(res);
            }catch(InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("can't get result from Future");
        }

        executor.shutdown();
    }
}