package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_menuoption,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id=item.getItemId();
        if(id==R.id.action_settings)
        {
            Intent set=new Intent(MainActivity.this,settings.class);
            startActivity(set);
        }
        if(id==R.id.action_home)
        {
            Intent home=new Intent(MainActivity.this,home.class);
            startActivity(home);
        }
        if(id==R.id.action_contact)
        {
            Intent contact=new Intent(MainActivity.this,contact.class);
            startActivity(contact);
        }
        if(id==R.id.action_share)
        {
            Intent share=new Intent(MainActivity.this,share.class);
            startActivity(share);
        }
        return super.onOptionsItemSelected(item);
    }
}