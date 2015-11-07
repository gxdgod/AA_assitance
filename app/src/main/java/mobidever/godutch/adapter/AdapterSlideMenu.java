package mobidever.godutch.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mobidever.godutch.activity.R;
import mobidever.godutch.adapter.base.AdapterBase;
import mobidever.godutch.controls.SlideMenuItem;

/**
 * Created by leon on 15-10-29.
 */
public class AdapterSlideMenu extends AdapterBase {

    private class Holder
    {
        TextView  tvMenuName;
    }

    public AdapterSlideMenu(Context pContext, List pList) {
        super(pContext, pList);
    }

    private Context  mContext;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder _Holder;
        if (convertView == null)
        {

            convertView = GetLayeroutInflater().inflate(R.layout.slidemenu_list_item,null);

            _Holder = new Holder();

            _Holder.tvMenuName = (TextView)  convertView.findViewById(R.id.ivMenuName);
            convertView.setTag(_Holder);
        }else{
            _Holder = (Holder)convertView.getTag();
        }

        SlideMenuItem _Item = (SlideMenuItem) GetList().get(position);


        _Holder.tvMenuName.setText(_Item.getTitle());

        return convertView;
    }
}
