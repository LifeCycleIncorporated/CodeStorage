package lifecycle.inc.codestorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Display_Only_activity extends AppCompatActivity {

    private TextView titleTv, detailsTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_only);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        titleTv=findViewById(R.id.displayTitleTextOnlyId);
        detailsTv=findViewById(R.id.displayDetailTextOnlyId);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null)
        {
            String details = bundle.getString("AtoZ");
            titleTv.setText(details);

            String details1 = bundle.getString("AtoZ2");
            detailsTv.setText(details1);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}