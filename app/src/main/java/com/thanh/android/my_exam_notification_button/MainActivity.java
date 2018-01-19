package com.thanh.android.my_exam_notification_button;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String arr_question_group[] = {
            "Intel",
            "SamSung",
            "Nokia",
            "Simen",
            "AMD",
            "KIC",
            "ECD"
    };
//    todo notification 3: declare layout
    RelativeLayout notificationCount1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        todo notification 11: mutiply data return from  QuestionGroupDisplay.java
//        todo notification 12_END: edit theme for popup menu to diaglog in AndroidManifest.xml
        if(requestCode == 1) {
            Toast.makeText(this, String.valueOf(data.getIntExtra("position_return", 0)), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void init() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        todo notification 4: inflafe my menu into activity menu
        getMenuInflater().inflate(R.menu.notification_menu, menu);
//        todo notification 5: set item1 for display my layout (button display)
        MenuItem item1 = menu.findItem(R.id.actionbar_item0);
        MenuItemCompat.setActionView(item1, R.layout.notification_count_badge_in_actionbar);
//        todo notification 6: get layout for get button
        notificationCount1 = (RelativeLayout) MenuItemCompat.getActionView(item1);
//        todo notification 7: get button from layout
        Button tmp = (Button) notificationCount1.findViewById(R.id.button1);
//        todo notification 8: set event click for display -> QuestionGroupDisplay.java
        tmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Tim hoai eo ra, buc qua- cuoi cung cung phai ra cho :D", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(getApplicationContext(),QuestionGroupDisplay.class);
                startActivityForResult(intent,1);
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
