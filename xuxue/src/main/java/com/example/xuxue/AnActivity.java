package com.example.xuxue;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/11/2.
 */

public class AnActivity extends AppCompatActivity implements  View.OnClickListener {
    private Button button;
    private Button button1;
    private Button button2;
    private  Button button3;
    private  Button button4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kuang);
        button = (Button) findViewById(R.id.dan);
        button.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.liebiaodandan);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.danxuan);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.danxuan);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.duoxuan);
        button4.setOnClickListener(this);
    }
    public void anniu_1(){
        DialogInterface.OnClickListener dialogOnclicListener = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case Dialog.BUTTON_POSITIVE:
                        Toast.makeText(AnActivity.this,"确定"+which,Toast.LENGTH_LONG).show();
                        break;
                    case Dialog.BUTTON_NEGATIVE:
                        Toast.makeText(AnActivity.this,"取消"+which,Toast.LENGTH_LONG).show();
                        break;
                    case Dialog.BUTTON_NEUTRAL:
                        Toast.makeText(AnActivity.this,"关闭"+which,Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
            }
        };
        AlertDialog.Builder builder =new  AlertDialog.Builder(this);
        builder.setTitle("提示：");
        builder.setMessage("确定要退出吗");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("确定",dialogOnclicListener);
        builder.setNegativeButton("取消",dialogOnclicListener);
        builder.setNeutralButton("关闭",dialogOnclicListener);
        builder.create().show();
    }
    private  void anniu_2(){
        final String itms[] = {"王维","王安石","王勃"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示：");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(itms,new  DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(AnActivity.this,itms[which],Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(AnActivity.this,"确定"+which,Toast.LENGTH_LONG).show();
            }
        });
        builder.create().show();

    }
    private  void anniu_3(){
        final String itms[] = {"男","女"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示:");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(itms,1,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
                Toast.makeText(AnActivity.this, itms[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(AnActivity.this,"确定"+which,Toast.LENGTH_LONG).show();
            }
        });
        builder.create().show();
    }
    private  void anniu_4(){
        final String itms[]={"足球","篮球","排球"};
        final boolean defaults[] ={true,false,true};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示：");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMultiChoiceItems(itms,defaults,new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(AnActivity.this,itms[which]+isChecked,Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(AnActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.dan :
                anniu_1();
                break;
            case R.id.liebiaodandan:
                anniu_2();
                break;
            case R.id.danxuan:
                anniu_3();
                break;
            case R.id.duoxuan:
                anniu_4();
                break;
        }
    }
}
