package com.py.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static  DatabseAccess instance;
    Cursor c = null;

    private DatabseAccess(Context context){

        this.openHelper = new DatabaseOpenHelper(context);
    }

    public  static  DatabseAccess getInstance(Context context){
        if (instance == null){

            instance = new DatabseAccess(context);
        }
        return instance;
    }


    public void open(){

        this.db = openHelper.getWritableDatabase();
    }

    public void close(){

        if (db != null){
            this.db.close();
        }
    }

    public String  getAddress(String name){

        c= db.rawQuery("select HEIGHT from TIDEPRED where TIME ='"+name+"'",new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String address = c.getString(0);
            buffer.append(""+address);

        }
        return buffer.toString();
    }

}
