package example.sr.fyp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_plant extends AppCompatActivity {
    EditText etpid,etpspecie,etpfamily,etpname,etplocation;
    Button btn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);
        etpid= findViewById(R.id.pid);
        etpspecie= findViewById(R.id.pspecies);
        etpfamily= findViewById(R.id.pfamily);
        etpname= findViewById(R.id.pname);
        etplocation= findViewById(R.id.plocation);
        databaseReference=FirebaseDatabase.getInstance().getReference("plant_add");
        btn= findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchactivity();

            }
        });
    }
    private void launchactivity() {

                String pid = etpid.getText().toString().trim();
                String pspecie = etpspecie.getText().toString().trim();
                String pfamily= etpfamily.getText().toString().trim();
                String pname = etpname.getText().toString().trim();
                String plocation=etplocation.getText().toString().trim();
                if (TextUtils.isEmpty(pid)) {
                    Toast.makeText(this, "Please Enter plant id", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pspecie)) {
                    Toast.makeText(this, "Please Enter plant specie", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pfamily)) {
                    Toast.makeText(this, "Please Enter plant family", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pname)) {
                    Toast.makeText(this, "Please Enter plant name", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(plocation)) {
                    Toast.makeText(this, "Please Enter plant location", Toast.LENGTH_SHORT).show();
                }
                else {
                    String id = databaseReference.push().getKey();
                    add_plant plant= new add_plant();
                    databaseReference.child(id).child("Plant id").setValue(pid);
                    databaseReference.child(id).child("Plant specie").setValue(pspecie);
                    databaseReference.child(id).child("Plant family").setValue(pfamily);
                    databaseReference.child(id).child("Plant name").setValue(pname);
                    databaseReference.child(id).child("Plant location").setValue(plocation);
                    Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show();
                    Cleartxt();

                }

            }

            private void Cleartxt() {
                etpid.setText("");
                etpspecie.setText("");
                etpfamily.setText("");
                etplocation.setText("");
                etpname.setText("");

            }


        }