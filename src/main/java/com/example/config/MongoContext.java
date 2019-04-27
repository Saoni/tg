package com.example.config;
import java.net.UnknownHostException;
import java.util.function.Function;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoContext {
  private static MongoContext ctx = new MongoContext();
  private  MongoClient client;
  private  DB db;
  private MongoContext(){
      try{
          init();
      }catch(Exception ex){
          ex.printStackTrace();
      }
  }
  private void init() throws UnknownHostException{
      this.client = new MongoClient("training-shard-00-00-dbhj9.mongodb.net" , 27017);
    }
  public static MongoContext get(){
      return ctx;
  }
  public MongoContext connectDb(String dbname){
    if(db !=null){
        throw new RuntimeException("Already conected to " + db.getName() + "can't connect " + dbname);
    }
    this.db = client.getDB(dbname);
    
System.out.println("DB Details :: " + db.getName());
    return ctx;
}
public <T,X> DBCursor findByKey(String collectionName,String key,T value,Function<T,X> convertDataType){
    DBCollection collection = db.getCollection(collectionName);
    BasicDBObject searchQuery = new BasicDBObject();
    searchQuery.put(key, convertDataType.apply(value));
    System.out.println("search Query ::" + searchQuery);
    DBCursor cursor = collection.find(searchQuery);
    return cursor;
}
}
