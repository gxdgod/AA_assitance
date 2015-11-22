package mobidever.godutch.business;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import mobidever.godutch.database.sqlitedal.SQLiteDALUser;
import mobidever.godutch.model.ModelUser;

/**
 * Created by leon on 15-11-21.
 */
public class BusinessUser extends BusinessBase{

    private SQLiteDALUser mSQLiteDALUser;
    public BusinessUser(Context pContext) {
        super(pContext);
        mSQLiteDALUser = new SQLiteDALUser(pContext);
    }

    public boolean InsertUser(ModelUser pInfo)
    {
        boolean _Result = mSQLiteDALUser.InsertUser(pInfo) ;

        return _Result;

    }

    public boolean DeleteUserID(int pUserID)
    {
        String _Condition = "And UserID = " + pUserID;
        boolean _Result = mSQLiteDALUser.DeleteUser(_Condition);
        return _Result;
    }

    public boolean updateUserByUserID(ModelUser pModelUser)
    {
        String _Condition = "And UserID =" +pModelUser.getUserID();
        boolean _Result = mSQLiteDALUser.UpdateUser(_Condition, pModelUser);

        return _Result;
    }

    public List<ModelUser> GetNotHideUser()
    {
        return mSQLiteDALUser.GetUser("And State =1");
    }

   private List<ModelUser> GetUser(String pCondition)
   {
        return mSQLiteDALUser.GetUser(pCondition);
   }

    public ModelUser GetModeUserByUserID(int pUserID)
    {
        List<ModelUser> _List = mSQLiteDALUser.GetUser("And  UserID = " + pUserID);
        if (_List.size() == 1) {
            return _List.get(0);
        }else{
            return null;
        }
    }

    public List<ModelUser> GetUserList(String pUserID[])
    {
        List<ModelUser> _List = new ArrayList<ModelUser>();
        for (int i= 0; i < pUserID.length; i++)
        {
              _List.add(GetModeUserByUserID(Integer.valueOf(pUserID[i])));

        }

        return _List;
    }

}































