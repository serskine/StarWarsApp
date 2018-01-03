package com.erskine.stuart.starwarsapp.util.view;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.erskine.stuart.starwarsapp.R;

/**
 * Created by Owner on 2/6/2017.
 * Copyright of Stuart Marr Erskine, all rights reserved.
 */

public class ViewUtil {

    public static final String getColoredHtml(String text, int color) {
        return getColoredHtml(text, "#" + Integer.toHexString(color));
    }
    public static final String getColoredHtml(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }

    public static final SpannableString getColoredSpanned(String text, int color) {
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ForegroundColorSpan(color), 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * This will hide the soft keyboard given the specified activity
     * @param activity
     */
    public static final void hideInputWindow(Activity activity)
    {
        // Check if no view has focus:
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static final Spanned toHtml(String text)
    {
        text = myHtmlString(text);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
        {
            return Html.fromHtml(text,Html.FROM_HTML_MODE_LEGACY);
        } else
        {
            return Html.fromHtml(text);
        }

    }

    /**
     * This is a preprocessing method of sorts.
     * @param html
     * @return
     */
    private static final String myHtmlString(String html)
    {

        if (html==null) html = "";
        html = html.trim();
        html = html.replace("<?html>","");
        html = html.replace("<?body>","");

        String EMPTY = "";
        String parsed = html;

        String removeLeading = "\\s*<html>(\\s*<br>)*\\s*";
        String removeTrailing = "\\s*<br>*\\s*</html>\\s*";
        String removeMultiLineBreaks = "<br>(\\s*<br>)*";
        String endListElements = "</li>";
        String startListElement = "<li>";

        parsed = parsed.replace(removeLeading,EMPTY);
        parsed = parsed.replace(removeTrailing, EMPTY);
        parsed = parsed.replace(startListElement, " • ");
        parsed = parsed.replace(endListElements, "<br>");
        parsed = parsed.replace(removeMultiLineBreaks, "<br>");

        return parsed;
    }
}
