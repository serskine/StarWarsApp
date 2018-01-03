package com.erskine.stuart.starwarsapp;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import com.erskine.stuart.starwarsapp.util.logger.Logger;
import com.erskine.stuart.starwarsapp.util.view.UiWatcher;

import java.io.Serializable;

/**
 * Created by stuart.erskine on 2017-12-31.
 */

public abstract class AppActivity extends AppCompatActivity {
    public static final String KEY_RESPONSE_JSON = "KEY_RESPONSE_JSON";

    protected UiWatcher uiWatcher = new UiWatcher() {
        @Override
        protected void onUiUpdate() {
            AppActivity.this.onUiUpdate();
        }
    };

    @CallSuper
    protected void onUiUpdate() {
        Logger.debug("onUiUpdate");
    }
}
