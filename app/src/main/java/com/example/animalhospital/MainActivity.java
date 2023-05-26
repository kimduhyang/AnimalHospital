package com.example.animalhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_userid, edt_passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_login = findViewById(R.id.btn_login);
        edt_userid = findViewById(R.id.edt_userid);
        edt_passwd = findViewById(R.id.edt_passwd);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "로그인 버튼 클릭", Toast.LENGTH_SHORT).show();
                //아이디: 5자리 apple
                //비밀번호: 7~13 자리 12345678
                String str_userid = edt_userid.getText().toString();
                String str_passwd = edt_passwd.getText().toString();
                Log.d("abc", "str_userid"+str_userid);
                Log.d("abc", str_passwd);

                if(str_userid.length()!=5){
                    Toast.makeText(MainActivity.this, "아이디는 5자입니다.", Toast.LENGTH_SHORT).show();
                }
                else if(str_passwd.length()<7||str_passwd.length()>13){
                    Toast.makeText(MainActivity.this, "비밀번호는 7~12자입니다.", Toast.LENGTH_SHORT).show();
                }
                else if(str_userid.equals("apple") && str_passwd.equals("12345678")){
                    Toast.makeText(MainActivity.this, str_userid + "님 환엽합니다!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "입력한 정보를 확인하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btn_info).setOnClickListener(this);
        findViewById(R.id.btn_guide).setOnClickListener(this);
        findViewById(R.id.btn_call).setOnClickListener(this);
        findViewById(R.id.btn_shop).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_info:
                intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("MSG", "안녕하세요");
                break;
            case R.id.btn_guide:
                intent = new Intent(MainActivity.this, GuideActivity.class);
                break;
            case R.id.btn_call:
                intent = new Intent(MainActivity.this, CallActivity.class);
                break;
            case R.id.btn_shop:
                intent = new Intent(getApplicationContext(), ShopActivity.class);
                break;
        }
        startActivity(intent);
    }
}