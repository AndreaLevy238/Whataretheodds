package comsiteandrealevysprograms.google.sites.whataretheodds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void dare(View view)
    {
        EditText actionInput = (EditText) findViewById(R.id.action);
        String actionString = actionInput.getText().toString();
        Log.i("action",actionString);
        EditText oddsInput = (EditText) findViewById(R.id.oddsNumber);
        String oddsString = oddsInput.getText().toString();
        Log.i("odds", "the odds are 1 in " + oddsString);
        int odds = Integer.parseInt(oddsString);
        EditText yourNumberInput = (EditText) findViewById(R.id.yourNumber);
        String yourNumberString = yourNumberInput.getText().toString();
        Log.i("your number", yourNumberString);
        int yourNumber = Integer.parseInt(yourNumberString);
        if (yourNumber > odds)
        {
            Toast.makeText(getApplicationContext(), "Your number is invalid!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            int computerNumber = getComputerNumber(odds);
            Log.i("computer's number", String.valueOf(computerNumber));
            if (computerNumber == yourNumber)
            {
                Toast.makeText(getApplicationContext(), "Go ahead and " + actionString + "!", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "The computer did not guess your number", Toast.LENGTH_LONG).show();
            }
        }

    }


    private int getComputerNumber(int n)
    {
        Random random = new Random();
        return random.nextInt(n) + 1;
    }
}
