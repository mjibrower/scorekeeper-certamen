package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.scorekeeper.R;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int questionNumber = 0;
    String endOfRound = "false";
    String winner = "winner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
/**
 * Start the scoring here
 */
    /**
     * Increase the score for Team A by 10 points (for a tossup).
     */
    public void tossUpForTeamA(View v) {

        if (questionNumber <= 19) {
            scoreTeamA = scoreTeamA + 10;
            questionNumber = questionNumber + 1;
            displayQuestionNumber(questionNumber);
            displayForTeamA(scoreTeamA);

        }


        if (questionNumber == 20) {
            Toast.makeText(getApplicationContext(), "Game Over!", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * Increase the score for Team A by 5 points (for a bonus question).
     */
    public void bonusForTeamA(View v) {

        if (questionNumber <= 19) {

            scoreTeamA = scoreTeamA + 5;
            displayForTeamA(scoreTeamA);
        }


        if (questionNumber == 20) {
            endOfRound = "true";
        }
    }


    /**
     * Increase the score for Team A by 10 points (for a tossup).
     */
    public void tossUpForTeamB(View v) {

        if (questionNumber <= 19) {
            scoreTeamB = scoreTeamB + 10;
            questionNumber = questionNumber + 1;
            displayQuestionNumber(questionNumber);
            displayForTeamB(scoreTeamB);
        }

        if (questionNumber == 20) {
            Toast.makeText(getApplicationContext(), "Game Over!", Toast.LENGTH_SHORT).show();

        }

    }


    /**
     * Increase the score for Team B by 5 points (for a bonus).
     */

    public void bonusForTeamB(View v) {

        if (questionNumber <= 19) {

            scoreTeamB = scoreTeamB + 5;
            displayForTeamB(scoreTeamB);
        }


    }

    /**
     * Display the score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display the score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /*
    Display the number of toss-ups
     */

    public void displayQuestionNumber(int questionNumber) {

        TextView questionView = (TextView) findViewById(R.id.question_number);
        questionView.setText(String.valueOf(questionNumber));


    }


    /**
     * Reset both teams & toss-up total
     */
    public void reset(View v) {
        scoreTeamB = 0;
        displayForTeamB(scoreTeamB);
        scoreTeamA = 0;
        displayForTeamA(scoreTeamA);
        questionNumber = 0;
        displayQuestionNumber(questionNumber);
    }


}


/*

NOTES FOR LATER:
- After every 5 questions, highlight the high score (as it's done in competition)
- Play goes: toss-up; bonus; optional bonus. Maybe add errors if either bonus button is clicked without a tossup being clicked first
or if a bonus button is clicked more than twice in a row or if a bonus button is clicked for TeamA after a TeamB tossup (or vice versa)?
- Implement turns: correct/incorrect for a tossup; if incorrect, go to the next team. Highlight which team's turn it is.
----USE ONCLICKLISTENER: When either Tossup button is clicked, add 1 to question variable
                         - when question variable hits 5, 10, and 15, highlight high score
                         - when question variable hits 20, find high score & declare winner

 */
