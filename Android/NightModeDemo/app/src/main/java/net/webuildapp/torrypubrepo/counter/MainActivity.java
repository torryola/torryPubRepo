package net.webuildapp.torrypubrepo.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private int iCounter;
    private TextView txtCounter;
    private ImageButton imgPlus;
    private ImageButton imgMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCounter = (TextView) findViewById(R.id.tv_Count);
        imgMinus = (ImageButton) findViewById(R.id.decreaseCounter);
        imgPlus = (ImageButton) findViewById(R.id.increaseCounter);

        // Add click Listeners
        imgPlus.setOnClickListener(MainActivity.this::plusCounter); // Method Ref Style
        imgMinus.setOnClickListener(view -> minusCounter()); // Lambda Style

    }//End onCreate

    // Set Count Values
    private void set_CounterValue(int iVal)
    {
        txtCounter.setText(String.valueOf(iVal));
    }

    private void minusCounter()
    {
        if (iCounter > 0)
            iCounter--;
        else
            iCounter = 0;

        set_CounterValue(iCounter);

    }//End setCounter(View view)

    private void plusCounter(View view)
    {
        iCounter++;
        set_CounterValue(iCounter);

    }//End setCounter(View view)

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu
        getMenuInflater().inflate(R.menu.main_menu, menu);

        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle("Day Mode");
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }

       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == R.id.night_mode)
        {
            // Check the Night Mode state
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            Toast.makeText(this, "Night Mode :"+nightMode, Toast.LENGTH_SHORT).show();

            // Set Night Mode for Restarted Activity
            if (   nightMode == AppCompatDelegate.MODE_NIGHT_NO ||
                    nightMode == AppCompatDelegate.MODE_NIGHT_UNSPECIFIED ||
                nightMode == AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            // restart Activity
            recreate();
        }
        return true;
    }//End onOptionsItemSelected(@NonNull MenuItem item)

}//End MainActivity