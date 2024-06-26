package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
    String ResourceList [] ={"Seattle Aquarium Conservation","Clean Air Task Force", "Save the Children", "Greenpeace","Science Friday", "Rainforest Alliance","Oceana", "The Climate Foundation", "Earthjustice","Sierra Club","World Agroforestry Centre","Rainforest Action Network","Food & Water Watch","Conservation International","Global Green USA","Earth Island Institute"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Activity 1");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void previousMonthAction(View view) {
    }

    public void nextMonthAction(View view) {
    }

    public void OpenResources(View view) {
        startActivity(new Intent(this, ResourceMain.class));
    }

    public void OpenCalendar(View view) {
        startActivity(new Intent(this, CalendarMain.class));
    }
}