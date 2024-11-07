package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button brightnessButton, darknessButton, grayscaleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        brightnessButton = findViewById(R.id.brightnessButton);
        darknessButton = findViewById(R.id.darknessButton);
        grayscaleButton = findViewById(R.id.grayscaleButton);
    }

    public void applyBrightness(View view) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{
                1.5f, 0, 0, 0, 0,  // Red
                0, 1.5f, 0, 0, 0,  // Green
                0, 0, 1.5f, 0, 0,  // Blue
                0, 0, 0, 1, 0     // Alpha
        });
        applyColorFilter(colorMatrix);
    }

    public void applyDarkness(View view) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{
                0.5f, 0, 0, 0, 0,  // Red
                0, 0.5f, 0, 0, 0,  // Green
                0, 0, 0.5f, 0, 0,  // Blue
                0, 0, 0, 1, 0     // Alpha
        });
        applyColorFilter(colorMatrix);
    }

    public void applyGrayscale(View view) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        applyColorFilter(colorMatrix);
    }

    private void applyColorFilter(ColorMatrix colorMatrix) {
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        imageView.setColorFilter(colorFilter);
        imageView.invalidate();
    }
}
