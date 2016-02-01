package cs6242.westga.edu.waynemullinsactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE1 = "edu.westga.cs6242.WayneMullinsActivities.MESSAGE1";
    public final static String EXTRA_MESSAGE2 = "edu.westga.cs6242.WayneMullinsActivities.MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Display Activities 1");
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

/*      ORIGINAL CODE PER TUTORIAL
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
*/

//      WITH NEW STUDIO LAYOUT
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(message);
    }

    /** Called when the user clicks the Send button */
    public void nextMessage(View view) {
        Intent intent = new Intent(this, DisplaySecondMessageActivity.class);
        TextView textView = (TextView)findViewById(R.id.textView);
        String message1 = textView.getText().toString();
        EditText editText = (EditText)findViewById(R.id.editText);
        String message2 = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE1, message1);
        intent.putExtra(EXTRA_MESSAGE2, message2);
        startActivity(intent);
    }

}
