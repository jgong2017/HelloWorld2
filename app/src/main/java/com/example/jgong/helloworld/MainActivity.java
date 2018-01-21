package com.example.jgong.helloworld;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.content.res.Configuration;
import android.content.pm.ActivityInfo;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private Button btnOne,btnTwo;

    public void save(String filename, String filecontent) throws Exception {
        Context mContext = getApplicationContext();
        FileOutputStream output = mContext.openFileOutput( "GJ_Test.txt", getApplicationContext().MODE_PRIVATE);
        output.write((filecontent+"asdfasdf").getBytes());  //将String字符串以字节流的形式写入到输出流中
        output.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne=(Button)findViewById(R.id.button1 );
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Clicked", 10);
                toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL , 0, 0);  //设置显示位置
                TextView vv = (TextView) toast.getView().findViewById(android.R.id.message);
                vv.setTextColor(Color.RED);     //设置字体颜色
                toast.show();
                btnOne.setText("Clicked !!!");
                Configuration config = getResources().getConfiguration();
                //如果是横屏的话切换成竖屏
//                if(config.orientation == Configuration.ORIENTATION_LANDSCAPE)
//                {
//                    MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//                }
//                //如果竖屏的话切换成横屏
//                if(config.orientation == Configuration.ORIENTATION_PORTRAIT)
//                {
//                    MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//                }

                TextView textView = (TextView) findViewById(R.id.textView1);
                textView.setText("ASDF " + textView.getText());
                try {
                    save("GJ_Test_Write.txt",textView.getText()+": Good to write into a file");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
