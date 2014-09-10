package com.example.matthewburns.halloweenapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



public class MyActivity extends Activity
{
    MediaPlayer ourSong;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ourSong = MediaPlayer.create(MyActivity.this, R.raw.halloween_theme);
        ourSong.start();
        blinkText();
    }

    protected void onPause()
    {
        ourSong.release();
    }


    private void blinkText()
    {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 300;
                try {
                    Thread.sleep(timeToBlink);
                } catch (Exception e) {

                }
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        TextView txt = (TextView)findViewById(R.id.Text);
                        if(txt.getVisibility() == View.VISIBLE)
                        {
                            txt.setVisibility(View.INVISIBLE);
                        }else
                        {
                            txt.setVisibility(View.VISIBLE);
                        }
                        blinkText();
                    }
                });
            }}).start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
