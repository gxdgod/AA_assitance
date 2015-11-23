package mobidever.godutch.database.base;

import android.content.Context;
import android.os.Build;

import java.util.ArrayList;

import mobidever.godutch.activity.R;

/**
 * Created by leon on 15-11-8.
 */
public class SQLiteDateBaseConfig  {


    private static final String DATABASE_NAME = "GoDutchDataBase";
    private static final int VERSION = 1;
    private static  SQLiteDateBaseConfig INSTANCE;
    private static Context mContext;

    private  SQLiteDateBaseConfig()
    {

    }

    public static SQLiteDateBaseConfig GetInstance(Context pContext)
    {
        if (INSTANCE == null)
        {
            INSTANCE = new SQLiteDateBaseConfig();
            mContext = pContext;
        }
            return INSTANCE;
    }

    public  String GetDataBaseName()
    {
        return DATABASE_NAME;
    }

    public int GetVersion()
    {
        return VERSION;
    }

    public ArrayList<String> GetTables()
    {
        ArrayList<String> _ArrayList = new ArrayList<String>();
        String[] _SQLiteDALClassName = mContext.getResources().getStringArray(R.array.SQLiteDALClassName);
        String _PackagePath= mContext.getPackageName() + ".database.sqlitedal.";
        for (int i=0; i<_SQLiteDALClassName.length;i++)
        {
            _ArrayList.add(_PackagePath + _SQLiteDALClassName[i]);

        }

        return _ArrayList;
    }

}
