package mobidever.godutch.database.base;

import android.os.Build;

import java.util.ArrayList;

/**
 * Created by leon on 15-11-8.
 */
public class SQLiteDateBaseConfig  {

    private static  final  String DATABASE_NAME="GoDutonDataBase";
    private static final int VERSION = 1;
    private static  SQLiteDateBaseConfig INSTANCE;

    private  SQLiteDateBaseConfig()
    {

    }

    public static SQLiteDateBaseConfig GetInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new SQLiteDateBaseConfig();
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
            return _ArrayList;
    }

}
