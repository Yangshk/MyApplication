package com.example.xuxue;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;


public class ListActivity extends Activity {
    private SeekBar seekBar;
    public SeekBar.OnSeekBarChangeListener ocl = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Toast.makeText(ListActivity.this,"progress:"+progress,Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Toast.makeText(ListActivity.this,seekBar.getProgress(),Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Toast.makeText(ListActivity.this,seekBar.getProgress(),Toast.LENGTH_LONG).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.psview);
        seekBar =(SeekBar) findViewById(R.id.sb1);
        seekBar.setOnSeekBarChangeListener(ocl);
    }
}
