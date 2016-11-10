package com.example.xuxue;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * Created by Administrator on 2016/9/6.
 */

public class WenjianActivity extends AppCompatActivity {
    private Button btn_1;
    private Button btn_2;
    private Context context;
    private EditText editText;
    String text;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        context = this;
        editText = (EditText)findViewById(R.id.id0);
        btn_1 = (Button) findViewById(R.id.id1);
        btn_2 = (Button) findViewById(R.id.id2);
        btn_1.setOnClickListener(ocl);
        btn_1.setOnClickListener(ocl);
    }
    private View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text = String.valueOf(editText.getText());
            switch (v.getId()){
                case R.id.id1:
                    try {
                        OutputStream os = context.openFileOutput("my_flie.txt",Context.MODE_PRIVATE);
                        os.write(text.getBytes());
                        os.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(context,"文件保存成功!",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.id2:
                    try {
                        InputStream is = context.openFileInput("my_flie.txt");
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        int tmp = 0;

                            while((tmp=is.read())!=-1){
                                bos.write(tmp);
                            }
                                String read = new String(bos.toByteArray(),"utf-8");
                                bos.close();
                                is.close();
                                Toast.makeText(context,read,Toast.LENGTH_SHORT).show();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    break;
            }
        }
    };
}
