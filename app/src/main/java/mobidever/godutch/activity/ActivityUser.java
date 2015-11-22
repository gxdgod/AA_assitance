package mobidever.godutch.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import mobidever.godutch.activity.base.ActivityFrame;
import mobidever.godutch.adapter.AdapterAppGrid;
import mobidever.godutch.adapter.AdapterUser;
import mobidever.godutch.controls.SlideMenuItem;
import mobidever.godutch.controls.SlideMenuView;

/**
 * Created by leon on 15-11-22.
 */
public class ActivityUser extends ActivityFrame implements SlideMenuView.OnSlideMenuListener{


    private ListView lvUserList;

    private AdapterUser mAdapterUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   setContentView(R.layout.activity_main);
        AppendMainBody(R.layout.user);

        InitVariable();
        InitView();
        InitListeners();
        BindData();
        CreateSlideMenu(R.array.SlideMenuActivityMain);
    }

    public void InitVariable()
    {
        mAdapterUser = new AdapterUser(this);
    }

    public void InitView()
    {
        lvUserList = (ListView) findViewById(R.id.lvUserList);
    }

    public  void InitListeners()
    {

    }

    public  void BindData()
    {
        lvUserList.setAdapter(mAdapterUser);
    }

    @Override
    public void onSlideMenuItemClick(View pView, SlideMenuItem pSlideMenuItem) {
        Toast.makeText(this,pSlideMenuItem.getTitle(),Toast.LENGTH_LONG).show();
    }
}
