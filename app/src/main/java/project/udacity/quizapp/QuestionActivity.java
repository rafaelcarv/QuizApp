package project.udacity.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuestionActivity extends AppCompatActivity {

    @BindView(R.id.question1d) RadioButton question1RightAnswer;
    @BindView(R.id.question2a) CheckBox question2AnswerA;
    @BindView(R.id.question2b) CheckBox question2AnswerB;
    @BindView(R.id.question2c) CheckBox question2AnswerC;
    @BindView(R.id.question2d) CheckBox question2AnswerD;
    @BindView(R.id.question3answer) EditText question3Answer;
    @BindView(R.id.question4a) CheckBox question4AnswerA;
    @BindView(R.id.question4b) CheckBox question4AnswerB;
    @BindView(R.id.question4c) CheckBox question4AnswerC;
    @BindView(R.id.question4d) CheckBox question4AnswerD;
    @BindView(R.id.question5d) RadioButton question5RightAnswer;
    @BindView(R.id.submitAnswers) Button submitAnswers;

    final String RESULT_MESSAGE = "Your result is: ";
    final String QUESTION_3_RIGHT_RESULT = "100";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        ButterKnife.bind(this);
    }

    private int getRadioButtonResult(RadioButton rightAnswer) {
        if(rightAnswer.isChecked()) {
            return 2;
        }
        else {
            return 0;
        }
    }

    private int getQuestion3Result() {
        if(question3Answer.getText().toString().equals(QUESTION_3_RIGHT_RESULT)) {
            return 2;
        }
        else {
            return 0;
        }
    }

    private int getQuestion2Result() {
        if(question2AnswerB.isChecked() || question2AnswerD.isActivated()) {
            return 0;
        }
        if(question2AnswerA.isChecked() && question2AnswerC.isChecked()) {
            return 2;
        }
        else {
            return 0;
        }
    }

    private int getQuestion4Result() {
        if(question4AnswerA.isChecked() || question4AnswerD.isActivated()) {
            return 0;
        }
        if(question4AnswerB.isChecked() && question4AnswerC.isChecked()) {
            return 2;
        }
        else {
            return 0;
        }
    }

    @OnClick(R.id.submitAnswers)
    public void onClick(View v) {
        int result = 0;
        result += getRadioButtonResult(question1RightAnswer);
        result += getQuestion2Result();
        result += getQuestion3Result();
        result += getQuestion4Result();
        result += getRadioButtonResult(question5RightAnswer);
        Toast.makeText(this, RESULT_MESSAGE + result, Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
