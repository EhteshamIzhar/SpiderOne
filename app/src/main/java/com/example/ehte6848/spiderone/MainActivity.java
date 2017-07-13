package com.example.ehte6848.spiderone;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.TypedValue;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    Button btn;
    TextView text;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    /*    if(savedInstanceState==null)
        {
            counter=0;
        }
        else
        {
            counter = savedInstanceState.getInt("counter",0);
        }*/
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button2);
        text = (TextView) findViewById(R.id.textView3);
        text.setGravity(Gravity.LEFT);
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);


        //setOnClickListener
        btn.setOnClickListener(this);

        //sharePreferences
        SharedPreferences sharedPref = getSharedPreferences("value",Context.MODE_PRIVATE);
        String name = sharedPref.getString("val","0");
        counter = Integer.parseInt(name);
        text.setText(name);


    }


    @Override
    public void onClick(View v) {
        counter++;
        text.setText(Integer.toString(counter));
    }

  /*  @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter",counter);
    }*/

      @Override
    public void onPause()
    {
        super.onPause();
        SharedPreferences sharedPref = getSharedPreferences("value", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("val",text.getText().toString());
        editor.apply();
    }

/*    @Override
    public void onResume()
    {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("value",Context.MODE_PRIVATE);
        String name = sharedPref.getString("val","");
        counter = Integer.parseInt(name);
        text.setText(name);

    }
*/
}
