package mobidever.godutch.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by leon on 15-11-5.
 */
public abstract  class AdapterBase extends BaseAdapter {

    public List mList;

    public Context GetContext() {
        return mContext;
    }

    public Context mContext;

    public LayoutInflater GetLayeroutInflater() {
        return mLayeroutInflater;
    }

    private LayoutInflater mLayeroutInflater;

    public  AdapterBase(Context pContext,List pList)
    {
        mContext = pContext;
        mList = pList;
        mLayeroutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int pPosition) {
        return mList.get(pPosition);
    }

    @Override
    public long getItemId(int pPosition) {
        return pPosition;
    }

}
