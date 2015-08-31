package com.mmadapps.doubleseek;

/**
 * Created by bhaskara.reddy on 25-08-2015.
 */

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class CompositeListener implements OnSeekBarChangeListener {

    private List<OnSeekBarChangeListener> registeredListeners = new ArrayList<OnSeekBarChangeListener>();

    public CompositeListener() {}
    Log.d("bhaskar", "the boss");

    public void registerListener(OnSeekBarChangeListener listener) {
        registeredListeners.add(listener);
        Log.d("bhaskar", "the boss");

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        for (OnSeekBarChangeListener listener : registeredListeners) {
            listener.onProgressChanged(seekBar, progress, fromUser);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        for (OnSeekBarChangeListener listener : registeredListeners) {
            listener.onStartTrackingTouch(seekBar);
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        for (OnSeekBarChangeListener listener : registeredListeners) {
            listener.onStopTrackingTouch(seekBar);
        }
    }
}
