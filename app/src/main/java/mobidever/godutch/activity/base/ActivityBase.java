package mobidever.godutch.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by leon on 15-10-25.
 */
public class ActivityBase extends Activity {

       protected void ShowMsg(String pMsg)
        {
            Toast.makeText(this,pMsg,Toast.LENGTH_LONG ).show();
        }

        protected void OPenActivity(Class<?> pClass){

            Intent _Intent = new Intent();
            _Intent.setClass(this,pClass);

            startActivity(_Intent);
        }

}
