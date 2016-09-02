package comsiteandrealevysprograms.google.sites.whataretheodds;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

   private EditText actionInput;
   private EditText oddsInput;
   private EditText yourNumberInput;


   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
      actionInput = (EditText) findViewById(R.id.action);
      oddsInput = (EditText) findViewById(R.id.oddsNumber);
      yourNumberInput = (EditText) findViewById(R.id.yourNumber);

      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      fab.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View view)
         {
            String actionString = actionInput.getText().toString();
            String oddsString = oddsInput.getText().toString();
            String yourNumberString = yourNumberInput.getText().toString();

            Log.i("action", actionString);
            Log.i("odds", "the odds are 1 in " + oddsString);
            Log.i("your number", yourNumberString);

            String result = dare(actionString,oddsString,yourNumberString);

            Snackbar.make(view, result, Snackbar.LENGTH_SHORT).show();
         }
      });
   }

   public String dare (String actionString,  String oddsString, String yourNumberString)
   {
      //This part of the program adds all user input to the Logs


      if (!(oddsString.isEmpty() || yourNumberString.isEmpty()) )
      {
         int odds = Integer.parseInt(oddsString);
         int yourNumber = Integer.parseInt(yourNumberString);

         if (yourNumber > odds)
         {
            return "Your number is invalid!";
         }
         if (actionString.isEmpty())
         {
            return  "You did not pick an action!";
         }
         //Getting the computer's random guess
         int computerNumber = getComputerNumber(odds);
         Log.i("computer's number", String.valueOf(computerNumber));
         if (computerNumber == yourNumber)
         {
            return "Go ahead and " + actionString + "!";
         }
         return "The computer did not guess your number";
      }
      if (oddsString.isEmpty())
      {
         return "One out of nothing...";
      }
      return  "You didn't pick a number";
   }

   private int getComputerNumber(int n)
   {
      Random random = new Random();
      return random.nextInt(n) + 1;
   }

}
