package com.example.andreza.harvardmuseums.activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
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
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {


    public static final String CHAVE_EMAIL = "chave_email";
    private static final String TAG = "Login" ;
    //private static final int RC_SIGN_IN = ;
    private FirebaseAuth mAuth;
    private LoginButton loginFacebook;
    private CallbackManager callbackManager;

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode,resultCode,data);

        /*if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
            }
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final AutoCompleteTextView emailDigitado = findViewById(R.id.login_email_id);
        final EditText passwordDigitado = findViewById(R.id.login_password_id);
        final int colorDefaultEmail = emailDigitado.getCurrentTextColor();
        final int colorDefaultPassword = passwordDigitado.getCurrentTextColor();

        mAuth = FirebaseAuth.getInstance();


        //TODO Login Facebook
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

        getSupportActionBar().hide();
        //TODO Google Login
        Button buttonGoogle = findViewById(R.id.login_google_id);
        buttonGoogle.setOnClickListener(new OnClickListener() {
             @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
             }
        });

                mAuth = FirebaseAuth.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();


        //TODO registro
        TextView register = findViewById(R.id.register_now_id);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        // LOGIN COM EMAIL E SENHA

        Button loginClicado = findViewById(R.id.login_button);
        loginClicado.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Estou no loginClicado.OnClick", Toast.LENGTH_SHORT).show();
                final Intent intent = new Intent(v.getContext(), HomeActivity.class);
                final Bundle bundle = new Bundle();


                final Button buttonLogin = findViewById(R.id.login_button);

                if (!emailDigitado.getText().toString().equals("") && !passwordDigitado.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "email e senha tem conteudo, dentro do if de prevencao de NullPointerException", Toast.LENGTH_SHORT).show();
                    mAuth.signInWithEmailAndPassword(emailDigitado.getText().toString(), passwordDigitado.getText().toString())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(LoginActivity.this, "onComplete", Toast.LENGTH_SHORT).show();
                                    if (task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this, "task is successful, auth complete", Toast.LENGTH_SHORT).show();
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "signInWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(LoginActivity.this, "Authentication successful! Enjoy our gallery!", Toast.LENGTH_LONG).show();
                                        bundle.putString(CHAVE_EMAIL, emailDigitado.getText().toString());
                                        intent.putExtras(bundle);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(LoginActivity.this, "task is not successful, auth failed", Toast.LENGTH_SHORT).show();
                                        emailDigitado.setTextColor(getResources().getColor(R.color.colorPrimary));
                                        passwordDigitado.setTextColor(getResources().getColor(R.color.colorPrimary));

                                        Snackbar.make(buttonLogin, "Invalid email and/or password.", Snackbar.LENGTH_INDEFINITE)
                                                .setAction("Got it.", new View.OnClickListener(){
                                                    @Override
                                                    public void onClick(View view) {
                                                        emailDigitado.setTextColor(colorDefaultEmail);
                                                        passwordDigitado.setTextColor(colorDefaultPassword);
                                                    }
                                                }).show();
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    }
                                }
                            });
                } else {
                    Toast.makeText(LoginActivity.this, "You need to provide an email and a password in order to Log In.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //TODO ativar esse método inteiro quando colocar o logout
    @Override
    protected void onStart() {
        super.onStart();

        // JA ESTA LOGADO COM EMAIL E SENHA

        // Check if user is signed in (non-null) and update UI accordingly.
        if(mAuth.getCurrentUser()!=null){
            FirebaseUser currentUser = mAuth.getCurrentUser();
            goToHome();
        }


        //GMAIL
        FirebaseUser currentUser = mAuth.getCurrentUser();

        /*AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        if (isLoggedIn){
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
        }*/
    }

    private void goToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Snackbar.make(findViewById(R.id.login_layout_id), "Authentication Failed.",
                                    Snackbar.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    /*private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }*/

    public void registerNow(View view) {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }



}