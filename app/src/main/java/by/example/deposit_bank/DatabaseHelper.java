package by.example.deposit_bank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "client.db";
    public static final String TABLE_NAME = "client";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "LASTNAME";
    public static final String COL_5 = "SUMM";
    public static final String COL_6 = "PERSENT";
    public static final String COL_7 = "PLUS";
    public static final String COL_8 = "NUMBER";
    public static final String COL_9 = "PASPORT";
    public static final String COL_10 = "BORN";
    public static final String COL_11 = "REGISTER";
    public static final String COL_12 = "VNESENIE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT, SURNAME TEXT, LASTNAME TEXT," +
                "SUMM INTEGER, PERSENT INTEGER, PLUS INTEGER, NUMBER INTEGER, PASPORT STRING, BORN INTEGER, REGISTER INTEGER, VNESENIE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String surname,String lastname,String summ,
                              String persent,String plus,String pasport,String number,
                              String born,String register,String vnesenie) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,lastname);
        contentValues.put(COL_5,summ);
        contentValues.put(COL_6,persent);
        contentValues.put(COL_7,plus);
        contentValues.put(COL_8,number);
        contentValues.put(COL_9,pasport);
        contentValues.put(COL_10,born);
        contentValues.put(COL_11,register);
        contentValues.put(COL_12,vnesenie);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String name,String surname,String lastname,String summ,
                              String persent,String plus,String pasport,String number,
                              String register,String vnesenie) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,lastname);
        contentValues.put(COL_5,summ);
        contentValues.put(COL_6,persent);
        contentValues.put(COL_7,plus);
        contentValues.put(COL_8,number);
        contentValues.put(COL_9,pasport);
        contentValues.put(COL_11,register);
        contentValues.put(COL_12,vnesenie);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}
