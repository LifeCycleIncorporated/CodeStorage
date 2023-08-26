package lifecycle.inc.codestorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Custom_ListView_Activity extends AppCompatActivity {
    private ListView ListView;
    private String[] CountryName;
    private int[] flags =
            {R.drawable.bangladesh,
                    R.drawable.pakistan,
                    R.drawable.india,
                    R.drawable.canada,
                    R.drawable.brazil,
                    R.drawable.saudi,
                    R.drawable.japan,
                    R.drawable.america,
                    R.drawable.argentina,
                    R.drawable.china,
                    R.drawable.jarman,
                    R.drawable.nepal,
                    R.drawable.bhutan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list_view_activity);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        CountryName = getResources().getStringArray(R.array.country_name);

        ListView=findViewById(R.id.sexyListViewId);

        CustomAdapter adapter = new CustomAdapter(this,CountryName,flags);
        ListView.setAdapter(adapter);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(Custom_ListView_Activity.this,""+(i+1),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Custom_ListView_Activity.this,Display_Activity.class);
                intent.putExtra("sexy_image", flags[i]);
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