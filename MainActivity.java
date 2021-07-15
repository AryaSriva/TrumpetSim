package my.app.trumpetsim;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;



public  class MainActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);
        final int blue = Color.parseColor("#0000FF");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final Button start = this.findViewById(R.id.start_button);
        final Intent intent = new Intent(this, AppActivity.class);
        start.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    start.setBackgroundColor(blue);
                    startActivity(intent);
                }
                return true;
            }
        });
        final Button tutorial = this.findViewById(R.id.tutorial_button);
        final Intent tutorial_intent = new Intent(this, TutorialActivity.class);
        tutorial.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    tutorial.setBackgroundColor(blue);
                    startActivity(tutorial_intent);
                }
                return true;
            }
        });
    }
}



