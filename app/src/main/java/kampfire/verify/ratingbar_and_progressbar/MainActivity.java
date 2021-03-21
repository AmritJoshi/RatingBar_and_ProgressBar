package kampfire.verify.ratingbar_and_progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RatingBar ratingBar;
    TextView textView;
    ProgressBar progressBar;
    Handler handler;
    int counter = 0;
    //private int progressBarStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar2);
        textView = findViewById(R.id.textview);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                textView.setText(" " + v);
            }
        });
        progressBar = findViewById(R.id.progressBar);
        handler = new Handler();
        new Thread(new Runnable() {
            public void run() {
                while (counter<100) {
                    counter += 5;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(counter);
                        }
                    });
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){

                    }
                }
            }
        }).start();
    }
}