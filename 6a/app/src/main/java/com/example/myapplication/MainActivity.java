package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button moveButton, rotateButton, expandButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        moveButton = findViewById(R.id.moveButton);
        rotateButton = findViewById(R.id.rotateButton);
        expandButton = findViewById(R.id.expandButton);

        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performMoveAnimation();
            }
        });

        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRotateAnimation();
            }
        });

        expandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performExpandAnimation();
            }
        });
    }

    private void performMoveAnimation() {
        Random random = new Random();
        int deltaY = random.nextInt(100) - 50; // Randomly move up or down by a maximum of 50 pixels
        Animation moveAnimation = AnimationUtils.loadAnimation(this, R.anim.move_animation);
        imageView.startAnimation(moveAnimation);
        imageView.animate().translationYBy(deltaY);
    }

    private void performRotateAnimation() {
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);
        imageView.startAnimation(rotateAnimation);
    }

    private void performExpandAnimation() {
        Animation expandAnimation = AnimationUtils.loadAnimation(this, R.anim.expand_animation);
        imageView.startAnimation(expandAnimation);
    }
}

