package com.hfad.tictactoe;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String DB_Name = "HighScores"; //DB Name
    private static final int DB_Version = 1; //DB Version
    DatabaseHelper(Context context)
    {
        super(context, DB_Name, null, DB_Version);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        updateMyDatabase(db, 0, DB_Version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        updateMyDatabase(db, oldVersion, newVersion);
    }
    private static void insertDrink(SQLiteDatabase db, String name, String date,
                                    String time, String latitude, String longitude)
    {
        ContentValues scoreValues = new ContentValues();
        scoreValues.put("NAME", name);
        scoreValues.put("DATE", date);
        scoreValues.put("TIME", time);
        scoreValues.put("LATITUDE", latitude);
        scoreValues.put("LONGITUDE", longitude);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (oldVersion < 1)
        {
            db.execSQL("CREATE TABLE HighScores (SCORE_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DATE NUMERIC, "
                    + "TIME NUMERIC,"
                    + "LATITUDE NUMERIC,"
                    + "LONGITUDE NUMERIC );"
            );
        }
    }
}

