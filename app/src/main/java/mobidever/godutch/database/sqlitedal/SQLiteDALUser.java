package mobidever.godutch.database.sqlitedal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;
import java.util.List;

import mobidever.godutch.activity.R;
import mobidever.godutch.utility.DateTools;

import mobidever.godutch.database.base.SQLiteDALBase;
import mobidever.godutch.model.ModelUser;

/**
 * Created by leon on 15-11-15.
 */
public class SQLiteDALUser extends SQLiteDALBase {
    public SQLiteDALUser(Context p_Context) {

        super(p_Context);
    }

    public boolean InsertUser(ModelUser pModelUser)
    {
        ContentValues _ContextValues =CreateParms(pModelUser);
       long _NewID= GetDataBase().insert(GetTableNameAndPK()[0],null,_ContextValues);
        pModelUser.setUserID((int) _NewID);
        return _NewID > 0;

    }

    public boolean DeleteUser(String pCondition)
    {
        return Delete(GetTableNameAndPK()[0],pCondition);

    }

    public List<ModelUser> GetUser(String pCondition)
    {
        String _SqlTest = "Select * From User Where 1=1 " + pCondition;
        return GetList(_SqlTest);

    }

    public boolean UpdateUser(String pCondition,ModelUser pModelUser)
    {
        ContentValues _ContentValue = CreateParms(pModelUser);
        return GetDataBase().update(GetTableNameAndPK()[0],_ContentValue,pCondition,null) > 0;

    }
    @Override
    protected String[] GetTableNameAndPK() {
        return new String[0];
    }

    @Override
    protected Object FindModel(Cursor pCursor) {

        ModelUser _ModelUser = new ModelUser();
        _ModelUser.setUserID(pCursor.getInt(pCursor.getColumnIndex("UserID")));
        _ModelUser.setUserName(pCursor.getString(pCursor.getColumnIndex("UserName")));
        Date _CreateDate = DateTools.getDate(pCursor.getString(pCursor.getColumnIndex("CreateDate")), "yyyy-MM-dd HH:mm:ss");
        _ModelUser.setCreateDate(_CreateDate);
        _ModelUser.setStatus((pCursor.getInt(pCursor.getColumnIndex("State"))));

        return _ModelUser;

    }

    private void InitDefaultDate(SQLiteDatabase pDatabase)
    {
          ModelUser _ModelUser = new ModelUser();
          String[] _UserName = GetContext().getResources().getStringArray(R.array.InitDefaultUserName);
        for (int i = 0; i < _UserName.length;i++)
        {
            _ModelUser.setUserName(_UserName[i]);
            ContentValues _ContentValues = CreateParms(_ModelUser);
            pDatabase.insert(GetTableNameAndPK()[0],null,_ContentValues);
        }

    }

    @Override
    public void OnCreate(SQLiteDatabase pDataBase) {

        StringBuilder s_CreateTableScript = new StringBuilder();

        s_CreateTableScript.append("		Create  TABLE User(");
        s_CreateTableScript.append("				[UserID] integer PRIMARY KEY AUTOINCREMENT NOT NULL");
        s_CreateTableScript.append("				,[UserName] varchar(10) NOT NULL");
        s_CreateTableScript.append("				,[CreateDate] datetime NOT NULL");
        s_CreateTableScript.append("				,[State] integer NOT NULL");
        s_CreateTableScript.append("				)");

        pDataBase.execSQL(s_CreateTableScript.toString());
        InitDefaultDate(pDataBase);

    }

    @Override
    public void OnUpgrade(SQLiteDatabase pDataBase) {

    }

    public ContentValues CreateParms(ModelUser pInfo)
    {
        ContentValues _ContentValues = new ContentValues();
        _ContentValues.put("UserName", pInfo.getUserName());
        _ContentValues.put("CreateDate",DateTools.getFormatDateTime(pInfo.getCreateDate(),"yyyy-MM-dd HH:mm:ss"));
        _ContentValues.put("State",pInfo.getStatus());
        return _ContentValues;
    }
}
