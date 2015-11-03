package mobidever.godutch.controls;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import mobidever.godutch.activity.R;
import mobidever.godutch.adapter.AdapterAppGrid;

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

    private class OnSlideMenuClick implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {

        }
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


    }

    private  void add()
    {


    }

    private void BindList ()
    {

    }

    private void OnSlideMenuClick()
    {

    }
}
