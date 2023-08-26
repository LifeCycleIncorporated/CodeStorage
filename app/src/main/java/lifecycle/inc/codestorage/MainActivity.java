package lifecycle.inc.codestorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Initialize variable.
    DrawerLayout drawerLayout;
    ImageView btMenu;
    RecyclerView recyclerView;

    private Button check,
            singInOrSingUpButton,
            sqliteButton,
            customListViewButton,
            listViewButton,
            cardViewButton,
            imageViewButton,
            luduButton,
            rotation,
            animation;

    static ArrayList<String> arrayList = new ArrayList<>();
    MainAdapter adapter;

    public static void classDrawer(DrawerLayout drawerLayout) {
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        //Assign variable
        drawerLayout=findViewById(R.id.drawer_layoutId);
        btMenu=findViewById(R.id.bt_menuId);
        recyclerView=findViewById(R.id.recycler_viewId);


        check=findViewById(R.id.checkId);
        singInOrSingUpButton=findViewById(R.id.singInOrSingUpButtonId);
        sqliteButton=findViewById(R.id.sqliteButtonId);
        customListViewButton=findViewById(R.id.customListViewButtonId);
        listViewButton=findViewById(R.id.listViewButtonId);
        cardViewButton=findViewById(R.id.cardViewButtonId);
        imageViewButton=findViewById(R.id.imageViewButtonId);
        luduButton=findViewById(R.id.luduButtonId);
        rotation=findViewById(R.id.rotationButtonId);
        animation=findViewById(R.id.animationButtonId);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Check_Activity.class);
                startActivity(intent);
            }
        });

        singInOrSingUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SingInSingUp_Activity.class);
                startActivity(intent);
            }
        });

        sqliteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SQLite_Activity.class);
                startActivity(intent);            }
        });


        customListViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Custom_ListView_Activity.class);
                startActivity(intent);
            }
        });
        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListView_Only_Activity.class);
                startActivity(intent);
            }
        });

        cardViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CardView_Activity.class);
                startActivity(intent);
            }
        });
        luduButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Ludu_Activity.class);
                startActivity(intent);
            }
        });
        rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Rotation_Activity.class);
                startActivity(intent);
            }
        });
        animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Animation_Activity.class);
                startActivity(intent);
            }
        });








        //Clear array list.
        arrayList.clear();

        // Add menu item in array list
        arrayList.add("Home");
        arrayList.add("SingIn or SingUp");
        arrayList.add("SQLite");
        arrayList.add("Custom LIstView");
        arrayList.add("ListView");
        arrayList.add("CardView");
        arrayList.add("ImageView");
        arrayList.add("Logout");

        //Initialize adapter
        adapter = new MainAdapter(this,arrayList);
        //Set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Set adapter
        recyclerView.setAdapter(adapter);

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open drawer
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        classDrawer(drawerLayout);
    }
}