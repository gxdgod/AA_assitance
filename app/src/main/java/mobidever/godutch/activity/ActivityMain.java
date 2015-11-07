package mobidever.godutch.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import mobidever.godutch.activity.base.ActivityBase;
import mobidever.godutch.activity.base.ActivityFrame;
import mobidever.godutch.adapter.AdapterAppGrid;

public class ActivityMain extends ActivityFrame {

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
}



