package com.example.mynotes.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mynotes.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE =
            "com.codinginflow.architectureexample.EXTRA_TITLE";
    public static final String EXTRA_TIME=
            "com.codinginflow.architectureexample.EXTRA_TIME";
    public static final String EXTRA_DATE =
            "com.codinginflow.architectureexample.EXTRA_DATE";
    public static final String EXTRA_PRIORITY =
            "com.codinginflow.architectureexample.EXTRA_PRIORITY";




    EditText note_txt;
    NumberPicker note_number_picker_priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
        // init views

        note_txt=findViewById(R.id.note_txt);



        note_number_picker_priority=findViewById(R.id.note_number_picker_priority);
        note_number_picker_priority.setMinValue(1);
        note_number_picker_priority.setMaxValue(3);





    }

    private void saveNote() {
        String title = note_txt.getText().toString();



        // get date  because the Api want it to get prayers time in this day..
        Date c1 = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        String date  = df.format(c1);

        Date c2 =  Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time = sdf.format(c2);

        int priority = note_number_picker_priority.getValue();

        if (title.trim().isEmpty() || time.trim().isEmpty() || date.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and time and date", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_TIME,time);
        data.putExtra(EXTRA_DATE,date);
        data.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}