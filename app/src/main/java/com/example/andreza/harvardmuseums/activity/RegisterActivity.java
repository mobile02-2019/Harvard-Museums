package com.example.andreza.harvardmuseums.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.andreza.harvardmuseums.User;
import com.example.andreza.harvardmuseums.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "Register";
    private TextInputEditText firstNameInput;
    private TextInputEditText lastNameInput;
    private TextInputEditText emailInput;
    private TextInputEditText passwordInput;
    private TextInputEditText passwordConfirmInput;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button register = findViewById(R.id.register_button_id);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarUsuario();
            }

        });
    }

    public void goToHomeActivity() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    private void criarUsuario() {
        firstNameInput = findViewById(R.id.edit_text_firstname_id);
        emailInput = findViewById(R.id.edit_text_email_id);
        passwordInput = findViewById(R.id.edit_text_password_id);
        passwordConfirmInput = findViewById(R.id.edit_text_password_confirm_id);

        if (passwordConfirmInput.getText().toString().equals(passwordInput.getText().toString())) {
            mAuth.createUserWithEmailAndPassword(emailInput.getText().toString(), passwordInput.getText().toString())
                    .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //criarUsuario();
                                //TODO mexi a partir daqui
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getInstance().getCurrentUser();
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(firstNameInput.getText().toString())
                                        //.setDisplayName(lastNameInput.getText().toString())
                                        .build();

                                user.updateProfile(profileUpdates)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Log.d(TAG, "User profile updated.");
                                                    goToHomeActivity();
                                                }
                                            }
                                        });

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            goToHomeActivity();

        } else {
            Toast.makeText(RegisterActivity.this, "Both passwords must match.", Toast.LENGTH_SHORT).show();
        }
    }
}

    /*private void criarUsuario() {
        User usuarioCriado = new User(firstNameInput.getText().toString(),
                lastNameInput.getText().toString(), emailInput.getText().toString());
        registrarDados("User: "+usuarioCriado.getFirstName()+" "+usuarioCriado.getLastName()+" - UID: "+FirebaseAuth.getInstance().getUid(), usuarioCriado);
        Log.d(TAG, "createUserWithEmail:success");
        Toast.makeText(RegisterActivity.this, "Successfully registered! Enjoy our Gallery!", Toast.LENGTH_LONG).show();
    }

    private void registrarDados(String path, Object value){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference currentRef = database.getReference(path);
        currentRef.setValue(value);
        goToHomeActivity();
    }*/
