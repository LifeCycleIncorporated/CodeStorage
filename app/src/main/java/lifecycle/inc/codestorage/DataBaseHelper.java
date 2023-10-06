package lifecycle.inc.codestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student_database";
    private static final String TABLE_NAME = "student_details";
    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String GENDER = "gender";
    private static final int VERSION_NUMBER = 22;

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR (255), "+AGE+" INTEGER, "+GENDER+" VARCHAR(15))";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " +TABLE_NAME;

    private static final String SELECT_ALL = "SELECT * FROM " +TABLE_NAME;

    private Context context;

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            Toast.makeText(context,"onCreate is active",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }catch (Exception e)
        {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            Toast.makeText(context,"onUpgrade is active",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }catch (Exception e)
        {
            Toast.makeText(context, "Exception ; "+e,Toast.LENGTH_SHORT).show();
        }
    }

    public long insertData(String name, String age, String gender)
    {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(NAME, name);
            contentValues.put(AGE, age);
            contentValues.put(GENDER, gender);
            long rowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
            return rowId;

    }






    public Cursor  showAllData()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;
    }





    // onUpgrade
    public boolean updateData(String id, String name, String age, String gender)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);
        contentValues.put(GENDER,gender);

        sqLiteDatabase.update(TABLE_NAME, contentValues, ID+" = ?", new String[]{id});
        return true;
    }






    public int deleteData(String id)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,ID+" = ?",new String[]{id});

    }
}

