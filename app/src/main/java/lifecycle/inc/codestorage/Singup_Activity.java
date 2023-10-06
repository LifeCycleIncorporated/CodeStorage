package lifecycle.inc.codestorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Singup_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText , emailEditText, usernameEditText, passwordEditText;
    private Button singUpSingUpButton, singUpLogInButton;
    UserDetails userDetails;
    SingUpDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nameEditText=findViewById(R.id.sinUpNameEditTextId);
        emailEditText=findViewById(R.id.singUpEmailEditTextId);
        usernameEditText=findViewById(R.id.singUpUsernameEditTextId);
        passwordEditText=findViewById(R.id.singUpPasswordEditTextId);
        
        singUpLogInButton=findViewById(R.id.singUpSingUpId);
        singUpSingUpButton=findViewById(R.id.singUpLoginInId);

        databaseHelper = new SingUpDatabaseHelper(this);

        userDetails = new UserDetails();

        singUpSingUpButton.setOnClickListener(this);
        singUpLogInButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.singUpSingUpId)
        {
            String name = nameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // jodi kono ghor khali rakhe tahole ei if jak korobe;
            if (name.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()){
                Toast.makeText(getApplicationContext(),"Please insert data",Toast.LENGTH_SHORT).show();

            }
            // jodi sob ghor purrno kora hoy tahole else kaj korobe;
            else {
                userDetails.setName(name);
                userDetails.setEmail(email);
                userDetails.setUsername(username);
                userDetails.setPassword(password);


                // sob kichu thik thakole SingUpDatabaseHelper clss e data pathabe
                long rowId = databaseHelper.insertData(userDetails);

                if (rowId>0) {
                    Toast.makeText(getApplicationContext(),"Row "+rowId+" is inserted successful",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Row "+ rowId+" is inserted failed",Toast.LENGTH_SHORT).show();
                }
                nameEditText.setText("");
                emailEditText.setText("");
                usernameEditText.setText("");
                passwordEditText.setText("");
            }
        }

        else if (view.getId() == R.id.singUpLoginInId)
        {
            Intent intent = new Intent(Singup_Activity.this,SingInSingUp_Activity.class);
            startActivity(intent);
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