package com.merlier.numberpicker;

import java.util.Arrays;
import java.util.Map;

import javax.annotation.Nullable;

import android.graphics.Color;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.LinearLayout.LayoutParams;

import androidx.annotation.NonNull;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class RNNumberPickerViewManager extends SimpleViewManager<FrameLayout> {
    public static final String REACT_CLASS = "RCTNumberPickerView";

    public RNNumberPickerViewManager(ReactApplicationContext reactContext) {
        super();
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public FrameLayout createViewInstance(@NonNull ThemedReactContext reactContext) {

        final FrameLayout frameLayout = new FrameLayout(reactContext);
        NumberPicker numberPicker = new NumberPicker(reactContext);
        numberPicker.setTag("numberPicker");
        frameLayout.addView(numberPicker);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                WritableMap event = Arguments.createMap();
                event.putString("value", Integer.toString(newVal));

                Log.d("value", Integer.toString(newVal));

                ReactContext reactContext = (ReactContext) numberPicker.getContext();
                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                        frameLayout.getId(),
                        "topChange",
                        event
                );
            }
        });

        return frameLayout;
    }

    @ReactProp(name = "items")
    public void setItems(FrameLayout frameLayout, @Nullable ReadableArray items) {
        NumberPicker numberPicker = frameLayout.findViewWithTag("numberPicker");
        assert items != null;

        String[] displayValues = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            displayValues[i] = (String) items.getString(i);
        }

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(displayValues.length > 0 ? displayValues.length - 1 : 0);
        numberPicker.setDisplayedValues(displayValues.length > 0 ? displayValues : null);
    }

    @ReactProp(name = "selectedItem")
    public void setValue(FrameLayout frameLayout, Integer selectedItem) {
        NumberPicker numberPicker = frameLayout.findViewWithTag("numberPicker");
        numberPicker.setValue(selectedItem);
    }

    @ReactProp(name = "textColor")
    public void setTextColor(FrameLayout frameLayout, String textColor) {
        NumberPicker numberPicker = frameLayout.findViewWithTag("numberPicker");

        numberPicker.setTextColor(Color.parseColor(textColor));
    }

    @ReactProp(name = "fontSize")
    public void setFontSize(FrameLayout frameLayout, float fontSize) {
        NumberPicker numberPicker = frameLayout.findViewWithTag("numberPicker");

        numberPicker.setTextSize(fontSize);
    }

    @Override
    public @Nullable
    Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        MapBuilder.Builder<String, Object> builder = MapBuilder.builder();
        registerEvent(builder, "topChange", "onChange");

        return builder.build();
    }

    /**
     * Helper to register React Native events.
     */
    private void registerEvent(MapBuilder.Builder<String, Object> builder, String topLevel, String callback) {
        builder.put(
                topLevel,
                MapBuilder.of(
                        "phasedRegistrationNames",
                        MapBuilder.of("bubbled", callback))
        );
    }
}
