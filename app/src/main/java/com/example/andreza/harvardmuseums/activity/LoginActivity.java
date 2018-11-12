package com.example.andreza.harvardmuseums.activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import com.example.andreza.harvardmuseums.User;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andreza.harvardmuseums.BancoDeDados;
import com.example.andreza.harvardmuseums.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {


    public static final String CHAVE_EMAIL = "chave_email";
    private LoginButton loginFacebook;
    private CallbackManager callbackManager;

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginFacebook = (LoginButton) findViewById(R.id.login_facebook);
        loginFacebook.setReadPermissions("email");

        callbackManager = CallbackManager.Factory.create();
        loginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        Intent intent = new Intent(loginFacebook.getContext(), HomeActivity.class);
                        startActivity(intent);

                    }

            @Override
                    public void onCancel() {


                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });

        /*loginFacebook.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                

            }
        });*/

        getSupportActionBar().hide();

        TextView register = findViewById(R.id.register_now_id);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });




        Button loginClicado = findViewById(R.id.login_button);
        loginClicado.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BancoDeDados.userList.size()==0){
                    BancoDeDados.userList.add(new User("Ad", "Min", "00", "000"));
                }
                Intent intent = new Intent(v.getContext(), HomeActivity.class);

                Bundle bundle = new Bundle();

                final AutoCompleteTextView emailDigitado = findViewById(R.id.email_id);
                final EditText passwordDigitado = findViewById(R.id.password_id);

                Button buttonLogin = findViewById(R.id.login_button);

                for (User user: BancoDeDados.userList) {
                    if (emailDigitado.getText().toString().equals(user.getEmail()) && passwordDigitado.getText().toString().equals(user.getPassword())){
                        bundle.putString(CHAVE_EMAIL, emailDigitado.getText().toString());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    } else {
                        final int colorDefaultEmail = emailDigitado.getCurrentTextColor();
                        final int colorDefaultPassword = passwordDigitado.getCurrentTextColor();

                        emailDigitado.setTextColor(getResources().getColor(R.color.colorPrimary));
                        passwordDigitado.setTextColor(getResources().getColor(R.color.colorPrimary));

                        Snackbar.make(buttonLogin, "Invalid email and/or password.", Snackbar.LENGTH_INDEFINITE)
                                .setAction("Got it.", new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        emailDigitado.setTextColor(colorDefaultEmail);
                                        passwordDigitado.setTextColor(colorDefaultPassword);
                                    }
                                })
                                .show();
                    }
                }
            }
        });

    }

    public void registerNow(View view) {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }



}