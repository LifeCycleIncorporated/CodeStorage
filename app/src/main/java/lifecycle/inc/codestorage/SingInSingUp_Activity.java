package lifecycle.inc.codestorage;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SingInSingUp_Activity extends AppCompatActivity implements View.OnClickListener {

    SingUpDatabaseHelper singUpDatabaseHelper;

    private EditText mainUserNameEditText, mainPasswordEditText;
    private Button mainLogInButton, mainSingUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in_sing_up);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mainLogInButton=findViewById(R.id.mainLoginButtonId);
        mainUserNameEditText=findViewById(R.id.mainLoginInUsernameEditTextId);
        mainPasswordEditText=findViewById(R.id.mainLogInPasswordEditTextId);
        mainLogInButton=findViewById(R.id.mainLoginButtonId);
        mainSingUpButton=findViewById(R.id.mainSingUpButtonId);

        singUpDatabaseHelper = new SingUpDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = singUpDatabaseHelper.getWritableDatabase();

        mainLogInButton.setOnClickListener(this);
        mainSingUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String username = mainUserNameEditText.getText().toString();
        String password = mainPasswordEditText.getText().toString();


        if (view.getId()==R.id.mainLoginButtonId){

            Boolean results = singUpDatabaseHelper.findPassword(username,password);
            if(results==true)
            {
                Intent intent = new Intent(SingInSingUp_Activity.this,MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(),"Incorrect User or Password",Toast.LENGTH_SHORT).show();
            }

        }

        else if (view.getId()==R.id.mainSingUpButtonId){
            Intent intent = new Intent(SingInSingUp_Activity.this,Singup_Activity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Error login", Toast.LENGTH_SHORT).show();
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