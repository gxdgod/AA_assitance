package mobidever.godutch.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import mobidever.godutch.activity.base.ActivityBase;
import mobidever.godutch.activity.base.ActivityFrame;
import mobidever.godutch.adapter.AdapterAppGrid;
import mobidever.godutch.controls.SlideMenuItem;
import mobidever.godutch.controls.SlideMenuView;

public class ActivityMain extends ActivityFrame implements SlideMenuView.OnSlideMenuListener {

    private GridView gvAppGrid;

    private AdapterAppGrid mAdapterAppGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_main);
        AppendMainBody(R.layout.main_body);

        InitVariable();
        InitView();
        InitListeners();
        BindData();
        CreateSlideMenu(R.array.SlideMenuActivityMain);
    }

    public void InitVariable()
    {
        mAdapterAppGrid = new AdapterAppGrid(this);
    }

    public void InitView()
    {
        gvAppGrid = (GridView) findViewById(R.id.gvAppGrid);
    }

    public  void InitListeners()
    {

    }

    public  void BindData()
    {
        gvAppGrid.setAdapter(mAdapterAppGrid);
    }

    @Override
    public void onSlideMenuItemClick(View pView, SlideMenuItem pSlideMenuItem) {
        Toast.makeText(this,pSlideMenuItem.getTitle(),Toast.LENGTH_LONG).show();
    }
}



