package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
public class calendarmain {
    public class MainActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener
    {
        private TextView monthYearText;
        private RecyclerView calendarRecyclerView;
        private LocalDate selectedDate;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);
            initWidgets();
            selectedDate = LocalDate.now();
            setMonthView();
        }



        private void initWidgets()
        {
            calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
            monthYearText = findViewById(R.id.monthYearTV);
        }
        private void setMonthView() {
            monthYearText.setText(monthYearFromDate(selectedDate));
            ArrayList<String> daysInMonth = daysInMonthArray(selectedDate);

            CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
            calendarRecyclerView.setLayoutManager(layoutManager);
            calendarRecyclerView.setAdapter(calendarAdapter);
        }

        private ArrayList<String> daysInMonthArray(LocalDate date)
        {
            ArrayList<String> daysInMonthArray = new ArrayList<>();
            YearMonth yearMonth = YearMonth.from((TemporalAccessor) date);
            int daysInMonth = yearMonth.lengthOfMonth();
            LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
            int dayOfWeek = firstOfMonth.getDayOfWeek();

            for(int i = 1; i <= 42; i++){
                if(i<=dayOfWeek || i > daysInMonth + dayOfWeek) {
                    daysInMonthArray.add("");
                }
                else {
                    daysInMonthArray.add(String.valueOf(i - dayOfWeek));
                }
            }
            return daysInMonthArray;
        }

        private String monthYearFromDate(LocalDate date)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            return date.format(formatter);
        }

        public void previousMonthAction(View view) {
            selectedDate = selectedDate.minusMonths(1);
            setMonthView();
        }

        public void nextMonthAction(View view) {
            selectedDate = selectedDate;
            setMonthView();
        }

        @Override
        public void onItemClick(int position, String dayText) {
            if(dayText.equals("")){
                String message = "Selected Date" + dayText + "" + monthYearFromDate(selectedDate);
                Toast.makeText(this,message, Toast.LENGTH_LONG).show();
            }

        }
    }
}
