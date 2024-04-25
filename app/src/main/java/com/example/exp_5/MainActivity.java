package com.example.exp_5;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {

    TextView username1,password1;
    @Override
    public void applyTexts(String username, String password) {
        username1.setText(username);
        password1.setText(password);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        username1=findViewById(R.id.textView);
        password1=findViewById(R.id.textView1);
        Button open=findViewById(R.id.button2);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog();
            }
        });
        registerForContextMenu(username1);
    }

    public void opendialog(){
        ExampleDialog exampledialog=new ExampleDialog();
        exampledialog.show(getSupportFragmentManager(),"example_dialog");
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose your option");
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Ite1:
                Toast.makeText(this,"Text printed",Toast.LENGTH_LONG).show();
                return true;

            case R.id.Ite2:
                Toast.makeText(this,"Text copied",Toast.LENGTH_LONG).show();
                return true;

            case R.id.Ite3:
                Toast.makeText(this,"Text copied as link",Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.first:
                Toast.makeText(this,"Opening Help ",Toast.LENGTH_LONG).show();
                return true;

            case R.id.second:
                Toast.makeText(this,"Opening Customization tools",Toast.LENGTH_LONG).show();
                return true;

            case R.id.third:
                Toast.makeText(this,"Opening Settings",Toast.LENGTH_LONG).show();
                return true;

            case R.id.fourth:
                Toast.makeText(this,"Opening App Settings",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void Showpopup(View view){
        PopupMenu popupMenu=new PopupMenu(MainActivity.this,view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.Item1:
                        Toast.makeText(MainActivity.this,"Text edited",Toast.LENGTH_LONG).show();
                        return true;

                    case R.id.Item2:
                        Toast.makeText(MainActivity.this,"Text copied",Toast.LENGTH_LONG).show();
                        return true;

                    case R.id.Item3:
                        Toast.makeText(MainActivity.this,"Cancelled",Toast.LENGTH_LONG).show();
                        return true;

                    default:
                        return false;
                }
            }
        });
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.show();
    }
}
