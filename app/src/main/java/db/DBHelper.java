package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import modules.Product;

public class DBHelper extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;
    private static final String DATABASE_NAME = "MakeUpDB";
    private static final int DATABASE_VERSION = 1;
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE product(id INTEGER PRIMARY KEY, name TEXT, img INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Product.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean insertProduct(String name, int img){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Product.NAME, name);
        contentValues.put(Product.IMG, img);
        long count = db.insert(Product.TABLE_NAME, null, contentValues);
        db.close();
        return count > 0;
    }

    public ArrayList<Product> getAllProducts(){
        ArrayList<Product> products = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlQuery = "SELECT * FROM " + Product.TABLE_NAME + " ORDER BY " + Product.ID;
        Cursor c = db.rawQuery(sqlQuery, null);
        if(c.moveToFirst()){
            do{
                Product product = new Product();
                product.setId(c.getInt(c.getColumnIndexOrThrow(Product.ID)));
                product.setName(c.getString(c.getColumnIndexOrThrow(Product.NAME)));
                product.setImg(c.getInt(c.getColumnIndexOrThrow(Product.IMG)));
                products.add(product);
            } while(c.moveToNext());
        }
        c.close();
        db.close();
        return products;
    }

    public boolean deleteProduct(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        int count = db.delete(Product.TABLE_NAME, Product.ID + "=?", new String[]{String.valueOf(id)});
        db.close();
        return count > 0;
    }

    public boolean updateProduct(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Product.NAME, name);
        int count = db.update(Product.TABLE_NAME, contentValues, Product.ID + "=?", new String[]{String.valueOf(id)});
        db.close();
        return count > 0;
    }

    public void closeDB(){
        SQLiteDatabase db= this.getReadableDatabase();
        if ((db != null && db.isOpen()))
            db.close();
    }
}
