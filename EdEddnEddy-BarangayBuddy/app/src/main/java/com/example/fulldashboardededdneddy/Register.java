package com.example.fulldashboardededdneddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Register extends AppCompatActivity {

    private boolean passwordShowing = false;
    private boolean conPasswordShowing = false;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        final EditText email = findViewById(R.id.emailET);
        final EditText mobile = findViewById(R.id.mobileET);

        final EditText password = findViewById(R.id.passwordET);
        final EditText conPassword = findViewById(R.id.conPasswordET);
        final ImageView passwordIcon = findViewById(R.id.passwordIcon);
        final ImageView conPasswordIcon = findViewById(R.id.conPasswordIcon);

        final AppCompatButton signUpBtn = findViewById(R.id.signUpBtn);
        final ProgressBar progressBar = findViewById(R.id.progressBar);
        final TextView signInBtn = findViewById(R.id.signInBtn);

        passwordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Checking if password is showing or not
                if (passwordShowing) {
                    passwordShowing = false;
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.eye_password_show);
                } else {
                    passwordShowing = true;
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.eye_password_hide);

                }
                // move the cursor at last of the text
                password.setSelection(password.length());
            }
        });

        conPasswordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Checking if password is showing or not
                if (conPasswordShowing) {
                    conPasswordShowing = false;
                    conPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    conPasswordIcon.setImageResource(R.drawable.eye_password_show);
                } else {
                    conPasswordShowing = true;
                    conPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    conPasswordIcon.setImageResource(R.drawable.eye_password_hide);

                }
                // move the cursor at last of the text
                conPassword.setSelection(conPassword.length());
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String getMobileTxt = mobile.getText().toString();
                final String getEmailTxt = email.getText().toString();
                final String getPassword = password.getText().toString();
                final String getConPassword = conPassword.getText().toString();

                if (getMobileTxt.isEmpty() || getEmailTxt.isEmpty() || getPassword.isEmpty() || getConPassword.isEmpty()) {
                    Toast.makeText(Register.this, "Fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!getPassword.equals(getConPassword)) {
                    Toast.makeText(Register.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (getMobileTxt.isEmpty()) {
                    Toast.makeText(Register.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                signUpBtn.setVisibility(View.INVISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(getEmailTxt, getPassword)
                        .addOnCompleteListener(Register.this, task -> {
                            progressBar.setVisibility(View.GONE);
                            signUpBtn.setVisibility(View.VISIBLE);

                            if (task.isSuccessful()) {
                                // Registration successful
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                Toast.makeText(Register.this, "Registration successful please wait", Toast.LENGTH_SHORT).show();

                            } else {
                                // Registration failed
                                Toast.makeText(Register.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+63" + mobile.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        Register.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                progressBar.setVisibility(View.GONE);
                                signInBtn.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                signInBtn.setVisibility(View.VISIBLE);
                                Toast.makeText(Register.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                                progressBar.setVisibility(View.GONE);
                                signInBtn.setVisibility(View.VISIBLE);
                                //opening OTP Verification Activity along with mobile and email
                                Intent intent = new Intent(Register.this, OTPVerification.class);
                                intent.putExtra("mobile", getMobileTxt);
                                intent.putExtra("verificationId", verificationId);
                                startActivity(intent);
                            }
                        }
                );


            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}