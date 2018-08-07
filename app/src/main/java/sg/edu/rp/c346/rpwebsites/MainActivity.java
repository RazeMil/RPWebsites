package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spnCat;
    Spinner spnSub;
    Button btnGo;

    ArrayList<String> alList;
    ArrayAdapter<String> aaList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCat = findViewById(R.id.spinnerCat);
        spnSub = findViewById(R.id.spinnerSub);
        btnGo = findViewById(R.id.buttonGo);

        alList = new ArrayList<>();

         String[] Site = getResources().getStringArray(R.array.RP);
        alList.addAll(Arrays.asList(Site));

        aaList = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,alList);
        spnSub.setAdapter(aaList);

        spnCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                alList.clear();
                switch (i){
                    case 0:
                        String[] Site = getResources().getStringArray(R.array.RP);

                        //Convert Array to List and add to the ArrayList
                        alList.addAll(Arrays.asList(Site));
                        break;

                    case 1:
                        String[] Site2 = getResources().getStringArray(R.array.SOI);

                        //Convert Array to List and add to the ArrayList
                        alList.addAll(Arrays.asList(Site2));
                        break;

                }
                aaList.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Cat = spnCat.getSelectedItemPosition();
                int Sub = spnSub.getSelectedItemPosition();
                alList.clear();

                if (Cat == 0) {
                    if (Sub == 0) {
                        String url = "https://www.rp.edu.sg/";
                        Intent Page = new Intent(getBaseContext(), Webpage.class);
                        Page.putExtra("URL", url);
                        startActivity(Page);

                    } else {
                        String url = "https://www.rp.edu.sg/student-life";
                        Intent Page = new Intent(getBaseContext(), Webpage.class);
                        Page.putExtra("URL", url);
                        startActivity(Page);
                    }

                } else {
                    if (Sub == 0) {
                        String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                        Intent Page = new Intent(getBaseContext(), Webpage.class);
                        Page.putExtra("URL", url);
                        startActivity(Page);

                    } else {
                        String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                        Intent Page = new Intent(getBaseContext(), Webpage.class);
                        Page.putExtra("URL", url);
                        startActivity(Page);

                    }
                }}

            });
        }
        @Override
        protected void onPause() {
            super.onPause();
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor prefEdit = prefs.edit();
            int selectedPosition = spnCat.getSelectedItemPosition();
            int selectedPosition2 = spnSub.getSelectedItemPosition();
            prefEdit.putInt("Cat", selectedPosition);
            prefEdit.putFloat("Sub", selectedPosition2);
            prefEdit.commit();

        }

     @Override
    protected void onResume() {
         super.onResume();
         SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
         int selectedPosition =  prefs.getInt("Cat",0);
         int selectedPosition2 =  prefs.getInt("Sub",0);



     }}