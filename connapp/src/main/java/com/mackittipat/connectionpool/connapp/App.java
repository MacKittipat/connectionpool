package com.mackittipat.connectionpool.connapp;

import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) throws IOException {


//        Runnable runnable = () -> {
//            IntStream.range(1, 1000).forEach((num) -> {
//                try {
//                    System.out.println(Request.Get("http://localhost:9000/connwebapp/save").execute().returnContent());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//        };
//        new Thread(runnable).start();



        IntStream.range(1, 10).forEach((num) -> {
            Runnable runnable = () -> {
                IntStream.range(1, 1000).forEach((num2) -> {
                    try {
                        System.out.println(num + " >> " + Request.Get("http://localhost:9000/connwebapp/save").execute().returnContent());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            };
            new Thread(runnable).start();
        });

    }
}
