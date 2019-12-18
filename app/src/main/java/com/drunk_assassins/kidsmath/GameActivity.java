package com.drunk_assassins.kidsmath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.drunk_assassins.kidsmath.drunk_assassins.Calculator;
import com.drunk_assassins.kidsmath.drunk_assassins.Player;

public class GameActivity extends AppCompatActivity {

    TextView questionValue1, questionValue2, questionOperator, currentScore, currentLevel;
    Button choice1, choice2, choice3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        questionValue1 = findViewById(R.id.questionValue1);
        questionValue2 = findViewById(R.id.questionValue2);
        questionOperator = findViewById(R.id.questionOperator);

        currentScore = findViewById(R.id.currentScore);
        currentLevel = findViewById(R.id.currentLevel);

        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);

        currentScore.setText(Player.defaultScore);
        currentLevel.setText(Player.defaultLevel);

        setQuestion();

        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageAnswer(choice1.getText().toString());
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageAnswer(choice2.getText().toString());
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageAnswer(choice3.getText().toString());
            }
        });

    }

    private void setQuestion() {
        String[] questionValues = Player.getQuestionValues(Integer.parseInt(currentLevel.getText().toString()));
        questionValue1.setText(questionValues[0]);
        questionValue2.setText(questionValues[1]);
        questionOperator.setText(questionValues[2]);
        String[] choices = Player.choices(questionValues[0],questionValues[1],questionValues[2]);
        choice1.setText(choices[0]);
        choice2.setText(choices[1]);
        choice3.setText(choices[2]);
    }

    private void manageAnswer(String selectedBtnText) {

        int qV1 = Integer.parseInt(questionValue1.getText().toString());
        int qV2 = Integer.parseInt(questionValue2.getText().toString());
        String op = questionOperator.getText().toString();

        if (Integer.parseInt(selectedBtnText) == Calculator.calculate(qV1,qV2,op)) {
            Toast.makeText(this, "Well Done !", Toast.LENGTH_SHORT).show();
            currentScore.setText(String.valueOf(Integer.parseInt(currentScore.getText().toString())+1));
            setQuestion();
        } else {
            Toast.makeText(this, "Try Again !", Toast.LENGTH_SHORT).show();
            currentScore.setText(Player.defaultScore);
        }
    }

}
