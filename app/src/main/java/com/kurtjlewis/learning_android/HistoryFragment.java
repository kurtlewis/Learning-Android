package com.kurtjlewis.learning_android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kurt on 5/7/17.
 */

public class HistoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        // Get history entry
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String defaultHistory = getResources().getString(R.string.history_placeholder);
        String history = sharedPref.getString(getString(R.string.saved_history_1), defaultHistory);

        TextView historyText = (TextView) view.findViewById(R.id.historyTextView);
        historyText.setText(history);

        return view;
    }
}
