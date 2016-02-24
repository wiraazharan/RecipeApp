package com.magic.wiraazharan.fortitudeasia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by wiraazharan on 24/02/16.
 */
public class RecipePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         Intent i = getIntent();
        // getting attached intent data
        int a = i.getIntExtra("recipe", 0);
        setContentView(R.layout.vegetarian1);

        if (a==0){
            setContentView(R.layout.vegetarian1);
        }else if (a==1){
            setContentView(R.layout.vegetarian2);
        }else if (a==3){
            setContentView(R.layout.fastfood1);
        }
        else if (a==4){
            setContentView(R.layout.fastfood2);
        }
        else if (a==5){
            setContentView(R.layout.healthy1);
        }
        else if (a==6){
            setContentView(R.layout.healthy2);
        }
        else if (a==7){
            setContentView(R.layout.nocook1);
        }
        else if (a==8){
            setContentView(R.layout.nocook2);
        }
        else if (a==9){
            setContentView(R.layout.makeahead1);
        }
        else if (a==10){
            setContentView(R.layout.makeahead2);
        }


    }



}
