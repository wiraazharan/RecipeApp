package com.magic.wiraazharan.fortitudeasia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity  {

    public int location=0;

    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String[] vegetarian ={"veg recipe 1","veg recipe 2"};
        String[] fastfood ={"ff recipe 1","ff recipe 2"};
        String[] healthy ={"heal recipe 1","heal recipe 2"};
        String[] nocook ={"nocook recipe 1","nocook recipe 2"};
        String[] makeahead ={"makeahead recipe 1","makeahead recipe 2"};


        final ArrayAdapter adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,vegetarian);
        final ArrayAdapter adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fastfood);
        final ArrayAdapter adapter3 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,healthy);
        final ArrayAdapter adapter4 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,nocook);
        final ArrayAdapter adapter5 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,makeahead);

        final ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter1);


        Spinner s1 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.recipetype, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        showToast("Spinner1: position=" + position + " id=" + id);
                        if (id == 0)
                            listView.setAdapter(adapter1);
                        else if (id == 1) {
                            location = 3;
                            listView.setAdapter(adapter2);
                        }
                        else if (id == 2) {
                            location = 5;
                            listView.setAdapter(adapter3);
                        }
                        else if (id == 3) {
                            location = 7;
                            listView.setAdapter(adapter4);
                        }
                        else if (id == 4) {
                            location = 9;
                            listView.setAdapter(adapter5);
                        }

                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        showToast("Spinner1: unselected");
                    }
                });



                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        // selected item
                        int y=location+i;
                        showToast(y+"  ");


                        // Launching new Activity on selecting single List Item
                        Intent b = new Intent(getApplicationContext(), RecipePage.class);
                        // sending data to new activity
                        b.putExtra("recipe", y);
                        startActivity(b);
                    }
                });


                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //adapterView.remove(listView.getItem(i).toString());
                        return true;
                    }
                });




    }

}
