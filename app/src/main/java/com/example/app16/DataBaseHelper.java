package com.example.app16;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "manga.db";
    private static final int SCHEMA = 1;
    static final String TABLE_NAME = "manga";

    private static final String COLUMN_ID = "id_manga";
    private static final String COLUMN_TITLE = "manga_title";
    private static final String COLUMN_AVTOR = "manga_avtor";


    public DataBaseHelper (@Nullable Context context){
        super(context,DATABASE_NAME,null,SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME +" ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_TITLE+" TEXT, "+COLUMN_AVTOR+" TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    public void onUpgrades(int id, String Title, String Avtor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, Title);
        contentValues.put(COLUMN_AVTOR, Avtor);
        db.update(TABLE_NAME,contentValues, COLUMN_ID +" = "+id,null);
    }

    public  void onDelte(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,COLUMN_ID+" = " +id,null);
    }

    public  void addManga(Anime anime){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COLUMN_ID, anime.getID());
        contentValues.put(COLUMN_TITLE, anime.getTitleName());
        contentValues.put(COLUMN_AVTOR, anime.getAvtorName());
        db.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<Anime> getMangaList(){
        ArrayList<Anime> listmanga = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        if(result.moveToNext()){
            while (result.moveToNext()){
                int id = result.getInt(0);
                String Title = result.getString(1);
                String Avtor = result.getString(2);
                Anime anime = new Anime(id,Title,Avtor);
                listmanga.add(anime);
            }
        }
        result.close();
        return listmanga;
    }

}
