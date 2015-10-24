package com.mackittipat.connectionpool.connapp;

import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println(Request.Get("http://localhost:9000/connwebapp/save").execute().returnContent());
    }
}
