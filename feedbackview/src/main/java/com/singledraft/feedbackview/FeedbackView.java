package com.singledraft.feedbackview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.DimenRes;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedbackView extends FrameLayout {

    private Context context;
    private FeedbackRegistry feedbackRegistry;
    @DimenRes
    private int gap = R.dimen.buttons_gap_default;

    public FeedbackView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public FeedbackView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(@NonNull Context context) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.feedback_view, this);
        feedbackRegistry = new FeedbackRegistry();
    }

    public void setQuery(String text) {
        TextView textView = findViewById(R.id.feedback_query);
        textView.setText(text);
    }

    public void addOption(String option) {
        View feedbackOption = LayoutInflater.from(context).inflate(R.layout.feedback_option, null);
        TextView textView = feedbackOption.findViewById(R.id.feedback_magnitude);
        textView.setText(option);

        ImageView optionImage = feedbackOption.findViewById(R.id.option_check);
        optionImage.setTag(option);
        feedbackRegistry.addViewToRegistry(optionImage);

        LinearLayout layout = findViewById(R.id.options);
        LayoutParams params = getOptionParams();
        layout.addView(feedbackOption, layout.getChildCount(), params);

        layout.invalidate();

    }

    private LayoutParams getOptionParams() {
        LayoutParams params = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        params.setMargins(context.getResources().getDimensionPixelSize(gap), 0, context.getResources().getDimensionPixelSize(gap), 0);
        return params;
    }

    public void addOptions(List<String> options) {
        for (String option : options) {
            addOption(option);
        }

    }

    public void setOptionsGap(@DimenRes int gap) {
        this.gap = gap;
    }

    @Nullable
    public String getCurrentSelection() {
        return feedbackRegistry.currentSelection;
    }


    private class FeedbackRegistry {

        private Map<String, ImageView> optionsMap = new HashMap<>();
        private String currentSelection;

        private void setCurrentSelection(String selection) {

            for (String key : optionsMap.keySet()) {
                if (key.equals(selection)) {
                    optionsMap.get(key).setImageResource(R.drawable.ic_radio_button_checked);
                } else {
                    optionsMap.get(key).setImageResource(R.drawable.ic_radio_button_unchecked);
                }
            }

            currentSelection = selection;

        }

        private void addViewToRegistry(ImageView view) {

            view.setOnClickListener(view1 -> {
                String selection = (String) view1.getTag();
                setCurrentSelection((selection));
            });

            optionsMap.put((String) view.getTag(), view);

        }


    }

}
