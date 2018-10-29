package com.example.andreza.harvardmuseums.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.andreza.harvardmuseums.R;

public class LoginActivity extends AppCompatActivity {


    public static final String CHAVE_EMAIL = "chave_email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                Intent intent = new Intent(v.getContext(), HomeActivity.class);

                Bundle bundle = new Bundle();

                final AutoCompleteTextView emailDigitado = findViewById(R.id.email_id);
                final EditText passwordDigitado = findViewById(R.id.password_id);

                Button buttonLogin = findViewById(R.id.login_button);

                if (emailDigitado.getText().toString().equals(passwordDigitado.getText().toString())) {
                    bundle.putString(CHAVE_EMAIL, emailDigitado.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    emailDigitado.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    passwordDigitado.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    Snackbar.make(buttonLogin, "Email e/ou senha incorreto(s)", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Ok, entendi.", new View.OnClickListener(){
                                @Override
                                public void onClick(View view) {
                                    emailDigitado.setTextColor(getResources().getColor(R.color.colorPrimary));
                                    passwordDigitado.setTextColor(getResources().getColor(R.color.colorPrimary));
                                }
                            })
                            .show();
                }

            }
        });
    }



    public void registerNow(View view) {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}

