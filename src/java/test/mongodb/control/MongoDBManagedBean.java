/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.mongodb.control;

import com.google.gson.Gson;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.mongodb.*;
import com.mongodb.util.JSON;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javier
 */
@ManagedBean
@SessionScoped
public class MongoDBManagedBean {

    private String text;
    private MongoClient mongoClient;
    private String output;
    private User user;

    /**
     * Creates a new instance of MongoDBManagedBean
     */
    public MongoDBManagedBean() {
        user = new User();
        try {
            this.mongoClient = new MongoClient();
        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoDBManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public void test() {
        System.out.println("este es el texto que usted ingresó: " + this.text);
    }

    public String testB(String collName) {

        this.output = "";
        DB db = this.mongoClient.getDB("mydb");
        System.out.println("Result: " + db.getName());
        DBCollection collection = null;
        Set<String> colls = db.getCollectionNames();

        for (String c : colls) {
            if (c.equalsIgnoreCase(collName)) {
                collection = db.getCollection(c);
            }
        }

        DBCursor cursorDoc = collection.find();
        try {
            while (cursorDoc.hasNext()) {
                this.output = this.output + "" + cursorDoc.next();
                //System.out.println(cursorDoc.next());
            }
        } finally {
            cursorDoc.close();
        }

        System.out.println("output: " + this.output);
        return this.output;
    }

    public String testC(String collName) {

        DB db = this.mongoClient.getDB("mydb");
        System.out.println("Result: " + db.getName());
        Gson gson = new Gson();
        String jsonResult = "";

        DBCollection collection = db.getCollection(collName);
        BasicDBObject query = new BasicDBObject("nombre", "Leidy");
        DBCursor cursor = collection.find(query);

        try {
            while (cursor.hasNext()) {
                jsonResult = "" + cursor.next();
                //System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }

        System.out.println("json: \n" + jsonResult);
        this.user = gson.fromJson(jsonResult, User.class);
        System.out.println("Datos de usuario (Java): " + this.user.getNombre() + " " + this.user.getApellido());
        return jsonResult;
    }

    public String testD(String collName) {

        //BasicDBObject example
        DB db = this.mongoClient.getDB("mydb");
        DBCollection collection = db.getCollection(collName);
        String[] p = {"d", "f", "g"};
        this.output = "";

        BasicDBObject document = new BasicDBObject();
        document.put("_id", 3);
        document.put("nombre", "Luis");
        document.put("apellido", "Suarez");
        document.put("edad", 54);
        document.put("nacimiento", 1959);
        document.put("premios", p);

        collection.insert(document);

        DBCursor cursorDoc = collection.find();
        while (cursorDoc.hasNext()) {
            this.output = this.output + cursorDoc.next() + "\n";
            //System.out.println(cursorDoc.next());
        }

        System.out.println("result: \n" + this.output);
        //collection.remove(new BasicDBObject());
        return this.output;


    }

    public String testE(String collName) {

        // JSON parse example
        DB db = this.mongoClient.getDB("mydb");
        DBCollection collection = db.getCollection(collName);

        String json = "{'_id' : 4,'nombre' : 'Gilma','apellido' : 'Meza', 'edad' : 45, 'nacimiento' : 'Jul 21, 1968', 'premios' :  ['t','r','d']}";
        this.output = "";
        DBObject dbObject = (DBObject) JSON.parse(json);
        collection.insert(dbObject);

        DBCursor cursorDocJSON = collection.find();
        while (cursorDocJSON.hasNext()) {
            this.output = this.output + cursorDocJSON.next() + "\n";
            //System.out.println(cursorDocJSON.next());
        }
        System.out.println("Collections: \n" + this.output);
//            collection.remove(new BasicDBObject());
        return this.output;

    }
}
