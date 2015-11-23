package mobidever.godutch.database.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import mobidever.godutch.utility.Reflection;

/**
 * Created by leon on 15-11-8.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private  static SQLiteDateBaseConfig SQLITE_DATABASE_CONFIG;
    private  Context mContext;
    private static  SQLiteHelper INSTANCE;
    private Reflection mReflection ;


    public interface SQLiteDataTable
    {
        public void OnCreate(SQLiteDatabase pDataBase);
        public void OnUpgrade(SQLiteDatabase pDataBase);
    }

    public  SQLiteHelper(Context pContext)
    {
        super(pContext, SQLITE_DATABASE_CONFIG.GetDataBaseName(), null, SQLITE_DATABASE_CONFIG.GetVersion());
        mContext=pContext;
    }

    public static SQLiteHelper GetInstace(Context pContext)
    {
        if (INSTANCE == null)
        {
            SQLITE_DATABASE_CONFIG =SQLiteDateBaseConfig.GetInstance(pContext);
            INSTANCE = new SQLiteHelper(pContext);

        }
        return INSTANCE;

    }

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase pDataBase) {
        ArrayList<String> _ArrayList = SQLITE_DATABASE_CONFIG.GetTables();
        Reflection mReflection = new Reflection();
        for (int i=0; i < _ArrayList.size(); i++) {
            try {
                SQLiteDataTable _SQLiteDataTable = (SQLiteDataTable) mReflection.newInstance(_ArrayList.get(i),
                        new Object[]{mContext},
                        new Class[]{Context.class});
                 _SQLiteDataTable.OnCreate(pDataBase);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public static SQLiteOpenHelper GetInstance(Context pContext) {
        if (INSTANCE == null)
        {
            SQLITE_DATABASE_CONFIG = SQLiteDateBaseConfig.GetInstance(pContext);
            INSTANCE = new SQLiteHelper(pContext) ;

        }
        return INSTANCE;
    }
}


























