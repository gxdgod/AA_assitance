package mobidever.godutch.activity.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import mobidever.godutch.activity.R;

/**
 * Created by leon on 15-10-29.
 */
public class ActivityFrame extends ActivityBase {
    @Override
    protected   void onCreate(Bundle savedInstanceState){
        // super
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
    }

    protected  void AppendMainBody(int pResID){
        LinearLayout _MainBody = (LinearLayout)findViewById(R.id.layMainBody);

        View _View = LayoutInflater.from(this).inflate(pResID, null);

        RelativeLayout.LayoutParams _LayoutParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT);

        _MainBody.addView(_View,_LayoutParams);
    }
}