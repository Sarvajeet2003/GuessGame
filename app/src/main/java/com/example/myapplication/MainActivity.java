package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

    private EditText guessInput;
    private Button guessButton;
    private int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guessInput = findViewById(R.id.editTextGuess);
        guessButton = findViewById(R.id.buttonGuess);
        Random random = new Random();
        randomNumber = random.nextInt(10) + 1;
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guessString = guessInput.getText().toString();
                if (!guessString.isEmpty()) {
                    int guess = Integer.parseInt(guessString);
                    if (guess == randomNumber) {
                        Toast.makeText(MainActivity.this, "Congratulations! You guessed the number.", Toast.LENGTH_SHORT).show();
                    } else if (guess < randomNumber) {
                        Toast.makeText(MainActivity.this, "Too low! Try again.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Too high! Try again.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a number.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}