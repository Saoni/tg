package com.example;
import com.example.config.MongoContext;
import com.mongodb.DBCursor;
public class Main {
 
    public static void main(String[] args) {
        DBCursor result = MongoContext.get().connectDb("tg").findByKey("games", "rank", 6,
                (value) -> new Integer(value));
                System.out.println("Connection established");
      System.out.println(result.count());
    }
}