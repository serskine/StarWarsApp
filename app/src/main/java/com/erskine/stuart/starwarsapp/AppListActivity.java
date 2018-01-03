package com.erskine.stuart.starwarsapp;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.erskine.stuart.starwarsapp.util.logger.Logger;

/**
 * Created by stuart.erskine on 2017-12-31.
 */

public abstract class AppListActivity extends AppActivity {

    protected ListView theListView;
    protected EditText theFilterEdit;
    protected View theClearFilterButton;
    protected View theFilterButton;
    protected View theAddButton;
    protected View theRemoveButton;
    protected View theEditButton;
    protected View theClearButton;
    protected View theSaveButton;
    protected View theCancelButton;


    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portrait_edit_list);
        
        theListView = (ListView) findViewById(R.id.theListView);
        theFilterEdit = (EditText) findViewById(R.id.theFilterEdit);
        theFilterButton = findViewById(R.id.theFilterButton);
        theClearFilterButton = findViewById(R.id.theClearFilterButton);
        theAddButton = findViewById(R.id.theAbilityButton);
        theRemoveButton = findViewById(R.id.theRemoveButton);
        theClearButton = findViewById(R.id.theClearButton);
        theEditButton = findViewById(R.id.theEditButton);
        theSaveButton = findViewById(R.id.theSaveButton);
        theCancelButton = findViewById(R.id.theCancelButton);

        uiWatcher.listenTo(theFilterEdit);
    }
    
    @CallSuper
    public void onAddButtonClicked(View view) {
        Logger.debug("onAddButtonClicked");
    }

    @CallSuper
    public void onRemoveButtonClicked(View view) {
        Logger.debug("onRemoveButtonClicked");
    }

    @CallSuper
    public void onEditButtonClicked(View view) {
        Logger.debug("onEditButtonClicked");
    }

    @CallSuper
    public void onClearButtonClicked(View view) {
        Logger.debug("onClearButtonClicked");
    }

    @CallSuper
    public void onSaveButtonClicked(View view) {
        Logger.debug("onSaveButtonClicked");
    }

    @CallSuper
    public void onCancelButtonClicked(View view) {
        Logger.debug("onCancelButtonClicked");
    }

    @CallSuper
    public void onFilterButtonClicked(View view) {
        Logger.debug("onFilterButtonClicked");
        performFilter();
    }

    @CallSuper
    public void onClearFilterButtonClicked(View view) {
        Logger.debug("onClearFilterButtonClicked");
        theFilterEdit.setText("");
    }

    @Override
    protected void onUiUpdate() {
        super.onUiUpdate();
        performFilter();
    }

    /**
     * This will perform a search using the given text in the search edit field
     */
    protected final void performFilter() {
        Logger.debug("performFilter()");
        uiWatcher.ignore(theFilterEdit);
        final CharSequence filterText = theFilterEdit.getText();
        performFilter(filterText);
        uiWatcher.listenTo(theFilterEdit);
    }

    @CallSuper
    protected void performFilter(final CharSequence filterText) {
        Logger.debug("performFilter(\"" + filterText + "\")");
    }
}
