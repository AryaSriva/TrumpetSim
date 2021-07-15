package my.app.trumpetsim;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class TutorialActivity extends AppCompatActivity {
    @SuppressLint("ClickableViewAccessibility")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorialpage);
        final int blue = Color.parseColor("#0000FF");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final Button how_to_play = this.findViewById(R.id.how_to_play);
        final Intent how_to_intent = new Intent(this, HowtoPlayActivity.class);
        how_to_play.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    how_to_play.setBackgroundColor(blue);
                    startActivity(how_to_intent);
                }
                return true;
            }
        });
        final Button about_the_trumpet = this.findViewById(R.id.about_the_trumpet);
        final Intent about_intent = new Intent(this, AboutActivity.class);
        about_the_trumpet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    about_the_trumpet.setBackgroundColor(blue);
                    startActivity(about_intent);
                }
                return true;
            }
        });
        final Button back_to_start2 = this.findViewById(R.id.back_to_start3);
        final Intent back_intent = new Intent(this, MainActivity.class);
        back_to_start2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    back_to_start2.setBackgroundColor(blue);
                    startActivity(back_intent);
                }
                return true;
            }
        });
    }
}
