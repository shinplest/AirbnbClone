package com.shinplest.airbnbclone.src.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.shinplest.airbnbclone.src.BaseActivity;
import com.shinplest.airbnbclone.src.login.LoginActivity;
import com.shinplest.airbnbclone.src.main.MainActivity;

import static com.shinplest.airbnbclone.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.shinplest.airbnbclone.src.ApplicationClass.sSharedPreferences;

public class SplashActivity extends BaseActivity {
    private String jwtToken;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent activityIntent;


        // 여기서 해야할 것 .

        //구글 로그인 오케이 || 토큰 있으면 메인으로
        //아니라면 로그인 액티비티로.

//        //토큰이 없으면 로그인페이지로 이동
//        if(X_ACCESS_TOKEN.equals("X-ACCESS-TOKEN")){
//
//        }
//        //토큰이 있으면
//        else{
//
//        }


        //테스트용으로 int값으로 하였음, 토큰있으면 메인, 없으면 로그인 창 jwt위해 남겨놓는다.
        int token = 10;
        if(token != 10){
            activityIntent = new Intent(this, MainActivity.class);
        }
        else
        {
            activityIntent = new Intent(this, LoginActivity.class);
        }
        startActivity(activityIntent);
        finish();
    }
}
