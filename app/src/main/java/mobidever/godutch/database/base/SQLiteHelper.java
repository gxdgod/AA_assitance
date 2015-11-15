package mobidever.godutch.database.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by leon on 15-11-8.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private  static SQLiteDateBaseConfig mSQLiteDateBaseConfig;
    private  Context mContext;
    private static  SQLiteHelper INSTANCE;

    public interface SQLiteDataTable
    {
        public void OnCreate(SQLiteDatabase pDataBase);
        public void OnUpgrade(SQLiteDatabase pDataBase);


    }
    public  SQLiteHelper(Context pContext)
    {
        super(pContext,mSQLiteDateBaseConfig.GetDataBaseName(),null,mSQLiteDateBaseConfig.GetVersion());
        mContext=pContext;
    }

    public static SQLiteHelper GetInstace(Context pContext)
    {
        if (INSTANCE == null)
        {
            INSTANCE = new SQLiteHelper(pContext);
        }
        return INSTANCE;

    }

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        ArrayList<String> _ArrayList = mSQLiteDateBaseConfig.GetTables();
        _ArrayList.add("");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static SQLiteOpenHelper GetInstance(Context m_context) {
        return null;
    }
}
