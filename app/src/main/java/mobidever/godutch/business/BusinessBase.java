package mobidever.godutch.business;

import android.content.Context;

/**
 * Created by leon on 15-11-21.
 */
public class BusinessBase {
    private Context mContext;
    protected BusinessBase(Context pContext) {

        mContext = pContext;

    }

    protected String GetString(int pResID){
       return mContext.getString(pResID);
    }

    protected String GetString(int pResID,Object pObject[]){
        return mContext.getString(pResID,pObject);

    }
}
