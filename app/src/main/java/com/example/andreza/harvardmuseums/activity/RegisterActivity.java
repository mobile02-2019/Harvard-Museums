package com.example.andreza.harvardmuseums.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import com.example.andreza.harvardmuseums.User;
import com.example.andreza.harvardmuseums.BancoDeDados;
import com.example.andreza.harvardmuseums.R;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText firstName;
    private TextInputEditText lastName;
    private TextInputEditText email;
    private TextInputEditText password;
    private TextInputEditText passwordConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firstName = findViewById(R.id.edit_text_firstname_id);
        lastName = findViewById(R.id.edit_text_lastname_id);
        email = findViewById(R.id.edit_text_email_id);
        password = findViewById(R.id.edit_text_password_id);
        passwordConfirm = findViewById(R.id.edit_text_password_confirm_id);

        Button register = findViewById(R.id.register_button_id);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateUserInfo(firstName, lastName, email, password, passwordConfirm)){
                    BancoDeDados.userList.add(new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), password.getText().toString()));
                    Toast.makeText(RegisterActivity.this, "Successfully registered! Enjoy our Gallery!", Toast.LENGTH_LONG).show();
                    goToHomeActivity();
                }
            }
        });

    }


    public boolean validateUserInfo(TextInputEditText firstName, TextInputEditText lastName, TextInputEditText email, TextInputEditText password, TextInputEditText passwordConfirm){
        boolean infoIsValid = true;

        if (firstName.getText().toString().contains(" ") || firstName.getText().toString().length()==0){
            Toast.makeText(RegisterActivity.this, "Your First Name is invalid. It cannot contain spaces nor be empty.", Toast.LENGTH_LONG).show();
            infoIsValid = false;
        }

        if (lastName.getText().toString().contains(" ") || lastName.getText().toString().length()==0){
            Toast.makeText(RegisterActivity.this, "Your Last Name is invalid. It cannot contain spaces nor be empty.", Toast.LENGTH_LONG).show();
            infoIsValid = false;
        }

        if (!email.getText().toString().contains("@") || !email.getText().toString().contains(".")){
            Toast.makeText(RegisterActivity.this, "The email is invalid. Example: (yourname@domain.com)", Toast.LENGTH_LONG).show();
            infoIsValid = false;
        }

        for (User user: BancoDeDados.userList) {
            if (email.getText().toString().equals(user.getEmail())){
                Toast.makeText(RegisterActivity.this, "There is already an account registered with that email, try another one.", Toast.LENGTH_LONG).show();
                infoIsValid = false;
            }
        }

        if (password.getText().toString().length()<8 || password.getText().toString().length()>20){
            Toast.makeText(this, "Your password is invalid. It must contain 8 to 20 digits and may include symbols, numbers, and uppercase/lowercase letters.", Toast.LENGTH_LONG).show();
            infoIsValid = false;
        }

        if (!passwordConfirm.getText().toString().equals(password.getText().toString())){
            Toast.makeText(this, "Please confirm your password.", Toast.LENGTH_LONG).show();
            infoIsValid = false;
        }

        return infoIsValid;
    }

    public void goToHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}