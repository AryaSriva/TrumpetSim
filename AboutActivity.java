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


public class AboutActivity extends AppCompatActivity {
    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutthetrumpet);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final int blue = Color.parseColor("#0000FF");
        final Button back_to_start = this.findViewById(R.id.back_to_start);
        final Intent back_intent = new Intent(this, TutorialActivity.class);
        back_to_start.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    back_to_start.setBackgroundColor(blue);
                    startActivity(back_intent);
                }
                return true;
            }
        });
        final TextView text = findViewById(R.id.about_text);
        text.setText("The Trumpet is a member of the Brass Family.\n" +
                "To produce sound from a Trumpet, a player must buzz into their mouthpiece.\n" +
                "Buzzing is when the trumpet player pushes their lips together and blow air through the lips to create a buzzing sound effect.\n" +
                " When the player does this, they form an embouchure with their lips, which is the positioning of the lips to correctly and cleanly buzz into the Trumpet.\n" +
                " The Trumpet has 3 valves, giving a Trumpeter a total of 8 distinct fingerings to play notes with.\n" +
                " Since there are only 8 fingerings, a lot of notes share fingerings, such as F and Bb.\n" +
                " To help distinguish between notes, the Trumpet player must change their embouchure and the amount of air they use" +
                " To produce higher pitched notes, faster air and tighter lips are required. Inversely, lower notes need slower air and looser lips.\n" +
                " The Trumpet is a chromatic instrument, with the lowest note fingering possible being all 3 valves, and the highest note fingering possible being open.\n" +
                " The Trumpet is also the highest pitched Brass Instrument, often taking the melody in many songs.\n" +
                " The sign of an amazing Trumpeter is not only their range, but also their articulation, intonation, rhythm, and pitch accuracy.\n" +
                " The lowest note on the Trumpet is a F#, but many professionals can go even lower than that.\n" +
                " Similarly, they can also play higher than a C above the Staff, which is considered the highest note possible for beginner to average level players");
    }
}
