package mobidever.godutch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import mobidever.godutch.activity.R;
import mobidever.godutch.adapter.base.AdapterBase;

/**
 * Created by leon on 15-10-29.
 */
public class AdapterSliderMenu extends AdapterBase {

    private class Holder
    {
        ImageView ivIcon;
        TextView  tvName;
    }


    public AdapterSliderMenu(Context pContext, List pList) {
        super(pContext, pList);
    }




    private Context  mContext;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder _Holder;
        if (convertView == null)
        {
            LayoutInflater _LayoutInflater = LayoutInflater.from(mContext);
            convertView = _LayoutInflater.inflate(R.layout.main_body_item, null);

            _Holder = new Holder();
            _Holder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
            _Holder.tvName = (TextView)  convertView.findViewById(R.id.tvName);
            convertView.setTag(_Holder);
        }else{
            _Holder = (Holder)convertView.getTag();
        }

       // _Holder.ivIcon.setImageResource(mImageInteger[position]);
        LinearLayout.LayoutParams _LayoutParams = new LinearLayout.LayoutParams(50,50);
        _Holder.ivIcon.setLayoutParams(_LayoutParams);
        _Holder.ivIcon.setScaleType(ImageView.ScaleType.FIT_XY);
        

        //_Holder.tvName.setText(mImageString[position]);

        return convertView;
    }
}
