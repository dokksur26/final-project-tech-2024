package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class ResourceMain extends AppCompatActivity {
    String ResourceList [] ={"Seattle Aquarium Conservation","Clean Air Task Force", "Save the Children", "Greenpeace","Science Friday", "Rainforest Alliance","Oceana", "The Climate Foundation", "Earthjustice","Sierra Club","World Agroforestry Centre","Rainforest Action Network","Food & Water Watch","Conservation International","Global Green USA","Earth Island Institute"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Activity 2");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            listView = (ListView) findViewById(R.id.ListView);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                    (this, R.layout.activity_list_view,R.id.textView, ResourceList);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Log.i("LIST_VIEW", "This item has been clicked @ position" + position);
                }
            });
            return insets;
        });
    }
}