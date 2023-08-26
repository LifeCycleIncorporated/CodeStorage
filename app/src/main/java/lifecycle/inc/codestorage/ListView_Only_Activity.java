package lifecycle.inc.codestorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView_Only_Activity extends AppCompatActivity {

    private ListView listViewOnly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_only);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listViewOnly=findViewById(R.id.listViewOnlyId);

        String[] countryNameOnly = getResources().getStringArray(R.array.country_name_only);
        String countryName = getResources().getString(R.string.OnlyText1);
        String countryName3 = getResources().getString(R.string.OnlyText3);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(ListView_Only_Activity.this,
                R.layout.simple_view_only,R.id.simpleTextViewOnlyId,countryNameOnly);
        listViewOnly.setAdapter(adapter);

        listViewOnly.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(ListView_Only_Activity.this, Display_Only_activity.class);
                intent.putExtra("AtoZ", countryNameOnly[i]);
                intent.putExtra("AtoZ2", countryName);
                startActivity(intent);
            }
        });
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