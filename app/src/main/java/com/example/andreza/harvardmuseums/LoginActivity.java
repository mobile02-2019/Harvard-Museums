package com.example.andreza.harvardmuseums;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private List<User> userList = new ArrayList<>();


    public static final String CHAVE_EMAIL = "chave_email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView register = findViewById(R.id.register_now_id);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CadastroActivity.class);
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




//    public void loginClicado(View view) {
//        Intent intent = new Intent(this, HarvardMuseumsMainActivity.class);
//
//        Bundle bundle = new Bundle();
//
//        final AutoCompleteTextView emailDigitado = findViewById(R.id.email_id);
//        final EditText passwordDigitado = findViewById(R.id.password_id);
//
//        Button buttonLogin = findViewById(R.id.login_button);
//
//        if (emailDigitado.getText().toString().equals(passwordDigitado.getText().toString())) {
//            bundle.putString(CHAVE_EMAIL, emailDigitado.getText().toString());
//            intent.putExtras(bundle);
//            startActivity(intent);
//        } else {
//            emailDigitado.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
//            passwordDigitado.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
//
//            Snackbar.make(buttonLogin, "Email e/ou senha incorreto(s)", Snackbar.LENGTH_INDEFINITE)
//                    .setAction("Ok, entendi.", new View.OnClickListener(){
//                        @Override
//                        public void onClick(View view) {
//                            emailDigitado.setTextColor(getResources().getColor(R.color.colorPrimary));
//                            passwordDigitado.setTextColor(getResources().getColor(R.color.colorPrimary));
//                        }
//                    })
//                    .show();
//        }
//
//    }


    public void registerNow(View view) {
        Intent intent = new Intent(this,CadastroActivity.class);
        startActivity(intent);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

