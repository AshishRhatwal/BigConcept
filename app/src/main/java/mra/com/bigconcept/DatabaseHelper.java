package mra.com.bigconcept;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mr. A on 27-05-2019.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String TAG="DatabaseHelper";
    private static final String DATABASE_NAME="info";
    private static final String TABLE_NAME="personalinfo";
    private static final String col1="ID";
    private static final String col2="name";
    private static final String col3="number";
    private static final String col4="email";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String dd ="CREATE TABLE "+ TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                col2 + " TEXT "+ col3 +"TEXT " + col4 +"TEXT )";


        String createTable=(" CREATE TABLE " + TABLE_NAME + " (" +
        col1 + " TEXT PRIMARY KEY, " +
                col2 + " TEXT NOT NULL, " +
                col3 + " INTEGER NOT NULL, " +
                col4 + " TEXT NOT NULL);"
        );

        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE EXITS" + TABLE_NAME);
        onCreate(db);


    }

    public boolean addData(String item)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,item);
        contentValues.put(col3,item);
        contentValues.put(col4,item);

        Log.d(TAG,"addData:Adding"+item+"to"+TABLE_NAME);
        long result=db.insert(TABLE_NAME,null,contentValues);

        if(result== -1)
        {
            return false;
        }
        else
        {

            return true;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }


}
