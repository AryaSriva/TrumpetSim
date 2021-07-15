package my.app.trumpetsim;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;



import java.io.File;
import java.io.IOException;

public class AppActivity extends AppCompatActivity {
    /*public static class Note {
        public Button key;
        public MediaPlayer audio;
        public RectF rectF;
        public boolean isPressed;
        public Note (RectF rectF, Button key, MediaPlayer audio, boolean isPressed) {
            this.audio = audio;
            this.rectF = rectF;
            this.key = key;
            this.isPressed = isPressed;
        }
    }*/
    //private String name = null;
    private int blue = Color.parseColor("#0000FF");
    private int black = Color.parseColor("#000000");
    private int white = Color.parseColor("#FFFFFF");
    //private Note [] buttons;
    private Button [] buttoning;
    private MediaPlayer [] sounds;
 /*   public String audioName(int number) {
        final String []  names = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
        };
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            int n = (int)(Math.random()*names.length);
            stringBuilder.append(names[n]);
        }
        stringBuilder.append("TrumpetSim");
        return stringBuilder.toString();
    } */
 /*  public void makeDirectory(int number) {
        name = Environment.getExternalStorageDirectory().getAbsolutePath();
        String newFolder = "Audio";
        String folder = "TrumpetSimMusic";
        String sep = File.separator;
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        File myNewFolder = new File(extStorageDirectory + sep + newFolder + sep + folder);
        myNewFolder.mkdir();
        name = Environment.getExternalStorageDirectory().toString()
                + sep + newFolder + sep + folder + sep + audioName(number) + "TrumpetSim.mp3";
    } */
    /*@SuppressLint("ClickableViewAccessibility")
    public void record(final Button recordButton, final Button stop, final Button resume, final Button stopPlayback, final Chronometer recordingTime, final MediaRecorder recorder) {
        final String[] Permissions = {
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO
        };
        recordButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    if (ActivityCompat.checkSelfPermission(AppActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                            || ActivityCompat.checkSelfPermission(AppActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                            || ActivityCompat.checkSelfPermission(AppActivity.this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(AppActivity.this, Permissions, 2);
                    } else {
                        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        recorder.setOutputFile(name);
                        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        Toast.makeText(AppActivity.this, "Please make sure your mic and audio is on and read the tutorial", Toast.LENGTH_SHORT).show();
                        try {
                            recorder.prepare();
                            recorder.start();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        stopPlayback.setVisibility(View.VISIBLE);
                        stop.setVisibility(View.VISIBLE);
                        recordButton.setVisibility(View.INVISIBLE);
                        recordingTime.setVisibility(View.VISIBLE);
                        recordingTime.setBase(SystemClock.elapsedRealtime());
                        recordingTime.start();
                    }
                }
                return true;
            }
        });
        stop.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if ((motionEvent.getAction() == MotionEvent.ACTION_DOWN)) {
                    stop.setVisibility(View.INVISIBLE);
                    resume.setVisibility(View.VISIBLE);
                    recordingTime.stop();
                    recorder.pause();
                }
                return true;
            }
        });
        resume.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    resume.setVisibility(View.INVISIBLE);
                    stop.setVisibility(View.VISIBLE);
                    recorder.resume();
                    recordingTime.start();
                }
                return true;
            }
        });
        stopPlayback.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    stop.setVisibility(View.INVISIBLE);
                    stopPlayback.setVisibility(View.INVISIBLE);
                    recordButton.setVisibility(View.VISIBLE);
                    recordingTime.stop();
                    recordingTime.setVisibility(View.INVISIBLE);
                    recorder.stop();
                    recorder.reset();
                }
                return true;
            }
        });
    }*/
    public boolean isBlack(Button button) {
        return button.getId() == R.id.High_Bb || button.getId() == R.id.High_Ab || button.getId() == R.id.High_Gb || button.getId() == R.id.Middle_Eb || button.getId() == R.id.Middle_Db
                || button.getId() == R.id.Middle_Bb || button.getId() == R.id.middle_Ab || button.getId() == R.id.middle_Gb || button.getId() == R.id.low_Eb || button.getId() == R.id.low_Db;
    }
    @SuppressLint("ClickableViewAccessibility")
    public void play(Button [] buttons,  MediaPlayer [] sounds) {
            /*for (Note ignored : buttons) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Note note = findNote(x, y);
                if (note != null) {
                    note.isPressed = d;
                }
            }*/
            /*for (Note button: buttons) {
                if (button.isPressed) {
                    button.key.setBackgroundColor(blue);
                    prepare(button.audio);
                    onPrepared(button.audio);
                } else {
                    stop(button.audio);
                    if (isBlack(button.key)) {
                        button.key.setBackgroundColor(black);
                    } else {
                        button.key.setBackgroundColor(white);
                    }
                }*/
        //}

        for (int index = 0; index < buttoning.length; index++) {
            final Button button = buttons[index];
            final MediaPlayer sound = sounds[index];
            button.setOnTouchListener(new View.OnTouchListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() ==  MotionEvent.ACTION_DOWN) {
                        sound.start();
                        sound.setLooping(true);
                        button.setBackgroundColor(blue);
                    } else  {
                        sound.pause();
                        if (isBlack(button)) {
                            button.setBackgroundColor(black);
                        } else {
                            button.setBackgroundColor(white);
                        }
                    }
                    return true;
                }
            });
        }
    }
   /* public RectF getRect(Button button) {
        return new RectF(button.getLeft(), button.getTop(), button.getRight(), button.getBottom());
    } */
    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
       /* MediaRecorder recorder = new MediaRecorder();
        Button recordButton = this.findViewById(R.id.record_button);
        Button stop = this.findViewById(R.id.stop_button);
        Button resume = this.findViewById(R.id.pause);
        Button stopPlayback = this.findViewById(R.id.create_button);
        Chronometer recordingTime = findViewById(R.id.chronometer1); */

        //record(recordButton, stop, resume, stopPlayback, recordingTime, recorder);

        final Button low_C = this.findViewById(R.id.button);
        final MediaPlayer lowC = MediaPlayer.create(this, R.raw.lowctuned);
        //final Note lowCNote = new Note(getRect(low_C), low_C, lowC, false);

        final Button low_Db = this.findViewById(R.id.low_Db);
        final MediaPlayer lowDb = MediaPlayer.create(this, R.raw.lowdbtuned);
        //final Note lowDbNote = new Note(getRect(low_Db), low_Db, lowDb, false);

        final Button low_D = this.findViewById(R.id.low_D);
        final MediaPlayer lowD = MediaPlayer.create(this, R.raw.lowdtuned);
        //final Note lowDNote = new Note(getRect(low_D), low_D, lowD, false);

        final Button low_Eb = this.findViewById(R.id.low_Eb);
        final MediaPlayer lowEb = MediaPlayer.create(this, R.raw.lowebtuned);
        //final Note lowEbNote = new Note(getRect(low_Eb), low_Eb, lowEb, false);

        final Button low_E = this.findViewById(R.id.low_E);
        final MediaPlayer lowE = MediaPlayer.create(this, R.raw.lowetuned);
        //final Note lowENote = new Note(getRect(low_E), low_E, lowE, false);

        final Button low_F = this.findViewById(R.id.low_f);
        final MediaPlayer lowF = MediaPlayer.create(this, R.raw.lowftuned);
        //final Note lowFNote = new Note(getRect(low_F), low_F, lowF, false);

        final Button middle_Gb = this.findViewById(R.id.middle_Gb);
        final MediaPlayer middleGb = MediaPlayer.create(this, R.raw.middlegbtuned);
        //final Note middleGbNote = new Note(getRect(middle_Gb), middle_Gb, middleGb, false);

        final Button middle_G = this.findViewById(R.id.Middle_G);
        final MediaPlayer middleG = MediaPlayer.create(this, R.raw.middlegtuned);
        //final Note middleGNote = new Note(getRect(middle_G), middle_G, middleG, false);

        final Button middle_Ab = this.findViewById(R.id.middle_Ab);
        final MediaPlayer middleAb = MediaPlayer.create(this, R.raw.middleabtuned);
        //final Note middleAbNote = new Note(getRect(middle_Ab), middle_Ab, middleAb, false);

        final Button middle_A = this.findViewById(R.id.Middle_A);
        final MediaPlayer middleA = MediaPlayer.create(this, R.raw.middleatuned);
        //final Note middleANote = new Note(getRect(middle_A), middle_A, middleA, false);

        final Button middle_Bb = this.findViewById(R.id.Middle_Bb);
        final MediaPlayer middleBb = MediaPlayer.create(this, R.raw.middlebbtuned);
        //final Note middleBbNote = new Note(getRect(middle_Bb), middle_Bb, middleBb, false);

        final Button middle_B = this.findViewById(R.id.Middle_B);
        final MediaPlayer middleB = MediaPlayer.create(this, R.raw.middlebtuned);
        //final Note middleBNote = new Note(getRect(middle_B), middle_B, middleB, false);

        final Button middle_C = this.findViewById(R.id.Middle_C);
        final MediaPlayer middleC = MediaPlayer.create(this, R.raw.middlectuned);
        //final Note middleCNote = new Note(getRect(middle_C), middle_C, middleC, false);

        final Button middle_Db = this.findViewById(R.id.Middle_Db);
        final MediaPlayer middleDb = MediaPlayer.create(this, R.raw.middledbtuned);
        //final Note middleDbNote = new Note(getRect(middle_Db), middle_Db, middleDb, false);

        final Button middle_D = this.findViewById(R.id.Middle_D);
        final MediaPlayer middleD = MediaPlayer.create(this, R.raw.middledtuned);
        //final Note middleDNote = new Note(getRect(middle_D), middle_D, middleD, false);

        final Button middle_Eb = this.findViewById(R.id.Middle_Eb);
        final MediaPlayer middleEb = MediaPlayer.create(this, R.raw.middleebtuned);
        //final Note middleEbNote = new Note(getRect(middle_Eb), middle_Eb, middleEb, false);

        final Button middle_E = this.findViewById(R.id.middle_e);
        final MediaPlayer middleE = MediaPlayer.create(this, R.raw.middleetuned);
        //final Note middleENote = new Note(getRect(middle_E), middle_E, middleE, false);

        final Button middle_F = this.findViewById(R.id.Middle_F);
        final MediaPlayer middleF = MediaPlayer.create(this, R.raw.middleftuned);
        //final Note middleFNote = new Note(getRect(middle_F), middle_F, middleF, false);

        final Button high_Gb = this.findViewById(R.id.High_Gb);
        final MediaPlayer highGb = MediaPlayer.create(this, R.raw.highgbtuned);
        //final Note highGbNote = new Note(getRect(high_Gb), high_Gb, highGb, false);

        final Button high_G = this.findViewById(R.id.High_G);
        final MediaPlayer highG = MediaPlayer.create(this, R.raw.highgtuned);
        //final Note highGNote = new Note(getRect(high_G), high_G, highG, false);

        final Button high_Ab = this.findViewById(R.id.High_Ab);
        final MediaPlayer highAb = MediaPlayer.create(this, R.raw.highabtuned);
        //final Note highAbNote = new Note(getRect(high_Ab), high_Ab, highAb, false);

        final Button high_A = this.findViewById(R.id.High_A);
        final MediaPlayer highA = MediaPlayer.create(this, R.raw.highatuned);
        //final Note highANote = new Note(getRect(high_A), high_A, highA, false);

        final Button high_Bb = this.findViewById(R.id.High_Bb);
        final MediaPlayer highBb = MediaPlayer.create(this, R.raw.highbbtuned);
        //final Note highBbNote = new Note(getRect(high_Bb), high_Bb, highBb, false);

        final Button high_B = this.findViewById(R.id.High_B);
        final MediaPlayer highB = MediaPlayer.create(this, R.raw.highbtuned);
        //final Note highBNote = new Note(getRect(high_B), high_B, highB, false);

        final Button high_C = this.findViewById(R.id.High_C);
        final MediaPlayer highC = MediaPlayer.create(this, R.raw.highctuned);
        //final Note highCNote = new Note(getRect(high_C), high_C, highC, false);
        //buttons = new Note[]{lowCNote, lowDbNote, lowDNote, lowEbNote, lowENote, lowFNote, middleGbNote, middleGNote, middleAbNote, middleANote, middleBbNote, middleBNote,
        //middleCNote, middleDbNote, middleDNote, middleEbNote, middleENote, middleFNote, highGbNote, highGNote, highAbNote, highANote, highBbNote, highBNote, highCNote};
        buttoning = new Button[] {
                low_C, low_Db, low_D,
                low_Eb, low_E, low_F,
                middle_Gb, middle_G, middle_Ab,
                middle_A, middle_Bb, middle_B,
                middle_C, middle_Db, middle_D,
                middle_Eb, middle_E, middle_F,
                high_Gb, high_G, high_Ab,
                high_A, high_Bb, high_B,
                high_C};
        sounds = new MediaPlayer[]{
                lowC, lowDb, lowD, lowEb, lowE, lowF, middleGb, middleG, middleAb, middleA, middleBb, middleB, middleC, middleDb, middleD, middleEb, middleE, middleF, highGb, highG, highAb, highA, highBb, highB, highC
        };
        play(buttoning, sounds);
        final Button back = this.findViewById(R.id.back_button);
        final Intent intent = new Intent(this, MainActivity.class);
        back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    startActivity(intent);
                    back.setBackgroundColor(blue);
                }
                return true;
            }
        });
    }
}

