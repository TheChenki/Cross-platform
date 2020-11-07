package models;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MyDB
{
    static private MongoDatabase db;

    public static MongoDatabase getDB()
    {
        if(db == null)
        {
            var mongoClient = MongoClients.create();
            MyDB.db = mongoClient.getDatabase("Java");
        }

        return db;
    }
}
