package example.sr.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class supplier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);

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
