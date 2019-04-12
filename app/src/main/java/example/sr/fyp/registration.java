package example.sr.fyp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity {
   private EditText etuname, etemail,etpassword,etcpassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
       auth=FirebaseAuth.getInstance();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        etuname = (EditText) findViewById(R.id.uname);
        etemail=(EditText) findViewById(R.id.email);
        etpassword=(EditText)findViewById(R.id.password);
        etcpassword=(EditText)findViewById(R.id.cpassword);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etuname.getText().toString().trim();
                String email = etemail.getText().toString().trim();
                String password = etpassword.getText().toString().trim();
                String cpassword = etcpassword.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(),"Enter The Name!", Toast.LENGTH_SHORT).show();
return;
                }
              else   if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter Email Address!", Toast.LENGTH_SHORT).show();
return;
                }

               else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter Password!", Toast.LENGTH_SHORT).show();
return;
                }

               else if (password.length() < 6)
                    if (password.length() < 6) {
                        Toast.makeText(registration.this, "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
return;
                    }
               else if (!password.equals(cpassword)) {
                    Toast.makeText(registration.this, "Please Enter The Same Password", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(registration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(registration.this, "Registration successfull" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);

                                if (!task.isSuccessful()) {
                                    Toast.makeText(registration.this, "Registration unsuccessfull" + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(registration.this, nursery_owner.class));
                                    finish();
                                }
                            }
                        });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}



