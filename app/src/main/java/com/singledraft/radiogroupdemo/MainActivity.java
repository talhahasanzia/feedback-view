package com.singledraft.radiogroupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.singledraft.feedbackview.FeedbackView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FeedbackView feedbackView= findViewById(R.id.feedback_view);
        feedbackView.setQuery("How do you do? ");
        feedbackView.setOptionsGap(R.dimen.my_app_options_gap);

        for(int i=0; i<25; i++){
            feedbackView.addOption(String.valueOf(i));
        }

        // or add options as list
        //feedbackView.addOptions(listOptions);

        // when submit is clicked or you need to know the selected option
        String selectedOption = feedbackView.getCurrentSelection();
    }
}
