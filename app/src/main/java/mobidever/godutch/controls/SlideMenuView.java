package mobidever.godutch.controls;



import java.util.ArrayList;
import java.util.List;

import mobidever.godutch.activity.R;
import mobidever.godutch.adapter.AdapterAppGrid;
import mobidever.godutch.adapter.AdapterSliderMenu;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;


/**
 * Created by leon on 15-11-3.
 */
public class SlideMenuView {

    private  Activity mActivity;
    private  List mMenuList;
    private  boolean mIsClosed;
    private RelativeLayout  layBottomBox;

    public  SlideMenuView(Activity pActivity)
    {
        mActivity = pActivity;
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
        _LayoutParam.addRule(RelativeLayout.BELOW,R.id.IncludeTitle);

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

    private  void Add(SliderMenuItem pSliderMenuItem)
    {
        mMenuList.add(pSliderMenuItem);
    }



    private void BindList ()
    {
        AdapterSliderMenu _AdapterSlideMenu = new AdapterSliderMenu(mActivity, mMenuList);
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
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }
}
