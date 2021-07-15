package my.app.trumpetsim;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class HowtoPlayActivity extends AppCompatActivity {
    @SuppressLint({"ClickableViewAccessibility", "ResourceType", "SetTextI18n"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.howtoplay);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final int blue = Color.parseColor("#0000FF");
        final Button back_to_start1 = this.findViewById(R.id.back_to_start1);
        final Intent intent = new Intent(this, TutorialActivity.class);
        back_to_start1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    back_to_start1.setBackgroundColor(blue);
                    startActivity(intent);
                }
                return true;
            }
        });
        final TextView text1 = findViewById(R.id.how_to_text);
        text1.setText("PLEASE READ!!!!  The TrumpetSim App allows you to play 2 octaves, starting from the c below the staff to the C above the staff. \n" +
                "To play a note, simply press the button labeled with the note you wish to play. \n" +
                "The note will hold for as long as you hold the button. \n" +
                "For realism, there will be a short pause after holding a note for too long. This is to simulate a breath. \n" +
                "Please realize that this app is in Alpha and more updates will (hopefully) come.");
    }
}
