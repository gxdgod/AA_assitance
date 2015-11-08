package mobidever.godutch.controls;



import java.util.ArrayList;
import java.util.List;

import mobidever.godutch.activity.R;
import mobidever.godutch.adapter.AdapterSlideMenu;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.ListView;
import android.widget.RelativeLayout;


/**
 * Created by leon on 15-11-3.
 */
public class SlideMenuView {

    private  Activity mActivity;
    private  List mMenuList;
    private  boolean mIsClosed;
    private RelativeLayout  layBottomBox;
    private OnSlideMenuListener mSlideMenuListener;

    public interface OnSlideMenuListener
    {
        public abstract void onSlideMenuItemClick(View pView, SlideMenuItem pSlideMenuItem);
    }


    public  SlideMenuView(Activity pActivity)
    {
        mActivity = pActivity;
        mSlideMenuListener=(OnSlideMenuListener)pActivity;
        InitVariable();
        InitView();
        InitListeners();
    }

    private void InitListeners() {
       layBottomBox.setOnClickListener(new OnSlideMenuClick());
    }


    public void InitVariable()
    {
        mMenuList= new ArrayList();
        mIsClosed = true;
    }

    public void InitView(){
        layBottomBox = (RelativeLayout) mActivity.findViewById(R.id.IncludeBottom);
    }


    private void Open()
    {
        RelativeLayout.LayoutParams _LayoutParam = new RelativeLayout.LayoutParams(
          RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT
        );
        _LayoutParam.addRule(RelativeLayout.BELOW,R.id.IncludeTitle);

        layBottomBox.setLayoutParams(_LayoutParam);
        mIsClosed = false;
    }

    private void Close()
    {
        RelativeLayout.LayoutParams _LayoutParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,68 );
        _LayoutParam.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        layBottomBox.setLayoutParams(_LayoutParam);
        mIsClosed = true;
    }

    private  void Toggle()
    {

        if (mIsClosed)
        {
            Open();
        }else {
            Close();
        }

    }

    public void Add(SlideMenuItem pSliderMenuItem)
    {
        mMenuList.add(pSliderMenuItem);
    }



    public void BindList()
    {
        AdapterSlideMenu _AdapterSlideMenu = new AdapterSlideMenu(mActivity, mMenuList);
        ListView _ListView = (ListView) mActivity.findViewById(R.id.lvSlideList);
        _ListView.setAdapter(_AdapterSlideMenu);

        _ListView.setOnItemClickListener(new OnSlideMenuItemCLick());

    }


    private class OnSlideMenuClick implements OnClickListener
    {
        @Override
        public void onClick(View v) {
            Toggle();;
        }
    }


    private class OnSlideMenuItemCLick implements OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> pAdapterView, View pView, int pPosition,
                                long arg3) {
            SlideMenuItem _SlideMenuItem = (SlideMenuItem) pAdapterView.getItemAtPosition(pPosition);
            mSlideMenuListener.onSlideMenuItemClick(pView, _SlideMenuItem);
        }
    }
}
