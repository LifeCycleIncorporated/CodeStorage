package lifecycle.inc.codestorage;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Display_Activity extends AppCompatActivity {


    private ImageView displayImageView;
    private Button shareButton,randomNumberButton;
    private TextView randomNumberTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        displayImageView=findViewById(R.id.displayImageViewId);
        shareButton=findViewById(R.id.shareButtonId);
        randomNumberButton=findViewById(R.id.randomNumberButtonId);
        randomNumberTextView=findViewById(R.id.randomNumberTextViewId);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null)
        {
            int sexyImage = bundle.getInt("sexy_image");
            displayImageView.setImageResource(sexyImage);

        }


        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,shareButton.getText().toString());
                intent.setType("text/plain");
                intent = Intent.createChooser(intent,"Share and publish");
                startActivity(intent);
            }
        });

        randomNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //random
                Random random = new Random();
                int randomNumber = random.nextInt(9)+1;

                randomNumberTextView.setText("Random : "+randomNumber);
            }


        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
