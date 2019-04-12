package example.sr.fyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class nursery_owner extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursery_owner);
        tv=(TextView) findViewById(R.id.addplant);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(nursery_owner.this,add_plant.class);
                startActivity(intent);

            }
        });

        ImageView ivGraphRepoting = findViewById(R.id.ivGraphReporting);
        ImageView ivProgressMonitoring = findViewById(R.id.ivProgressReporting);
        ivGraphRepoting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GraphReportActivity.class);
                startActivity(intent);
            }
        });

        ivProgressMonitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProgressReportActivity.class);
                startActivity(intent);
            }
        });

    }
}
