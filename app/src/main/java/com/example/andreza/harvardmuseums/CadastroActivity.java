package com.example.andreza.harvardmuseums;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends Activity {
    private TextInputEditText firstName;
    private TextInputEditText lastName;
    private TextInputEditText email;
    private TextInputEditText password;
    private TextInputEditText passwordConfirm;
    private List<User> registeredUsers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

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
                    registeredUsers.add(new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), password.getText().toString()));
                    Toast.makeText(CadastroActivity.this, "Successfully registered! Enjoy our Gallery!", Toast.LENGTH_SHORT).show();
                    goToHomeActivity();
                }
            }
        });

    }


    public boolean validateUserInfo(TextInputEditText firstName, TextInputEditText lastName, TextInputEditText email, TextInputEditText password, TextInputEditText passwordConfirm){
        boolean infoIsValid = true;

        if (firstName.getText().toString().contains(" ")){
            Toast.makeText(CadastroActivity.this, "Your First Name is invalid. It cannot contain space.", Toast.LENGTH_LONG).show();
            infoIsValid = false;
        }

        if (lastName.getText().toString().contains(" ")){
            Toast.makeText(CadastroActivity.this, "Your Last Name is invalid. It cannot contain space.", Toast.LENGTH_LONG).show();
            infoIsValid = false;
        }

        if (!email.getText().toString().contains("@")){
            Toast.makeText(CadastroActivity.this, "The email is invalid. Example: (yourname@domain.com)", Toast.LENGTH_LONG).show();
            infoIsValid = false;
        }

        if (password.getText().toString().length()<8 || password.getText().toString().length()>20){
            Toast.makeText(this, "Your password is invalid. It must contain 8 to 20 digits and may include symbols, numbers, and uppercase/lowercase letters.", Toast.LENGTH_LONG).show();
            infoIsValid = false;
        }

        if (!passwordConfirm.getText().toString().equals(password.getText().toString())){
            Toast.makeText(this, "Password Confirm is invalid. It must match the Password.", Toast.LENGTH_LONG).show();
            infoIsValid = false;
        }

        return infoIsValid;
    }

    public void goToHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }



}



